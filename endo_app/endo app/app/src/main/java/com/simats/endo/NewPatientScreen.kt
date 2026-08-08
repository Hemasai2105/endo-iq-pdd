package com.simats.endo

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewPatientScreen(
    viewModel: EndoViewModel,
    onBack: () -> Unit, 
    onSave: () -> Unit = onBack
) {
    var selectedTab by remember { mutableStateOf(0) } // Defaulting to Personal
    var maxCompletedTab by remember { mutableIntStateOf(0) }

    val bgColor = MaterialTheme.colorScheme.background
    val primaryBlue = MaterialTheme.colorScheme.primary
    val textDark = MaterialTheme.colorScheme.onSurface
    val textGray = MaterialTheme.colorScheme.onSurfaceVariant
    val borderColor = MaterialTheme.colorScheme.surfaceVariant

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(bgColor)
    ) {
        // Top App Bar Area
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(bgColor)
                .padding(horizontal = 24.dp, vertical = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .border(1.dp, primaryBlue, RoundedCornerShape(12.dp))
                        .clip(RoundedCornerShape(12.dp))
                        .clickable { onBack() },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBackIosNew,
                        contentDescription = "Back",
                        tint = textDark,
                        modifier = Modifier.size(20.dp)
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(
                        text = "New Patient",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = textDark
                    )
                    Text(
                        text = "Record EN-1043",
                        fontSize = 14.sp,
                        color = textGray
                    )
                }
            }
        }

        // Tabs
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TabItem(
                icon = if (maxCompletedTab > 0) Icons.Default.Check else Icons.Outlined.Person,
                label = "Personal",
                isSelected = selectedTab == 0,
                isCompleted = maxCompletedTab > 0,
                onClick = { if (maxCompletedTab >= 0) selectedTab = 0 }
            )
            TabItem(
                icon = if (maxCompletedTab > 1) Icons.Default.Check else Icons.Outlined.Assignment,
                label = "History",
                isSelected = selectedTab == 1,
                isCompleted = maxCompletedTab > 1,
                onClick = { if (maxCompletedTab >= 1) selectedTab = 1 }
            )
            TabItem(
                icon = if (maxCompletedTab > 2) Icons.Default.Check else Icons.Outlined.MedicalServices,
                label = "Teeth",
                isSelected = selectedTab == 2,
                isCompleted = maxCompletedTab > 2,
                onClick = { if (maxCompletedTab >= 2) selectedTab = 2 }
            )
            TabItem(
                icon = if (maxCompletedTab > 3) Icons.Default.Check else Icons.Outlined.Search,
                label = "Diagnosis",
                isSelected = selectedTab == 3,
                isCompleted = maxCompletedTab > 3,
                onClick = { if (maxCompletedTab >= 3) selectedTab = 3 }
            )
        }
        
        HorizontalDivider(color = borderColor, thickness = 1.dp, modifier = Modifier.fillMaxWidth())

        // Content
        Box(modifier = Modifier.fillMaxSize()) {
            if (selectedTab == 0) {
                PersonalInfoContent(
                    viewModel = viewModel,
                    onContinue = { 
                        if (maxCompletedTab < 1) maxCompletedTab = 1
                        selectedTab = 1 
                    }
                )
            } else if (selectedTab == 1) {
                HistoryContent(
                    viewModel = viewModel,
                    onBack = { selectedTab = 0 },
                    onContinue = { 
                        if (maxCompletedTab < 2) maxCompletedTab = 2
                        selectedTab = 2 
                    }
                )
            } else if (selectedTab == 2) {
                TeethContent(
                    viewModel = viewModel,
                    onBack = { selectedTab = 1 },
                    onContinue = { 
                        if (maxCompletedTab < 3) maxCompletedTab = 3
                        selectedTab = 3 
                    }
                )
            } else if (selectedTab == 3) {
                DiagnosisContent(
                    viewModel = viewModel,
                    onBack = { selectedTab = 2 },
                    onSave = {
                        onSave()
                    }
                )
            }
        }
    }
}

