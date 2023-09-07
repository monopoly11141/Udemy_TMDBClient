package com.example.udemy_tmdbclient.data.presentation.di.artist

import com.example.udemy_tmdbclient.data.domain.usecase.GetArtistsUseCase
import com.example.udemy_tmdbclient.data.domain.usecase.UpdateArtistsUseCase
import com.example.udemy_tmdbclient.data.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ) : ArtistViewModelFactory{
        return ArtistViewModelFactory(getArtistsUseCase, updateArtistsUseCase)
    }

}