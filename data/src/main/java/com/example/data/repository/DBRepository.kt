package com.example.data.repository

import com.example.data.entity.home.MovieEntityMapper
import com.example.data.entity.home.Movie
import com.example.data.entity.room.entity.MovieDB
import com.example.data.source.local.room.dao.movie.MovieDao
import com.example.data.source.local.room.entity.home.MovieDataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DBRepository @Inject constructor(
    private val movieDao: MovieDao,
) : IRoomDBRepository {
    override fun getAllMovies(): Flow<List<MovieDB>> {
        return movieDao.getAllMovies().map {
            MovieDataMapper.mapper.fromDomainList(it)
        }
    }
    override suspend fun insertMovies(movie: List<Movie>?): LongArray? {
        val movieEntity = MovieEntityMapper.mapper.fromDomainList(movie)
        val movieData = MovieDataMapper.mapper.toDomainList(movieEntity)
        return movieDao.insert(movieData)
    }

    override fun deleteAll() {
        movieDao.deleteAll()
    }

}
