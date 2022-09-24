package com.example.data.repository

import com.example.data.entity.home.Movie
import com.example.data.util.ApiResult
import kotlinx.coroutines.flow.Flow


interface IMovieDetailsRepository {
    suspend fun getMovieDetails(movieId:Int): Flow<ApiResult<Movie>>
}