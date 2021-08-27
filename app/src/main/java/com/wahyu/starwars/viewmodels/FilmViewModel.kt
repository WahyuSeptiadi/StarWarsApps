package com.wahyu.starwars.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wahyu.starwars.data.FilmResponse
import com.wahyu.starwars.data.ResultsItem
import com.wahyu.starwars.data.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by wahyu_septiadi on 27, August 2021.
 * Visit My GitHub --> https://github.com/WahyuSeptiadi
 */

class FilmViewModel : ViewModel() {
    private val _films = MutableLiveData<List<ResultsItem>>()
    val films: LiveData<List<ResultsItem>> = _films

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    companion object {
        private const val TAG = "FilmViewModel"
    }

    init {
        getDataFilmStarWars()
    }

    private fun getDataFilmStarWars() {
        _isLoading.value = true
        val client = ApiConfig.getApiService().getFilms()
        client.enqueue(object : Callback<FilmResponse> {
            override fun onResponse(
                call: Call<FilmResponse>,
                response: Response<FilmResponse>
            ) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    _films.value = response.body()?.results
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<FilmResponse>, t: Throwable) {
                _isLoading.value = false
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
    }

    fun searchFilmStarWars(title: String): LiveData<List<ResultsItem>> {
        _isLoading.value = true
        val client = ApiConfig.getApiService().searchFilm(title)
        client.enqueue(object : Callback<FilmResponse> {
            override fun onResponse(
                call: Call<FilmResponse>,
                response: Response<FilmResponse>
            ) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    _films.value = response.body()?.results
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<FilmResponse>, t: Throwable) {
                _isLoading.value = false
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
        return _films
    }
}