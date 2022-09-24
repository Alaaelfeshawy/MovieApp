package com.example.data.source.local.room.dao.movie
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.data.source.local.room.AppDatabase
import com.example.data.source.local.room.dao.BaseDao
import com.example.data.source.local.room.entity.home.MovieData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

@Dao
abstract class MovieDao(private val appDatabase: AppDatabase) : BaseDao<MovieData?> {

    @Transaction
    @Query("SELECT * FROM movies")
    abstract fun  getAllMovies(): Flow<List<MovieData>>

    @Transaction
    open suspend fun insertMovie (movie: List<MovieData>) : LongArray?{
        return appDatabase.movieDao().insert(movie)
    }

    @Transaction
    open fun delete() {
        appDatabase.movieDao().deleteAll()
    }

}
