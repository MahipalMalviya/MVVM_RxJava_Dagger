package com.example.imdbdemo.di.component

import com.example.imdbdemo.Application
import com.example.imdbdemo.di.module.*
import com.example.imdbdemo.di.scope.AppScoped
import com.example.imdbdemo.network.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@AppScoped
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        NetworkModule::class,
        AppModule::class,
        ActivityBindingModule::class,
        FragmentBindingModule::class,
//        AdapterModule::class,
        ViewModelModule::class,
        Utils::class
    ]
)
interface AppComponent : AndroidInjector<Application> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun attachApplication(application: Application): Builder

        fun build(): AppComponent
    }



}