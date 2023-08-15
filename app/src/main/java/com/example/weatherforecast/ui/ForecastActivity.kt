package com.example.weatherforecast.ui

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherforecast.R
import com.example.weatherforecast.domain.model.ForecastDaily
import com.example.weatherforecast.view_model.ForecastState
import com.example.weatherforecast.view_model.ForecastViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ForecastActivity : AppCompatActivity() {

    private lateinit var forecastRecyclerView: RecyclerView
    private lateinit var errorTextView: TextView
    private val viewModel: ForecastViewModel by viewModel()
    private val forecastAdapter = ForecastAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.forecast_activity)
        errorTextView = findViewById(R.id.error_text_view)
        forecastRecyclerView = findViewById<RecyclerView?>(R.id.forecast_recycler_view).apply {
            adapter = forecastAdapter
            layoutManager = LinearLayoutManager(context)
        }

        viewModel.observeForecastState().observe(this) {
            render(it)
        }
    }

    private fun render(state: ForecastState) {
        when (state) {
            is ForecastState.DisplayForecast -> displayForecast(state.forecastDailyList)
            is ForecastState.ErrorState -> displayError(state.errorText)
        }
    }

    private fun displayForecast(forecastDailyList: List<ForecastDaily>) {
        errorTextView.visibility = View.GONE
        forecastRecyclerView.visibility = View.VISIBLE
        forecastAdapter.forecastDailyList.apply {
            clear()
            addAll(forecastDailyList)
        }
        forecastAdapter.notifyDataSetChanged()
    }

    private fun displayError(errorText: String) {
        forecastRecyclerView.visibility = View.GONE
        errorTextView.apply {
            visibility = View.VISIBLE
            text = errorText
        }
    }
}