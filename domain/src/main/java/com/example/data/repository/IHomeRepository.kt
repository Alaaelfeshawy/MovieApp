package com.example.data.repository

import com.example.data.model.home.TopRatedMoviesResponse
import com.example.data.util.ApiResult
import kotlinx.coroutines.flow.Flow


interface IHomeRepository {
    suspend fun getTopRatedMovies(): Flow<ApiResult<TopRatedMoviesResponse>>
}