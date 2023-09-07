package com.example.udemy_tmdbclient.data.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.udemy_tmdbclient.data.domain.usecase.GetMoviesUseCase
import com.example.udemy_tmdbclient.data.domain.usecase.UpdateMoviesUseCase

class MovieViewModelFactory(
    private val getMovieUseCase : GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieViewModel(getMovieUseCase, updateMoviesUseCase) as T
    }


}