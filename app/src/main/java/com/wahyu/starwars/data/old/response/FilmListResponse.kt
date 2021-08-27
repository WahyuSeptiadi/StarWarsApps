package com.wahyu.starwars.data.old.response

import com.google.gson.annotations.SerializedName

/**
 * Created by wahyu_septiadi on 27, August 2021.
 * Visit My GitHub --> https://github.com/WahyuSeptiadi
 */

data class FilmListResponse (
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("previous")
    val previous: String,
    @SerializedName("results")
    val filmResultResponse: List<FilmResultsResponse>
)