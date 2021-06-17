package com.ibrahim.themovieapp.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibrahim.themovieapp.network.Status
import com.ibrahim.themovieapp.network.model.ResponseMoviesList
import com.ibrahim.themovieapp.ui.activities.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class MoviesViewModel @Inject constructor(
        private val mainRepo: MainRepository
): ViewModel() {

    private val _moviesListLiveData = MutableLiveData<Status<*>>()

    fun fetchMoviesList(page: Int, apiKey: String){
        viewModelScope.launch(Dispatchers.IO) {
            mainRepo.fetchMoviesList(page, apiKey).collect {
                withContext(Dispatchers.Main){
                    when(it){
                        is Status.Success -> {
                            val data = it.data as ResponseMoviesList
                            val d = data
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