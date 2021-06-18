package com.ibrahim.themovieapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.ibrahim.themovieapp.R
import com.ibrahim.themovieapp.databinding.FragmentMoviesDetailBinding
import com.ibrahim.themovieapp.ui.base.BaseFragment
import com.ibrahim.themovieapp.ui.viewmodels.MoviesViewModel
import com.ibrahim.themovieapp.utils.Constants
import com.ibrahim.themovieapp.utils.Utils
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_movies_detail.*

@AndroidEntryPoint
class MoviesDetailFragment : BaseFragment(R.layout.fragment_movies_detail) {

    private val moviesViewModel : MoviesViewModel by activityViewModels()

    private var _binding: FragmentMoviesDetailBinding? = null
    private val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentMoviesDetailBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initObservers()
    }

    private fun initViews() {
        detailToolbar.setNavigationOnClickListener { findNavController().popBackStack() }
        activity?.let {
            ivMoviePoster.layoutParams.width = Utils.getImgWidth(it, Constants.HORIZONTAL_MARGIN).toInt()
            ivMoviePoster.layoutParams.height = Utils.getImgHeight(it, Constants.VERTICAL_MARGIN).toInt()
            ivBackdrop.layoutParams.height = Utils.getBackdropImgHeight(it, 0).toInt()
        }
    }

    private fun initObservers() {
        moviesViewModel.selectedMovie.observe(viewLifecycleOwner, Observer {
            it?.let { movie ->

                binding?.apply {
                    tvMovieTitle.text = movie.title
                    tvMovieOverview.text = movie.overview
                    tvVoteAvg.text = resources.getString(R.string.vote_average, movie.voteAverage)
                    tvVoteCount.text = resources.getString(R.string.vote_count, movie.voteCount)
                    tvReleaseDate.text = resources.getString(R.string.release_date, movie.releaseDate)

                    if(movie.posterPath.isNotEmpty()){
                            Glide.with(ivMoviePoster)
                                .load(movie.posterPath)
                                .placeholder(R.drawable.iv_placeholder)
                                .transition(DrawableTransitionOptions.withCrossFade())
                                .into(ivMoviePoster)
                    }

                    if(movie.backdropPath.isNotEmpty()){
                            Glide.with(ivBackdrop)
                                .load(movie.backdropPath)
                                .placeholder(R.drawable.iv_placeholder)
                                .transition(DrawableTransitionOptions.withCrossFade())
                                .into(ivBackdrop)
                    }
                }
            }
        })
    }

    override fun clearResources() {
        _binding = null
    }
}