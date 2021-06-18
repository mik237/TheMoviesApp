package com.ibrahim.themovieapp.mappers

import com.ibrahim.themovieapp.BuildConfig
import com.ibrahim.themovieapp.network.model.Result
import com.ibrahim.themovieapp.ui.fragments.data_models.Movie
import javax.inject.Inject

class ViewStateMapperImpl @Inject constructor(): ViewStateMapper {

    override fun mapResultsToMovies(results: List<Result>): List<Movie> {
        return results.map { mapToMovie(it) }
    }

    private fun mapToMovie(result: Result) : Movie{
        return with(result){
            Movie(
                    id = this.id,
                    title = this.title,
                    overview = this.overview,
                    backdropPath = BuildConfig.BACKDROP_IMAGES_BASEURL + this.backdropPath,
                    posterPath = BuildConfig.POSTER_IMAGES_BASEURL + this.posterPath,
                    releaseDate = this.releaseDate,
                    voteAverage = this.voteAverage,
                    voteCount = this.voteCount
            )
        }
    }
}