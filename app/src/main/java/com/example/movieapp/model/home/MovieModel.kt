package com.example.movieapp.model.home

import com.example.data.entity.home.Movie
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

data class MovieModel (
    var adult: Boolean ? =null,
    var backdropPath : String ? = null,
    var genreIds:List<Int>?=null,
    var id : Int ? =null,
    var originalTitle:String?=null,
    var overview : String?=null,
    var popularity:String ? =null,
    var posterPath:String?=null,
    var releaseDate:String?=null,
    var title:String?=null,
    var video:Boolean?=null,
    var voteAverage:Double?=null,
    var voteCount : Int ?=null
)
@Mapper
interface MovieModelMapper {
    fun fromDomain(domain: Movie?): MovieModel

    companion object {
        var mapper: MovieModelMapper =
            Mappers.getMapper(MovieModelMapper::class.java)
    }
}