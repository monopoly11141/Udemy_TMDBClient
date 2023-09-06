package com.example.udemy_tmdbclient.data.repository.tvshow.datasourceimpl

import com.example.udemy_tmdbclient.data.api.TMDBService
import com.example.udemy_tmdbclient.data.model.tvshow.TvShowList
import com.example.udemy_tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : TvShowRemoteDataSource {

    override suspend fun getTvShows(): Response<TvShowList> = tmdbService.getPopularTvShows(apiKey)

}