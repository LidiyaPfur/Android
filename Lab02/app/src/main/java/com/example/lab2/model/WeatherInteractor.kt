package com.example.lab2.model

import com.example.lab2.api.API
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class WeatherInteractor {

    private val weatherApi = API.retrofitService

    // получаем погоду по определенному городу
    suspend fun getLocalWeather(
        city: String,
        onSuccess: suspend (String) -> Unit,
        onError: suspend (Throwable) -> Unit
    ) {
        kotlin.runCatching {
            flow {
                emit(weatherApi.getWeather(q = city))
            }.collect {
                onSuccess(it.data?.current_condition?.first()?.temp_C ?: "")
            }
        }.onFailure {
            onError(it)
        }
    }
}