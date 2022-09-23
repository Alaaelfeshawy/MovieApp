package com.example.data.remote

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.data.entity.home.response.TopRatedMoviesResponseEntity
import com.example.data.factory.response.TopRatedMoviesFactory
import com.example.data.source.remote.HomeApi
import com.example.data.utils.TestUtils
import com.google.gson.Gson
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.*
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.*
import org.junit.rules.TestRule
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.net.HttpURLConnection

@ExperimentalCoroutinesApi
class HomeApiTest {
    private lateinit var SUT: HomeApi
    private lateinit var moshi: Moshi
    private lateinit var mockWebServer: MockWebServer

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()


    @OptIn(DelicateCoroutinesApi::class)
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @Before
    fun setup() {
        mockWebServer = MockWebServer()
        moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()


        SUT = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(HomeApi::class.java)

        Dispatchers.setMain(mainThreadSurrogate)

    }

    @After
    fun stopService() {
        mockWebServer.shutdown()
        Dispatchers.resetMain()
        mainThreadSurrogate.close()
    }


    @Test
    fun `getTopRatedMovies() 'with path' 'then return member movie response'`() = runTest{
        withContext(Dispatchers.Default) {
            //arrange
            val topRatedMovieEntity = TopRatedMoviesFactory.generateDummyMovieApiResponseEntity()
            val mockResponse = MockResponse()
                .setResponseCode(HttpURLConnection.HTTP_OK)
                .setBody(TestUtils.getJson("home/top_rated_movies.json"))
            mockWebServer.enqueue(mockResponse)
            //act
            val results = SUT.getTopRatedMovies("apiKey").body()
            //assert
            Assert.assertEquals(results, topRatedMovieEntity)
        }
    }

}