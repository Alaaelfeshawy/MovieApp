package com.example.data.factory.response
import com.example.data.entity.home.response.TopRatedMoviesResponseEntity
import com.example.data.entity.home.TopRatedMoviesResponse
import com.example.data.factory.MovieApiFactory

object TopRatedMoviesFactory {

    fun generateDummyMovieApiResponseEntity(): TopRatedMoviesResponseEntity {
        return TopRatedMoviesResponseEntity(
            listOf(MovieApiFactory.generateDummyMovieApiResponseEntity())
        )
    }

    fun generateDummyMovieApiResponse(): TopRatedMoviesResponse {
        return TopRatedMoviesResponse(
            listOf(MovieApiFactory.generateDummyMovieApiResponse())
        )
    }
}