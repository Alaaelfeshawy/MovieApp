package com.example.data.repository

import com.example.data.model.home.TopRatedMoviesResponse
import com.example.data.model.room.entity.MovieDB
import com.example.data.util.ApiResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow


interface IHomeRepository {
    val movies: Flow<List<MovieDB>>

    suspend fun getTopRatedMovies(): Flow<ApiResult<TopRatedMoviesResponse>>
}