package com.kerosene.weatherapp.data.repository

import com.kerosene.weatherapp.data.mapper.toEntities
import com.kerosene.weatherapp.data.network.api.ApiService
import com.kerosene.weatherapp.domain.entity.City
import com.kerosene.weatherapp.domain.repository.SearchRepository
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
) : SearchRepository {

    override suspend fun search(query: String): List<City> {
        return apiService.searchCity(query).toEntities()
    }
}