package com.ibrahim.themovieapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.ibrahim.themovieapp.R
import com.ibrahim.themovieapp.databinding.FragmentMoviesDetailBinding
import com.ibrahim.themovieapp.ui.base.BaseFragment
import com.ibrahim.themovieapp.ui.viewmodels.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

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
    }

    override fun clearResources() {
        _binding = null
    }
}