package com.example.data.repository

import com.example.data.entity.home.TopRatedMoviesResponse
import com.example.data.entity.room.entity.MovieDB
import com.example.data.util.ApiResult
import kotlinx.coroutines.flow.Flow


interface IHomeRepository {
    val movies: Flow<List<MovieDB>>

    suspend fun getTopRatedMovies(): Flow<ApiResult<TopRatedMoviesResponse>>
}