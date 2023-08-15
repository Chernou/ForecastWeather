package com.example.weatherforecast.data.dto

import com.google.gson.annotations.SerializedName

data class ForecastResponse(val forecast: Forecast) : Response()

data class Forecast(
    @SerializedName("forecastday") val forecastDay: List<ForecastDay>
)

data class ForecastDay(
    val day: ForecastDailyDto,
)

data class ForecastDailyDto(
    @SerializedName("avghumidity") val humidity: Int,
    @SerializedName("avgtemp_c") val averageTemp: Double,
    val condition: Condition,
    @SerializedName("maxwind_kph") val windSpeed: Double,
)

data class Condition(
    val icon: String,
    val text: String
)
