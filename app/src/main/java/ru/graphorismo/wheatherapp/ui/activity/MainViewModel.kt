package ru.graphorismo.wheatherapp.ui.activity

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel: ViewModel() {

    val uiState = MutableStateFlow<UIState>(UIState.SPLASH)
}