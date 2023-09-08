package com.example.udemy_tmdbclient.data.presentation.artist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.udemy_tmdbclient.R
import com.example.udemy_tmdbclient.data.model.artist.Artist
import com.example.udemy_tmdbclient.data.model.movie.Movie
import com.example.udemy_tmdbclient.databinding.ListItemBinding

class ArtistAdapter : RecyclerView.Adapter<MovieViewHolder>() {

    private val artistList = ArrayList<Artist>()

    fun setList(artists: List<Artist>) {
        artistList.clear()
        artistList.addAll(artists)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)

        return MovieViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return artistList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(artistList[position])
    }
}

class MovieViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(artist: Artist) {
        binding.tvTitle.text = artist.name
        binding.tvDescription.text = artist.popularity.toString()

        val posterUrl = "https://image.tmdb.org/t/p/w500${artist.profilePath}"
        Glide.with(binding.ivPoster.context)
            .load(posterUrl)
            .into(binding.ivPoster)
    }

}