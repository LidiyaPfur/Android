package com.example.lab2.api

object API {

    private const val BASE_URL = "https://api.worldweatheronline.com/"
    val retrofitService: WeatherAPI
        get() = RetrofitClient.getClient(BASE_URL).create(WeatherAPI::class.java)
}