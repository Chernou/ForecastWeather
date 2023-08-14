package com.example.weatherforecast.data.converter

import com.example.weatherforecast.data.dto.ForecastDailyDto
import com.example.weatherforecast.domain.model.ForecastDaily

class ForecastConverter {
    fun map(forecastDailyDto: ForecastDailyDto): ForecastDaily {
        return ForecastDaily(
            conditionText = forecastDailyDto.conditionText,
            conditionIconUri = forecastDailyDto.conditionIconUri,
            averageTemp = forecastDailyDto.averageTemp,
            windSpeed = forecastDailyDto.windSpeed,
            humidity = forecastDailyDto.humidity
        )
    }
}