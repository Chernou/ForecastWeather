package com.example.weatherforecast.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherforecast.R
import com.example.weatherforecast.domain.model.ForecastDaily

class ForecastAdapter : RecyclerView.Adapter<ForecastViewHolder>() {

    val forecastDailyList = ArrayList<ForecastDaily>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder =
        ForecastViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.forecast_card_view, parent, false)
        )

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        holder.bind(forecastDailyList[position])
    }

    override fun getItemCount(): Int = forecastDailyList.size
}