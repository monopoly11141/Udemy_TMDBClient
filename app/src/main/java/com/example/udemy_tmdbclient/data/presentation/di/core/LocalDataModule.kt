package com.example.udemy_tmdbclient.data.presentation.di.core

import com.example.udemy_tmdbclient.data.db.ArtistDao
import com.example.udemy_tmdbclient.data.db.MovieDao
import com.example.udemy_tmdbclient.data.db.TvShowDao
import com.example.udemy_tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.udemy_tmdbclient.data.repository.artist.datasourceimpl.ArtistLocalDataSourceImpl
import com.example.udemy_tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.example.udemy_tmdbclient.data.repository.movie.datasourceimpl.MovieLocalDataSourceImpl
import com.example.udemy_tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.udemy_tmdbclient.data.repository.tvshow.datasourceimpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule() {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao : MovieDao) : MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao : TvShowDao) : TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao) : ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }
}