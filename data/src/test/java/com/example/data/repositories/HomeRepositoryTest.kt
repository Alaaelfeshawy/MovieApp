package com.example.data.repositories

import com.example.data.entity.home.TopRatedMoviesResponse
import com.example.data.factory.response.TopRatedMoviesFactory
import com.example.data.repository.DBRepository
import com.example.data.repository.HomeRepository
import com.example.data.source.local.room.dao.movie.MovieDao
import com.example.data.source.remote.HomeApi
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
class HomeRepositoryTest {
    private lateinit var SUT: HomeRepository

    @Mock
    private lateinit var homeApi: HomeApi

    @Mock
    private lateinit var dao: MovieDao

    @Mock
    private lateinit var roomRepository:DBRepository

    @Before
    fun setup() {
        roomRepository = DBRepository(dao)
        SUT = HomeRepository(homeApi, roomRepository,true)
    }

    @Test
    fun `'getMovieData()' 'with token' 'then return movie info response'`() = runTest{
        // Arrange
        val topRatedMovieEntity = TopRatedMoviesFactory.generateDummyMovieApiResponseEntity()
        val topRatedMovieDomain = TopRatedMoviesFactory.generateDummyMovieApiResponse()

        var actual = ApiSuccess(topRatedMovieDomain)

        Mockito.`when`(homeApi.getTopRatedMovies("apiKey"))
            .thenReturn(Response.success(topRatedMovieEntity))
        // Act
        SUT.getTopRatedMovies().collect{
            actual = it as ApiSuccess<TopRatedMoviesResponse>
        }

        Mockito.verify(homeApi, Mockito.times(1)).getTopRatedMovies("apiKey")

        // Assert
        Assert.assertEquals(actual.data , topRatedMovieDomain)

    }

}