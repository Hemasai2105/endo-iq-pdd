package com.simats.endo

import android.content.ContentValues
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.graphics.pdf.PdfDocument
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.widget.Toast
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream

object PdfGenerator {

    fun generateAndSavePdf(context: Context, report: SavedReport) {
        val pdfDocument = PdfDocument()
        val pageInfo = PdfDocument.PageInfo.Builder(595, 842, 1).create() // A4 Size
        val page = pdfDocument.startPage(pageInfo)
        val canvas: Canvas = page.canvas

        // Set up paints
        val titlePaint = Paint().apply {
            color = Color.rgb(25, 97, 165) // Primary Blue
            textSize = 24f
            typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
        }
        val headerPaint = Paint().apply {
            color = Color.BLACK
            textSize = 16f
            typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
        }
        val textPaint = Paint().apply {
            color = Color.DKGRAY
            textSize = 14f
            typeface = Typeface.create(Typeface.DEFAULT, Typeface.NORMAL)
        }

        var yPos = 60f
        val margin = 50f
        val maxWidth = pageInfo.pageWidth - (margin * 2)

        // Draw Title
        canvas.drawText("AI Endodontic Treatment Report", margin, yPos, titlePaint)
        yPos += 40f

        // Draw Patient Info
        val data = report.patientData
        canvas.drawText("Patient ID: ${report.id}", margin, yPos, headerPaint)
        yPos += 25f
        canvas.drawText("Patient Name: ${report.patientName}", margin, yPos, headerPaint)
        yPos += 25f
        canvas.drawText("Date: ${report.date}", margin, yPos, textPaint)
        yPos += 25f
        
        val genderAge = "${data.gender}, ${data.age} yrs"
        canvas.drawText("Profile: $genderAge", margin, yPos, textPaint)
        yPos += 25f
        
        canvas.drawText("Diagnosis: ${data.primaryDiagnosis}", margin, yPos, textPaint)
        yPos += 25f
        
        val teeth = if (data.selectedTeeth.isNotEmpty()) data.selectedTeeth.joinToString() else "None"
        canvas.drawText("Affected Teeth: $teeth", margin, yPos, textPaint)
        yPos += 50f

        // Draw Stages
        report.fullReport.forEach { stage ->
            if (yPos > pageInfo.pageHeight - 100f) {
                // Not handling multi-page for simplicity in this demo, just warning
                // But normally we'd finish page and start a new one
            }
            
            canvas.drawText(stage.title, margin, yPos, headerPaint)
            yPos += 20f

            // Handle multiline text wrapper (simple approach)
            val lines = splitTextIntoLines(stage.aiText, textPaint, maxWidth)
            for (line in lines) {
                canvas.drawText(line, margin, yPos, textPaint)
                yPos += 20f
            }
            yPos += 20f
        }

        pdfDocument.finishPage(page)

        // Save to Downloads
        try {
            val fileName = "EndoReport_${report.patientName.replace(" ", "_")}_${report.id}.pdf"
            val outputStream: OutputStream?

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                val resolver = context.contentResolver
                val contentValues = ContentValues().apply {
                    put(MediaStore.MediaColumns.DISPLAY_NAME, fileName)
                    put(MediaStore.MediaColumns.MIME_TYPE, "application/pdf")
                    put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_DOWNLOADS + "/EndoReports")
                }
                val uri = resolver.insert(MediaStore.Downloads.EXTERNAL_CONTENT_URI, contentValues)
                outputStream = uri?.let { resolver.openOutputStream(it) }
            } else {
                val downloadsDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                val reportsDir = File(downloadsDir, "EndoReports")
                if (!reportsDir.exists()) {
                    reportsDir.mkdirs()
                }
                val file = File(reportsDir, fileName)
                outputStream = FileOutputStream(file)
            }

            outputStream?.use {
                pdfDocument.writeTo(it)
            }
            Toast.makeText(context, "PDF saved to Downloads!", Toast.LENGTH_LONG).show()

        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(context, "Failed to save PDF: ${e.message}", Toast.LENGTH_LONG).show()
        } finally {
            pdfDocument.close()
        }
    }

    private fun splitTextIntoLines(text: String, paint: Paint, maxWidth: Float): List<String> {
        val lines = mutableListOf<String>()
        val words = text.split(" ")
        var currentLine = ""

        for (word in words) {
            val testLine = if (currentLine.isEmpty()) word else "$currentLine $word"
            val width = paint.measureText(testLine)
            if (width > maxWidth) {
                if (currentLine.isNotEmpty()) {
                    lines.add(currentLine)
                }
                currentLine = word
            } else {
                currentLine = testLine
            }
        }
        if (currentLine.isNotEmpty()) {
            lines.add(currentLine)
        }
        return lines
    }
}
