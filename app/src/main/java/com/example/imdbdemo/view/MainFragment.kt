package com.example.imdbdemo.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.imdbdemo.databinding.FragmentMainBinding
import com.example.imdbdemo.di.scope.ActivityScoped
import com.example.imdbdemo.view.adapter.MovieAdapter
import com.example.imdbdemo.view.base.BaseFragment
import com.example.imdbdemo.viewmodel.MainFragmentViewModel
import javax.inject.Inject

@ActivityScoped
class MainFragment @Inject constructor():
    BaseFragment<MainFragmentViewModel, FragmentMainBinding>() {

    @Inject
    lateinit var movieAdapter: MovieAdapter

    override fun getViewModelClass() = MainFragmentViewModel::class.java

    override fun getViewBinding(inflater: LayoutInflater,
                                container: ViewGroup?,
                                savedInstanceState: Bundle?): FragmentMainBinding {
        return FragmentMainBinding.inflate(inflater,container,false)
    }

    override fun initializeViews() {
        Log.d("MainFragment","initializeViews -> Calling ViewModel")
        viewModel.getPopularMovies()
    }

    private fun initViews() {
        binding.rvMovieList.apply {
            layoutManager = LinearLayoutManager(context,RecyclerView.VERTICAL,false)
            adapter = movieAdapter
        }
    }

    override fun setDataToView() {
        initViews()

        viewModel.progressData.observe(viewLifecycleOwner,{
            binding.progressBar.visibility = if (it) View.VISIBLE else View.GONE
        })
        viewModel.error.observe(viewLifecycleOwner,{
            Toast.makeText(context,it,Toast.LENGTH_LONG).show()
        })
        viewModel.response.observe(viewLifecycleOwner, {
            movieAdapter.setData(it)
        })
    }
}