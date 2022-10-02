package ru.graphorismo.wheatherapp.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.launch
import ru.graphorismo.wheatherapp.R
import ru.graphorismo.wheatherapp.data.WeatherRepository
import ru.graphorismo.wheatherapp.ui.activity.MainViewModel
import ru.graphorismo.wheatherapp.ui.activity.UIState


class MainFragment : Fragment() {

    val activityViewModel: MainViewModel by activityViewModels()

    lateinit var button_town: Button
    lateinit var textView_field_temperature: TextView
    lateinit var textView_field_pressure: TextView
    lateinit var textView_field_humidity: TextView
    lateinit var textView_field_clouds: TextView
    lateinit var textView_field_wind: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_main, container, false)
        button_town =
            view.findViewById<Button>(R.id.mainFragment_button_town)
        textView_field_temperature =
            view.findViewById<TextView>(R.id.mainFragment_textView_field_temperature)
        textView_field_pressure =
            view.findViewById<TextView>(R.id.mainFragment_textView_field_pressure)
        textView_field_humidity =
            view.findViewById<TextView>(R.id.mainFragment_textView_field_humidity)
        textView_field_clouds =
            view.findViewById<TextView>(R.id.mainFragment_textView_field_clouds)
        textView_field_wind =
            view.findViewById<TextView>(R.id.mainFragment_textView_field_wind)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                activityViewModel.weatherState.collect { weatherState ->
                    button_town.text =
                        weatherState.name
                    button_town.setOnClickListener(){
                        activityViewModel.uiState.value = UIState.TOWNS
                    }
                    textView_field_temperature.text =
                        (weatherState.main.temp.toInt()-273).toString()+" C"
                    textView_field_pressure.text=
                        weatherState.main.pressure.toString()
                    textView_field_humidity.text =
                        weatherState.main.humidity.toString()+"%"
                    textView_field_clouds.text=weatherState.clouds.all.toString()
                    textView_field_wind.text =
                        weatherState.wind.speed.toString()+" m/s"
                }
            }
        }

    }

}