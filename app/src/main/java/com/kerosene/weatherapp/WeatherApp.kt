package com.kerosene.weatherapp

import android.app.Application
import com.kerosene.weatherapp.data.di.ApplicationComponent
import com.kerosene.weatherapp.data.di.DaggerApplicationComponent

class WeatherApp : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }
}