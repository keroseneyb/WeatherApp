package com.kerosene.weatherapp.domain.repository

import com.kerosene.weatherapp.domain.entity.City

interface SearchRepository {

    suspend fun search(query: String): List<City>
}