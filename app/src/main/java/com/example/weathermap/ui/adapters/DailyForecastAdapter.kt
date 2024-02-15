package com.example.weathermap.ui.adapters
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weathermap.R
import com.example.weathermap.data.model.DailyWeather
import java.text.SimpleDateFormat
import java.util.*

class DailyForecastAdapter(private val dailyForecastList: List<DailyWeather>) : RecyclerView.Adapter<DailyForecastAdapter.ForecastViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_day_forecast, parent, false)
        return ForecastViewHolder(view)
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        val forecast = dailyForecastList[position]
        holder.bind(forecast)
    }

    override fun getItemCount(): Int {
        return dailyForecastList.size
    }

    inner class ForecastViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val dateTextView: TextView = itemView.findViewById(R.id.dateTextView)
        private val weatherIconImageView: ImageView = itemView.findViewById(R.id.weatherIconImageView)
        private val temperatureTextView: TextView = itemView.findViewById(R.id.temperatureTextView)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)

        fun bind(forecast: DailyWeather) {
            // Format and display the date
            val dateFormat = SimpleDateFormat("EEE, MMM d")
            val formattedDate = dateFormat.format(Date(forecast.timestamp * 1000))

            dateTextView.text = formattedDate
            temperatureTextView.text = itemView.context.getString(R.string.temperature, forecast.temperature.day.toString())
            descriptionTextView.text = forecast.weather[0].description

            // Load appropriate weather icon based on the weather condition (you need to implement this)
            // weatherIconImageView.setImageResource(getWeatherIconResourceId(forecast.weather[0].main))
        }
    }
}

