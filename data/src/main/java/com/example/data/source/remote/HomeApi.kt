package com.example.data.source.remote

import com.example.data.entity.home.response.TopRatedMoviesResponseEntity
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.*
import javax.inject.Named

interface HomeApi {

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies( @Query("api_key") apiKey : String): Response<TopRatedMoviesResponseEntity>
}