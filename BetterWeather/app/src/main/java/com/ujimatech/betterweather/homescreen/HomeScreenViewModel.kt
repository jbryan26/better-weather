package com.ujimatech.betterweather.homescreen

import androidx.lifecycle.ViewModel
import com.ujimatech.betterweather.R
import com.ujimatech.betterweather.models.WeatherItemModel
import com.ujimatech.betterweather.networking.WeatherApi

class HomeScreenViewModel(weatherApi: WeatherApi): ViewModel() {
    private val weatherItemModels: ArrayList<WeatherItemModel> = arrayListOf()

    fun getSampleData(): ArrayList<WeatherItemModel> {
        weatherItemModels.add(WeatherItemModel(R.drawable.ic_weather_cloudy, "Sunday", "Sunny", "77", "75", "81%", "1101", "5", "S"))
        weatherItemModels.add(WeatherItemModel(R.drawable.ic_weather_cloudy, "Sunday", "Sunny", "77", "75", "81%", "1101", "5", "S"))
        weatherItemModels.add(WeatherItemModel(R.drawable.ic_weather_cloudy, "Sunday", "Sunny", "77", "75", "81%", "1101", "5", "S"))
        weatherItemModels.add(WeatherItemModel(R.drawable.ic_weather_cloudy, "Sunday", "Sunny", "77", "75", "81%", "1101", "5", "S"))
        weatherItemModels.add(WeatherItemModel(R.drawable.ic_weather_cloudy, "Sunday", "Sunny", "77", "75", "81%", "1101", "5", "S"))
        weatherItemModels.add(WeatherItemModel(R.drawable.ic_weather_cloudy, "Sunday", "Sunny", "77", "75", "81%", "1101", "5", "S"))
        weatherItemModels.add(WeatherItemModel(R.drawable.ic_weather_cloudy, "Sunday", "Sunny", "77", "75", "81%", "1101", "5", "S"))
        weatherItemModels.add(WeatherItemModel(R.drawable.ic_weather_cloudy, "Sunday", "Sunny", "77", "75", "81%", "1101", "5", "S"))
        weatherItemModels.add(WeatherItemModel(R.drawable.ic_weather_cloudy, "Sunday", "Sunny", "77", "75", "81%", "1101", "5", "S"))
        weatherItemModels.add(WeatherItemModel(R.drawable.ic_weather_cloudy, "Sunday", "Sunny", "77", "75", "81%", "1101", "5", "S"))
        weatherItemModels.add(WeatherItemModel(R.drawable.ic_weather_cloudy, "Sunday", "Sunny", "77", "75", "81%", "1101", "5", "S"))

        return weatherItemModels
    }
}