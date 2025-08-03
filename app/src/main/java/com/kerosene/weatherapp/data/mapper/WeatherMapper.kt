package com.kerosene.weatherapp.data.mapper

import com.kerosene.weatherapp.data.network.dto.WeatherCurrentDto
import com.kerosene.weatherapp.data.network.dto.WeatherDto
import com.kerosene.weatherapp.data.network.dto.WeatherForecastDto
import com.kerosene.weatherapp.domain.entity.Forecast
import com.kerosene.weatherapp.domain.entity.Weather
import java.util.Calendar
import java.util.Date

private const val DROP_FIRST_DAY = 1
private const val MILLISECONDS_IN_SECONDS = 1000

fun WeatherCurrentDto.toEntity(): Weather = currentWeather.toEntity()

fun WeatherDto.toEntity(): Weather = Weather(
    tempC = tempC,
    conditionText = conditionDto.text,
    conditionUrl = conditionDto.iconUrl.correctImageUrl(),
    date = date.toCalendar()
)

fun WeatherForecastDto.toEntity() = Forecast(
    currentWeather = current.toEntity(),
    upcoming = forecastDto.forecastDay.drop(DROP_FIRST_DAY).map { dayDto ->
        val dayWeatherDto = dayDto.dayWeatherDto
        Weather(
            tempC = dayWeatherDto.avgTempC,
            conditionText = dayWeatherDto.conditionDto.text,
            conditionUrl = dayWeatherDto.conditionDto.iconUrl.correctImageUrl(),
            date = dayDto.date.toCalendar()
        )
    }
)

private fun Long.toCalendar() = Calendar.getInstance().apply {
    time = Date(this@toCalendar * MILLISECONDS_IN_SECONDS)
}

private fun String.correctImageUrl() = "https:$this".replace(
    oldValue = "64x64",
    newValue = "128x128"
)

