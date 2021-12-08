package com.example.imdbdemo.di.module

import com.example.imdbdemo.di.scope.FragmentScoped
import com.example.imdbdemo.view.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindingModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun provideMainFragment(): MainFragment
}