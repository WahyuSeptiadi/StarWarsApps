package com.wahyu.starwars.data.old.response

import com.google.gson.annotations.SerializedName

/**
 * Created by wahyu_septiadi on 27, August 2021.
 * Visit My GitHub --> https://github.com/WahyuSeptiadi
 */

data class FilmResultsResponse(
    val title: String,
    @SerializedName("episode_id")
    val episodeId: Int,
    @SerializedName("opening_crawl")
    val openingCrawl: String,
    val director: String,
    val producer: String,
    @SerializedName("release_date")
    val releaseDate: String
)