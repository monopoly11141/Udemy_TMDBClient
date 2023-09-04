package com.example.udemy_tmdbclient.data.domain.usecase

import com.example.udemy_tmdbclient.data.domain.repository.MovieRepository
import com.example.udemy_tmdbclient.data.model.movie.Movie

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute() : List<Movie>? = movieRepository.updateMovies()
}