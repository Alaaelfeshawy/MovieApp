package com.example.data.di

import com.example.data.repository.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoriesModule {
    @Provides
    @Singleton
    fun providerHomeRepository(homeRepository: HomeRepository): IHomeRepository {
        return homeRepository
    }

    @Provides
    @Singleton
    fun providerMovieDetailsRepository(movieDetailsRepository: MovieDetailsRepository): IMovieDetailsRepository {
        return movieDetailsRepository
    }
    @Provides
    @Singleton
    fun providerRoomRepository(dBRepository: DBRepository): IRoomDBRepository {
        return dBRepository
    }
}