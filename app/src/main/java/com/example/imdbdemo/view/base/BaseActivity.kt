package com.example.imdbdemo.view.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.example.imdbdemo.viewmodel.ViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity<T: ViewModel,V: ViewBinding> : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    protected lateinit var viewModel: T
    protected lateinit var binding: V

    protected abstract fun getViewModelClass(): Class<out ViewModel>
    protected abstract fun getViewBinding(layoutInflater: LayoutInflater): V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this,viewModelFactory)[getViewModelClass()] as T
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}