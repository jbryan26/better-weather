package com.ujimatech.betterweather.models
import android.graphics.drawable.Drawable
import com.squareup.moshi.Json

data class WeatherMapResponse(
    val city: City = City(),
    val cnt: Int = 0,
    val cod: String = "",
    val list: List<DayWeather> = listOf(),
    val message: Double = 0.0
)

data class City(
    val coord: Coord = Coord(),
    val country: String = "",
    val id: Int = 0,
    val name: String = "",
    val population: Int = 0,
    val timezone: Int = 0
)

data class WeatherItemModel(
    val iconId: Int,
    val dayName: String = "",
    val weatherOutlook: String = "",
    val tempHigh: String = "",
    val tempLow: String = "",
    val humidity: String = "",
    val pressure: String = "",
    val windSpeed: String = "",
    val windDirection: String = "",
    var isExpanded: Boolean = false
)

data class DayWeather(
    val clouds: Int = 0,
    val deg: Int = 0,
    val dt: Int = 0,
    @field:Json(name = "feels_like")
    val feelsLike: FeelsLike = FeelsLike(),
    val gust: Double = 0.0,
    val humidity: Int = 0,
    val pop: Double = 0.0,
    val pressure: Int = 0,
    val rain: Double = 0.0,
    val speed: Double = 0.0,
    val sunrise: Int = 0,
    val sunset: Int = 0,
    val temp: Temp = Temp(),
    val weather: List<Weather> = listOf()
)

data class Coord(
    val lat: Double = 0.0,
    val lon: Double = 0.0
)

data class FeelsLike(
    val day: Double = 0.0,
    val eve: Double = 0.0,
    val morn: Double = 0.0,
    val night: Double = 0.0
)

data class Temp(
    val day: Double = 0.0,
    val eve: Double = 0.0,
    val max: Double = 0.0,
    val min: Double = 0.0,
    val morn: Double = 0.0,
    val night: Double = 0.0
)

data class Weather(
    val description: String = "",
    val icon: String = "",
    val id: Int = 0,
    val main: String = ""
)