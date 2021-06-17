package com.ibrahim.themovieapp.ui.activities

import com.ibrahim.themovieapp.network.NetworkService
import com.ibrahim.themovieapp.network.networkBoundResource
import com.ibrahim.themovieapp.utils.ConnectionManager
import javax.inject.Inject

class MainRepository @Inject constructor(
        private val networkService: NetworkService,
        private val connectionManager: ConnectionManager
) {

    fun fetchMoviesList(
            page: Int,
            apiKey: String
    ) = networkBoundResource(
            isNetworkConnected = { connectionManager.isConnected() },
            fetch = { networkService.getMoviesList(page, apiKey) }
    )
}