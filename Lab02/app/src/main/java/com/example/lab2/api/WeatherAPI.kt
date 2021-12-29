package com.example.lab2.api

import retrofit2.http.GET
import retrofit2.http.Query

private const val API_KEY = "c4390d903eaf45578ec193854210912"

interface WeatherAPI {

    /**
     * Метод получения погоду по определенному городу
     * @param q - индификатор города/страны
     */
    @GET("premium/v1/weather.ashx")
    suspend fun getWeather(
        @Query("key") apiKey: String = API_KEY,
        @Query("format") format: String = "json",
        @Query("q") q: String = "Russia",
        @Query("num_of_days") numOfDays: Int = 1
    ): Root
}

// POJO классы
data class CurrentCondition(
    var temp_C: String? = null
)

data class Data(
    var current_condition: List<CurrentCondition>? = null
)

data class Root(
    var data: Data? = null
)
