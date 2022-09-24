package com.example.data.repositories

import com.example.data.entity.home.Movie
import com.example.data.entity.home.TopRatedMoviesResponse
import com.example.data.factory.MovieApiFactory
import com.example.data.factory.response.TopRatedMoviesFactory
import com.example.data.repository.DBRepository
import com.example.data.repository.HomeRepository
import com.example.data.repository.MovieDetailsRepository
import com.example.data.source.local.room.dao.movie.MovieDao
import com.example.data.source.remote.HomeApi
import com.example.data.source.remote.MovieDetailsApi
import com.example.data.util.ApiSuccess
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class MovieDetailsRepositoryTest {
    private lateinit var SUT: MovieDetailsRepository

    @Mock
    private lateinit var movieDetailsApi: MovieDetailsApi

    @Before
    fun setup() {
        SUT = MovieDetailsRepository(movieDetailsApi,true)
    }

    @Test
    fun `'getMovieData()' 'with token' 'then return movie info response'`() = runTest{
        // Arrange
        val movieEntity = MovieApiFactory.generateDummyMovieApiResponseEntity()
        val movieDomain = MovieApiFactory.generateDummyMovieApiResponse()

        var actual = ApiSuccess(movieDomain)

        Mockito.`when`(movieDetailsApi.getMovieDetails(1,"apiKey"))
            .thenReturn(Response.success(movieEntity))
        // Act
        SUT.getMovieDetails(1).collect{
            actual = it as ApiSuccess<Movie>
        }

        Mockito.verify(movieDetailsApi, Mockito.times(1)).getMovieDetails(1,"apiKey")

        // Assert
        Assert.assertEquals(actual.data , movieDomain)

    }

}