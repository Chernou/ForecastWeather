package com.example.weatherforecast.data.converter

import com.example.weatherforecast.data.dto.ForecastDailyDto
import com.example.weatherforecast.domain.model.ForecastDaily

class ForecastConverter {
    fun map(forecastDto: ForecastDailyDto): ForecastDaily {
        return ForecastDaily(
            conditionText = forecastDto.day.condition.text,
            conditionIconUri = forecastDto.day.condition.icon,
            averageTemp = forecastDto.day.averageTemp,
            windSpeed = forecastDto.day.windSpeed,
            humidity = forecastDto.day.humidity,
            date = forecastDto.date
        )
    }
}