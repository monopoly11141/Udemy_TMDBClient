package com.example.udemy_tmdbclient.data.repository.artist.datasourceimpl

import com.example.udemy_tmdbclient.data.api.TMDBService
import com.example.udemy_tmdbclient.data.model.artist.ArtistList
import com.example.udemy_tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : ArtistRemoteDataSource {

    override suspend fun getArtists(): Response<ArtistList> = tmdbService.getPopularArtists(apiKey)

}