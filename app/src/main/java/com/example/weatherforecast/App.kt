package com.example.weatherforecast

import android.app.Application
import com.example.weatherforecast.di.dataModule
import com.example.weatherforecast.di.interactorModule
import com.example.weatherforecast.di.repositoryModule
import com.example.weatherforecast.di.utilsModule
import com.example.weatherforecast.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                repositoryModule,
                dataModule,
                interactorModule,
                viewModelModule,
                utilsModule
            )
        }
    }
}