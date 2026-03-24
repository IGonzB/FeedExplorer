package com.example.feedexplorer.data.impl

import com.example.feedexplorer.data.ProfessionalApi
import com.example.feedexplorer.domain.data.ProfessionalRepository
import com.example.feedexplorer.domain.model.Professional
import com.example.feedexplorer.data.mapper.toDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProfessionalRepositoryImpl @Inject constructor(
    private val api: ProfessionalApi
) : ProfessionalRepository {

    override suspend fun getProfessionals(): List<Professional> {
        return withContext(Dispatchers.IO) {
            try {
                // Production habit: You could add logic here to
                // cache the result in a Room database if needed.
                api.getProfessionals().map { it.toDomain() }
            } catch (e: Exception) {
                // Re-throw or wrap in a custom DataException
                throw e
            }
        }
    }
}