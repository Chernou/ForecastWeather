package com.example.weatherforecast.di

import com.example.weatherforecast.utils.ResourceProvider
import com.example.weatherforecast.utils.ResourceProviderImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val utilsModule = module {
    single<ResourceProvider> {
        ResourceProviderImpl(androidContext())
    }
}