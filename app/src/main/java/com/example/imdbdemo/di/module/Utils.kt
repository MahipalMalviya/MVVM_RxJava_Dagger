package com.example.imdbdemo.di.module

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.imdbdemo.di.scope.AppScoped
import dagger.Module
import dagger.Provides
import javax.inject.Inject

@Module
class Utils @Inject constructor() {

    @AppScoped
    @Provides
    fun launchFragment(frameId:Int, context: FragmentManager, fragment: Fragment): Int {
        return context.beginTransaction()
            .replace(frameId,fragment,fragment::class.java.simpleName)
            .commit()
    }

}