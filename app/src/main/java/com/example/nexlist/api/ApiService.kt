package com.example.nexlist.api

import com.example.nexlist.model.Movie
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @Headers(
        "x-rapidapi-host: unogs-unogs-v1.p.rapidapi.com",
        "x-rapidapi-key: 3cbdd67ceemsheded313af5a1125p108312jsnb064a1995fa7"
    )
    @GET("aaapi.cgi")
    fun getAllMoviesAsync(@Query("q") q :String = "get:new7:US",
                          @Query("p") p :Int = 1,
                          @Query("t") t :String = "ns",
                          @Query("st") st :String = "adv"): Flowable<Movie>

}
