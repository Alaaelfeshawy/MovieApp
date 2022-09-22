package com.example.movieapp.ui.movie_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.model.home.Movie
import com.example.data.use_case.home.GetMovieDetailsUseCase
import com.example.data.util.ErrorStatus
import com.example.data.util.ResponseResult
import com.example.movieapp.model.home.MovieModel
import com.example.movieapp.model.home.MovieModelMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel  @Inject constructor(
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase

    ) :  ViewModel(){
    val state = MutableStateFlow<MovieDetailsState<MovieModel>>(MovieDetailsState.Idle)

    fun getMovieDetails(movieId:Int) {
        viewModelScope.launch {
            getMovieDetailsUseCase.invoke(movieId).collect {
                when (it) {
                    is ResponseResult.IsLoading -> state.emit(MovieDetailsState.Loading(it.isLoading))
                    is ResponseResult.Idle -> Unit
                    is ResponseResult.Error -> {
                        state.emit(MovieDetailsState.NoConnection(it.errorStatus ==  ErrorStatus.NO_CONNECTION))
                        state.emit(MovieDetailsState.Error(it.message ?: "UnKnown Message"))
                    }
                    is ResponseResult.Success<Movie> -> {
                        state.emit(MovieDetailsState.Success(MovieModelMapper.mapper.fromDomain(it.data)))
                    }
                }

            }
        }
    }

    sealed class MovieDetailsState<out T : Any> {

        object Idle : MovieDetailsState<Nothing>()

        data class Loading(val isLoading: Boolean) : MovieDetailsState<Nothing>()

        data class Success<out T : Any>(val data: T) : MovieDetailsState<T>()

        data class Error(val message: String) : MovieDetailsState<Nothing>()

        data class NoConnection(val isConnected: Boolean) : MovieDetailsState<Nothing>()
    }
}