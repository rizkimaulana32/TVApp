package com.example.tvapp.data.remote.retrofit

import com.example.tvapp.data.remote.dto.ListTVShowsResponseItem
import com.example.tvapp.data.remote.dto.TVShowDetailResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("shows")
    suspend fun getTVShows(
        @Query("page") page: Int = 0
    ): List<ListTVShowsResponseItem>

    @GET("shows/{id}")
    suspend fun getTVShowDetail(
        @Path("id") id: Int = 0
    ): TVShowDetailResponse
}