package com.example.udemy_tmdbclient.data.domain.usecase

import com.example.udemy_tmdbclient.data.domain.repository.TvShowRepository
import com.example.udemy_tmdbclient.data.model.tvshow.TvShow

class GetTvShowsUseCase(private val tvShowRepository: TvShowRepository) {

    suspend fun execute() : List<TvShow>? = tvShowRepository.getTvShows()

}