package com.example.udemy_tmdbclient.data.repository.artist.datasource

import com.example.udemy_tmdbclient.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {

    suspend fun getArtists(): Response<ArtistList>

}