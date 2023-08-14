package com.example.weatherforecast.view_model

import com.example.weatherforecast.domain.model.ForecastDaily

sealed interface ForecastState {
    class DisplayForecast(val forecastDailyList: List<ForecastDaily>) : ForecastState
    class ErrorState(val errorText: String) : ForecastState
}