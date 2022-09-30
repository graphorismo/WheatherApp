package ru.graphorismo.wheatherapp.data

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import ru.graphorismo.wheatherapp.data.api.OpenWeatherMapAPI

class WeatherRepository {
    private val weatherApi : OpenWeatherMapAPI
    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        weatherApi = retrofit.create<OpenWeatherMapAPI>()
    }

    suspend fun getWeatherForMoscow() = weatherApi.getWeatherForMoscow()
}