package com.example.nexlist.screens

import androidx.lifecycle.LiveData
import com.example.nexlist.model.Movie
import com.example.nexlist.repository.MovieRepository
import javax.inject.Inject

class MovieViewModel  @Inject constructor(private val movieRepository: MovieRepository){

    fun allMovies():LiveData<Movie>{
       return movieRepository.getAllMovies()
    }
}