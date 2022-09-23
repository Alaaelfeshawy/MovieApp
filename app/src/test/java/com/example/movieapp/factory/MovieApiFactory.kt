package com.example.movieapp.factory

import com.example.data.entity.home.Movie
import com.example.movieapp.model.home.MovieModel

object MovieApiFactory {
    fun generateDummyMovieApiResponseModel(): MovieModel{
        return MovieModel(
           true,
            "backdropPath",
            listOf(1),
            1,
            "originalTitle",
            "overview",
            "popularity",
            "posterPath",
            "releaseDate",
            "title",
            true,
            1.0,
            1,
        )
    }

    fun generateDummyMovieApiResponse(): Movie {
        return Movie(
            true,
            "backdropPath",
            listOf(1),
            1,
            "originalTitle",
            "overview",
            "popularity",
            "posterPath",
            "releaseDate",
            "title",
            true,
            1.0,
            1,
        )
    }
}