package com.example.tvapp.domain.usecases

import com.example.tvapp.core.commons.Resource
import com.example.tvapp.domain.models.TVShow
import com.example.tvapp.domain.repositories.TVShowRepository
import javax.inject.Inject

class GetTVShowsUseCase @Inject constructor(
    private val repository: TVShowRepository
) {
    suspend operator fun invoke(): Resource<List<TVShow>> {
        return repository.getTVShows()
    }
}