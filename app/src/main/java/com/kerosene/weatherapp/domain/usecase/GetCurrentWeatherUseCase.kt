package com.kerosene.weatherapp.domain.usecase

import com.kerosene.weatherapp.domain.repository.WeatherRepository
import javax.inject.Inject

class GetCurrentWeatherUseCase @Inject constructor(
    private val repository: WeatherRepository,
) {

    suspend operator fun invoke(cityId: Int) = repository.getWeather(cityId)
}