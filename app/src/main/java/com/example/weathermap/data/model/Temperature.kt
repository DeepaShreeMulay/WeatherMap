package com.example.weathermap.data.model

import com.google.gson.annotations.SerializedName

data class Temperature(
    @SerializedName("day") val day: Double,
    // Add other temperature properties as needed
)