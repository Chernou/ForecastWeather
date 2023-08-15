package com.example.weatherforecast.di

import com.example.weatherforecast.data.impl.ForecastRepositoryImpl
import com.example.weatherforecast.domain.api.ForecastRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<ForecastRepository> {
        ForecastRepositoryImpl(get(), get(), get())
    }
}