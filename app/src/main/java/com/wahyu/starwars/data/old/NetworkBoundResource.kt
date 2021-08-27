package com.wahyu.starwars.data.old

import com.wahyu.starwars.utils.AppExecutors

/**
 * Created by wahyu_septiadi on 27, August 2021.
 * Visit My GitHub --> https://github.com/WahyuSeptiadi
 */

abstract class NetworkBoundResource<ResultType, RequestType>(private val mExecutors: AppExecutors) {
}