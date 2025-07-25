package com.kerosene.weatherapp.data.network.api

import com.kerosene.weatherapp.data.network.dto.CityDto
import retrofit2.http.Query
import com.kerosene.weatherapp.data.network.dto.WeatherCurrentDto
import com.kerosene.weatherapp.data.network.dto.WeatherForecastDto
import retrofit2.http.GET

interface ApiService {

    @GET("current.json")
    suspend fun loadCurrentWeather(
        @Query("q") query: String
    ): WeatherCurrentDto

    @GET("forecast.json")
    suspend fun loadForecast(
        @Query("q") query: String,
        @Query("days") daysCount: Int = 4
    ): WeatherForecastDto

    @GET("search.json")
    suspend fun searchCity(
        @Query("q") query: String
    ): List<CityDto>
}