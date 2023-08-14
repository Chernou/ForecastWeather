package com.example.weatherforecast.di

import com.example.weatherforecast.domain.api.ForecastInteractor
import com.example.weatherforecast.domain.impl.ForecastInteractorImpl
import org.koin.dsl.module

val interactorModule = module {

    single<ForecastInteractor> {
        ForecastInteractorImpl(get())
    }

}