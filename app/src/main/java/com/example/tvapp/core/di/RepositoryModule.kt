package com.example.tvapp.core.di

import com.example.tvapp.data.repositories.TVShowRepositoryImpl
import com.example.tvapp.domain.repositories.TVShowRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindsTVShowRepository(tvShowRepositoryImpl: TVShowRepositoryImpl): TVShowRepository
}