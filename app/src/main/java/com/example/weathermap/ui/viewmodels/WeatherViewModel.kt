package com.example.weathermap.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.weathermap.data.model.DailyWeather
import com.example.weathermap.data.repository.WeatherRepository
import io.reactivex.rxjava3.core.Single

class WeatherViewModel(private val repository: WeatherRepository) : ViewModel() {
    private val apiKey = "c1f6f3783682c05817829e13eb652582"

    fun getWeatherForecast(lat: Double, lon: Double): Single<List<DailyWeather>> {
        return repository.getWeatherForecast(lat, lon, apiKey)
    }
}