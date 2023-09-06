package com.example.udemy_tmdbclient.data.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.udemy_tmdbclient.R
import com.example.udemy_tmdbclient.data.presentation.artist.ArtistActivity
import com.example.udemy_tmdbclient.data.presentation.movie.MovieActivity
import com.example.udemy_tmdbclient.data.presentation.tvshow.TvShowActivity
import com.example.udemy_tmdbclient.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        binding.btnMovie.setOnClickListener {
            Intent(this, MovieActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnTvShow.setOnClickListener {
            Intent(this, TvShowActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnArtist.setOnClickListener {
            Intent(this, ArtistActivity::class.java).also {
                startActivity(it)
            }
        }

    }
}