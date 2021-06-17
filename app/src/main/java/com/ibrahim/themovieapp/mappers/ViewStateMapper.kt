package com.ibrahim.themovieapp.mappers

import com.ibrahim.themovieapp.network.model.Result
import com.ibrahim.themovieapp.ui.fragments.data_models.Movie

interface ViewStateMapper {
    fun mapResultsToMovies(results: List<Result>) : List<Movie>
}