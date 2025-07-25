package com.kerosene.weatherapp.data.mapper

import com.kerosene.weatherapp.data.network.dto.CityDto
import com.kerosene.weatherapp.domain.entity.City

fun CityDto.toEntity(): City = City(id, name, country)

fun List<CityDto>.toEntities(): List<City> = map { it.toEntity() }