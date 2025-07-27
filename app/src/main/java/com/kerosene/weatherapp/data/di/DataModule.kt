package com.kerosene.weatherapp.data.di

import android.content.Context
import com.kerosene.weatherapp.data.local.db.FavouriteCitiesDao
import com.kerosene.weatherapp.data.local.db.FavouriteDatabase
import com.kerosene.weatherapp.data.network.api.ApiFactory
import com.kerosene.weatherapp.data.network.api.ApiService
import com.kerosene.weatherapp.data.repository.FavouriteRepositoryImpl
import com.kerosene.weatherapp.data.repository.SearchRepositoryImpl
import com.kerosene.weatherapp.data.repository.WeatherRepositoryImpl
import com.kerosene.weatherapp.domain.repository.FavouriteRepository
import com.kerosene.weatherapp.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindFavouriteRepository(impl: FavouriteRepositoryImpl): FavouriteRepository

    @ApplicationScope
    @Binds
    fun bindWeatherRepository(impl: WeatherRepositoryImpl): WeatherRepository

    @ApplicationScope
    @Binds
    fun bindSearchRepository(impl: SearchRepositoryImpl): FavouriteRepository

    companion object {

        @ApplicationScope
        @Provides
        fun provideService(): ApiService = ApiFactory.apiService

        @ApplicationScope
        @Provides
        fun provideFavouriteDatabase(context: Context): FavouriteDatabase {
            return FavouriteDatabase.getInstance(context)
        }

        @ApplicationScope
        @Provides
        fun provideFavouriteCitiesDao(database: FavouriteDatabase): FavouriteCitiesDao {
            return database.favouriteCitiesDao()
        }
    }
}