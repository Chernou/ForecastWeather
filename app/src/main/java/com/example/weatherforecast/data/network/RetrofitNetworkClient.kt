package com.example.weatherforecast.data.network

import android.util.Log
import com.example.weatherforecast.data.dto.ForecastRequest
import com.example.weatherforecast.data.dto.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RetrofitNetworkClient(
    private val forecastService: WeatherForecastService
) : NetworkClient {

    override suspend fun doRequest(dto: Any): Response {
        if (dto !is ForecastRequest) {
            return Response().apply { resultCode = BAD_REQUEST_ERROR }
        }
        return withContext(Dispatchers.IO) {
            try {
                val response = forecastService.getForecast(dto.location)
                response.apply { resultCode = SUCCESSFUL_REQUEST }
            } catch (e: Throwable) {
                Response().apply { resultCode = SERVER_ERROR }
            }
        }
    }

    companion object {
        const val BASE_URL = "https://api.weatherapi.com/v1/"
        const val BAD_REQUEST_ERROR = 400
        const val SERVER_ERROR = 500
        const val SUCCESSFUL_REQUEST = 200
        const val NO_CONNECTIVITY_ERROR = -1
    }
}