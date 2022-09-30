package ru.graphorismo.wheatherapp.data.api.request.town

data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)