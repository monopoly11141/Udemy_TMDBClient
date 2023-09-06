package com.example.udemy_tmdbclient.data.repository.tvshow

import android.util.Log
import com.example.udemy_tmdbclient.data.domain.repository.TvShowRepository
import com.example.udemy_tmdbclient.data.model.tvshow.TvShow
import com.example.udemy_tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.udemy_tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.udemy_tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
) : TvShowRepository {

    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListOfTvShows = getTvShowsFromApi()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowsToDB(newListOfTvShows)

        tvShowCacheDataSource.saveTvShowsToCache(newListOfTvShows)

        return newListOfTvShows
    }

    suspend fun getTvShowsFromApi(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>

        try {
            val response = tvShowRemoteDataSource.getTvShows()
            val body = response.body()
            body?.let {
                tvShowList = body.tvShows
            }

        } catch (e: Exception) {
            Log.i("MYTAG", e.message.toString())
        }
        return tvShowList
    }

    suspend fun getTvShowsFromDB(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>

        try {
            val tvShowList = tvShowLocalDataSource.getTvShowsFromDB()

        } catch (e: Exception) {
            Log.i("MYTAG", e.message.toString())
        }

        if (tvShowList.isEmpty()) {
            tvShowList = getTvShowsFromApi()
            tvShowLocalDataSource.saveTvShowsToDB(tvShowList)
        } else {
            return tvShowList
        }

        return tvShowList

    }

    suspend fun getTvShowsFromCache(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>

        try {
            val movieList = tvShowCacheDataSource.getTvShowsFromCache()

        } catch (e: Exception) {
            Log.i("MYTAG", e.message.toString())
        }

        if (tvShowList.isEmpty()) {
            tvShowList = getTvShowsFromDB()
            tvShowCacheDataSource.saveTvShowsToCache(tvShowList)
        } else {
            return tvShowList
        }

        return tvShowList
    }
}