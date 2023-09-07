package com.example.udemy_tmdbclient.data.presentation.di.core

import com.example.udemy_tmdbclient.data.presentation.di.artist.ArtistSubComponent
import com.example.udemy_tmdbclient.data.presentation.di.movie.MovieSubComponent
import com.example.udemy_tmdbclient.data.presentation.di.tvshow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetModule::class,
        DatabaseModule::class,
        UseCaseModule::class,
        RepositoryModule::class,
        RemoteDataModule::class,
        LocalDataModule::class,
        CacheDataModule::class,
    ]
)
interface AppComponent {

    fun movieSubComponent() : MovieSubComponent.Factory
    fun tvShowSubComponent() : TvShowSubComponent.Factory
    fun artistSubComponent() : ArtistSubComponent.Factory
}