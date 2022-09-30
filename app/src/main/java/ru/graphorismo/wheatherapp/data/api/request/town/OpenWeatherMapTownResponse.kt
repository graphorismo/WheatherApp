package ru.graphorismo.wheatherapp.data.api.request.town

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class OpenWeatherMapTownResponse(
    val base: String = "",
    val clouds: Clouds = Clouds(),
    val cod: Int = 0,
    val coord: Coord = Coord(),
    val dt: Int = 0,
    val id: Int = 0,
    val main: Main = Main(),
    val name: String = "",
    val sys: Sys = Sys(),
    val timezone: Int = 0,
    val visibility: Int = 0,
    val weather: List<Weather> = emptyList(),
    val wind: Wind = Wind()
)