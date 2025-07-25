package com.kerosene.weatherapp.domain.repository

import com.kerosene.weatherapp.domain.entity.Forecast
import com.kerosene.weatherapp.domain.entity.Weather

interface WeatherRepository {

    suspend fun getWeather(cityId: Int): Weather

    suspend fun getForecast(cityId: Int): Forecast
}