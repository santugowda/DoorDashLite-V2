package com.example.ddlite.modules

import com.example.ddlite.presentation.viewmodel.RestaurantViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val restaurantViewModel = module {
    viewModel { RestaurantViewModel(get()) }
}
