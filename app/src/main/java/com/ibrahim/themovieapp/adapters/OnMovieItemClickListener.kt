package com.ibrahim.themovieapp.adapters

import com.ibrahim.themovieapp.ui.fragments.data_models.Movie

interface OnMovieItemClickListener {
    fun onMovieItemClicked(movie: Movie)
}