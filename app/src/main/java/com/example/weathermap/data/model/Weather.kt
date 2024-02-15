package com.example.weathermap.data.model

import com.google.gson.annotations.SerializedName

data class Weather(
    @SerializedName("main") val main: String,
    @SerializedName("description") val description: String,
    @SerializedName("humidity") val humidity: Int,
    // Add other properties as needed
)
