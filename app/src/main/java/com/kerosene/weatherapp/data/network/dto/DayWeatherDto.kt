package com.kerosene.weatherapp.data.network.dto

import com.google.gson.annotations.SerializedName

data class DayWeatherDto(
    @SerializedName("avgtemp_c") val avgTempC: Float,
    @SerializedName("condition") val conditionDto: ConditionDto
)
