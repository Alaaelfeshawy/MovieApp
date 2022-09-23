package com.example.data.source.local.room.entity.home

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.data.entity.home.MovieEntity
import com.example.data.model.room.entity.MovieDB
import com.example.data.source.local.room.AppDatabase
import com.squareup.moshi.JsonClass
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy
import org.mapstruct.factory.Mappers

@Entity(tableName = "movies")
open class MovieData(
    var adult: Boolean ? =null,
    var backdropPath : String ? = null,
    var genreIds:List<Int>?=null,
    @field:PrimaryKey
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

@Mapper//(unmappedTargetPolicy = ReportingPolicy.ERROR, unmappedSourcePolicy = ReportingPolicy.ERROR)
interface MovieDataMapper {
    fun fromDomainList(model: List<MovieData>?): List<MovieDB>
    fun toDomainList(model: List<MovieEntity>?): List<MovieData>

    companion object {
        var mapper: MovieDataMapper =
            Mappers.getMapper(MovieDataMapper::class.java)
    }
}