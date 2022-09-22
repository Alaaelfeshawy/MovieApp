package com.example.data.use_case.home

import com.example.data.model.room.entity.MovieDB
import com.example.data.repository.IHomeRepository
import com.example.data.use_case.base.FlowableUseCaseWithoutParams
import com.example.data.util.ApiResult
import com.example.data.util.ApiSuccess
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMoviesListUseCase @Inject constructor(
    private val homeRepository: IHomeRepository ){

    fun getMoviesList() : Flow<List<MovieDB>> {
       return homeRepository.movies
    }


}