package com.example.udemy_tmdbclient.data.presentation

import android.app.Application
import com.example.udemy_tmdbclient.data.presentation.di.Injector
import com.example.udemy_tmdbclient.data.presentation.di.artist.ArtistSubComponent
import com.example.udemy_tmdbclient.data.presentation.di.core.AppComponent
import com.example.udemy_tmdbclient.data.presentation.di.core.AppModule
import com.example.udemy_tmdbclient.data.presentation.di.core.DaggerAppComponent
import com.example.udemy_tmdbclient.data.presentation.di.movie.MovieSubComponent
import com.example.udemy_tmdbclient.data.presentation.di.tvshow.TvShowSubComponent

class App : Application(), Injector {

    private lateinit var appComponent: AppComponent

//    override fun onCreate() {
//        super.onCreate()
//        appComponent = DaggerAppComponent.builder()
//            .appModule(AppModule(applicationContext))
//            .
//    }

    override fun createMovieSubComponent(): MovieSubComponent {
        TODO("Not yet implemented")
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        TODO("Not yet implemented")
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        TODO("Not yet implemented")
    }
}