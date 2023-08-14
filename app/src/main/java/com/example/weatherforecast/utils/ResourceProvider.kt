package com.example.weatherforecast.utils

interface ResourceProvider {
    fun getString(resId: Int): String
}