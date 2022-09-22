package com.example.data.entity.home

import com.squareup.moshi.Json


data class MovieEntity (
    var adult: Boolean ? =null,
    @Json(name="backdrop_path")
    var backdropPath : String ? = null,
    @Json(name="genre_ids")
    var genreIds:List<Int>?=null,
    var id : Int ? =null,
    @Json(name="originalTitle")
    var originalTitle:String?=null,
    var overview : String?=null,
    var popularity:String ? =null,
    @Json(name="poster_path")
    var posterPath:String?=null,
    @Json(name="release_date")
    var releaseDate:String?=null,
    var title:String?=null,
    var video:Boolean?=null,
    @Json(name="vote_average")
    var voteAverage:Double?=null,
    @Json(name="vote_count")
    var voteCount : Int ?=null
)

