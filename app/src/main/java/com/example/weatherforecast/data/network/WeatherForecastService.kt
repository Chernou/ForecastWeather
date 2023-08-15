package com.example.weatherforecast.data.network

import com.example.weatherforecast.data.dto.ForecastResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherForecastService {
    @GET("forecast.json")
    suspend fun getForecast(
        @Query("q") location: String,
        @Query("key") key: String,
        @Query("days") days: Int,
        @Query("lang") language: String
    ): ForecastResponse
}