package com.example.weatherforecast.utils

import java.text.SimpleDateFormat
import java.util.Locale

object TextUtils {
    fun getPercentageString(int: Int): String = "$int%"
    fun getCelsiusString(double: Double): String = "$double\u2103"
    fun getKmPerHourString(double: Double): String = "$double км/ч"
    fun addHttps(uri: String): String = "https:$uri"
    fun getDate(date: String): String {
        val locale = Locale("ru")
        val parsedDate = SimpleDateFormat("yyyy-MM-dd", locale).parse(date)
        val dayOfWeek = SimpleDateFormat("EE", locale).format(parsedDate!!)
            .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
        val day = SimpleDateFormat("d", locale).format(parsedDate)
        val month = SimpleDateFormat("MMMM", locale).format(parsedDate).take(3)
        return "$dayOfWeek $day $month"
    }
}