package com.ibrahim.themovieapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.ibrahim.themovieapp.BuildConfig
import com.ibrahim.themovieapp.R
import com.ibrahim.themovieapp.databinding.FragmentMoviesListBinding
import com.ibrahim.themovieapp.ui.base.BaseFragment
import com.ibrahim.themovieapp.ui.viewmodels.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MoviesListFragment : BaseFragment(R.layout.fragment_movies_list) {


    private val moviesViewModel : MoviesViewModel by activityViewModels()

    private var _binding: FragmentMoviesListBinding? = null
    private val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentMoviesListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fetchMoviesList()
    }

    private fun fetchMoviesList() {
        moviesViewModel.fetchMoviesList(1, BuildConfig.API_KEY)
    }


    override fun clearResources() {
        _binding = null
    }
}