package com.example.movieapp.model.response

import com.example.movieapp.factory.response.TopRatedMoviesFactory
import com.example.movieapp.model.home.response.TopRatedMoviesResponseModelMapper
import org.junit.Assert.*
import org.junit.Test

class TopRatedMovieModelMapperTest{
    @Test
    fun `'fromDomainTopRatedMovie()' 'with model is not null' 'then return app model same as domain model'`() {
        //arrange
        val topRatedMovie = TopRatedMoviesFactory.generateDummyMovieApiResponse()

        //act
        val topRatedMovieModel = TopRatedMoviesResponseModelMapper.mapper.fromDomain(topRatedMovie)

        //assert
        assertNotNull(topRatedMovieModel)
        assertEquals(topRatedMovieModel.results[0].adult, topRatedMovie.results[0].adult)
        assertEquals(topRatedMovieModel.results[0].backdropPath, topRatedMovie.results[0].backdropPath)
        assertEquals(topRatedMovieModel.results[0].genreIds?.get(0), topRatedMovie.results[0].genreIds?.get(0))
        assertEquals(topRatedMovieModel.results[0].id, topRatedMovie.results[0].id)
        assertEquals(topRatedMovieModel.results[0].originalTitle, topRatedMovie.results[0].originalTitle)
        assertEquals(topRatedMovieModel.results[0].overview, topRatedMovie.results[0].overview)
        assertEquals(topRatedMovieModel.results[0].popularity, topRatedMovie.results[0].popularity)
        assertEquals(topRatedMovieModel.results[0].posterPath, topRatedMovie.results[0].posterPath)
        assertEquals(topRatedMovieModel.results[0].releaseDate, topRatedMovie.results[0].releaseDate)
        assertEquals(topRatedMovieModel.results[0].title, topRatedMovie.results[0].title)
        assertEquals(topRatedMovieModel.results[0].voteAverage, topRatedMovie.results[0].voteAverage)
        assertEquals(topRatedMovieModel.results[0].voteCount, topRatedMovie.results[0].voteCount)
        assertEquals(topRatedMovieModel.results[0].video, topRatedMovie.results[0].video)

    }

    @Test
    fun `'fromDomainTopRatedMovie()' 'with model is null' 'then return app model is null'`() {
        //arrange
        val topRatedMovieModel = null

        //act
        val topRatedMovie = TopRatedMoviesResponseModelMapper.mapper.fromDomain(topRatedMovieModel)

        //assert
        assertNull(topRatedMovie)
    }
}