package com.example.udemy_tmdbclient.data.presentation.tvshow

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.udemy_tmdbclient.R
import com.example.udemy_tmdbclient.data.presentation.di.Injector
import com.example.udemy_tmdbclient.data.presentation.movie.MovieAdapter
import com.example.udemy_tmdbclient.data.presentation.movie.MovieViewModel
import com.example.udemy_tmdbclient.data.presentation.movie.MovieViewModelFactory
import com.example.udemy_tmdbclient.databinding.ActivityMovieBinding
import com.example.udemy_tmdbclient.databinding.ActivityTvShowBinding
import javax.inject.Inject

class TvShowActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: TvShowViewModelFactory
    private lateinit var tvShowViewModel: TvShowViewModel

    private lateinit var adapter: TvShowAdapter
    private lateinit var binding: ActivityTvShowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)

        (application as Injector).createTvShowSubComponent()
            .inject(this)

        tvShowViewModel = ViewModelProvider(this, factory)
            .get(TvShowViewModel::class.java)

        initRecyclerView()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.action_update -> {
                updateMovies()
                true
            }
            else -> super.onOptionsItemSelected(item)

        }

    }

    private fun updateMovies() {
        binding.pbProgress.visibility = View.VISIBLE
        val response = tvShowViewModel.updateTvShows()
        response.observe(this, Observer {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.pbProgress.visibility = View.GONE
            } else {
                binding.pbProgress.visibility = View.GONE
            }
        })
    }

    private fun initRecyclerView() {
        binding.rvTvShow.layoutManager = LinearLayoutManager(this)
        adapter = TvShowAdapter()

        binding.rvTvShow.adapter = adapter

        displayPopularMovies()

    }

    private fun displayPopularMovies() {

        binding.pbProgress.visibility = View.VISIBLE

        val responseLiveData = tvShowViewModel.getTvShows()
        responseLiveData.observe(this, Observer {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.pbProgress.visibility = View.GONE
            } else {
                binding.pbProgress.visibility = View.GONE
                Toast.makeText(applicationContext, "No data available", Toast.LENGTH_SHORT).show()
            }

        })

    }
}