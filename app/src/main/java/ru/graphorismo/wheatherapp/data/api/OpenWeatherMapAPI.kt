package ru.graphorismo.wheatherapp.data.api

import retrofit2.http.GET
import ru.graphorismo.wheatherapp.BuildConfig
import ru.graphorismo.wheatherapp.data.api.request.town.OpenWeatherMapTownRequest

interface OpenWeatherMapAPI {

    @GET("/data/2.5/weather?q=moscow&appid=${BuildConfig.API_KEY}")
    suspend fun getWeatherForMoscow():String
}