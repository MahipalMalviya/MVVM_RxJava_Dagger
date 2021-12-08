package com.example.imdbdemo.di.module

import com.example.imdbdemo.view.adapter.MovieAdapter
import dagger.Module
import dagger.Provides

@Module
class AdapterModule {

     @Provides
     fun provideMovieAdapter(movieAdapter: MovieAdapter): MovieAdapter {
          return movieAdapter
     }
}