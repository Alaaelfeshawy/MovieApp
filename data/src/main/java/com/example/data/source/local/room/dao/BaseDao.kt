package com.example.data.source.local.room.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy

interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: T?): Long?

    @Delete
    suspend fun deleteMovie(item:T?) : Int
}