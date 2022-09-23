package com.example.data.use_case.home

import com.example.data.entity.home.TopRatedMoviesResponse
import com.example.data.repository.IHomeRepository
import com.example.data.use_case.base.FlowableUseCaseWithoutParams
import com.example.data.util.ApiResult
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class GetTopRatedMoviesUseCase @Inject constructor(
    private val homeRepository: IHomeRepository
) : FlowableUseCaseWithoutParams<TopRatedMoviesResponse>() {
    override suspend fun run(): Flow<ApiResult<TopRatedMoviesResponse>> {
        return homeRepository.getTopRatedMovies()
    }


}