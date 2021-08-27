package com.wahyu.starwars.data.network

import com.wahyu.starwars.data.FilmResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by wahyu_septiadi on 27, August 2021.
 * Visit My GitHub --> https://github.com/WahyuSeptiadi
 */

interface ApiService {
    @GET("films")
    fun getFilms(): Call<FilmResponse>

    @GET("films/?")
    fun searchFilm(@Query("search") title: String): Call<FilmResponse>
}