package com.wahyu.starwars.data.old.network

import com.wahyu.starwars.data.old.response.FilmListResponse
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by wahyu_septiadi on 27, August 2021.
 * Visit My GitHub --> https://github.com/WahyuSeptiadi
 */

interface ApiService {
    @GET("films")
    fun getFilms(): Call<FilmListResponse>
}