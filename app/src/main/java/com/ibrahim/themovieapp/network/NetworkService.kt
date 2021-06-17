package com.ibrahim.themovieapp.network

import com.ibrahim.themovieapp.network.model.ResponseMoviesList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {

    @GET("movie")
    suspend fun getMoviesList(
        @Query("page") page: Int,
        @Query("api_key") apiKey: String
    ) : Response<ResponseMoviesList>

}