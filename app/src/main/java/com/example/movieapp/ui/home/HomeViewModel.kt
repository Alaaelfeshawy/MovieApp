package com.example.movieapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.model.*
import com.example.data.model.home.TopRatedMoviesResponse
import com.example.data.use_case.home.GetTopRatedMoviesUseCase
import com.example.data.util.ErrorStatus
import com.example.data.util.ResponseResult
import com.example.movieapp.model.home.response.TopRatedMoviesResponseModel
import com.example.movieapp.model.home.response.TopRatedMoviesResponseModelMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel  @Inject constructor(
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase,
    ) :  ViewModel(){
    val state = MutableStateFlow<HomeState<TopRatedMoviesResponseModel>>(HomeState.Idle)

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
                        state.emit(HomeState.Success(TopRatedMoviesResponseModelMapper.mapper.fromDomain(it.data)))
                    }
                }

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
