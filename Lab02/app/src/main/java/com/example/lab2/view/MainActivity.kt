package com.example.lab2.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.lab2.R
import com.example.lab2.databinding.ActivityMainBinding
import com.example.lab2.model.WeatherViewModel

class MainActivity : AppCompatActivity() {

    private val city = "Moscow"
    private lateinit var binding: ActivityMainBinding
    private val model by viewModels<WeatherViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setClickListeners()

        // слушаем ответ от сервера
        model.currentTemperature.observe(this) {
            binding.tvCurrentTmp.text = getString(R.string.current_temperature_is, it)
        }
    }

    // устанавливаем слушатели кликов
    private fun setClickListeners() {
        binding.btnCurrentTmp.setOnClickListener {
            model.getLocalTemperature(city)
        }

        binding.btnCitiesWeather.setOnClickListener {
            startActivity(Intent(this, WeatherListActivity::class.java))
        }
    }
}