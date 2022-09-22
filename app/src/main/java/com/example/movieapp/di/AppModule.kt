package com.example.movieapp.di

import com.example.data.util.AppConstants
import com.example.movieapp.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Singleton
    @Provides
    @Named(AppConstants.BASE_URL)
    fun provideFirstBaseUrl() = BuildConfig.BASE_URL

    @Singleton
    @Provides
    @Named(AppConstants.BUILD_FLAVOR)
    fun provideBuildFlavor() = BuildConfig.FLAVOR




}

