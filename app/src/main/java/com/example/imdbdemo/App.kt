package com.example.imdbdemo

import com.example.imdbdemo.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class Application: DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent
            .builder()
            .attachApplication(this)
            .build()
    }
}