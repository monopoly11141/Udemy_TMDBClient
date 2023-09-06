package com.example.udemy_tmdbclient.data.domain.repository

import com.example.udemy_tmdbclient.data.model.artist.Artist

interface ArtistRepository {

    suspend fun getArtists(): List<Artist>?
    suspend fun updateArtists(): List<Artist>?
}