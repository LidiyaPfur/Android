package com.example.lab2.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext

class WeatherViewModel : ViewModel() {

    private val interactor = WeatherInteractor()

    // слушатели получения городов
    val currentTemperature = MutableLiveData<String>()
    val weatherList = MutableLiveData<List<Pair<String, String>>>()

    // получаем погоду города
    fun getLocalTemperature(city: String) {
        viewModelScope.launch(Dispatchers.IO) {
            interactor.getLocalWeather(
                city = city,
                onSuccess = {
                    currentTemperature.postValue(it)
                },
                onError = {
                    println(it)
                }
            )
        }
    }

    // получаем погоду определенного списка городов
    fun getLocalTemperature(cities: List<String>) {
        val list = mutableListOf<Pair<String, String>>()
        cities.forEach { city ->
            viewModelScope.launch(Dispatchers.IO) {
                interactor.getLocalWeather(
                    city = city,
                    onSuccess = {
                        list.add(Pair(city, it))
                        weatherList.postValue(list)
                    },
                    onError = {}
                )
            }
        }
    }
}