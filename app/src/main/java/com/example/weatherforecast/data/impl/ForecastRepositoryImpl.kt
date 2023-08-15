package com.example.weatherforecast.data.impl

import com.example.weatherforecast.R
import com.example.weatherforecast.data.converter.ForecastConverter
import com.example.weatherforecast.data.dto.ForecastRequest
import com.example.weatherforecast.data.dto.ForecastResponse
import com.example.weatherforecast.data.network.NetworkClient
import com.example.weatherforecast.domain.api.ForecastRepository
import com.example.weatherforecast.domain.model.ForecastDaily
import com.example.weatherforecast.utils.Resource
import com.example.weatherforecast.utils.ResourceProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.koin.core.component.KoinComponent
import org.koin.core.parameter.parametersOf

class ForecastRepositoryImpl(
    private val networkClient: NetworkClient,
    private val forecastConverter: ForecastConverter,
    private val resourceProvider: ResourceProvider
) : ForecastRepository, KoinComponent {

    override fun getForecast(): Flow<Resource<List<ForecastDaily>>> = flow {
        val weatherRequest: ForecastRequest = getKoin().get {
            parametersOf(LOCATION)
        }
        val response = networkClient.doRequest(weatherRequest)
        when (response.resultCode) {
            SUCCESSFUL_REQUEST -> {
                emit(Resource.Success((response as ForecastResponse).forecast.forecastDay.map {
                    forecastConverter.map(it.day)
                }))
            }

            else -> {
                emit(Resource.Error(resourceProvider.getString(R.string.server_error)))
            }
        }
    }

    companion object {
        const val SUCCESSFUL_REQUEST = 200
        const val LOCATION = "Moscow"
    }
}