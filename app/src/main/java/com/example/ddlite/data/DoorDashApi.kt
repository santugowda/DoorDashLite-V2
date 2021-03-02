package com.example.ddlite.data

import com.example.ddlite.utils.DoorDashConstants.RESTAURANT_ENDPOINT
import com.example.ddlite.data.model.Restaurant
import com.example.ddlite.data.model.RestaurantDetails
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DoorDashApi {

    @GET(RESTAURANT_ENDPOINT)
    suspend fun fetchAllRestaurants(
        @Query("lat") lat: Double,
        @Query("lng") lng: Double
    ): Response<List<Restaurant>>

    @GET("$RESTAURANT_ENDPOINT{id}/")
    suspend fun fetchRestaurant(
        @Path("id") restaurantId: Int)
            : Response<RestaurantDetails>
}