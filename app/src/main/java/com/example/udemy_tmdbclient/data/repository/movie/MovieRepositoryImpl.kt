package com.example.udemy_tmdbclient.data.repository.movie

import android.util.Log
import com.example.udemy_tmdbclient.data.domain.repository.MovieRepository
import com.example.udemy_tmdbclient.data.model.movie.Movie
import com.example.udemy_tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.example.udemy_tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.example.udemy_tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromApi()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)

        movieCacheDataSource.saveMoviesToCache(newListOfMovies)

        return newListOfMovies
    }

    suspend fun getMoviesFromApi(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            body?.let {
                movieList = body.movies
            }

        } catch (e: Exception) {
            Log.i("MYTAG", e.message.toString())
        }
        return movieList
    }

    suspend fun getMoviesFromDB(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            val movieList = movieLocalDataSource.getMoviesFromDB()

        } catch (e: Exception) {
            Log.i("MYTAG", e.message.toString())
        }

        if (movieList.isEmpty()) {
            movieList = getMoviesFromApi()
            movieLocalDataSource.saveMoviesToDB(movieList)
        } else {
            return movieList
        }

        return movieList

    }

    suspend fun getMoviesFromCache(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            val movieList = movieCacheDataSource.getMoviesFromCache()

        } catch (e: Exception) {
            Log.i("MYTAG", e.message.toString())
        }

        if (movieList.isEmpty()) {
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
        } else {
            return movieList
        }

        return movieList
    }
}