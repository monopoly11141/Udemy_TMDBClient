package com.example.udemy_tmdbclient.data.repository.movie.datasourceimpl

import com.example.udemy_tmdbclient.data.api.TMDBService
import com.example.udemy_tmdbclient.data.model.movie.MovieList
import com.example.udemy_tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : MovieRemoteDataSource {

    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)


}