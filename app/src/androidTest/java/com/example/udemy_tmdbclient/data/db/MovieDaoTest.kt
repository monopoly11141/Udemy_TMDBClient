package com.example.udemy_tmdbclient.data.db

import android.app.Application
import android.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.udemy_tmdbclient.data.model.movie.Movie
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var movieDao : MovieDao
    private lateinit var tmdbDatabase : TMDBDatabase

    @Before
    fun setUp() {
        tmdbDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            TMDBDatabase::class.java
        ).build()

        movieDao = tmdbDatabase.movieDao()
    }

    @After
    fun tearDown() {
        tmdbDatabase.close()
    }

    @Test
    fun saveMoviesTest() = runBlocking {
        val movies = listOf(
            Movie(1, "overview1", "posterPath1", "releaseDate1", "title1"),
            Movie(2, "overview2", "posterPath2", "releaseDate2", "title2"),
            Movie(3, "overview3", "posterPath3", "releaseDate3", "title3"),
        )
        movieDao.saveMovies(movies)

        val allMovies = movieDao.getMovies()
        Truth.assertThat(allMovies).isEqualTo(movies)

    }

    @Test
    fun deleteMoviesTest() = runBlocking {
        val movies = listOf(
            Movie(1, "overview1", "posterPath1", "releaseDate1", "title1"),
            Movie(2, "overview2", "posterPath2", "releaseDate2", "title2"),
            Movie(3, "overview3", "posterPath3", "releaseDate3", "title3"),
        )
        movieDao.saveMovies(movies)
        movieDao.deleteAllMovies()

        val moviesResult = movieDao.getMovies()
        Truth.assertThat(moviesResult).isEmpty()


    }
}