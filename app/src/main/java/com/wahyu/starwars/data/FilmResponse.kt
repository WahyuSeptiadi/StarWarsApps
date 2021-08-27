package com.wahyu.starwars.data

import com.google.gson.annotations.SerializedName

data class FilmResponse(

	@field:SerializedName("next")
	val next: Any,

	@field:SerializedName("previous")
	val previous: Any,

	@field:SerializedName("count")
	val count: Int,

	@field:SerializedName("results")
	val results: List<ResultsItem>
)

data class ResultsItem(

	@field:SerializedName("edited")
	val edited: String,

	@field:SerializedName("director")
	val director: String,

	@field:SerializedName("created")
	val created: String,

	@field:SerializedName("vehicles")
	val vehicles: List<String>,

	@field:SerializedName("opening_crawl")
	val openingCrawl: String,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("url")
	val url: String,

	@field:SerializedName("characters")
	val characters: List<String>,

	@field:SerializedName("episode_id")
	val episodeId: Int,

	@field:SerializedName("planets")
	val planets: List<String>,

	@field:SerializedName("release_date")
	val releaseDate: String,

	@field:SerializedName("starships")
	val starships: List<String>,

	@field:SerializedName("species")
	val species: List<String>,

	@field:SerializedName("producer")
	val producer: String
)
