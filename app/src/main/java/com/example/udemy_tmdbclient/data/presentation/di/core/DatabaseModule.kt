package com.example.udemy_tmdbclient.data.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.example.udemy_tmdbclient.data.db.ArtistDao
import com.example.udemy_tmdbclient.data.db.MovieDao
import com.example.udemy_tmdbclient.data.db.TMDBDatabase
import com.example.udemy_tmdbclient.data.db.TvShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideMovieDatabase(context: Context): TMDBDatabase {
        return Room.databaseBuilder(context, TMDBDatabase::class.java, "tmdbclient")
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase) : MovieDao {
        return tmdbDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun provideTvShowDao(tmdbDatabase: TMDBDatabase) : TvShowDao {
        return tmdbDatabase.tvShowDao()
    }

    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDatabase) : ArtistDao {
        return tmdbDatabase.artistDao()
    }

}