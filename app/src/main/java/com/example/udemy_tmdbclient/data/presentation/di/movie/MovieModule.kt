package com.example.udemy_tmdbclient.data.presentation.di.movie

import com.example.udemy_tmdbclient.data.domain.usecase.GetArtistsUseCase
import com.example.udemy_tmdbclient.data.domain.usecase.GetMoviesUseCase
import com.example.udemy_tmdbclient.data.domain.usecase.UpdateArtistsUseCase
import com.example.udemy_tmdbclient.data.domain.usecase.UpdateMoviesUseCase
import com.example.udemy_tmdbclient.data.presentation.artist.ArtistViewModelFactory
import com.example.udemy_tmdbclient.data.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ) : MovieViewModelFactory{
        return MovieViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
    }

}