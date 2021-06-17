package com.ibrahim.themovieapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ibrahim.themovieapp.databinding.ItemMovieBinding
import com.ibrahim.themovieapp.ui.fragments.data_models.Movie
import javax.inject.Inject

class MoviesListAdapter @Inject constructor():
    RecyclerView.Adapter<MoviesListAdapter.MovieViewHolder>(){

    private val moviesList = ArrayList<Movie>()
    private var listener : OnMovieItemClickListener? = null

    fun setMoviesList(newMoviesList : List<Movie>){
        val diffCallback = MoviesListDiffCallback(moviesList, newMoviesList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        moviesList.clear()
        moviesList.addAll(newMoviesList)
        diffResult.dispatchUpdatesTo(this)
    }

    fun setOnMovieItemClickListener(listener: OnMovieItemClickListener?){
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun getItemCount(): Int = moviesList.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(moviesList.get(position))
    }

    inner class MovieViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(movie: Movie){

            binding.apply {

                tvMovieTitle.text = movie.title
                tvMovieReleaseDate.text = movie.releaseDate
                if(movie.posterPath.isNotEmpty()){
                    Glide.with(ivMoviePoster)
                        .load(movie.posterPath)
                        .into(ivMoviePoster)
                }

            }
        }
    }

}