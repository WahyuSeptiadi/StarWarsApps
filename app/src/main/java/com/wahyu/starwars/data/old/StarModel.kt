package com.wahyu.starwars.data.old

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by wahyu_septiadi on 27, August 2021.
 * Visit My GitHub --> https://github.com/WahyuSeptiadi
 */

@Parcelize
class StarModel(
    val title: String,
    val episodeId: Int,
    val openingCrawl: String,
    val director: String,
    val producer: String,
    val releaseDate: String
) : Parcelable