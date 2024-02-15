package com.example.weathermap.data.model

import com.google.gson.annotations.SerializedName

data class WeatherForecastResponse(
    @SerializedName("lat") val latitude: Double,
    @SerializedName("lon") val longitude: Double,
    @SerializedName("timezone") val timezone: String,
    @SerializedName("current") val current: CurrentWeather,
    @SerializedName("daily") val daily: List<DailyWeather>,
    // Add other properties as needed
)








