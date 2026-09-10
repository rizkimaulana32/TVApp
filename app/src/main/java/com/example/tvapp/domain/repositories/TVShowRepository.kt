package com.example.tvapp.domain.repositories

import com.example.tvapp.core.commons.Resource
import com.example.tvapp.domain.models.TVShow
import com.example.tvapp.domain.models.TVShowDetail

interface TVShowRepository {
    suspend fun getTVShows(): Resource<List<TVShow>>
    suspend fun getTVShowDetail(id: Int): Resource<TVShowDetail>
}