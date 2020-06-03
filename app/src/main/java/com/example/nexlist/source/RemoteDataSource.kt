package com.example.nexlist.source

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.nexlist.api.ApiService
import com.example.nexlist.model.Movie

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: ApiService){

    // Private, mutable backing field - only update values internally
    private val _myLiveData = MutableLiveData<Movie>()

    // Observers will subscribe to this since it is immutable to them
    val myLiveData: LiveData<Movie>
        get() = _myLiveData

    init {
        getAllMovies()
    }

    private fun getAllMovies(){
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            apiService.getAllMoviesAsync()
                .toObservable()
                .subscribeOn(Schedulers.io())
                .subscribe({
                    response ->
                Log.e("Response",response.toString())
                _myLiveData.postValue(response)
            },{
                error ->
                Log.e("Error",error.message.toString())
            },{
                Log.e("Completed","Completed")
            })
        )




    }

}