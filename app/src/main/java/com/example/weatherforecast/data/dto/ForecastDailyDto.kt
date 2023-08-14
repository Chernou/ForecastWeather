package com.example.weatherforecast.data.dto

import com.google.gson.annotations.SerializedName

data class ForecastDailyDto(
    @SerializedName("condition.text") val conditionText: String,
    @SerializedName("condition.icon") val conditionIconUri: String,
    @SerializedName("avgtemp_c") val averageTemp: Double,
    @SerializedName("maxwind_kph") val windSpeed: Double,
    @SerializedName("avghumidity") val humidity: Int,
)
