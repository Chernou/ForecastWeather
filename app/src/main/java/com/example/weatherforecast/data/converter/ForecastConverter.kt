package com.example.weatherforecast.data.converter

import com.example.weatherforecast.data.dto.ForecastDailyDto
import com.example.weatherforecast.domain.model.ForecastDaily

class ForecastConverter {
    fun map(day: ForecastDailyDto): ForecastDaily {
        return ForecastDaily(
            conditionText = day.condition.text,
            conditionIconUri = day.condition.icon,
            averageTemp = day.averageTemp,
            windSpeed = day.windSpeed,
            humidity = day.humidity
        )
    }
}