package com.example.udemy_tmdbclient.data.presentation.di.core

import com.example.udemy_tmdbclient.data.api.TMDBService
import com.example.udemy_tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.udemy_tmdbclient.data.repository.artist.datasourceimpl.ArtistRemoteDataSourceImpl
import com.example.udemy_tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.udemy_tmdbclient.data.repository.movie.datasourceimpl.MovieRemoteDataSourceImpl
import com.example.udemy_tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.udemy_tmdbclient.data.repository.tvshow.datasourceimpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRoomDataSource(tmdbService: TMDBService): MovieRemoteDataSource {

        return MovieRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideTVShowRoomDataSource(tmdbService: TMDBService): TvShowRemoteDataSource {

        return TvShowRemoteDataSourceImpl(tmdbService, apiKey)
    }


    @Singleton
    @Provides
    fun provideArtistRoomDataSource(tmdbService: TMDBService): ArtistRemoteDataSource {

        return ArtistRemoteDataSourceImpl(tmdbService, apiKey)
    }


}