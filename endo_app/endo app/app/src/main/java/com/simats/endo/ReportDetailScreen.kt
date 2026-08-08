package com.simats.endo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReportDetailScreen(
    report: SavedReport,
    onBack: () -> Unit
) {
    val bgColor = Color(0xFFF4F6F9)

    Scaffold(
        containerColor = bgColor,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Report Details",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1A202C)
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBack,
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .background(Color.White, shape = RoundedCornerShape(12.dp))
                            .size(40.dp)
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color(0xFF2D3748)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = bgColor)
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp),
            contentPadding = PaddingValues(top = 16.dp, bottom = 32.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        Text(text = "Patient Info", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1A202C))
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(text = "Name: ${report.patientName}", fontSize = 16.sp, color = Color(0xFF2D3748))
                        Text(text = "ID: ${report.id}", fontSize = 16.sp, color = Color(0xFF2D3748))
                        Text(text = "Date: ${report.date}", fontSize = 14.sp, color = Color(0xFF718096))
                        Spacer(modifier = Modifier.height(8.dp))
                        val genderAge = "${report.patientData.gender}, ${report.patientData.age} yrs"
                        Text(text = "Profile: $genderAge", fontSize = 14.sp, color = Color(0xFF718096))
                        Text(text = "Diagnosis: ${report.patientData.primaryDiagnosis}", fontSize = 14.sp, color = Color(0xFF718096))
                        val teeth = if (report.patientData.selectedTeeth.isNotEmpty()) report.patientData.selectedTeeth.joinToString() else "None"
                        Text(text = "Teeth: $teeth", fontSize = 14.sp, color = Color(0xFF718096))
                    }
                }
            }
            
            items(report.fullReport) { stage ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        Text(text = stage.title, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1961A5))
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(text = stage.aiText, fontSize = 15.sp, color = Color(0xFF2D3748), lineHeight = 22.sp)
                    }
                }
            }
        }
    }
}
