package com.example.data.repository

import com.example.data.entity.home.Movie
import com.example.data.entity.room.entity.MovieDB
import kotlinx.coroutines.flow.Flow

interface IRoomDBRepository {
    fun getAllMovies(): Flow<List<MovieDB>>
    suspend fun insertMovies(movie: List<Movie>?) : LongArray?
    fun deleteAll()
}