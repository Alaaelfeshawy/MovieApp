package com.example.data.factory

import com.example.data.entity.home.MovieEntity
import com.example.data.entity.home.Movie

object MovieApiFactory {
    fun generateDummyMovieApiResponseEntity(): MovieEntity{
        return MovieEntity(
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