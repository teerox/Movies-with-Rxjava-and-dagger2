package com.example.nexlist.repository

import androidx.lifecycle.LiveData
import com.example.nexlist.model.Movie
import com.example.nexlist.source.RemoteDataSource
import javax.inject.Inject

class MovieRepository  @Inject constructor(
    private val localDataSource: RemoteDataSource){

    fun getAllMovies():LiveData<Movie>{
        return localDataSource.myLiveData
    }

}