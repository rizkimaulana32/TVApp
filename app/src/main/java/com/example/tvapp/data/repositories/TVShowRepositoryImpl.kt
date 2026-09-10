package com.example.tvapp.data.repositories

import com.example.tvapp.core.commons.Resource
import com.example.tvapp.core.commons.safeCall
import com.example.tvapp.data.mapper.TVShowMapper.toDomain
import com.example.tvapp.data.remote.retrofit.ApiService
import com.example.tvapp.domain.models.TVShow
import com.example.tvapp.domain.models.TVShowDetail
import com.example.tvapp.domain.repositories.TVShowRepository
import javax.inject.Inject

class TVShowRepositoryImpl @Inject constructor (
    private val apiService: ApiService
) : TVShowRepository {
    override suspend fun getTVShows(): Resource<List<TVShow>> {
        return safeCall {
            apiService.getTVShows().map { it.toDomain() }
        }
    }

    override suspend fun getTVShowDetail(id: Int): Resource<TVShowDetail> {
        return safeCall {
            apiService.getTVShowDetail(id = id).toDomain()
        }
    }
}