@Composable
fun TabItem(icon: ImageVector, label: String, isSelected: Boolean, isCompleted: Boolean = false, onClick: () -> Unit) {
    val primaryBlue = MaterialTheme.colorScheme.primary
    val successGreen = Color(0xFF00C853)
    val textGray = MaterialTheme.colorScheme.onSurfaceVariant
    
    val iconBgColor = when {
        isCompleted -> successGreen
        isSelected -> primaryBlue
        else -> MaterialTheme.colorScheme.surfaceVariant
    }
    
    val iconColor = if (isSelected || isCompleted) Color.White else textGray
    val textColor = if (isSelected) primaryBlue else textGray
    
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(70.dp)
            .clickable { onClick() }
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(iconBgColor, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = iconColor,
                modifier = Modifier.size(20.dp)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = label,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = textColor
        )
        Spacer(modifier = Modifier.height(8.dp))
        if (isSelected) {
            Box(modifier = Modifier.fillMaxWidth().height(3.dp).background(primaryBlue))
        } else {
            Box(modifier = Modifier.fillMaxWidth().height(3.dp).background(Color.Transparent))
        }
    }
}

@Composable
fun HistoryContent(viewModel: EndoViewModel, onBack: () -> Unit, onContinue: () -> Unit) {
    val primaryBlue = MaterialTheme.colorScheme.primary
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 24.dp, vertical = 24.dp)
    ) {
        // Systemic conditions
        var systemicExpanded by remember { mutableStateOf(false) }
        var selectedConditions by remember { mutableStateOf(viewModel.patientData.value.conditions) }
        var othersText by remember { mutableStateOf("") }
        
        ExpandableCard(
            title = "Systemic conditions",
            subtitle = if (selectedConditions.isEmpty()) "None selected" else "${selectedConditions.size} selected",
            icon = Icons.Outlined.MonitorHeart,
            expanded = systemicExpanded,
            onExpandClick = { systemicExpanded = !systemicExpanded }
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                val conditions = listOf("Diabetes", "Hypertension", "Heart Disease", "Pregnancy", "Kidney Disease", "Asthma", "Cancer", "Others")
                for (i in conditions.indices step 2) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        ConditionCheckbox(
                            text = conditions[i], 
                            isChecked = selectedConditions.contains(conditions[i]),
                            onCheckedChange = { checked ->
                                selectedConditions = if (checked) selectedConditions + conditions[i] else selectedConditions - conditions[i]
                            },
                            modifier = Modifier.weight(1f)
                        )
                        if (i + 1 < conditions.size) {
                            ConditionCheckbox(
                                text = conditions[i+1], 
                                isChecked = selectedConditions.contains(conditions[i+1]),
                                onCheckedChange = { checked ->
                                    selectedConditions = if (checked) selectedConditions + conditions[i+1] else selectedConditions - conditions[i+1]
                                },
                                modifier = Modifier.weight(1f)
                            )
                        } else {
                            Spacer(modifier = Modifier.weight(1f))
                        }
                    }
                    if (i + 2 < conditions.size) {
                        Spacer(modifier = Modifier.height(12.dp))
                    }
                }
                
                if (selectedConditions.contains("Others")) {
                    Spacer(modifier = Modifier.height(16.dp))
                    OutlinedTextField(
                        value = othersText,
                        onValueChange = { othersText = it },
                        placeholder = { Text("Specify other conditions...", color = MaterialTheme.colorScheme.onSurfaceVariant) },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedBorderColor = MaterialTheme.colorScheme.surfaceVariant,
                            focusedBorderColor = MaterialTheme.colorScheme.primary,
                            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                            focusedContainerColor = MaterialTheme.colorScheme.surface
                        ),
                        singleLine = true
                    )
                }
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Medication & allergies
        var medsExpanded by remember { mutableStateOf(true) }
        var previousDetails by remember { mutableStateOf("") }
        ExpandableCard(
            title = "Medication & allergies",
            subtitle = "Current drugs, known allergies",
            icon = Icons.Outlined.Medication,
            expanded = medsExpanded,
            onExpandClick = { medsExpanded = !medsExpanded }
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(text = "Current medication", fontSize = 14.sp, fontWeight = FontWeight.Medium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                Spacer(modifier = Modifier.height(8.dp))
                FormTextArea(placeholder = "e.g. Metformin 500 mg BD")
                
                Spacer(modifier = Modifier.height(16.dp))
                
                Text(text = "Allergies", fontSize = 14.sp, fontWeight = FontWeight.Medium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                Spacer(modifier = Modifier.height(8.dp))
                FormTextArea(placeholder = "e.g. Penicillin, latex")
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Lifestyle
        var lifestyleExpanded by remember { mutableStateOf(true) }
        var smoking by remember { mutableStateOf(viewModel.patientData.value.smoking) }
        var alcohol by remember { mutableStateOf(viewModel.patientData.value.alcohol) }
        ExpandableCard(
            title = "Lifestyle",
            subtitle = "Smoking, alcohol",
            icon = Icons.Outlined.LocalBar,
            expanded = lifestyleExpanded,
            onExpandClick = { lifestyleExpanded = !lifestyleExpanded }
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth().background(MaterialTheme.colorScheme.surfaceVariant, RoundedCornerShape(16.dp)).padding(horizontal = 16.dp, vertical = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Smoking", fontSize = 16.sp, fontWeight = FontWeight.SemiBold, color = MaterialTheme.colorScheme.onSurface)
                    Switch(checked = smoking, onCheckedChange = { smoking = it })
                }
                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    modifier = Modifier.fillMaxWidth().background(MaterialTheme.colorScheme.surfaceVariant, RoundedCornerShape(16.dp)).padding(horizontal = 16.dp, vertical = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Alcohol", fontSize = 16.sp, fontWeight = FontWeight.SemiBold, color = MaterialTheme.colorScheme.onSurface)
                    Switch(checked = alcohol, onCheckedChange = { alcohol = it })
                }
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Previous dental history
        var dentalHistoryExpanded by remember { mutableStateOf(true) }
        ExpandableCard(
            title = "Previous dental history",
            subtitle = "Restorations, extractions, RCTs",
            icon = Icons.Outlined.History,
            expanded = dentalHistoryExpanded,
            onExpandClick = { dentalHistoryExpanded = !dentalHistoryExpanded }
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(text = "Dental history", fontSize = 14.sp, fontWeight = FontWeight.Medium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                Spacer(modifier = Modifier.height(8.dp))
                FormTextArea(placeholder = "e.g. Composite on 36 (2022), extraction 48 (2019)")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        
        // Clinical notes
        var notesExpanded by remember { mutableStateOf(true) }
        ExpandableCard(
            title = "Clinical notes",
            subtitle = "Anything else worth recording",
            icon = Icons.Outlined.EditNote,
            expanded = notesExpanded,
            onExpandClick = { notesExpanded = !notesExpanded }
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(text = "Notes", fontSize = 14.sp, fontWeight = FontWeight.Medium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                Spacer(modifier = Modifier.height(8.dp))
                FormTextArea(placeholder = "Chief complaint, pain character, duration...")
            }
        }
        
        Spacer(modifier = Modifier.height(32.dp))
        
        LaunchedEffect(selectedConditions, smoking, alcohol) {
            viewModel.updateMedicalHistory(selectedConditions, smoking, alcohol)
        }
        
        // Bottom Actions
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(
                onClick = onBack,
                modifier = Modifier.weight(0.35f).height(56.dp).border(1.dp, MaterialTheme.colorScheme.surfaceVariant, RoundedCornerShape(28.dp)),
                shape = RoundedCornerShape(28.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.surface)
            ) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null, tint = MaterialTheme.colorScheme.onSurface)
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Back", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onSurface)
            }
            
            Button(
                onClick = {
                    viewModel.updateMedicalHistory(selectedConditions, smoking, alcohol)
                    onContinue()
                },
                modifier = Modifier.weight(0.65f).height(56.dp),
                shape = RoundedCornerShape(28.dp),
                colors = ButtonDefaults.buttonColors(containerColor = primaryBlue)
            ) {
                Text(text = "Continue", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
                Spacer(modifier = Modifier.width(8.dp))
                Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null, tint = Color.White)
            }
        }
        
        Spacer(modifier = Modifier.height(48.dp))
    }
}

@Composable
fun ExpandableCard(
    title: String,
    subtitle: String,
    icon: ImageVector,
    expanded: Boolean,
    onExpandClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onExpandClick() }
                    .padding(20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(text = title, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onSurface)
                    Text(text = subtitle, fontSize = 13.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
                Icon(
                    imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            
            if (expanded) {
                HorizontalDivider(color = MaterialTheme.colorScheme.surfaceVariant, thickness = 1.dp)
                content()
            }
        }
    }
}

@Composable
fun ConditionCheckbox(text: String, isChecked: Boolean, onCheckedChange: (Boolean) -> Unit, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .border(1.dp, MaterialTheme.colorScheme.surfaceVariant, RoundedCornerShape(24.dp))
            .background(MaterialTheme.colorScheme.surface, RoundedCornerShape(24.dp))
            .clickable { onCheckedChange(!isChecked) }
            .padding(horizontal = 12.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(20.dp)
                .border(2.dp, if (isChecked) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceVariant, RoundedCornerShape(6.dp))
                .background(if (isChecked) MaterialTheme.colorScheme.primary else Color.White, RoundedCornerShape(6.dp)),
            contentAlignment = Alignment.Center
        ) {
            if (isChecked) {
                Icon(imageVector = Icons.Default.Check, contentDescription = null, tint = Color.White, modifier = Modifier.size(14.dp))
            }
        }
        Spacer(modifier = Modifier.width(12.dp))
        Text(text = text, fontSize = 13.sp, fontWeight = FontWeight.Medium, color = MaterialTheme.colorScheme.onSurface)
    }
}

