package com.example.udemy_tmdbclient.data.repository.tvshow.datasource

import com.example.udemy_tmdbclient.data.model.tvshow.TvShow

interface TvShowCacheDataSource {

    suspend fun getTvShowsFromCache(): List<TvShow>

    suspend fun saveTvShowsToCache(movies: List<TvShow>)

}