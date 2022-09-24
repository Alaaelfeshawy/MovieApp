package com.example.movieapp.model.room.entity

import com.example.data.entity.room.entity.MovieDB
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

open class MovieModel {
    var adult: Boolean ? =null
    var backdropPath : String ? = null
    var genreIds:List<Int>?=null
    var id : Int ? =null
    var originalTitle:String?=null
    var overview : String?=null
    var popularity:String ? =null
    var posterPath:String?=null
    var releaseDate:String?=null
    var title:String?=null
    var video:Boolean?=null
    var voteAverage:Double?=null
    var voteCount : Int ?=null
}

@Mapper
interface MovieModelMapper {
    fun fromDomainList(domain: List<MovieDB>?): List<MovieModel>
    fun fromDomain(domain: MovieDB?): MovieModel
    fun toDomain(domain: MovieModel?): MovieDB

    companion object {
        var mapper: MovieModelMapper =
            Mappers.getMapper(MovieModelMapper::class.java)
    }
}