@Composable
fun FormTextArea(placeholder: String) {
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        placeholder = { Text(placeholder, color = MaterialTheme.colorScheme.onSurfaceVariant) },
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        shape = RoundedCornerShape(16.dp),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = MaterialTheme.colorScheme.surfaceVariant,
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
            focusedContainerColor = MaterialTheme.colorScheme.surface
        )
    )
}

@Composable
fun PersonalInfoContent(viewModel: EndoViewModel, onContinue: () -> Unit) {
    var fullName by remember { mutableStateOf(viewModel.patientData.value.fullName) }
    var age by remember { mutableStateOf(viewModel.patientData.value.age) }
    var gender by remember { mutableStateOf(viewModel.patientData.value.gender) }
    var dob by remember { mutableStateOf("") }
    var bloodGroup by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var emergencyContact by remember { mutableStateOf("") }
    var occupation by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }

    LaunchedEffect(fullName, age, gender) {
        viewModel.updatePersonalData(fullName, age, gender)
    }

    val primaryBlue = MaterialTheme.colorScheme.primary
    val textDark = MaterialTheme.colorScheme.onSurface
    val textGray = MaterialTheme.colorScheme.onSurfaceVariant
    val borderColor = MaterialTheme.colorScheme.surfaceVariant
    
    val context = LocalContext.current
    val calendar = Calendar.getInstance()
    val datePickerDialog = android.app.DatePickerDialog(
        context,
        { _, year, month, dayOfMonth ->
            dob = "${dayOfMonth.toString().padStart(2, '0')}-${(month + 1).toString().padStart(2, '0')}-$year"
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 24.dp, vertical = 24.dp)
    ) {


        // Personal Information Card
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(text = "Personal information", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = textDark)
                Spacer(modifier = Modifier.height(20.dp))
                FormField(label = "Full name", value = fullName, onValueChange = { fullName = it }, icon = Icons.Outlined.Person, placeholder = "e.g. Rohan Sharma", isRequired = true)
                Spacer(modifier = Modifier.height(16.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    FormField(modifier = Modifier.weight(1f), label = "Age", value = age, onValueChange = { age = it }, isRequired = true, placeholder = "34", keyboardType = KeyboardType.Number)
                    FormFieldDropdown(modifier = Modifier.weight(1f), label = "Gender", value = gender, placeholder = "Select", options = listOf("Male", "Female", "Other"), onValueChange = { gender = it })
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    Box(modifier = Modifier.weight(1f).clickable { datePickerDialog.show() }) {
                        FormField(
                            modifier = Modifier.fillMaxWidth(),
                            label = "Date of birth",
                            value = dob,
                            onValueChange = { },
                            placeholder = "DD-MM-YYYY",
                            icon = Icons.Outlined.CalendarToday,
                            isTrailingIcon = true,
                            readOnly = true
                        )
                    }
                    FormFieldDropdown(modifier = Modifier.weight(1f), label = "Blood group", value = bloodGroup, placeholder = "Select", options = listOf("A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"), onValueChange = { bloodGroup = it })
                }
                Spacer(modifier = Modifier.height(16.dp))
                FormField(label = "Phone", value = phone, onValueChange = { phone = it }, icon = Icons.Outlined.Phone, placeholder = "+91 98765 43210", keyboardType = KeyboardType.Phone)
                Spacer(modifier = Modifier.height(16.dp))
                FormField(label = "Email", value = email, onValueChange = { email = it }, icon = Icons.Outlined.Email, placeholder = "name@mail.com", keyboardType = KeyboardType.Email)
                Spacer(modifier = Modifier.height(16.dp))
                FormField(label = "Emergency contact", value = emergencyContact, onValueChange = { emergencyContact = it }, icon = Icons.Outlined.StarRate, placeholder = "+91 98765 43211", keyboardType = KeyboardType.Phone)
                Spacer(modifier = Modifier.height(16.dp))
                FormField(label = "Occupation", value = occupation, onValueChange = { occupation = it }, icon = Icons.Outlined.WorkOutline, placeholder = "e.g. Architect")
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Address", fontSize = 14.sp, fontWeight = FontWeight.Medium, color = textGray)
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = address,
                    onValueChange = { address = it },
                    placeholder = { Text("Street, city, postal code", color = MaterialTheme.colorScheme.onSurfaceVariant) },
                    modifier = Modifier.fillMaxWidth().height(120.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = borderColor,
                        focusedBorderColor = primaryBlue,
                        unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                        focusedContainerColor = MaterialTheme.colorScheme.surface
                    )
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        val isFormValid = fullName.isNotBlank() && age.isNotBlank()
        
        Button(
            onClick = { if (isFormValid) onContinue() },
            modifier = Modifier.fillMaxWidth().height(56.dp),
            shape = RoundedCornerShape(28.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isFormValid) primaryBlue else Color(0xFF90B4D8)
            ) 
        ) {
            Text(text = "Continue", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
            Spacer(modifier = Modifier.width(8.dp))
            Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null, modifier = Modifier.size(20.dp), tint = Color.White)
        }
        if (!isFormValid) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Name and age are required to continue.",
                color = Color(0xFFD69E2E),
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
        Spacer(modifier = Modifier.height(48.dp))
    }
}

