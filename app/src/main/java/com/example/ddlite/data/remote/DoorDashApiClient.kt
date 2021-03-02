package com.example.ddlite.data.remote
import com.example.ddlite.data.base.Resource
import com.example.ddlite.data.model.Restaurant
import com.example.ddlite.data.model.RestaurantDetails

interface DoorDashApiClient {

    suspend fun getAllRestaurants(latitude: Double, longitude: Double): Resource<List<Restaurant>>

    suspend fun getRestaurantInfo(restaurantId: Int): Resource<RestaurantDetails>

}