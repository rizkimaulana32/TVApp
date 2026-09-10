package com.example.tvapp.core.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen {
    @Serializable
    object List

    @Serializable
    data class Detail(
        val id: Int
    )
}