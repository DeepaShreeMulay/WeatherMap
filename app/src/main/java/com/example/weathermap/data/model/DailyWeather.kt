package com.example.weathermap.data.model

import com.google.gson.annotations.SerializedName

data class DailyWeather(
    @SerializedName("dt") val timestamp: Long,
    @SerializedName("temp") val temperature: Temperature,
    @SerializedName("weather") val weather: List<Weather>,
    // Add other properties as needed
)