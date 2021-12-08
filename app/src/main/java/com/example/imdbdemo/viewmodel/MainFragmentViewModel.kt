package com.example.imdbdemo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.imdbdemo.di.scope.AppScoped
import com.example.imdbdemo.model.Movie
import com.example.imdbdemo.repository.MainRepository
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@AppScoped
class MainFragmentViewModel @Inject constructor(
    private val mainRepository: MainRepository
): ViewModel() {

    val progressData = MutableLiveData<Boolean>()
    val response = MutableLiveData<List<Movie>>()
    val error = MutableLiveData<String>()

    fun getPopularMovies() {
        mainRepository.getPopularMovies()
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { progressData.postValue(true) }
            .doAfterTerminate { progressData.postValue(false) }
            .subscribe({
                if (!it.errorMsg.isNullOrEmpty()) {
                    error.postValue(it.errorMsg)
                } else {
                    response.postValue(it.movieList)
                }
            },{
                error.postValue("Something went wrong")
                it.printStackTrace()
            })

    }

}