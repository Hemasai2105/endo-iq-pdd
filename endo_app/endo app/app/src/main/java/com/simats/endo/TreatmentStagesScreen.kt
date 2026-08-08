package com.simats.endo

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

enum class StageStatus {
    Completed, InProgress, NotStarted
}

enum class AIStatus {
    Success, Live, Pending
}

data class TreatmentStage(
    val id: Int,
    val title: String,
    val description: String,
    val status: StageStatus,
    val aiText: String,
    val aiStatus: AIStatus,
    val durationMin: Int,
    val icon: ImageVector
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TreatmentStagesScreen(
    viewModel: EndoViewModel,
    onBack: () -> Unit
) {
    val patientData by viewModel.patientData.collectAsState()
    val bgColor = MaterialTheme.colorScheme.background
    val textDark = MaterialTheme.colorScheme.onSurface
    val textGray = MaterialTheme.colorScheme.onSurfaceVariant
    val primaryBlue = MaterialTheme.colorScheme.primary
    
    val context = androidx.compose.ui.platform.LocalContext.current
    
    val stages by viewModel.treatmentStages.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    LaunchedEffect(Unit) {
        if (stages.isEmpty()) {
            viewModel.generateReport()
        }
    }

    Scaffold(
        containerColor = bgColor,
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(text = "Treatment stages", fontSize = 20.sp, fontWeight = FontWeight.ExtraBold, color = textDark)
                        Text(text = "New Patient · Tooth", fontSize = 13.sp, color = textGray)
                    }
                },
                navigationIcon = {
                    Box(
                        modifier = Modifier
                            .padding(start = 16.dp, end = 8.dp)
                            .size(40.dp)
                            .background(MaterialTheme.colorScheme.surfaceVariant, CircleShape)
                            .clickable { onBack() },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = textDark)
                    }
                },
                actions = {
                    Box(
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .size(40.dp)
                            .background(MaterialTheme.colorScheme.surface, CircleShape)
                            .border(1.dp, MaterialTheme.colorScheme.surfaceVariant, CircleShape)
                            .clickable { },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(imageVector = Icons.Default.AutoAwesome, contentDescription = "AI Action", tint = textDark)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = bgColor)
            )
        },
        bottomBar = {
            BottomActionsPanel(
                onReturnToDashboard = onBack,
                onSaveAsPdf = {
                    saveToPdf(context, stages)
                }
            )
        }
    ) { innerPadding ->
        if (isLoading) {
            Box(modifier = Modifier.fillMaxSize().padding(innerPadding), contentAlignment = Alignment.Center) {
                CircularProgressIndicator(color = primaryBlue)
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                item {
                    Spacer(modifier = Modifier.height(16.dp))
                }
                
                itemsIndexed(stages) { index, stage ->
                    TimelineItem(stage = stage, isLast = index == stages.size - 1)
                }
                
                item {
                    Spacer(modifier = Modifier.height(32.dp))
                }
            }
        }
    }
}

@Composable
fun ProgressSummaryCard(completedStages: Int, totalStages: Int, currentFocus: String) {
    val percentage = (completedStages.toFloat() / totalStages) * 100
    val primaryBlue = MaterialTheme.colorScheme.primary
    val textDark = MaterialTheme.colorScheme.onSurface
    val textGray = MaterialTheme.colorScheme.onSurfaceVariant

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Row(
            modifier = Modifier.padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val surfaceVariantColor = MaterialTheme.colorScheme.surfaceVariant
            // Circular Progress
            Box(modifier = Modifier.size(70.dp), contentAlignment = Alignment.Center) {
                Canvas(modifier = Modifier.size(60.dp)) {
                    drawArc(
                        color = surfaceVariantColor,
                        startAngle = 0f,
                        sweepAngle = 360f,
                        useCenter = false,
                        style = Stroke(width = 8.dp.toPx(), cap = StrokeCap.Round)
                    )
                    drawArc(
                        color = primaryBlue,
                        startAngle = -90f,
                        sweepAngle = (percentage / 100f) * 360f,
                        useCenter = false,
                        style = Stroke(width = 8.dp.toPx(), cap = StrokeCap.Round)
                    )
                }
                Text(
                    text = "${percentage.toInt()}%",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = textDark
                )
            }
            
            Spacer(modifier = Modifier.width(20.dp))
            
            Column {
                Text(text = "$completedStages of $totalStages stages complete", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = textDark)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "Current focus: $currentFocus", fontSize = 13.sp, color = textGray)
                Spacer(modifier = Modifier.height(12.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    Text(text = "Irreversible pulpitis", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = primaryBlue)
                    Text(text = "Single visit", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(0xFF00B060))
                }
            }
        }
    }
}

