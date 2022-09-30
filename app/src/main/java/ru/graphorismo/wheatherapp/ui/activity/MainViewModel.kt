package ru.graphorismo.wheatherapp.ui.activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.graphorismo.wheatherapp.data.WeatherRepository
import ru.graphorismo.wheatherapp.data.api.request.town.OpenWeatherMapTownResponse

class MainViewModel: ViewModel() {

    val uiState = MutableStateFlow<UIState>(UIState.SPLASH)
    val weatherState = MutableStateFlow<OpenWeatherMapTownResponse>(OpenWeatherMapTownResponse())

    init {
        viewModelScope.launch {
            weatherState.value = WeatherRepository().getWeatherForMoscow()
        }
    }
}