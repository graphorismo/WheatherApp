package ru.graphorismo.wheatherapp.data.api.request.town

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Sys(
    val country: String = "",
    val id: Int = 0,
    val sunrise: Int = 0,
    val sunset: Int = 0,
    val type: Int = 0
)