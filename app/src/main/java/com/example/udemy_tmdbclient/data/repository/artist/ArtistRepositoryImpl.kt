package com.example.udemy_tmdbclient.data.repository.artist

import android.util.Log
import com.example.udemy_tmdbclient.data.domain.repository.ArtistRepository
import com.example.udemy_tmdbclient.data.model.artist.Artist
import com.example.udemy_tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.udemy_tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.udemy_tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {
    override suspend fun getArtists(): List<Artist>? {
        return getArtistFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfArtists = getArtistsFromApi()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newListOfArtists)

        artistCacheDataSource.saveArtistsToCache(newListOfArtists)

        return newListOfArtists
    }

    suspend fun getArtistsFromApi(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            val response = artistRemoteDataSource.getArtists()
            val body = response.body()
            body?.let {
                artistList = body.artists
            }

        } catch (e: Exception) {
            Log.i("MYTAG", e.message.toString())
        }
        return artistList
    }

    suspend fun getArtistsFromDB(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            artistList = artistLocalDataSource.getArtistsFromDB()

        } catch (e: Exception) {
            Log.i("MYTAG", e.message.toString())
        }

        if (artistList.isEmpty()) {
            artistList = getArtistsFromApi()
            artistLocalDataSource.saveArtistsToDB(artistList)
        } else {
            return artistList
        }

        return artistList

    }

    suspend fun getArtistFromCache(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            artistList = artistCacheDataSource.getArtistsFromCache()

        } catch (e: Exception) {
            Log.i("MYTAG", e.message.toString())
        }

        if (artistList.isEmpty()) {
            artistList = getArtistsFromDB()
            artistCacheDataSource.saveArtistsToCache(artistList)
        } else {
            return artistList
        }

        return artistList
    }
}