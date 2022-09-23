package com.example.data.entity.response
import com.example.data.entity.home.response.TopRatedMoviesResponseEntityMapper
import com.example.data.factory.response.TopRatedMoviesFactory
import org.junit.Assert.*
import org.junit.Test

class TopRatedMovieEntityMapperTest{
    @Test
    fun `'fromDomainTopRatedMovie()' 'with model is not null' 'then return app model same as domain model'`() {
        //arrange
        val topRatedMovie = TopRatedMoviesFactory.generateDummyMovieApiResponse()

        //act
        val topRatedMovieEntity = TopRatedMoviesResponseEntityMapper.mapper.fromDomain(topRatedMovie)

        //assert
        assertNotNull(topRatedMovieEntity)
        assertEquals(topRatedMovieEntity.results[0].adult, topRatedMovie.results[0].adult)
        assertEquals(topRatedMovieEntity.results[0].backdropPath, topRatedMovie.results[0].backdropPath)
        assertEquals(topRatedMovieEntity.results[0].genreIds?.get(0), topRatedMovie.results[0].genreIds?.get(0))
        assertEquals(topRatedMovieEntity.results[0].id, topRatedMovie.results[0].id)
        assertEquals(topRatedMovieEntity.results[0].originalTitle, topRatedMovie.results[0].originalTitle)
        assertEquals(topRatedMovieEntity.results[0].overview, topRatedMovie.results[0].overview)
        assertEquals(topRatedMovieEntity.results[0].popularity, topRatedMovie.results[0].popularity)
        assertEquals(topRatedMovieEntity.results[0].posterPath, topRatedMovie.results[0].posterPath)
        assertEquals(topRatedMovieEntity.results[0].releaseDate, topRatedMovie.results[0].releaseDate)
        assertEquals(topRatedMovieEntity.results[0].title, topRatedMovie.results[0].title)
        assertEquals(topRatedMovieEntity.results[0].voteAverage, topRatedMovie.results[0].voteAverage)
        assertEquals(topRatedMovieEntity.results[0].voteCount, topRatedMovie.results[0].voteCount)
        assertEquals(topRatedMovieEntity.results[0].video, topRatedMovie.results[0].video)

    }

    @Test
    fun `'fromDomainTopRatedMovie()' 'with model is null' 'then return app model is null'`() {
        //arrange
        val topRatedMovie = null

        //act
        val topRatedMovieEntity = TopRatedMoviesResponseEntityMapper.mapper.fromDomain(topRatedMovie)

        //assert
        assertNull(topRatedMovieEntity)
    }

    @Test
    fun `'toDomainTopRatedMovie()' 'with model is not null' 'then return app model same as domain model'`() {
        //arrange
        val topRatedMovieEntity = TopRatedMoviesFactory.generateDummyMovieApiResponseEntity()

        //act
        val topRatedMovie = TopRatedMoviesResponseEntityMapper.mapper.toDomain(topRatedMovieEntity)

        //assert
        assertNotNull(topRatedMovie)
        assertEquals(topRatedMovie.results[0].adult, topRatedMovieEntity.results[0].adult)
        assertEquals(topRatedMovie.results[0].backdropPath, topRatedMovieEntity.results[0].backdropPath)
        assertEquals(topRatedMovie.results[0].genreIds?.get(0), topRatedMovieEntity.results[0].genreIds?.get(0))
        assertEquals(topRatedMovie.results[0].id, topRatedMovieEntity.results[0].id)
        assertEquals(topRatedMovie.results[0].originalTitle, topRatedMovieEntity.results[0].originalTitle)
        assertEquals(topRatedMovie.results[0].overview, topRatedMovieEntity.results[0].overview)
        assertEquals(topRatedMovie.results[0].popularity, topRatedMovieEntity.results[0].popularity)
        assertEquals(topRatedMovie.results[0].posterPath, topRatedMovieEntity.results[0].posterPath)
        assertEquals(topRatedMovie.results[0].releaseDate, topRatedMovieEntity.results[0].releaseDate)
        assertEquals(topRatedMovie.results[0].title, topRatedMovieEntity.results[0].title)
        assertEquals(topRatedMovie.results[0].voteAverage, topRatedMovieEntity.results[0].voteAverage)
        assertEquals(topRatedMovie.results[0].voteCount, topRatedMovieEntity.results[0].voteCount)
        assertEquals(topRatedMovie.results[0].video, topRatedMovieEntity.results[0].video)

    }

    @Test
    fun `'toDomainTopRatedMovie()' 'with model is null' 'then return app model is null'`() {
        //arrange
        val topRatedMovieEntity = null

        //act
        val topRatedMovie = TopRatedMoviesResponseEntityMapper.mapper.toDomain(topRatedMovieEntity)

        //assert
        assertNull(topRatedMovie)
    }
}