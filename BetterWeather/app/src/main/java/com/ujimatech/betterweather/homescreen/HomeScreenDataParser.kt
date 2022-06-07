package com.ujimatech.betterweather.homescreen

import android.graphics.drawable.Drawable
import androidx.core.graphics.drawable.DrawableCompat
import com.ujimatech.betterweather.models.DayWeather
import com.ujimatech.betterweather.models.WeatherItemModel

class HomeScreenDataParser {
    private val weatherItemModels: ArrayList<WeatherItemModel> = arrayListOf()

    fun parseWeatherItemModels(dayWeatherModels: ArrayList<DayWeather>): ArrayList<WeatherItemModel> {
        return weatherItemModels
    }

    fun getIconDrawable(drawableResponseId: String) {

    }

    fun getWindDirectionFromDegrees(degrees: Int): String {
        return ""
    }

    fun getWindspeedInKilometersFromMph(windspeedInMph: Double): String {
        return ""
    }
}