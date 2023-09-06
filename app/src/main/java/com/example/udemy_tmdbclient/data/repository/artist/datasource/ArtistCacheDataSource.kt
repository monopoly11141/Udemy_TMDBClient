package com.example.udemy_tmdbclient.data.repository.artist.datasource

import com.example.udemy_tmdbclient.data.model.artist.Artist

interface ArtistCacheDataSource {

    suspend fun getArtistsFromCache(): List<Artist>

    suspend fun saveArtistsToCache(artists: List<Artist>)

}