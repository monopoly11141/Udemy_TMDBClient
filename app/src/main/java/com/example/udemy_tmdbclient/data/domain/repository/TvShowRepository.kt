package com.example.udemy_tmdbclient.data.domain.repository

import com.example.udemy_tmdbclient.data.model.tvshow.TvShow

interface TvShowRepository {

    suspend fun getTvShows(): List<TvShow>?
    suspend fun updateTvShows(): List<TvShow>?
}