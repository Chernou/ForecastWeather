package com.example.weatherforecast.di

import com.example.weatherforecast.view_model.ForecastViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel{
        ForecastViewModel(get())
    }

}