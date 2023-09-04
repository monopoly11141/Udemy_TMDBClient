package com.example.udemy_tmdbclient.data.domain.repository

import com.example.udemy_tmdbclient.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies() : List<Movie>?

    suspend fun updateMovies() : List<Movie>?




}