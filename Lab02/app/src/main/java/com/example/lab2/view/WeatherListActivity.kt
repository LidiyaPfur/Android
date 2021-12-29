package com.example.lab2.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab2.R
import com.example.lab2.databinding.ActivityMainBinding
import com.example.lab2.databinding.ActivityWeatherListBinding
import com.example.lab2.model.WeatherViewModel
import com.example.lab2.view.rv.WeatherRvAdapter

class WeatherListActivity : AppCompatActivity() {

    private val cities = listOf(
        "Moscow",
        "Vladivostok",
        "Novosibirsk",
        "Omsk",
        "Anapa",
        "Kirov",
        "Astrakhan",
        "Barnaul",
        "Beslan",
        "Blagoveshchensk",
        "Bryansk",
        "Gudermes",
        "Dubna",
        "Yeysk",
        "Yekaterinburg"
    )

    private val model by viewModels<WeatherViewModel>()
    private lateinit var binding: ActivityWeatherListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeatherListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        model.getLocalTemperature(cities)

        binding.rvWeather.layoutManager = LinearLayoutManager(this)

        // слушаем получение городов
        model.weatherList.observe(this) {
            val adapter = WeatherRvAdapter(it)
            binding.rvWeather.adapter = adapter
        }
    }
}