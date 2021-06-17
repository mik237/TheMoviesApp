package com.ibrahim.themovieapp.ui.fragments.data_models

data class Movie(    val id: Int,
                     val title: String,
                     val overview: String,
                     val releaseDate: String,
                     val backdropPath: String,
                     val posterPath: String,
                     val voteAverage: Double,
                     val voteCount: Int
)