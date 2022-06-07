package com.ujimatech.betterweather

import com.ujimatech.betterweather.homescreen.HomeScreenDataParser
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class BetterWeatherUnitTests {
    @Test
    fun icon_stormy_isCorrect() {
        val parser = HomeScreenDataParser()
        assertEquals(R.drawable.ic_weather_stormy, parser.getIconDrawable("11d"))
    }

    @Test
    fun icon_rainy_isCorrect() {
        val parser = HomeScreenDataParser()
        assertEquals(R.drawable.ic_weather_rainy, parser.getIconDrawable("09d"))
    }

    @Test
    fun icon_rainy_2_isCorrect() {
        val parser = HomeScreenDataParser()
        assertEquals(R.drawable.ic_weather_rainy_2, parser.getIconDrawable("10d"))
        assertEquals(R.drawable.ic_weather_rainy_2, parser.getIconDrawable("13d"))
    }

    @Test
    fun icon_sunny_isCorrect() {
        val parser = HomeScreenDataParser()
        assertEquals(R.drawable.ic_weather_sunny, parser.getIconDrawable("50d"))
        assertEquals(R.drawable.ic_weather_sunny, parser.getIconDrawable("01d"))
    }

    @Test
    fun icon_moon_isCorrect() {
        val parser = HomeScreenDataParser()
        assertEquals(R.drawable.ic_weather_moon, parser.getIconDrawable("01n"))
    }

    @Test
    fun icon_cloudy_isCorrect() {
        val parser = HomeScreenDataParser()
        assertEquals(R.drawable.ic_weather_cloudy, parser.getIconDrawable("02d"))
    }

    @Test
    fun icon_cloudy_night_isCorrect() {
        val parser = HomeScreenDataParser()
        assertEquals(R.drawable.ic_weather_cloudy_night, parser.getIconDrawable("02n"))
    }

    @Test
    fun icon_rainy_isDefault() {
        val parser = HomeScreenDataParser()
        assertEquals(R.drawable.ic_weather_rainy, parser.getIconDrawable("randomString"))
    }
}