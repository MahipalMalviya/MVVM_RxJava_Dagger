package com.example.imdbdemo.viewmodel

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import com.example.imdbdemo.di.module.Utils
import com.example.imdbdemo.di.scope.AppScoped
import javax.inject.Inject

@AppScoped
class MainActivityViewModel @Inject constructor(
    private val utils: Utils
): ViewModel() {

    fun launchMainFragment(frameId:Int, activity: FragmentManager,fragment:Fragment) {
        utils.launchFragment(frameId,activity,fragment)
    }

}