package com.example.weatherforecast.di

import com.example.weatherforecast.data.network.NetworkClient
import com.example.weatherforecast.data.converter.ForecastConverter
import com.example.weatherforecast.data.dto.ForecastRequest
import com.example.weatherforecast.data.network.RetrofitNetworkClient
import com.example.weatherforecast.data.network.WeatherForecastService
import com.google.gson.Gson
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {

    single<WeatherForecastService> {
        Retrofit.Builder()
            .baseUrl(RetrofitNetworkClient.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherForecastService::class.java)
    }

    single<NetworkClient> {
        RetrofitNetworkClient(get())
    }

    single {
        Gson()
    }

    factory { (location: String) ->
        ForecastRequest(location)
    }

    single {
        ForecastConverter()
    }
}