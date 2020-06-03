package com.example.nexlist.di

import com.example.nexlist.di.module.NetworkModule
import com.example.nexlist.screens.MainActivity
import com.example.nexlist.screens.MovieFragment
import com.example.nexlist.screens.SingleMovieFragment
import dagger.Component


@Component(modules = [NetworkModule::class])
interface ApplicationComponent {

    fun inject(activity: MainActivity)
    fun inject(fragment: MovieFragment)
    fun inject(fragment: SingleMovieFragment)
}