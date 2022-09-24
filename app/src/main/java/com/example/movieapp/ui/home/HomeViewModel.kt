package com.example.movieapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.entity.home.TopRatedMoviesResponse
import com.example.data.use_case.home.GetMoviesListUseCase
import com.example.data.use_case.home.GetTopRatedMoviesUseCase
import com.example.data.util.ErrorStatus
import com.example.data.util.ResponseResult
import com.example.movieapp.model.home.response.TopRatedMoviesResponseModel
import com.example.movieapp.model.room.entity.MovieModel
import com.example.movieapp.model.room.entity.MovieModelMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel  @Inject constructor(
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase,
    private val getMoviesListUseCase: GetMoviesListUseCase,
    ) :  ViewModel(){
    val state = MutableStateFlow<HomeState<TopRatedMoviesResponseModel>>(HomeState.Idle)
    val listState = MutableStateFlow<List<MovieModel>>(emptyList())

    fun getTopRatedMovies() {
        viewModelScope.launch {
            getTopRatedMoviesUseCase.invoke().collect {
                when (it) {
                    is ResponseResult.IsLoading -> state.emit(HomeState.Loading(it.isLoading))
                    is ResponseResult.Idle -> Unit
                    is ResponseResult.Error -> {
                        state.emit(HomeState.NoConnection(it.errorStatus ==  ErrorStatus.NO_CONNECTION))
                        state.emit(HomeState.Error(it.message ?: "UnKnown Message"))
                    }
                    is ResponseResult.Success<TopRatedMoviesResponse> -> {
                    }
                }

            }
        }
        getMovieList()
    }

    private fun getMovieList(){
        viewModelScope.launch {
            getMoviesListUseCase.getMoviesList().collect{
                listState.emit(MovieModelMapper.mapper.fromDomainList(it))
            }
        }
    }

    sealed class HomeState<out T : Any> {

        object Idle : HomeState<Nothing>()

        data class Loading(val isLoading: Boolean) : HomeState<Nothing>()

        data class Success<out T : Any>(val data: T) : HomeState<T>()

        data class Error(val message: String) : HomeState<Nothing>()

        data class NoConnection(val isConnected: Boolean) : HomeState<Nothing>()
    }

}
