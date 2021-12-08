package com.example.imdbdemo.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Response(
    @Json(name = "items") val movieList: List<Movie> = arrayListOf(),
    @Json(name = "errorMessage") val errorMsg: String? = null
)
