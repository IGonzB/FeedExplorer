package com.example.feedexplorer.presentation.view.list

import com.example.feedexplorer.domain.data.ProfessionalRepository
import com.example.feedexplorer.domain.model.Professional
import com.example.feedexplorer.domain.model.Resource
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ListViewModelTest {
    private lateinit var viewModel: ListViewModel
    private val repository = mockk<ProfessionalRepository>()
    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
    }

    @Test
    fun `fetchProfessionals should emit Success state when repository returns data`() = runTest {
        // Arrange
        val mockList = listOf(Professional("1", "John Doe", "Cardiology", "Houston, TX", true))
        coEvery { repository.getProfessionals() } returns mockList

        // Act
        viewModel = ListViewModel(repository)
        advanceUntilIdle()

        // Assert
        val state = viewModel.uiState.value
        assert(state is Resource.Success)
        TestCase.assertEquals(mockList, (state as Resource.Success).data)
    }

    @Test
    fun `fetchProfessionals should emit Error state when repository throws exception`() = runTest {
        // Arrange
        coEvery { repository.getProfessionals() } throws Exception("Network Error")

        // Act
        viewModel = ListViewModel(repository)
        advanceUntilIdle()

        // Assert
        val state = viewModel.uiState.value
        assert(state is Resource.Error)
        TestCase.assertEquals("Network Error", (state as Resource.Error).message)
    }
}