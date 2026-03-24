package com.example.feedexplorer.presentation.view.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.feedexplorer.data.dto.ProfessionalDto
import com.example.feedexplorer.domain.model.Resource
import com.example.feedexplorer.domain.data.ProfessionalRepository
import com.example.feedexplorer.domain.model.Professional
import com.example.feedexplorer.presentation.nav.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: ProfessionalRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    // Automatically reconstructs the Detail route object from the navigation arguments
    private val detailArgs = savedStateHandle.toRoute<Screen.Detail>()

    private val _uiState = MutableStateFlow<Resource<Professional>>(Resource.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        loadProfessionalDetail()
    }

    private fun loadProfessionalDetail() {
        viewModelScope.launch {
            _uiState.value = Resource.Loading
            try {
                // In a real app, this might be a DB query or a specific API call:
                // repository.getProfessionalById(detailArgs.id)
                val allItems = repository.getProfessionals()
                val item = allItems.find { it.id == detailArgs.id }

                if (item != null) {
                    _uiState.value = Resource.Success(item)
                } else {
                    _uiState.value = Resource.Error("Professional not found")
                }
            } catch (e: Exception) {
                _uiState.value = Resource.Error(e.localizedMessage ?: "Connection Error")
            }
        }
    }
}