@Composable
fun FormField(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String = "",
    icon: ImageVector? = null,
    isTrailingIcon: Boolean = false,
    isRequired: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text,
    readOnly: Boolean = false
) {
    Column(modifier = modifier) {
        Row {
            Text(text = label, fontSize = 14.sp, fontWeight = FontWeight.Medium, color = MaterialTheme.colorScheme.onSurfaceVariant)
            if (isRequired) {
                Text(text = " *", fontSize = 14.sp, fontWeight = FontWeight.Medium, color = Color.Red)
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            readOnly = readOnly,
            enabled = !readOnly,
            placeholder = { Text(placeholder, color = MaterialTheme.colorScheme.onSurfaceVariant) },
            leadingIcon = if (icon != null && !isTrailingIcon) {
                { Icon(imageVector = icon, contentDescription = null, tint = MaterialTheme.colorScheme.onSurfaceVariant) }
            } else null,
            trailingIcon = if (icon != null && isTrailingIcon) {
                { Icon(imageVector = icon, contentDescription = null, tint = MaterialTheme.colorScheme.onSurfaceVariant) }
            } else null,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = MaterialTheme.colorScheme.surfaceVariant,
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                focusedContainerColor = MaterialTheme.colorScheme.surface
            ),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormFieldDropdown(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    placeholder: String,
    options: List<String>,
    onValueChange: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Column(modifier = modifier) {
        Text(text = label, fontSize = 14.sp, fontWeight = FontWeight.Medium, color = MaterialTheme.colorScheme.onSurfaceVariant)
        Spacer(modifier = Modifier.height(8.dp))
        
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            OutlinedTextField(
                value = value,
                onValueChange = { },
                readOnly = true,
                placeholder = { Text(placeholder, color = MaterialTheme.colorScheme.onSurfaceVariant, maxLines = 1) },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.fillMaxWidth().menuAnchor(),
                shape = RoundedCornerShape(16.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = MaterialTheme.colorScheme.surfaceVariant,
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                    focusedContainerColor = MaterialTheme.colorScheme.surface
                ),
                singleLine = true
            )
            
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.background(MaterialTheme.colorScheme.surface)
            ) {
                options.forEach { selectionOption ->
                    DropdownMenuItem(
                        text = { Text(selectionOption) },
                        onClick = {
                            onValueChange(selectionOption)
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun TeethContent(viewModel: EndoViewModel, onBack: () -> Unit, onContinue: () -> Unit) {
    var selectedTeeth by remember { mutableStateOf(viewModel.patientData.value.selectedTeeth) }

    val primaryBlue = MaterialTheme.colorScheme.primary
    val textDark = MaterialTheme.colorScheme.onSurface
    val textGray = MaterialTheme.colorScheme.onSurfaceVariant
    val borderColor = MaterialTheme.colorScheme.surfaceVariant
    
    val upperTeeth = listOf(18, 17, 16, 15, 14, 13, 12, 11, 21, 22, 23, 24, 25, 26, 27, 28)
    val lowerTeeth = listOf(48, 47, 46, 45, 44, 43, 42, 41, 31, 32, 33, 34, 35, 36, 37, 38)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 24.dp, vertical = 24.dp)
    ) {
        // Description
        Text(text = "Tooth selection", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = textDark)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Select one or more teeth requiring endodontic treatment. Selected teeth are highlighted and carried into every stage, report and AI suggestion.",
            fontSize = 14.sp,
            color = textGray,
            lineHeight = 20.sp
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // FDI Notation Card
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            shape = RoundedCornerShape(20.dp),
            border = androidx.compose.foundation.BorderStroke(1.dp, borderColor),
            elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Header of the card
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "FDI notation · tap to select", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = textGray)
                    
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(32.dp)
                                .background(MaterialTheme.colorScheme.surfaceVariant, RoundedCornerShape(8.dp))
                                .clickable { },
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(imageVector = Icons.Outlined.ZoomOut, contentDescription = "Zoom Out", tint = textDark, modifier = Modifier.size(16.dp))
                        }
                        Text(text = "100%", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = textDark, modifier = Modifier.padding(horizontal = 8.dp))
                        Box(
                            modifier = Modifier
                                .size(32.dp)
                                .background(MaterialTheme.colorScheme.surfaceVariant, RoundedCornerShape(8.dp))
                                .clickable { },
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(imageVector = Icons.Outlined.ZoomIn, contentDescription = "Zoom In", tint = textDark, modifier = Modifier.size(16.dp))
                        }
                    }
                }
                
                Spacer(modifier = Modifier.height(24.dp))
                
                Text(text = "UPPER", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = textGray)
                Spacer(modifier = Modifier.height(16.dp))
                
                // Upper Teeth Row
                Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
                    upperTeeth.forEach { toothNumber ->
                        ToothItem(
                            number = toothNumber,
                            isSelected = selectedTeeth.contains(toothNumber),
                            onClick = {
                                selectedTeeth = if (selectedTeeth.contains(toothNumber)) {
                                    selectedTeeth - toothNumber
                                } else {
                                    selectedTeeth + toothNumber
                                }
                            }
                        )
                    }
                }
                
                Spacer(modifier = Modifier.height(16.dp))
                HorizontalDivider(color = borderColor, thickness = 1.dp)
                Spacer(modifier = Modifier.height(16.dp))
                
                // Lower Teeth Row
                Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
                    lowerTeeth.forEach { toothNumber ->
                        ToothItem(
                            number = toothNumber,
                            isSelected = selectedTeeth.contains(toothNumber),
                            isLower = true,
                            onClick = {
                                selectedTeeth = if (selectedTeeth.contains(toothNumber)) {
                                    selectedTeeth - toothNumber
                                } else {
                                    selectedTeeth + toothNumber
                                }
                            }
                        )
                    }
                }
                
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "LOWER", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = textGray)
                
                Spacer(modifier = Modifier.height(32.dp))
                Text(text = "Hover or select a tooth for details", fontSize = 13.sp, color = textGray)
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // AI Anatomy Hint Card
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
        ) {
            Row(modifier = Modifier.padding(20.dp)) {
                Icon(imageVector = Icons.Outlined.AutoAwesome, contentDescription = null, tint = Color(0xFF319795), modifier = Modifier.size(24.dp))
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(text = "AI anatomy hint", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = textDark)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Select a tooth to see expected canal anatomy and instrumentation guidance.",
                        fontSize = 13.sp,
                        color = textGray,
                        lineHeight = 18.sp
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))
        
        LaunchedEffect(selectedTeeth) {
            viewModel.updateChiefComplaint(selectedTeeth)
        }
        
        // Bottom Actions
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(
                onClick = onBack,
                modifier = Modifier
                    .weight(0.35f)
                    .height(56.dp)
                    .border(1.dp, borderColor, RoundedCornerShape(28.dp)),
                shape = RoundedCornerShape(28.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.surface)
            ) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null, tint = textDark)
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Back", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = textDark)
            }
            
            Button(
                onClick = { 
                    if (selectedTeeth.isNotEmpty()) {
                        viewModel.updateChiefComplaint(selectedTeeth)
                        onContinue() 
                    }
                },
                modifier = Modifier
                    .weight(0.65f)
                    .height(56.dp),
                shape = RoundedCornerShape(28.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (selectedTeeth.isNotEmpty()) primaryBlue else Color(0xFF90B4D8)
                )
            ) {
                Text(text = "Continue", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
                Spacer(modifier = Modifier.width(8.dp))
                Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null, tint = Color.White)
            }
        }
        
        if (selectedTeeth.isEmpty()) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Select at least one tooth.",
                color = Color(0xFFD69E2E), // Orangeish
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
        
        Spacer(modifier = Modifier.height(48.dp))
    }
}

