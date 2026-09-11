package com.example.tvapp.domain.usecases

import com.example.tvapp.core.commons.Resource
import com.example.tvapp.domain.models.TVShowDetail
import com.example.tvapp.domain.repositories.TVShowRepository
import javax.inject.Inject

class GetTVShowDetailUseCase @Inject constructor(
    private val repository: TVShowRepository
) {
    suspend operator fun invoke(id: Int): Resource<TVShowDetail> {
        return repository.getTVShowDetail(id)
    }
}