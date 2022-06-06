package com.ujimatech.betterweather.networking

import com.ujimatech.betterweather.models.WeatherMapResponse
import retrofit2.Response
import retrofit2.http.GET

interface WeatherApi {
    @GET("&q=Atlanta")
    fun getWeatherResponse(): Response<WeatherMapResponse>
}