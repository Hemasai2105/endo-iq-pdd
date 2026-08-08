package com.simats.endo

import kotlinx.serialization.Serializable

@Serializable
data class PatientDto(
    val id: String? = null,
    val doctor_id: String? = null,
    val patient_id: String,
    val full_name: String,
    val age: String,
    val gender: String,
    val primary_diagnosis: String,
    val selected_teeth: List<Int>,
    val conditions: List<String>,
    val smoking: Boolean,
    val alcohol: Boolean,
    val created_at: String? = null
)

@Serializable
data class ReportDto(
    val id: String? = null,
    val doctor_id: String? = null,
    val patient_uuid: String,
    val report_data: List<TreatmentStageDto>,
    val created_at: String? = null
)

@Serializable
data class TreatmentStageDto(
    val id: Int,
    val title: String,
    val description: String,
    val aiText: String,
    val durationMin: Int
)

@Serializable
data class AppointmentDto(
    val id: String? = null,
    val doctor_id: String? = null,
    val patient_uuid: String,
    val appointment_date: String,
    val status: String,
    val created_at: String? = null
)
