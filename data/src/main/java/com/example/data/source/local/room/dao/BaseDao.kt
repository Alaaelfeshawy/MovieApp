package com.example.data.source.local.room.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(data: List<T>?): LongArray?

    @Query("DELETE FROM movies")
    fun deleteAll()
}