package com.example.udemy_tmdbclient.data.presentation.artist

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
import com.example.udemy_tmdbclient.databinding.ActivityArtistBinding
import com.example.udemy_tmdbclient.databinding.ActivityMovieBinding
import javax.inject.Inject

class ArtistActivity: AppCompatActivity() {

    @Inject
    lateinit var factory: ArtistViewModelFactory
    private lateinit var artistViewModel: ArtistViewModel

    private lateinit var binding: ActivityArtistBinding
    private lateinit var adapter: ArtistAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist)

        (application as Injector).createArtistSubComponent()
            .inject(this)

        artistViewModel = ViewModelProvider(this, factory)
            .get(ArtistViewModel::class.java)

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
                updateArtists()
                true
            }
            else -> super.onOptionsItemSelected(item)

        }

    }

    private fun updateArtists() {
        binding.pbProgress.visibility = View.VISIBLE
        val response = artistViewModel.updateArtists()
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
        binding.rvArtist.layoutManager = LinearLayoutManager(this)
        adapter = ArtistAdapter()

        binding.rvArtist.adapter = adapter

        displayPopularArtists()

    }

    private fun displayPopularArtists() {

        binding.pbProgress.visibility = View.VISIBLE

        val responseLiveData = artistViewModel.getArtists()
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