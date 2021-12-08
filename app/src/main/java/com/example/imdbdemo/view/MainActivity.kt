package com.example.imdbdemo.view

import android.os.Bundle
import android.view.LayoutInflater
import com.example.imdbdemo.databinding.ActivityMainBinding
import com.example.imdbdemo.view.base.BaseActivity
import com.example.imdbdemo.viewmodel.MainActivityViewModel
import javax.inject.Inject

class MainActivity : BaseActivity<MainActivityViewModel,ActivityMainBinding>() {

    @Inject
    lateinit var mainFragment: MainFragment

    override fun getViewModelClass() = MainActivityViewModel::class.java

    override fun getViewBinding(layoutInflater: LayoutInflater) = ActivityMainBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.launchMainFragment(binding.frameId.id,
        supportFragmentManager,mainFragment)
    }
}