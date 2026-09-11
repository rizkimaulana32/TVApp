package com.example.tvapp.presentation.screen.detail

import com.example.tvapp.core.commons.Resource
import com.example.tvapp.domain.models.TVShowDetail
import com.example.tvapp.domain.usecases.GetTVShowDetailUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@OptIn(ExperimentalCoroutinesApi::class)
class DetailViewModelTest {

    private val dispatcher = StandardTestDispatcher()
    private lateinit var getTVShowDetailUseCase: GetTVShowDetailUseCase
    private lateinit var viewModel: DetailViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
        getTVShowDetailUseCase = mock()
        viewModel = DetailViewModel(getTVShowDetailUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `getTVShowDetail success should update uiState with Success`() = runTest {
        val dummyId = 1
        val dummyDetail = TVShowDetail(
            id = 1,
            posterOriginal = "https://www.naruwo.com",
            title = "Naruwo",
            summary = "Naruto adalah anak presiden indonesia ke tujuh",
            premiereDate = "2026-07-09",
            url = "https://blognaruwo.com"
        )
        whenever(getTVShowDetailUseCase(dummyId)).thenReturn(Resource.Success(dummyDetail))

        viewModel.getTVShowDetail(1)
        advanceUntilIdle()

        val result = viewModel.uiState.value
        assertTrue(result is DetailState.Success)
        assertEquals(dummyDetail, (result as DetailState.Success).result)
    }

    @Test
    fun `getTVShowDetail failure should update uiState with Error`() = runTest {
        val dummyId = 1
        val errorMessage = "Terjadi kesalahan tidak terduga."
        whenever(getTVShowDetailUseCase(dummyId)).thenReturn(Resource.Error(errorMessage))

        viewModel.getTVShowDetail(1)
        advanceUntilIdle()

        val result = viewModel.uiState.value
        assertTrue(result is DetailState.Error)
        assertEquals(errorMessage, (result as DetailState.Error).message)
    }
}