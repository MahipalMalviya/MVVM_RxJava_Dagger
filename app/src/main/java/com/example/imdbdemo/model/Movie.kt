package com.example.imdbdemo.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Movie(
    @Json(name = "id") var id: String? = null,
    @Json(name = "rank") var rank: String? = null,
    @Json(name = "rankUpDown") var rankUpDown: String? = null,
    @Json(name = "title") var title: String? = null,
    @Json(name = "fullTitle") var fullTitle: String? = null,
    @Json(name = "year") var year: String? = null,
    @Json(name = "image") var image: String? = null,
    @Json(name = "crew") var crew: String? = null,
    @Json(name = "imDbRating") var imDbRating: String? = null,
    @Json(name = "imDbRatingCount") var imDbRatingCount: String? = null
)
