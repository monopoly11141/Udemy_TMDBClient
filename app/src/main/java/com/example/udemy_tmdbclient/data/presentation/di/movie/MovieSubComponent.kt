package com.example.udemy_tmdbclient.data.presentation.di.movie

import com.example.udemy_tmdbclient.data.presentation.artist.ArtistActivity
import com.example.udemy_tmdbclient.data.presentation.di.artist.ArtistScope
import com.example.udemy_tmdbclient.data.presentation.movie.MovieActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {

    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): MovieSubComponent
    }

}