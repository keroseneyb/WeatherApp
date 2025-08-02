package com.kerosene.weatherapp.presentation.screens.root

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.jetpack.stack.Children
import com.kerosene.weatherapp.presentation.screens.details.DetailsContent
import com.kerosene.weatherapp.presentation.screens.favourite.FavouriteContent
import com.kerosene.weatherapp.presentation.screens.search.SearchContent
import com.kerosene.weatherapp.presentation.ui.theme.WeatherAppTheme

@Composable
fun RootContent(component: RootComponent) {
    WeatherAppTheme {
        Children(
            stack = component.stack
        ) {
            when (val instance = it.instance) {
                is RootComponent.Child.Details -> {
                    DetailsContent(component = instance.component)
                }

                is RootComponent.Child.Favourite -> {
                    FavouriteContent(component = instance.component)
                }

                is RootComponent.Child.Search -> {
                    SearchContent(component = instance.component)
                }
            }
        }
    }
}