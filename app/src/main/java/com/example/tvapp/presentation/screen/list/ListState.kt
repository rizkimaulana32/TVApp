package com.example.tvapp.presentation.screen.list

import com.example.tvapp.domain.models.TVShow

sealed interface ListState {
    data object Loading : ListState
    data class Success(val result: List<TVShow>) : ListState
    data class Error(val message: String) : ListState
}