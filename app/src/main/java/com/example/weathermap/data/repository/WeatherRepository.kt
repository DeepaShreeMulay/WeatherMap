package com.example.weathermap.data.repository

import com.example.weathermap.data.model.DailyWeather
import com.example.weathermap.data.remote.WeatherApiService
import io.reactivex.rxjava3.core.Single

class WeatherRepository(private val apiService: WeatherApiService) {
    fun getWeatherForecast(lat: Double, lon: Double, apiKey: String): Single<List<DailyWeather>> {
        return apiService.getWeatherForecast(lat, lon, "minutely,hourly", apiKey)
            .map { response -> response.daily }
    }
}