@Composable
fun TimelineItem(stage: TreatmentStage, isLast: Boolean) {
    val textDark = MaterialTheme.colorScheme.onSurface
    val textGray = MaterialTheme.colorScheme.onSurfaceVariant
    val successGreen = Color(0xFF00C853)
    val primaryBlue = MaterialTheme.colorScheme.primary
    val lineColor = MaterialTheme.colorScheme.surfaceVariant

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        // Left Column (Icon + Line)
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.width(32.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .background(
                        when (stage.status) {
                            StageStatus.Completed -> successGreen
                            StageStatus.InProgress -> primaryBlue
                            StageStatus.NotStarted -> Color.Transparent
                        },
                        CircleShape
                    )
                    .border(
                        2.dp,
                        when (stage.status) {
                            StageStatus.Completed -> successGreen
                            StageStatus.InProgress -> primaryBlue
                            StageStatus.NotStarted -> lineColor
                        },
                        CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                when (stage.status) {
                    StageStatus.Completed -> Icon(imageVector = Icons.Default.Check, contentDescription = null, tint = Color.White, modifier = Modifier.size(16.dp))
                    StageStatus.InProgress -> Icon(imageVector = Icons.Default.PlayArrow, contentDescription = null, tint = Color.White, modifier = Modifier.size(16.dp))
                    StageStatus.NotStarted -> Box(modifier = Modifier.size(8.dp).background(lineColor, CircleShape))
                }
            }
            
            if (!isLast) {
                Canvas(
                    modifier = Modifier
                        .width(2.dp)
                        .weight(1f)
                        .padding(vertical = 4.dp)
                ) {
                    drawLine(
                        color = lineColor,
                        start = Offset(size.width / 2, 0f),
                        end = Offset(size.width / 2, size.height),
                        strokeWidth = 2.dp.toPx()
                    )
                }
            } else {
                Spacer(modifier = Modifier.weight(1f))
            }
        }
        
        Spacer(modifier = Modifier.width(16.dp))
        
        // Right Column (Card Content)
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .background(MaterialTheme.colorScheme.surfaceVariant, CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(imageVector = stage.icon, contentDescription = null, tint = textDark, modifier = Modifier.size(20.dp))
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text = stage.title, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = textDark)
                            Spacer(modifier = Modifier.width(12.dp))
                            val statusText = when (stage.status) {
                                StageStatus.Completed -> "Completed"
                                StageStatus.InProgress -> "In progress"
                                StageStatus.NotStarted -> ""
                            }
                            val statusColor = when (stage.status) {
                                StageStatus.Completed -> successGreen
                                StageStatus.InProgress -> primaryBlue
                                StageStatus.NotStarted -> Color.Transparent
                            }
                            if (statusText.isNotEmpty()) {
                                Text(text = statusText, fontSize = 12.sp, fontWeight = FontWeight.Bold, color = statusColor)
                            }
                        }
                    }
                }
                
                Spacer(modifier = Modifier.height(12.dp))
                Text(text = stage.description, fontSize = 13.sp, color = textGray, lineHeight = 18.sp)
                
                Spacer(modifier = Modifier.height(12.dp))
                
                // AI Pill
                val aiBgColor = when(stage.aiStatus) {
                    AIStatus.Success -> Color(0xFFE6F4EA)
                    AIStatus.Live -> Color(0xFFE6F4EA) // Or light blue depending on design
                    AIStatus.Pending -> MaterialTheme.colorScheme.surfaceVariant
                }
                val aiTextColor = when(stage.aiStatus) {
                    AIStatus.Success -> Color(0xFF0D652D)
                    AIStatus.Live -> Color(0xFF0D652D)
                    AIStatus.Pending -> Color(0xFF0D652D) // The pending in design has similar greenish/gray text
                }
                
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFEBF7F3), RoundedCornerShape(12.dp)) // Uniform light green bg from design
                        .padding(horizontal = 12.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(imageVector = Icons.Default.AutoAwesome, contentDescription = null, tint = Color(0xFF009688), modifier = Modifier.size(14.dp))
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = stage.aiText, fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF0D652D))
                }
                
                Spacer(modifier = Modifier.height(16.dp))
                

            }
        }
    }
}

