package com.example.feedexplorer.data.mapper

import com.example.feedexplorer.data.dto.LocationDto
import com.example.feedexplorer.data.dto.ProfessionalDto
import junit.framework.TestCase
import org.junit.Test

class DtoMapperTest {
    @Test
    fun `map DTO to Domain should format location and name correctly`() {
        // Arrange
        val dto = ProfessionalDto(
            id = 1,
            firstName = "Duc Thinh",
            lastName = "Pham",
            suffix = "MD",
            location = LocationDto(city = "Houston", state = "TX"),
            specialty = "Cardiology",
            acceptingNewPatients = true,
            npi = "123",
            salaryRange = "N/A"
        )

        // Act
        val domain = dto.toDomain()

        // Assert
        TestCase.assertEquals("Duc Thinh Pham, MD", domain.displayName)
        TestCase.assertEquals("Houston, TX", domain.fullLocation)
        TestCase.assertEquals(true, domain.isAvailable)
    }
}