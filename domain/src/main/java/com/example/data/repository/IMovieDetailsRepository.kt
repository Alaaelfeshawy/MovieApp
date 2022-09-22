package com.example.data.repository

import com.example.data.model.home.Movie
import com.example.data.model.home.TopRatedMoviesResponse
import com.example.data.util.ApiResult
import kotlinx.coroutines.flow.Flow


interface IMovieDetailsRepository {
    suspend fun getMovieDetails(movieId:Int): Flow<ApiResult<Movie>>
}