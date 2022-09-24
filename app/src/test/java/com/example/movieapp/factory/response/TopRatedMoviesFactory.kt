package com.example.movieapp.factory.response

import com.example.data.entity.home.TopRatedMoviesResponse
import com.example.movieapp.factory.MovieApiFactory
import com.example.movieapp.model.home.response.TopRatedMoviesResponseModel

object TopRatedMoviesFactory {

    fun generateDummyMovieApiResponseModel(): TopRatedMoviesResponseModel {
        return TopRatedMoviesResponseModel(
            listOf(MovieApiFactory.generateDummyMovieApiResponseModel())
        )
    }

    fun generateDummyMovieApiResponse(): TopRatedMoviesResponse {
        return TopRatedMoviesResponse(
            listOf(MovieApiFactory.generateDummyMovieApiResponse())
        )
    }
}