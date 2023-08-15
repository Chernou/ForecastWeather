package com.example.weatherforecast.domain.api

import com.example.weatherforecast.domain.model.ForecastDaily
import com.example.weatherforecast.utils.Resource
import kotlinx.coroutines.flow.Flow

interface ForecastRepository {
    fun getForecast(): Flow<Resource<List<ForecastDaily>>>
}