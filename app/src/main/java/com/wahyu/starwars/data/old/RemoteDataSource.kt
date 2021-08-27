package com.wahyu.starwars.data.old

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.wahyu.starwars.data.old.network.ApiResponse
import com.wahyu.starwars.data.old.network.ApiService
import com.wahyu.starwars.data.old.response.FilmListResponse
import com.wahyu.starwars.data.old.response.FilmResultsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by wahyu_septiadi on 27, August 2021.
 * Visit My GitHub --> https://github.com/WahyuSeptiadi
 */

class RemoteDataSource private constructor(private val apiService: ApiService) {
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(service: ApiService): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(service)
            }
    }

    fun getAllFilms(): LiveData<ApiResponse<List<FilmResultsResponse>>> {
        val resultData = MutableLiveData<ApiResponse<List<FilmResultsResponse>>>()

        val client = apiService.getFilms()

        client.enqueue(object : Callback<FilmListResponse> {
            override fun onResponse(
                call: Call<FilmListResponse>,
                responseFilms: Response<FilmListResponse>
            ) {
                val dataArray = responseFilms.body()?.filmResultResponse
                resultData.value =
                    if (dataArray != null) ApiResponse.Success(dataArray) else ApiResponse.Empty
            }

            override fun onFailure(call: Call<FilmListResponse>, t: Throwable) {
                resultData.value = ApiResponse.Error(t.message.toString())
                Log.e("RemoteDataSource", t.message.toString())
            }
        })

        return resultData
    }
}