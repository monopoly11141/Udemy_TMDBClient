package com.example.udemy_tmdbclient.data.presentation.di

import com.example.udemy_tmdbclient.data.presentation.di.artist.ArtistSubComponent
import com.example.udemy_tmdbclient.data.presentation.di.movie.MovieSubComponent
import com.example.udemy_tmdbclient.data.presentation.di.tvshow.TvShowSubComponent

interface Injector {

    fun createMovieSubComponent() : MovieSubComponent
    fun createTvShowSubComponent() : TvShowSubComponent
    fun createArtistSubComponent() : ArtistSubComponent

}