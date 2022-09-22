package com.example.data.repository

open class BaseRepository(private val fromTest: Boolean = false) {
    val apiToken: String
        get() = if (!fromTest){
            "1fd478cb82068e8bcf12172ab61d25be"
        }else{
            "apiKey"
        }
}