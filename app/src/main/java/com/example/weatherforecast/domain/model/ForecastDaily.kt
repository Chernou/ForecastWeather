package com.example.weatherforecast.domain.model

data class ForecastDaily(
    val conditionText: String,
    val conditionIconUri: String,
    val averageTemp: Double,
    val windSpeed: Double,
    val humidity: Int,
    val date: String
)