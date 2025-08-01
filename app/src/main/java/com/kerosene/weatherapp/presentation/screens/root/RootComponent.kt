package com.kerosene.weatherapp.presentation.screens.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.kerosene.weatherapp.presentation.screens.details.DetailsComponent
import com.kerosene.weatherapp.presentation.screens.favourite.FavouriteComponent
import com.kerosene.weatherapp.presentation.screens.search.SearchComponent

interface RootComponent {

    val stack: Value<ChildStack<*, Child>>

    sealed interface Child {

        data class Favourite(val component: FavouriteComponent) : Child

        data class Search(val component: SearchComponent) : Child

        data class Details(val component: DetailsComponent) : Child
    }
}