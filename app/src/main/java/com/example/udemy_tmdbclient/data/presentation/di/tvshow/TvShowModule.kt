package com.example.udemy_tmdbclient.data.presentation.di.tvshow

import com.example.udemy_tmdbclient.data.domain.usecase.GetArtistsUseCase
import com.example.udemy_tmdbclient.data.domain.usecase.GetTvShowsUseCase
import com.example.udemy_tmdbclient.data.domain.usecase.UpdateArtistsUseCase
import com.example.udemy_tmdbclient.data.domain.usecase.UpdateTvShowsUseCase
import com.example.udemy_tmdbclient.data.presentation.artist.ArtistViewModelFactory
import com.example.udemy_tmdbclient.data.presentation.tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ) : TvShowViewModelFactory{
        return TvShowViewModelFactory(getTvShowsUseCase, updateTvShowsUseCase)
    }

}