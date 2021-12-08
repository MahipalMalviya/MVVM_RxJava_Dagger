package com.example.imdbdemo.di.module

import android.content.Context
import com.example.imdbdemo.Application
import com.example.imdbdemo.di.scope.AppScoped
import dagger.Module

@Module
abstract class AppModule {

    @AppScoped
    fun provideContext(application: Application): Context = application

    @AppScoped
    fun provideUtils(utils: Utils) = utils
}