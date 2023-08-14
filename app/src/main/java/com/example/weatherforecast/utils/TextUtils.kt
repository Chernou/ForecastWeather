package com.example.weatherforecast.utils

object TextUtils {
    fun getPercentageString(double: Double): String = "$double%"
    fun getCelsiusString(int: Int): String = "$int\u2103"
}