package com.example.feedexplorer.data.mapper

import com.example.feedexplorer.data.dto.ProfessionalDto
import com.example.feedexplorer.domain.model.Professional


// Extension function to map DTO -> Domain
fun ProfessionalDto.toDomain(): Professional {
    return Professional(
        id = this.id.toString(),
        // Format: "Duc Thinh Pham, MD"
        displayName = "${this.firstName} ${this.lastName}${if (suffix != null) ", $suffix" else ""}",
        specialty = this.specialty,
        // Format: "Houston, TX"
        fullLocation = "${this.location.city}, ${this.location.state}",
        isAvailable = this.acceptingNewPatients
    )
}