package com.example.imdbdemo.repository

import com.example.imdbdemo.di.scope.ActivityScoped
import com.example.imdbdemo.model.Response
import com.example.imdbdemo.network.ServerApi
import dagger.Module
import dagger.Provides
import io.reactivex.Observable
import javax.inject.Inject

@Module
class MainRepository @Inject constructor(
    private val serverApi: ServerApi
) {

    @ActivityScoped
    @Provides
    fun getPopularMovies(): Observable<Response> {
        return serverApi.getPopularMovies()
    }
}