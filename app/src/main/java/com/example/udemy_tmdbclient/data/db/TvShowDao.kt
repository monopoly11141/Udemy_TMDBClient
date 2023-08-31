package com.example.udemy_tmdbclient.data.db

import androidx.room.*
import com.example.udemy_tmdbclient.data.model.movie.Movie
import com.example.udemy_tmdbclient.data.model.tvshow.TvShow

@Dao
interface TvShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(tvShows: List<TvShow>)

    @Query("DELETE FROM popular_tv_shows")
    suspend fun deleteAllTvShows()

    @Query("SELECT * FROM popular_tv_shows")
    suspend fun getTvShows() : List<TvShow>


}