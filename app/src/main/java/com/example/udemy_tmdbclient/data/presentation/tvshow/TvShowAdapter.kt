package com.example.udemy_tmdbclient.data.presentation.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.udemy_tmdbclient.R
import com.example.udemy_tmdbclient.data.model.movie.Movie
import com.example.udemy_tmdbclient.data.model.tvshow.TvShow
import com.example.udemy_tmdbclient.data.presentation.movie.MovieViewHolder
import com.example.udemy_tmdbclient.databinding.ListItemBinding

class TvShowAdapter : RecyclerView.Adapter<TvShowViewHolder>() {

    private val tvShowList = ArrayList<TvShow>()

    fun setList(tvShow: List<TvShow>) {
        tvShowList.clear()
        tvShowList.addAll(tvShow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)

        return TvShowViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return tvShowList.size
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bind(tvShowList[position])
    }
}

class TvShowViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(tvShow: TvShow) {
        binding.tvTitle.text = tvShow.name
        binding.tvDescription.text = tvShow.overview

        val posterUrl = "https://image.tmdb.org/t/p/w500${tvShow.posterPath}"
        Glide.with(binding.ivPoster.context)
            .load(posterUrl)
            .into(binding.ivPoster)
    }

}