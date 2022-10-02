package ru.graphorismo.wheatherapp.ui.activity

import androidx.lifecycle.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.graphorismo.wheatherapp.data.WeatherRepository
import ru.graphorismo.wheatherapp.data.api.request.town.OpenWeatherMapTownResponse

class MainViewModel: ViewModel() {

    val uiState = MutableStateFlow<UIState>(UIState.SPLASH)
    val weatherState = MutableStateFlow<OpenWeatherMapTownResponse>(OpenWeatherMapTownResponse())

    val currentTown = MutableStateFlow<TownState>(TownState.MOSCOW)

    init {
        viewModelScope.launch {
            weatherState.value = WeatherRepository().getWeatherFor(currentTown.value)
        }

        viewModelScope.launch {
            currentTown
                .collect {
                    weatherState.value = WeatherRepository().getWeatherFor(it)
                }
        }
    }
}