@Composable
fun ToothItem(number: Int, isSelected: Boolean, isLower: Boolean = false, onClick: () -> Unit) {
    val primaryBlue = MaterialTheme.colorScheme.primary
    val textGray = MaterialTheme.colorScheme.onSurfaceVariant
    
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(40.dp)
            .clickable { onClick() }
            .padding(vertical = 4.dp)
    ) {
        if (!isLower) {
            ToothOutlineIcon(isSelected = isSelected)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = number.toString(),
                fontSize = 11.sp,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.SemiBold,
                color = if (isSelected) primaryBlue else textGray
            )
        } else {
            Text(
                text = number.toString(),
                fontSize = 11.sp,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.SemiBold,
                color = if (isSelected) primaryBlue else textGray
            )
            Spacer(modifier = Modifier.height(8.dp))
            Box(modifier = Modifier.rotate(180f)) {
                ToothOutlineIcon(isSelected = isSelected)
            }
        }
    }
}

@Composable
fun ToothOutlineIcon(isSelected: Boolean) {
    val color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceVariant
    
    androidx.compose.foundation.Canvas(modifier = Modifier.size(24.dp, 32.dp)) {
        val width = size.width
        val height = size.height
        
        val path = androidx.compose.ui.graphics.Path().apply {
            moveTo(width * 0.2f, height * 0.1f)
            quadraticBezierTo(width * 0.5f, 0f, width * 0.8f, height * 0.1f)
            lineTo(width * 0.9f, height * 0.4f)
            quadraticBezierTo(width, height * 0.5f, width * 0.8f, height * 0.5f)
            lineTo(width * 0.7f, height * 0.9f)
            quadraticBezierTo(width * 0.6f, height, width * 0.5f, height * 0.8f)
            quadraticBezierTo(width * 0.4f, height, width * 0.3f, height * 0.9f)
            lineTo(width * 0.2f, height * 0.5f)
            quadraticBezierTo(0f, height * 0.5f, width * 0.1f, height * 0.4f)
            close()
        }
        
        if (isSelected) {
            drawPath(path = path, color = color, style = androidx.compose.ui.graphics.drawscope.Fill)
        } else {
            drawPath(path = path, color = color, style = Stroke(width = 2.dp.toPx()))
        }
    }
}

