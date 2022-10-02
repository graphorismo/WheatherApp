package ru.graphorismo.wheatherapp.data.api

import retrofit2.http.GET
import retrofit2.http.Query
import ru.graphorismo.wheatherapp.BuildConfig
import ru.graphorismo.wheatherapp.data.api.request.town.OpenWeatherMapTownResponse

interface OpenWeatherMapAPI {

    @GET("/data/2.5/weather")
    suspend fun getWeatherFor(
        @Query("q") town: String,
        @Query("appid") apikey: String
    ): OpenWeatherMapTownResponse
}