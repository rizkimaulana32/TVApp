package com.example.tvapp.presentation.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tvapp.core.commons.Resource
import com.example.tvapp.domain.usecases.GetTVShowDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val getTVShowDetailUseCase: GetTVShowDetailUseCase): ViewModel() {
    private val _uiState = MutableStateFlow<DetailState>(DetailState.Loading)
    val uiState get() = _uiState.asStateFlow()

    fun getTVShowDetail(id: Int) {
        viewModelScope.launch {
            _uiState.value = DetailState.Loading

            when (val result = getTVShowDetailUseCase(id)) {
                is Resource.Success -> {
                    _uiState.value = DetailState.Success(result.data)
                }

                is Resource.Error -> {
                    _uiState.value = DetailState.Error(result.message)
                }

                is Resource.Loading -> {
                    _uiState.value = DetailState.Loading
                }
            }
        }
    }
}