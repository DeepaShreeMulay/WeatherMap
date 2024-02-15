package com.example.weathermap.data.model

import com.google.gson.annotations.SerializedName

data class CurrentWeather(
    @SerializedName("dt") val timestamp: Long,
    @SerializedName("temp") val temperature: Double,
    @SerializedName("humidity") val humidity: Int,
    // Add other properties as needed
)