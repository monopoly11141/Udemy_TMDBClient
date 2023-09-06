package com.example.udemy_tmdbclient.data.repository.movie.datasource

import com.example.udemy_tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {

    suspend fun getMovies(): Response<MovieList>

}