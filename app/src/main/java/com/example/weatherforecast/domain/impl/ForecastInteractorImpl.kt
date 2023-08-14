package com.example.weatherforecast.domain.impl

import com.example.weatherforecast.domain.api.ForecastInteractor
import com.example.weatherforecast.domain.api.ForecastRepository
import com.example.weatherforecast.domain.model.ForecastDaily
import com.example.weatherforecast.utils.Resource
import kotlinx.coroutines.flow.Flow

class ForecastInteractorImpl(private val repository: ForecastRepository) : ForecastInteractor {
    override fun getForecast(): Flow<Resource<List<ForecastDaily>>> = repository.getForecast()
}