package com.example.data.repository

import com.example.data.model.home.Movie
import com.example.data.model.room.entity.MovieDB
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

interface IRoomDBRepository {
    fun getAllMovies(): Flow<List<MovieDB>>
    suspend fun insertMovies(movie: List<Movie>?) : LongArray?
    fun deleteAll()
}