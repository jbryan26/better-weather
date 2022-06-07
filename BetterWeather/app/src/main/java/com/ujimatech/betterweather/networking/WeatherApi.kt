package com.ujimatech.betterweather.networking

import com.ujimatech.betterweather.models.WeatherMapResponse
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET

interface WeatherApi {
    @GET("daily?mode=json&cnt=5&units=imperial&apikey=3aa158b2f14a9f493a8c725f8133d704&q=Atlanta")
    fun getWeatherResponse(): Observable<Response<WeatherMapResponse>>
}