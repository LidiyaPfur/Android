package com.example.lab2.view.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab2.R
import com.example.lab2.databinding.CardViewWeaterItemBinding

class WeatherRvAdapter(
    private val list: List<Pair<String, String>>
) : RecyclerView.Adapter<WeatherRvAdapter.WeatherViewHolder>() {


    class WeatherViewHolder(val binding: CardViewWeaterItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val binding =
            CardViewWeaterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WeatherViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        list[position].let {
            with(holder.binding) {
                city.text = it.first
                temperature.text = root.context.getString(R.string.temperature_is, it.second)
            }
        }
    }

    override fun getItemCount() = list.size
}