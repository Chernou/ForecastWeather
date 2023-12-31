package com.example.weatherforecast.ui

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.weatherforecast.R
import com.example.weatherforecast.domain.model.ForecastDaily
import com.example.weatherforecast.utils.TextUtils

class ForecastViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val conditionText = itemView.findViewById<TextView>(R.id.condition_text)
    private val temperature = itemView.findViewById<TextView>(R.id.temperature)
    private val windSpeed = itemView.findViewById<TextView>(R.id.wind_speed)
    private val humidity = itemView.findViewById<TextView>(R.id.humidity)
    private val date = itemView.findViewById<TextView>(R.id.date)
    private val conditionImage = itemView.findViewById<ImageView>(R.id.condition_icon)

    fun bind(position: Int, forecastDaily: ForecastDaily) {
        conditionText.text = forecastDaily.conditionText
        temperature.text = TextUtils.getCelsiusString(forecastDaily.averageTemp)
        windSpeed.text = TextUtils.getKmPerHourString(forecastDaily.windSpeed)
        humidity.text = TextUtils.getPercentageString(forecastDaily.humidity)
        Glide.with(conditionImage)
            .load(forecastDaily.conditionIconUri)
            .fitCenter()
            .placeholder(R.drawable.ic_placeholder)
            .into(conditionImage)
        date.text = when (position) {
            0 -> date.context.getString(R.string.today)
            1 -> date.context.getString(R.string.tomorrow)
            else -> TextUtils.getDate(forecastDaily.date)
        }
    }
}