@Composable
fun DiagnosisContent(viewModel: EndoViewModel, onBack: () -> Unit, onSave: () -> Unit) {
    var primaryDiagnosis by remember { mutableStateOf(viewModel.patientData.value.primaryDiagnosis) }
    
    val primaryBlue = MaterialTheme.colorScheme.primary
    val textDark = MaterialTheme.colorScheme.onSurface
    val textGray = MaterialTheme.colorScheme.onSurfaceVariant
    val borderColor = MaterialTheme.colorScheme.surfaceVariant

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 24.dp, vertical = 24.dp)
    ) {
        // Diagnosis Card
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(text = "Problem identification", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = textDark)
                Spacer(modifier = Modifier.height(20.dp))
                
                FormFieldDropdown(
                    label = "Primary diagnosis",
                    value = primaryDiagnosis,
                    placeholder = "Select a common condition",
                    options = listOf(
                        "Reversible pulpitis", 
                        "Irreversible pulpitis", 
                        "Periapical Abscess", 
                        "Periapical Lesion", 
                        "Root Fracture", 
                        "Necrotic Pulp", 
                        "Failed Root Canal", 
                        "Cracked Tooth"
                    ),
                    onValueChange = { primaryDiagnosis = it }
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                Text(text = "Additional diagnosis", fontSize = 14.sp, fontWeight = FontWeight.Medium, color = textGray)
                Spacer(modifier = Modifier.height(8.dp))
                FormTextArea(placeholder = "Secondary findings, differential diagnosis, pulp test results...")
            }
        }
        
        Spacer(modifier = Modifier.height(32.dp))
        
        val isDiagnosisValid = primaryDiagnosis.isNotBlank()
        
        LaunchedEffect(primaryDiagnosis) {
            viewModel.updateDiagnosis(primaryDiagnosis, "")
        }
        
        // Bottom Actions
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(
                onClick = onBack,
                modifier = Modifier
                    .weight(0.35f)
                    .height(56.dp)
                    .border(1.dp, borderColor, RoundedCornerShape(28.dp)),
                shape = RoundedCornerShape(28.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.surface)
            ) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null, tint = textDark)
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Back", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = textDark)
            }
            
            Button(
                onClick = { 
                    if (isDiagnosisValid) {
                        viewModel.updateDiagnosis(primaryDiagnosis, "")
                        onSave() 
                    }
                },
                modifier = Modifier
                    .weight(0.65f)
                    .height(56.dp),
                shape = RoundedCornerShape(28.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isDiagnosisValid) primaryBlue else Color(0xFF90B4D8)
                )
            ) {
                Text(text = "Save & start\ntreatment", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color.White, textAlign = androidx.compose.ui.text.style.TextAlign.Center, lineHeight = 18.sp)
                Spacer(modifier = Modifier.width(8.dp))
                Icon(imageVector = Icons.Default.CheckCircleOutline, contentDescription = null, tint = Color.White)
            }
        }
        
        if (!isDiagnosisValid) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Primary diagnosis is required to save.",
                color = Color(0xFFD69E2E), // Orangeish
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
        
        Spacer(modifier = Modifier.height(48.dp))
    }
}
