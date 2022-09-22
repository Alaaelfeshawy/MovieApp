package com.example.data.use_case.home

import com.example.data.model.home.Movie
import com.example.data.repository.IMovieDetailsRepository
import com.example.data.use_case.base.FlowableUseCaseWithParams
import com.example.data.util.ApiResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(
    private val movieDetailsRepository: IMovieDetailsRepository
) : FlowableUseCaseWithParams<Movie , Int>() {

    override suspend fun run(params: Int): Flow<ApiResult<Movie>> {
        return movieDetailsRepository.getMovieDetails(params)
    }


}