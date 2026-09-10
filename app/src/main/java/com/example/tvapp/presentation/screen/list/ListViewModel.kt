package com.example.tvapp.presentation.screen.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tvapp.core.commons.Resource
import com.example.tvapp.domain.usecases.GetTVShowsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val getTVShowsUseCase: GetTVShowsUseCase): ViewModel() {
    private val _uiState = MutableStateFlow<ListState>(ListState.Loading)
    val uiState get() = _uiState.asStateFlow()

    init {
        getTVShows()
    }

    private fun getTVShows() {
        viewModelScope.launch {
            _uiState.value = ListState.Loading

            when (val result = getTVShowsUseCase()) {
                is Resource.Success -> {
                    _uiState.value = ListState.Success(result.data)
                }

                is Resource.Error -> {
                    _uiState.value = ListState.Error(result.message)
                }

                is Resource.Loading -> {
                    _uiState.value = ListState.Loading
                }
            }
        }
    }

    fun retry() {
        getTVShows()
    }
}