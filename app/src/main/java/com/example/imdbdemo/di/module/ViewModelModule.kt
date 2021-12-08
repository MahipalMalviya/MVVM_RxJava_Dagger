package com.example.imdbdemo.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.imdbdemo.di.scope.AppScoped
import com.example.imdbdemo.viewmodel.MainActivityViewModel
import com.example.imdbdemo.viewmodel.MainFragmentViewModel
import com.example.imdbdemo.viewmodel.ViewModelFactory
import com.example.imdbdemo.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @AppScoped
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun bindMainActivityViewModel(viewModel: MainActivityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MainFragmentViewModel::class)
    abstract fun bindMainFragmentViewModel(viewModel: MainFragmentViewModel): ViewModel


}