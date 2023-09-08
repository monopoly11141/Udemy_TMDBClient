package com.example.udemy_tmdbclient.data.presentation.movie

import android.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.udemy_tmdbclient.data.domain.usecase.GetMoviesUseCase
import com.example.udemy_tmdbclient.data.domain.usecase.UpdateMoviesUseCase
import com.example.udemy_tmdbclient.data.model.movie.Movie
import com.example.udemy_tmdbclient.data.repository.movie.FakeMovieRepository
import com.example.udemy_tmdbclient.getOrAwaitValue
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MovieViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var movieViewModel: MovieViewModel

    @Before
    fun setUp() {
        val fakeMovieRepository = FakeMovieRepository()

        val getMoviesUsecase = GetMoviesUseCase(fakeMovieRepository)
        val updateMoviesUsecase = UpdateMoviesUseCase(fakeMovieRepository)

        movieViewModel = MovieViewModel(getMoviesUsecase, updateMoviesUsecase)
    }

    @Test
    fun getMovies_returnCurrentList() {
        val movies = mutableListOf<Movie>()
        movies.add(Movie(1, "overview1", "posterPath1", "releaseDate1", "title1"))
        movies.add(Movie(2, "overview2", "posterPath2", "releaseDate2", "title2"))
        movies.add(Movie(3, "overview3", "posterPath3", "releaseDate3", "title3"))

        val currentList = movieViewModel.getMovies().getOrAwaitValue()

        assertThat(currentList).isEqualTo(movies)
    }

    @Test
    fun updateMovies_returnUpdatedList() {
        val movies = mutableListOf<Movie>()
        movies.add(Movie(4, "overview4", "posterPath4", "releaseDate4", "title4"))
        movies.add(Movie(5, "overview5", "posterPath5", "releaseDate5", "title5"))
        movies.add(Movie(6, "overview6", "posterPath6", "releaseDate6", "title6"))

        val updatedList = movieViewModel.updateMovies().getOrAwaitValue()

        assertThat(updatedList).isEqualTo(movies)

    }

}