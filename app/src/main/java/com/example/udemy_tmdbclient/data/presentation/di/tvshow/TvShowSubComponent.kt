package com.example.udemy_tmdbclient.data.presentation.di.tvshow

import com.example.udemy_tmdbclient.data.presentation.artist.ArtistActivity
import com.example.udemy_tmdbclient.data.presentation.di.artist.ArtistModule
import com.example.udemy_tmdbclient.data.presentation.di.artist.ArtistScope
import com.example.udemy_tmdbclient.data.presentation.tvshow.TvShowActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {

    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): TvShowSubComponent
    }

}