package com.example.data.source.remote

import com.example.data.entity.home.MovieEntity
import com.example.data.entity.home.response.TopRatedMoviesResponseEntity
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.*
import javax.inject.Named

interface MovieDetailsApi {

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(@Path("movie_id") movieId:Int,@Query("api_key") apiKey : String): Response<MovieEntity>
}