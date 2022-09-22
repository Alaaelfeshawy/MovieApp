package com.example.movieapp.model.home.response

import com.example.data.model.home.TopRatedMoviesResponse
import com.example.movieapp.model.home.MovieModel
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

data class TopRatedMoviesResponseModel (
      var  results : List<MovieModel>
      )
@Mapper
interface TopRatedMoviesResponseModelMapper {
      fun fromDomain(domain: TopRatedMoviesResponse?): TopRatedMoviesResponseModel

      companion object {
            var mapper: TopRatedMoviesResponseModelMapper =
                  Mappers.getMapper(TopRatedMoviesResponseModelMapper::class.java)
      }
}