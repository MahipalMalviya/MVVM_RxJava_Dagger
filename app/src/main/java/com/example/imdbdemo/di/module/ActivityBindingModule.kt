package com.example.imdbdemo.di.module

import com.example.imdbdemo.di.scope.ActivityScoped
import com.example.imdbdemo.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [FragmentBindingModule::class])
    abstract fun contributeMainActivity(): MainActivity
}