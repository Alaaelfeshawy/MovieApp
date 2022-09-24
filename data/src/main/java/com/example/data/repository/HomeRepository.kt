package com.example.data.repository

import com.example.data.entity.home.response.TopRatedMoviesResponseEntityMapper
import com.example.data.entity.home.TopRatedMoviesResponse
import com.example.data.entity.room.entity.MovieDB
import com.example.data.source.remote.HomeApi
import com.example.data.util.ApiError
import com.example.data.util.ApiResult
import com.example.data.util.ApiSuccess
import com.example.data.util.handleApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class HomeRepository(
    private val homeApi: HomeApi,
    private val dbRepository: IRoomDBRepository,
    private var fromTest : Boolean = false) :
    BaseRepository(fromTest) , IHomeRepository{
    @Inject
    constructor(homeApi: HomeApi , dbRepository: IRoomDBRepository) :
            this(homeApi,dbRepository,fromTest =false)

    override val movies: Flow<List<MovieDB>>
        get() = dbRepository.getAllMovies()


    override suspend fun getTopRatedMovies(): Flow<ApiResult<TopRatedMoviesResponse>> {
      return  flow {
          handleApi { homeApi.getTopRatedMovies(apiToken)}.let {
              when(it){
                  is ApiSuccess->{
                      val response = TopRatedMoviesResponseEntityMapper.mapper.toDomain(it.data)
                      dbRepository.insertMovies(response.results)
                  }
                  is  ApiError->{
                      emit(ApiError(it.code , it.message , it.errorStatus))
                  }
              }
          }
      }
    }
}