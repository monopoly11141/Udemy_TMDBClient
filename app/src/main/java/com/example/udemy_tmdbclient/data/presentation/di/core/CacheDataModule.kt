package com.example.udemy_tmdbclient.data.presentation.di.core

import com.example.udemy_tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.udemy_tmdbclient.data.repository.artist.datasourceimpl.ArtistCacheDataSourceImpl
import com.example.udemy_tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.example.udemy_tmdbclient.data.repository.movie.datasourceimpl.MovieCacheDataSourceImpl
import com.example.udemy_tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.udemy_tmdbclient.data.repository.tvshow.datasourceimpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource() : MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource() : TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource() : ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }

}