package ru.graphorismo.wheatherapp.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.create
import ru.graphorismo.wheatherapp.R
import ru.graphorismo.wheatherapp.data.api.OpenWeatherMapAPI


class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
        val weatherApi: OpenWeatherMapAPI = retrofit.create<OpenWeatherMapAPI>()

        viewLifecycleOwner.lifecycleScope.launch {
            val response = weatherApi.getWeatherForMoscow()
            Log.d("TEST", "Response received: $response")
        }
    }

}