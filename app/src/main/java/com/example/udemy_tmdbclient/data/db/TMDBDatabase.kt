package com.example.udemy_tmdbclient.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.udemy_tmdbclient.data.model.artist.Artist
import com.example.udemy_tmdbclient.data.model.movie.Movie
import com.example.udemy_tmdbclient.data.model.tvshow.TvShow

@Database(
    entities = [Artist::class, Movie::class, TvShow::class],
    version = 1,
    exportSchema = false
)
abstract class TMDBDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
    abstract fun artistDao(): ArtistDao
    abstract fun tvShowDao(): TvShowDao

}