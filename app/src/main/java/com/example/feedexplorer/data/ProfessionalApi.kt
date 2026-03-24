package com.example.feedexplorer.data

import com.example.feedexplorer.data.dto.ProfessionalDto
import retrofit2.http.GET

interface ProfessionalApi {
    @GET("v1/5bb09ab0-8d6d-4d85-8284-b6a467299353")
     suspend fun getProfessionals(): List<ProfessionalDto>
}