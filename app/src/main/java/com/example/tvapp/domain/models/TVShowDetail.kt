package com.example.tvapp.domain.models

data class TVShowDetail(
    val id: Int,
    val posterOriginal: String?,
    val title: String?,
    val summary: String?,
    val premiereDate: String?,
    val url: String?
)