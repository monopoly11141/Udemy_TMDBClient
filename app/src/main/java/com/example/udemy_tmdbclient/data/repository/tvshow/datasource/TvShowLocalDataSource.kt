package com.example.udemy_tmdbclient.data.repository.tvshow.datasource

import com.example.udemy_tmdbclient.data.model.tvshow.TvShow

interface TvShowLocalDataSource {

    suspend fun getTvShowsFromDB(): List<TvShow>

    suspend fun saveTvShowsToDB(tvShows: List<TvShow>)

    suspend fun clearAll()
}