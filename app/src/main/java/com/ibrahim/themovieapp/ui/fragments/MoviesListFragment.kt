package com.ibrahim.themovieapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ibrahim.themovieapp.R
import com.ibrahim.themovieapp.databinding.FragmentMoviesListBinding
import com.ibrahim.themovieapp.ui.base.BaseFragment

class MoviesListFragment : BaseFragment(R.layout.fragment_movies_list) {

    private var _binding: FragmentMoviesListBinding? = null
    private val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentMoviesListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }



    override fun clearResources() {
        _binding = null
    }
}