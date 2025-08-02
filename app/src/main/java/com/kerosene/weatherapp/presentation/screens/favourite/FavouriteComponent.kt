package com.kerosene.weatherapp.presentation.screens.favourite

import com.kerosene.weatherapp.domain.entity.City
import kotlinx.coroutines.flow.StateFlow

interface FavouriteComponent {

    val model: StateFlow<FavouriteStore.State>

    fun onClickSearch()

    fun onClickAddFavourite()

    fun obCityItemClick(city: City)
}