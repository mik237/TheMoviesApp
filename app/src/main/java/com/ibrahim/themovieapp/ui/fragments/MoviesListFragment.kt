package com.ibrahim.themovieapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ibrahim.themovieapp.BuildConfig
import com.ibrahim.themovieapp.R
import com.ibrahim.themovieapp.adapters.MoviesListAdapter
import com.ibrahim.themovieapp.adapters.OnMovieItemClickListener
import com.ibrahim.themovieapp.databinding.FragmentMoviesListBinding
import com.ibrahim.themovieapp.network.Status
import com.ibrahim.themovieapp.ui.base.BaseFragment
import com.ibrahim.themovieapp.ui.fragments.data_models.Movie
import com.ibrahim.themovieapp.ui.viewmodels.MoviesViewModel
import com.ibrahim.themovieapp.utils.safNavigate
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_movies_list.*
import javax.inject.Inject


@AndroidEntryPoint
class MoviesListFragment : BaseFragment(R.layout.fragment_movies_list), OnMovieItemClickListener {

    @Inject lateinit var moviesAdapter : MoviesListAdapter

    private val moviesViewModel : MoviesViewModel by activityViewModels()


    private var apiCalling: Boolean = false
    private var _binding: FragmentMoviesListBinding? = null
    private val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentMoviesListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initObservers()
        if(moviesViewModel.mappedData.isNullOrEmpty()) {
            fetchMoviesList()
        }
    }

    private fun initViews() {

        swipeRefreshList.apply {
            setOnRefreshListener {
                swipeRefreshList.isRefreshing = false
                moviesViewModel.currentPage = 1
                fetchMoviesList()
            }
        }

        moviesAdapter.setOnMovieItemClickListener(this)

        activity?.let {
            rvMovies.apply {
                layoutManager = GridLayoutManager(it, 2)
                adapter = moviesAdapter

                addOnScrollListener(object : RecyclerView.OnScrollListener() {
                    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                        val count = (layoutManager as LinearLayoutManager).itemCount
                        val lastPos = (layoutManager as LinearLayoutManager).findLastVisibleItemPosition()
                        if(lastPos == count-1 && dy > 0 && !apiCalling){ //reach to end
                            apiCalling = true
                            fetchMoviesList()
                        }
                    }
                })
            }
        }
    }

    @Suppress("UNCHECKED_CAST")
    private fun initObservers() {
        moviesViewModel.statusLiveData.observe(viewLifecycleOwner, Observer {
            it?.let {status ->
                when(status){
                    is Status.Loading -> {
                        progressBar.isVisible = status.showLoading
                        tvError.isVisible = false
                    }
                    is Status.Error -> {
                        apiCalling = false
                        status.errorMsg?.let {
                            rvMovies.isVisible = false
                            tvError.apply {
                                isVisible = true
                                text = it
                            }
                        }
                    }
                    is Status.Success -> {
                        apiCalling = false
                        status.data?.let { data ->
                            rvMovies.isVisible = true
                            tvError.isVisible = false
                            val moviesList : List<Movie> = data as List<Movie>
                            if(moviesList.isNotEmpty())
                                moviesAdapter.setMoviesList(moviesList)
                            if(moviesViewModel.selectedMovie.value == null && moviesList.isNotEmpty())
                                moviesViewModel.selectedMovie.value = moviesList[0]
                        }
                    }
                }
            }
        })
    }

    private fun fetchMoviesList() {
        moviesViewModel.fetchMoviesList(BuildConfig.API_KEY)
    }

    override fun onMovieItemClicked(movie: Movie) {
        moviesViewModel.selectedMovie.value = movie
        val direction = MoviesListFragmentDirections.actionMoviesListFragmentToMoviesDetailFragment()
        findNavController().safNavigate(direction)
    }

    override fun clearResources() {
        moviesAdapter.setOnMovieItemClickListener(null)
        rvMovies.adapter = null
        _binding = null
    }


}