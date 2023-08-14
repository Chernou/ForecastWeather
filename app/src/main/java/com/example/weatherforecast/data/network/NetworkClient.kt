package com.example.weatherforecast.data.network

import com.example.weatherforecast.data.dto.Response

interface NetworkClient {

    suspend fun doRequest(dto: Any): Response
}