package com.example.weatherforecast.utils

object TextUtils {
    fun getPercentageString(int: Int): String = "$int%"
    fun getCelsiusString(double: Double): String = "$double\u2103"
    fun getKmPerHourString(double: Double): String = "$double км/ч"
    fun addHttps(uri: String): String = "https:$uri"
}