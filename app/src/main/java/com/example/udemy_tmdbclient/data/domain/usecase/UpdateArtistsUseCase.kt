package com.example.udemy_tmdbclient.data.domain.usecase

import com.example.udemy_tmdbclient.data.domain.repository.ArtistRepository
import com.example.udemy_tmdbclient.data.model.artist.Artist

class UpdateArtistsUseCase(private val artistRepository: ArtistRepository) {

    suspend fun execute(): List<Artist>? = artistRepository.updateArtists()

}