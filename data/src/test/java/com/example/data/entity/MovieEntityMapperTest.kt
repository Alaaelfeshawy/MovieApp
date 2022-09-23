package com.example.data.entity
import com.example.data.entity.home.MovieEntityMapper
import com.example.data.factory.MovieApiFactory
import org.junit.Assert.*
import org.junit.Test

class MovieEntityMapperTest {
    @Test
    fun `'fromDomainMovie()' 'with model is not null' 'then return app model same as domain model'`() {
        //arrange
        val movie = MovieApiFactory.generateDummyMovieApiResponse()

        //act
        val movieEntity = MovieEntityMapper.mapper.fromDomain(movie)

        //assert
        assertNotNull(movieEntity)
        assertEquals(movieEntity.adult, movie.adult)
        assertEquals(movieEntity.backdropPath, movie.backdropPath)
        assertEquals(movieEntity.genreIds?.get(0), movie.genreIds?.get(0))
        assertEquals(movieEntity.id, movie.id)
        assertEquals(movieEntity.originalTitle, movie.originalTitle)
        assertEquals(movieEntity.overview, movie.overview)
        assertEquals(movieEntity.popularity, movie.popularity)
        assertEquals(movieEntity.posterPath, movie.posterPath)
        assertEquals(movieEntity.releaseDate, movie.releaseDate)
        assertEquals(movieEntity.title, movie.title)
        assertEquals(movieEntity.voteAverage, movie.voteAverage)
        assertEquals(movieEntity.voteCount, movie.voteCount)
        assertEquals(movieEntity.video, movie.video)

    }

    @Test
    fun `'fromDomainMovie()' 'with model is null' 'then return app model is null'`() {
        //arrange
        val movie = null

        //act
        val movieEntity = MovieEntityMapper.mapper.fromDomain(movie)

        //assert
        assertNull(movieEntity)
    }

    @Test
    fun `'fromDomainListMovie()' 'with model is not null' 'then return app model same as domain model'`() {
        //arrange
        val movie = MovieApiFactory.generateDummyMovieApiResponse()

        //act
        val movieEntity = MovieEntityMapper.mapper.fromDomainList(listOf(movie))

        //assert
        assertNotNull(movieEntity)
        assertEquals(movieEntity[0].adult, movie.adult)
        assertEquals(movieEntity[0].backdropPath, movie.backdropPath)
        assertEquals(movieEntity[0].genreIds?.get(0), movie.genreIds?.get(0))
        assertEquals(movieEntity[0].id, movie.id)
        assertEquals(movieEntity[0].originalTitle, movie.originalTitle)
        assertEquals(movieEntity[0].overview, movie.overview)
        assertEquals(movieEntity[0].popularity, movie.popularity)
        assertEquals(movieEntity[0].posterPath, movie.posterPath)
        assertEquals(movieEntity[0].releaseDate, movie.releaseDate)
        assertEquals(movieEntity[0].title, movie.title)
        assertEquals(movieEntity[0].voteAverage, movie.voteAverage)
        assertEquals(movieEntity[0].voteCount, movie.voteCount)
        assertEquals(movieEntity[0].video, movie.video)

    }

    @Test
    fun `'fromDomainListMovie()' 'with model is null' 'then return app model is null'`() {
        //arrange
        val movie = null

        //act
        val movieEntity = MovieEntityMapper.mapper.fromDomainList(movie)

        //assert
        assertNull(movieEntity)
    }
    @Test
    fun `'toDomainMovie()' 'with model is not null' 'then return app model same as domain model'`() {
        //arrange
        val movieEntity = MovieApiFactory.generateDummyMovieApiResponseEntity()

        //act
        val movie = MovieEntityMapper.mapper.toDomain(movieEntity)

        //assert
        assertNotNull(movie)
        assertEquals(movie.adult, movie.adult)
        assertEquals(movie.backdropPath, movie.backdropPath)
        assertEquals(movie.genreIds?.get(0), movie.genreIds?.get(0))
        assertEquals(movie.id, movie.id)
        assertEquals(movie.originalTitle, movie.originalTitle)
        assertEquals(movie.overview, movie.overview)
        assertEquals(movie.popularity, movie.popularity)
        assertEquals(movie.posterPath, movie.posterPath)
        assertEquals(movie.releaseDate, movie.releaseDate)
        assertEquals(movie.title, movie.title)
        assertEquals(movie.voteAverage, movie.voteAverage)
        assertEquals(movie.voteCount, movie.voteCount)
        assertEquals(movie.video, movie.video)

    }

    @Test
    fun `'toDomainMovie()' 'with model is null' 'then return app model is null'`() {
        //arrange
        val movieEntity = null

        //act
        val movie = MovieEntityMapper.mapper.toDomain(movieEntity)

        //assert
        assertNull(movie)
    }
}
