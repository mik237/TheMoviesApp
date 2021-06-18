package com.ibrahim.themovieapp.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibrahim.themovieapp.mappers.ViewStateMapperImpl
import com.ibrahim.themovieapp.network.Status
import com.ibrahim.themovieapp.network.model.ResponseMoviesList
import com.ibrahim.themovieapp.ui.activities.MainRepository
import com.ibrahim.themovieapp.ui.fragments.data_models.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val mainRepo: MainRepository,
    private val viewStateMapper : ViewStateMapperImpl
): ViewModel() {

    private val _moviesListLiveData = MutableLiveData<Status<*>>()

    var selectedMovie = MutableLiveData<Movie>()
    val statusLiveData : LiveData<Status<*>> = _moviesListLiveData


    var mappedData = mutableListOf<Movie>()
    var currentPage = 1
    private var totalPages = 1

    fun fetchMoviesList(apiKey: String){
        if(currentPage <= totalPages){
            viewModelScope.launch(Dispatchers.IO) {
                mainRepo.fetchMoviesList(currentPage, apiKey).collect {
                    withContext(Dispatchers.Main){
                        when(it){
                            is Status.Success -> {
                                val data = it.data as ResponseMoviesList
                                handleMoviesResponse(data)
                            }
                            else -> {
                                _moviesListLiveData.value = it
                            }
                        }
                    }
                }
            }
        }
    }

    private fun handleMoviesResponse(responseMoviesList: ResponseMoviesList) {
        val newList = viewStateMapper.mapResultsToMovies(responseMoviesList.results).toMutableList()
        if(currentPage == 1){
            mappedData.clear()
            mappedData = newList
        }
        else{
            mappedData.addAll(newList)
        }
        _moviesListLiveData.value = Status.Success(mappedData)
        currentPage++
        totalPages = responseMoviesList.totalPages
    }
}