package com.wahyu.starwars.data.old

import com.wahyu.starwars.utils.AppExecutors

/**
 * Created by wahyu_septiadi on 27, August 2021.
 * Visit My GitHub --> https://github.com/WahyuSeptiadi
 */

class StarRepository private constructor(
    val remoteDataSource: RemoteDataSource,
    private val appExecutors: AppExecutors
) {
    companion object {
        @Volatile
        private var instance: StarRepository? = null

        fun getInstance(
            remoteData: RemoteDataSource,
            appExecutors: AppExecutors
        ): StarRepository =
            instance ?: synchronized(this) {
                instance ?: StarRepository(remoteData, appExecutors)
            }
    }

//    fun getAllFilm() : LiveData<Resource<List<StarModel>>> {
//
//    }

}