package com.example.weatherforecast.domain.api

import com.example.weatherforecast.utils.Resource
import com.example.weatherforecast.domain.model.ForecastDaily
import kotlinx.coroutines.flow.Flow

interface ForecastInteractor {
    fun getForecast(): Flow<Resource<List<ForecastDaily>>>
}