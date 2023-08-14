package com.example.weatherforecast.data.dto

data class ForecastResponse(val forecast: Forecast) : Response()

data class Forecast(
    val forecastday: List<ForecastDay>
)

data class ForecastDay(
    val day: Day,
)

data class Day(
    val avghumidity: Int,
    val avgtemp_c: Double,
    val condition: Condition,
    val maxwind_kph: Double,
)

data class Condition(
    val code: Int,
    val icon: String,
    val text: String
)
