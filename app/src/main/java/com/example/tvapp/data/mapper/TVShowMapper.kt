package com.example.tvapp.data.mapper


import com.example.tvapp.data.remote.dto.ListTVShowsResponseItem
import com.example.tvapp.data.remote.dto.TVShowDetailResponse
import com.example.tvapp.domain.models.TVShowDetail
import com.example.tvapp.domain.models.TVShow

object TVShowMapper {
    fun ListTVShowsResponseItem.toDomain(): TVShow {
        return TVShow(
            id = id,
            posterMedium = image?.medium,
            title = name,
            rating = rating?.average
        )
    }

    fun TVShowDetailResponse.toDomain(): TVShowDetail{
        return TVShowDetail(
            id = id,
            posterOriginal = image?.original,
            title = name,
            summary = summary,
            premiereDate = premiered
        )
    }
}