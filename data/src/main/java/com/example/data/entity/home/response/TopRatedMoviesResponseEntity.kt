package com.example.data.entity.home.response

import com.example.data.entity.home.MovieEntity
import com.example.data.entity.home.TopRatedMoviesResponse
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

data class TopRatedMoviesResponseEntity (
      var  results : List<MovieEntity>
 )

@Mapper//(unmappedTargetPolicy = ReportingPolicy.ERROR, uses = [TopRatedMoviesResponseEntity::class])
interface TopRatedMoviesResponseEntityMapper {
      fun fromDomain(domain: TopRatedMoviesResponse?): TopRatedMoviesResponseEntity
      fun toDomain(data: TopRatedMoviesResponseEntity?): TopRatedMoviesResponse

      companion object {
            var mapper: TopRatedMoviesResponseEntityMapper =
                  Mappers.getMapper(TopRatedMoviesResponseEntityMapper::class.java)
      }
}