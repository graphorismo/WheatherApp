package ru.graphorismo.wheatherapp.data.api.request.town

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Coord(
    val lat: Double = 0.0,
    val lon: Double = 0.0
)