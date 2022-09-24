package com.example.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.data.source.local.room.dao.movie.MovieDao
import com.example.data.source.local.room.entity.home.MovieData
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.io.IOException
import java.lang.reflect.Type

@Database(
    entities = [MovieData::class],
    exportSchema = false,
    version = 1
)
@TypeConverters(
    AppDatabase.Converters::class
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao

    class Converters {
        @TypeConverter
        fun intListToJson(json: List<Int>): String {
            return Moshi.Builder()
                .build()
                .adapter<List<Int>>(Types.newParameterizedType(List::class.java, Int::class.javaObjectType)).toJson(json)
        }

        @TypeConverter
        fun jsonToIntList(data: String?): List<Int>? {
            val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory())
                .build()
            val intListType: Type = Types.newParameterizedType(
                MutableList::class.java, Int::class.javaObjectType
            )
            val jsonAdapter = moshi.adapter<List<Int>>(intListType)
            var intList: List<Int>? = null
            try {
                intList = jsonAdapter.fromJson(data!!)
            } catch (e: IOException) {
                e.printStackTrace()
            }
            return intList
        }
    }
}