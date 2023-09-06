package com.example.udemy_tmdbclient.data.repository.tvshow.datasource

import com.example.udemy_tmdbclient.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {

    suspend fun getTvShows(): Response<TvShowList>

}