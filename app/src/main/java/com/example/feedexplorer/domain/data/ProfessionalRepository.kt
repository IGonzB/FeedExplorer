package com.example.feedexplorer.domain.data

import com.example.feedexplorer.data.dto.ProfessionalDto
import com.example.feedexplorer.domain.model.Professional

interface ProfessionalRepository {
    suspend fun getProfessionals(): List<Professional>
}