@Composable
fun BottomActionsPanel(
    onReturnToDashboard: () -> Unit,
    onSaveAsPdf: () -> Unit
) {
    val textDark = MaterialTheme.colorScheme.onSurface
    val primaryBlue = MaterialTheme.colorScheme.primary

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .padding(16.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            Button(
                onClick = onReturnToDashboard,
                modifier = Modifier.weight(1f).height(48.dp),
                shape = RoundedCornerShape(24.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.surface, contentColor = textDark),
                border = androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.surfaceVariant),
                contentPadding = PaddingValues(horizontal = 8.dp)
            ) {
                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null, modifier = Modifier.size(18.dp))
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Return to dashboard", fontSize = 12.sp, fontWeight = FontWeight.Bold)
            }
            Button(
                onClick = onSaveAsPdf,
                modifier = Modifier.weight(1f).height(48.dp),
                shape = RoundedCornerShape(24.dp),
                colors = ButtonDefaults.buttonColors(containerColor = primaryBlue, contentColor = Color.White),
                contentPadding = PaddingValues(horizontal = 8.dp)
            ) {
                Icon(imageVector = Icons.Outlined.PictureAsPdf, contentDescription = null, modifier = Modifier.size(18.dp))
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Save as PDF", fontSize = 12.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}

fun saveToPdf(context: android.content.Context, stages: List<TreatmentStage>) {
    try {
        val pdfDocument = android.graphics.pdf.PdfDocument()
        val pageInfo = android.graphics.pdf.PdfDocument.PageInfo.Builder(595, 842, 1).create()
        val page = pdfDocument.startPage(pageInfo)
        val canvas = page.canvas
        val paint = android.graphics.Paint().apply {
            textSize = 14f
            color = android.graphics.Color.BLACK
        }
        val titlePaint = android.graphics.Paint().apply {
            textSize = 20f
            isFakeBoldText = true
            color = android.graphics.Color.BLACK
        }
        var yPosition = 60f
        
        canvas.drawText("Endodontic Treatment AI Report", 50f, yPosition, titlePaint)
        yPosition += 50f
        
        for (stage in stages) {
            paint.isFakeBoldText = true
            canvas.drawText(stage.title, 50f, yPosition, paint)
            yPosition += 25f
            paint.isFakeBoldText = false
            
            // Text wrap logic (simple wrap for 15 words)
            val text = stage.aiText
            var textX = 50f
            canvas.drawText(text, textX, yPosition, paint)
            yPosition += 40f
        }
        
        pdfDocument.finishPage(page)
        
        val file = java.io.File(context.getExternalFilesDir(android.os.Environment.DIRECTORY_DOCUMENTS), "AI_Report_ENDODONTIC.pdf")
        pdfDocument.writeTo(java.io.FileOutputStream(file))
        pdfDocument.close()
        
        android.widget.Toast.makeText(context, "Report saved to Documents folder!", android.widget.Toast.LENGTH_LONG).show()
    } catch (e: Exception) {
        android.widget.Toast.makeText(context, "Failed to save PDF", android.widget.Toast.LENGTH_SHORT).show()
    }
}
