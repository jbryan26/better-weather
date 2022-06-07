package com.ujimatech.betterweather.homescreen

import androidx.lifecycle.ViewModel
import com.ujimatech.betterweather.models.DayWeather
import com.ujimatech.betterweather.models.WeatherItemModel
import com.ujimatech.betterweather.models.WeatherMapResponse
import com.ujimatech.betterweather.networking.WeatherApi
import io.reactivex.Observable
import retrofit2.Response

class HomeScreenViewModel(private val weatherApi: WeatherApi): ViewModel() {
    private val dataParser: HomeScreenDataParser = HomeScreenDataParser()
    private var weatherItemModels: ArrayList<WeatherItemModel> = arrayListOf()

    fun updateWeatherData(dayWeatherList: List<DayWeather>) {
        weatherItemModels.clear()
        weatherItemModels = dataParser.parseWeatherItemModels(dayWeatherList)
    }

    fun refreshWeatherData(): Observable<Response<WeatherMapResponse>> {
        return weatherApi.getWeatherResponse()
    }

    fun getWeatherDataList(): ArrayList<WeatherItemModel> {
        return weatherItemModels
    }
}