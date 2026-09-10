package com.example.tvapp.data.remote.retrofit

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("shows")
    suspend fun getTVShows(
        @Query("page") page: Int = 0
    )

    @GET("shows/{id}")
    suspend fun getTVShowDetail(
        @Query("id") id: Int = 0
    )
}