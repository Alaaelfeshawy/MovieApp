package com.example.movieapp.model

import com.example.movieapp.factory.MovieApiFactory
import com.example.movieapp.model.home.MovieModelMapper
import org.junit.Assert.*
import org.junit.Test

class MovieModelMapperTest{
    @Test
    fun `'fromDomainMovieModel()' 'with model is not null' 'then return app model same as domain model'`() {
        //arrange
        val movie = MovieApiFactory.generateDummyMovieApiResponse()

        //act
        val movieModel = MovieModelMapper.mapper.fromDomain(movie)

        //assert
        assertNotNull(movieModel)
        assertEquals(movieModel.adult, movie.adult)
        assertEquals(movieModel.backdropPath, movie.backdropPath)
        assertEquals(movieModel.genreIds?.get(0), movie.genreIds?.get(0))
        assertEquals(movieModel.id, movie.id)
        assertEquals(movieModel.originalTitle, movie.originalTitle)
        assertEquals(movieModel.overview, movie.overview)
        assertEquals(movieModel.popularity, movie.popularity)
        assertEquals(movieModel.posterPath, movie.posterPath)
        assertEquals(movieModel.releaseDate, movie.releaseDate)
        assertEquals(movieModel.title, movie.title)
        assertEquals(movieModel.voteAverage, movie.voteAverage)
        assertEquals(movieModel.voteCount, movie.voteCount)
        assertEquals(movieModel.video, movie.video)

    }

    @Test
    fun `'fromDomainMovieModel()' 'with model is null' 'then return app model is null'`() {
        //arrange
        val movie = null

        //act
        val movieModel = MovieModelMapper.mapper.fromDomain(movie)

        //assert
        assertNull(movieModel)
    }
}