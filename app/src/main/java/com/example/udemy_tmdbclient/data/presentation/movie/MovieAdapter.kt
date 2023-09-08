package com.example.udemy_tmdbclient.data.presentation.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.udemy_tmdbclient.R
import com.example.udemy_tmdbclient.data.model.movie.Movie
import com.example.udemy_tmdbclient.databinding.ListItemBinding

class MovieAdapter : RecyclerView.Adapter<MovieViewHolder>() {

    private val movieList = ArrayList<Movie>()

    fun setList(movies: List<Movie>) {
        movieList.clear()
        movieList.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)

        return MovieViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieList[position])
    }
}

class MovieViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movie) {
        binding.tvTitle.text = movie.title
        binding.tvDescription.text = movie.overview

        val posterUrl = "https://image.tmdb.org/t/p/w500${movie.posterPath}"
        Glide.with(binding.ivPoster.context)
            .load(posterUrl)
            .into(binding.ivPoster)
    }

}