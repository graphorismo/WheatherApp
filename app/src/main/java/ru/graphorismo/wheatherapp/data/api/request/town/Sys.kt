package ru.graphorismo.wheatherapp.data.api.request.town

data class Sys(
    val country: String,
    val id: Int,
    val sunrise: Int,
    val sunset: Int,
    val type: Int
)