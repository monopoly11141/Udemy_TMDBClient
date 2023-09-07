package com.example.udemy_tmdbclient.data.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.udemy_tmdbclient.data.domain.usecase.GetMoviesUseCase
import com.example.udemy_tmdbclient.data.domain.usecase.UpdateMoviesUseCase

class MovieViewModel(
    private val getMovieUseCase : GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModel() {

    fun getMovies() = liveData{
        val movieList = getMovieUseCase.execute()
        emit(movieList)
    }

    fun updateMovies() = liveData {
        val movieList = updateMoviesUseCase.execute()
        emit(movieList)
    }

}