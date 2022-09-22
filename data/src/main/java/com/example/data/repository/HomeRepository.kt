package com.example.data.repository

import com.example.data.entity.home.response.TopRatedMoviesResponseEntityMapper
import com.example.data.model.home.TopRatedMoviesResponse
import com.example.data.source.remote.HomeApi
import com.example.data.util.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class HomeRepository(
    private val homeApi: HomeApi,
    private var fromTest : Boolean = false) :
    BaseRepository(fromTest) , IHomeRepository{
    @Inject
    constructor(homeApi: HomeApi) : this(homeApi,fromTest =false)

    override suspend fun getTopRatedMovies(): Flow<ApiResult<TopRatedMoviesResponse>> {
      return  flow {
          handleApi { homeApi.getTopRatedMovies(apiToken)}.let {
              when(it){
                  is ApiSuccess->{
                      val response = TopRatedMoviesResponseEntityMapper.mapper.toDomain(it.data)
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