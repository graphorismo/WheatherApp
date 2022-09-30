package ru.graphorismo.wheatherapp.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.launch
import ru.graphorismo.wheatherapp.R
import ru.graphorismo.wheatherapp.data.WeatherRepository
import ru.graphorismo.wheatherapp.ui.activity.MainViewModel


class MainFragment : Fragment() {

    val activityViewModel: MainViewModel by activityViewModels()

    lateinit var textView_field_town: TextView
    lateinit var textView_field_temperature: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_main, container, false)
        textView_field_town =
            view.findViewById<TextView>(R.id.mainFragment_textView_field_town)
        textView_field_temperature =
            view.findViewById<TextView>(R.id.mainFragment_textView_field_temperature)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {
            // repeatOnLifecycle launches the block in a new coroutine every time the
            // lifecycle is in the STARTED state (or above) and cancels it when it's STOPPED.
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                // Trigger the flow and start listening for values.
                // Note that this happens when lifecycle is STARTED and stops
                // collecting when the lifecycle is STOPPED
                activityViewModel.weatherState.collect { weatherState ->
                    textView_field_town.text = weatherState.name
                    textView_field_temperature.text = (weatherState.main.temp-273).toString()
                }
            }
        }

    }

}