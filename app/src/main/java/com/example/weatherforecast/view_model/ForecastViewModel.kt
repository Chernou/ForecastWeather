package com.example.weatherforecast.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherforecast.domain.api.ForecastInteractor
import kotlinx.coroutines.launch

class ForecastViewModel(private val interactor: ForecastInteractor) : ViewModel() {

    init {
        viewModelScope.launch {
            interactor.getForecast().collect {
                if (it.data != null) renderState(ForecastState.DisplayForecast(it.data))
                else renderState(ForecastState.ErrorState(it.message!!))
            }
        }
    }

    private val forecastLiveData = MutableLiveData<ForecastState>()

    private fun renderState(state: ForecastState) {
        forecastLiveData.postValue(state)
    }

    fun observeForecastState(): LiveData<ForecastState> = forecastLiveData
}