package com.ujimatech.betterweather.homescreen

import com.ujimatech.betterweather.R
import com.ujimatech.betterweather.models.DayWeather
import com.ujimatech.betterweather.models.WeatherItemModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.math.roundToInt

class HomeScreenDataParser {
    private val weatherItemModels: ArrayList<WeatherItemModel> = arrayListOf()

    fun parseWeatherItemModels(dayWeatherModels: List<DayWeather>): ArrayList<WeatherItemModel> {
        weatherItemModels.clear()
        for (dayWeatherModel in dayWeatherModels) {
            weatherItemModels
                .add(
                    WeatherItemModel(
                        iconId = getIconDrawable(dayWeatherModel.weather.first().icon),
                        dayName = getDayStringFromUtcString(dayWeatherModel.dt.toString()),
                        weatherOutlook = dayWeatherModel.weather.first().main,
                        tempHigh = dayWeatherModel.temp.max.roundToInt().toString(),
                        tempLow = dayWeatherModel.temp.min.roundToInt().toString(),
                        dayTemp = dayWeatherModel.temp.day.roundToInt().toString(),
                        humidity = dayWeatherModel.humidity.toString(),
                        pressure = dayWeatherModel.pressure.toString(),
                        windSpeed = getWindspeedInKilometersFromMph(dayWeatherModel.speed),
                        windDirection = getWindDirectionFromDegrees(dayWeatherModel.deg)
                    )
                )
        }
        return weatherItemModels
    }

    fun getIconDrawable(drawableResponseId: String): Int {
        val iconId: Int = when (drawableResponseId) {
            "11d" -> R.drawable.ic_weather_stormy
            "09d" -> R.drawable.ic_weather_rainy
            "10d", "13d" -> R.drawable.ic_weather_rainy_2
            "50d", "01d" -> R.drawable.ic_weather_sunny
            "01n" -> R.drawable.ic_weather_moon
            "02d" -> R.drawable.ic_weather_cloudy
            "02n" -> R.drawable.ic_weather_cloudy_night
            else -> R.drawable.ic_weather_rainy
        }
        return iconId
    }

    fun getWindDirectionFromDegrees(degrees: Int): String {
        var windDirection = ""
        val isNorth: Boolean = degrees <= 22 || degrees >= 338
        val isNorthEast: Boolean = degrees in 23..67
        val isEast: Boolean = degrees in 68..112
        val isSouthEast: Boolean = degrees in 113..157
        val isSouth: Boolean = degrees in 158..202
        val isSouthWest: Boolean = degrees in 203..247
        val isWest: Boolean = degrees in 248..316
        val isNorthWest: Boolean = degrees in 317..337
        when {
            isNorth -> {
                windDirection = "N"
            }
            isNorthEast -> {
                windDirection = "NE"
            }
            isNorthEast -> {
                windDirection = "NE"
            }
            isEast -> {
                windDirection = "E"
            }
            isSouthEast -> {
                windDirection = "SE"
            }
            isSouth -> {
                windDirection = "S"
            }
            isSouthWest -> {
                windDirection = "SW"
            }
            isWest -> {
                windDirection = "W"
            }
            isNorthWest -> {
                windDirection = "NW"
            }
        }

        return windDirection
    }

    fun getWindspeedInKilometersFromMph(windspeedInMph: Double): String {
        return (windspeedInMph * 1.60934).roundToInt().toString()
    }

    fun getDayStringFromUtcString(utcString: String): String {
        //TODO: Correct date parsing

        // val date = Date(utcString.toLong()).toInstant()

        // return SimpleDateFormat("EEEE", Locale.getDefault()).format(date)
        return "Sunday"
    }
}