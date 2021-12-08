package com.example.imdbdemo.view.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.example.imdbdemo.viewmodel.ViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseFragment<T: ViewModel, V: ViewBinding>: DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    protected lateinit var viewModel: T
    protected lateinit var binding: V

    protected abstract fun getViewModelClass(): Class<out ViewModel>
    protected abstract fun getViewBinding(inflater: LayoutInflater,
                                container: ViewGroup?,
                                savedInstanceState: Bundle?): V

    protected abstract fun initializeViews()
    protected abstract fun setDataToView()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = ViewModelProvider(this,viewModelFactory)[getViewModelClass()] as T
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = getViewBinding(inflater,container,savedInstanceState)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews()
        setDataToView()
    }

    override fun onStart() {
        super.onStart()

    }

    override fun onDetach() {
        super.onDetach()

    }
}