package com.example.feedexplorer.presentation.view.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feedexplorer.domain.model.Resource
import com.example.feedexplorer.domain.data.ProfessionalRepository
import com.example.feedexplorer.domain.model.Professional
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val repository: ProfessionalRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<Resource<List<Professional>>>(Resource.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        fetchProfessionals()
    }

    fun fetchProfessionals() {
        viewModelScope.launch {
            _uiState.value = Resource.Loading
            try {
                val data = repository.getProfessionals()
                _uiState.value = Resource.Success(data)
            } catch (e: Exception) {
                _uiState.value = Resource.Error(e.localizedMessage ?: "Unknown Error")
            }
        }
    }
}