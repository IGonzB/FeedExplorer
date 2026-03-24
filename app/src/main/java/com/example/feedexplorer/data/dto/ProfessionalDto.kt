package com.example.feedexplorer.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProfessionalDto(
    @SerialName("id")
    val id: Int, // Your JSON has id as 1 (Int)

    @SerialName("first_name")
    val firstName: String,

    @SerialName("last_name")
    val lastName: String,

    @SerialName("suffix")
    val suffix: String? = null, // Optional field

    @SerialName("specialty")
    val specialty: String,

    @SerialName("npi")
    val npi: String,

    @SerialName("location")
    val location: LocationDto, // Nested Object

    @SerialName("salary_range")
    val salaryRange: String,

    @SerialName("accepting_new_patients")
    val acceptingNewPatients: Boolean
)