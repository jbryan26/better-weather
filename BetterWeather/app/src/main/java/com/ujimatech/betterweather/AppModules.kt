package com.ujimatech.betterweather

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

const val SERVICE_URL = "https://api.openweathermap.org/data/2.5/forecast/daily?mode=json&cnt=5&units=imperial&apikey=3aa158b2f14a9f493a8c725f8133d704"

val appModule = module {
    factory { provideLoggingInterceptor() }
    factory { provideOkHttpClient(get()) }
    factory { provideRetrofit(get()) }
}

fun provideLoggingInterceptor(): HttpLoggingInterceptor {
    val logger = HttpLoggingInterceptor()
    logger.setLevel(HttpLoggingInterceptor.Level.BODY)
    return logger
}

fun provideOkHttpClient(
    httpLoggingInterceptor: HttpLoggingInterceptor
): OkHttpClient {
    return OkHttpClient().newBuilder()
        .addInterceptor(httpLoggingInterceptor)
        .build()
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(SERVICE_URL)
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
}