package com.kerosene.weatherapp.domain.usecase

import com.kerosene.weatherapp.domain.repository.FavouriteRepository
import javax.inject.Inject

class GetFavouriteCitiesUseCase @Inject constructor(
    private val repository: FavouriteRepository,
) {

    operator fun invoke() = repository.favouriteCities
}