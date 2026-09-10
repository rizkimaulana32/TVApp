package com.example.tvapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class TVShowDetailResponse(

	@field:SerializedName("summary")
	val summary: String? = null,

	@field:SerializedName("image")
	val image: Image? = null,

	@field:SerializedName("averageRuntime")
	val averageRuntime: Int? = null,

	@field:SerializedName("dvdCountry")
	val dvdCountry: Any? = null,

	@field:SerializedName("_links")
	val links: Links? = null,

	@field:SerializedName("premiered")
	val premiered: String? = null,

	@field:SerializedName("rating")
	val rating: Rating? = null,

	@field:SerializedName("runtime")
	val runtime: Int? = null,

	@field:SerializedName("weight")
	val weight: Int? = null,

	@field:SerializedName("language")
	val language: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("officialSite")
	val officialSite: String? = null,

	@field:SerializedName("network")
	val network: Network? = null,

	@field:SerializedName("schedule")
	val schedule: Schedule? = null,

	@field:SerializedName("webChannel")
	val webChannel: Any? = null,

	@field:SerializedName("genres")
	val genres: List<String?>? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("ended")
	val ended: String? = null,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("externals")
	val externals: Externals? = null,

	@field:SerializedName("updated")
	val updated: Int? = null,

	@field:SerializedName("status")
	val status: String? = null
)