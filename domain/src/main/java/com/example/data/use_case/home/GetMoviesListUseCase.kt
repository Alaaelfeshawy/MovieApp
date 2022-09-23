package com.example.data.use_case.home

import com.example.data.entity.room.entity.MovieDB
import com.example.data.repository.IHomeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMoviesListUseCase @Inject constructor(
    private val homeRepository: IHomeRepository ){

    fun getMoviesList() : Flow<List<MovieDB>> {
       return homeRepository.movies
    }


}