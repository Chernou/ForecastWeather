package com.example.weatherforecast.data.network

import com.example.weatherforecast.data.dto.ForecastResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherForecastService {

    @GET("forecast.json?q={location}&days=5&lang=ru&key=$API_KEY")
    suspend fun getForecast(
        @Path("location") location: String
    ): ForecastResponse

    companion object {
        private const val API_KEY = "8613b0cad45a4c3b85f114827231408"
    }
}