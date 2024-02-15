package com.example.weathermap.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weathermap.R
import com.example.weathermap.data.remote.WeatherApiService
import com.example.weathermap.data.repository.WeatherRepository
import com.example.weathermap.ui.adapters.DailyForecastAdapter
import com.example.weathermap.ui.viewmodels.WeatherViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: WeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val apiService = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApiService::class.java)

        val repository = WeatherRepository(apiService)
        //viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(WeatherViewModel::class.java)
        // Pass repository to WeatherViewModel constructor
        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(WeatherViewModel::class.java)

        // Make API call and update UI accordingly
        viewModel.getWeatherForecast(0.0, 0.0)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ forecast ->

                // Update UI with forecast data
                val recyclerView: RecyclerView = findViewById(R.id.weeklyForecastRecyclerView)
                val adapter = DailyForecastAdapter(forecast)
                recyclerView.layoutManager = LinearLayoutManager(this)
                recyclerView.adapter = adapter

            }, { error ->
                Toast.makeText(this, "Failed to fetch weather data. Please try again later.", Toast.LENGTH_SHORT).show()

            })
    }
}
