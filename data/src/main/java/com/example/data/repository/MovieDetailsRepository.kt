package com.example.data.repository

import com.example.data.entity.home.MovieEntityMapper
import com.example.data.entity.home.response.TopRatedMoviesResponseEntityMapper
import com.example.data.model.home.Movie
import com.example.data.model.home.TopRatedMoviesResponse
import com.example.data.source.remote.HomeApi
import com.example.data.source.remote.MovieDetailsApi
import com.example.data.util.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieDetailsRepository(
    private val movieDetailsApi: MovieDetailsApi,
    private var fromTest : Boolean = false) :
    BaseRepository(fromTest) , IMovieDetailsRepository{
    @Inject
    constructor(movieDetailsApi: MovieDetailsApi) : this(movieDetailsApi,fromTest =false)

    override suspend fun getMovieDetails(movieId: Int): Flow<ApiResult<Movie>> {
        return  flow {
            handleApi { movieDetailsApi.getMovieDetails(movieId,apiToken)}.let {
                when(it){
                    is ApiSuccess->{
                        val response = MovieEntityMapper.mapper.toDomain(it.data)
                        emit(ApiSuccess(response))
                    }
                    is  ApiError->{
                        emit(ApiError(it.code , it.message , it.errorStatus))
                    }
                }
            }
        }
    }
}