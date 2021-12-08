package com.example.imdbdemo.network

import com.example.imdbdemo.model.Response
import io.reactivex.Observable
import retrofit2.http.GET

interface ServerApi {

    companion object {
        private const val API_KEY = "k_e7uv7n95"
    }

    @GET("en/API/MostPopularMovies/$API_KEY")
    fun getPopularMovies(): Observable<Response>

}