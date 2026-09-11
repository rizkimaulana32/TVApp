package com.example.tvapp.presentation.screen.detail

import com.example.tvapp.domain.models.TVShowDetail

sealed interface DetailState {
    data object Loading : DetailState
    data class Success(val result: TVShowDetail) : DetailState
    data class Error(val message: String) : DetailState
}