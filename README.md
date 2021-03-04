# DoorDashLitev2
A ‘lite’ version of DoorDash. Users will be able to view a list of restaurants in specified location and view details about the restaurant.

Home Screen: Parse https://api.doordash.com/v2/restaurant/?lat=37.422740&lng=-122.139956 and displays resulting list of restaurants. 

Results should display:
* Restaurants image along with it's name
* Description - type of food
* Delivery Cost
* Wait time

Item Details Screen: Selecting an item in list view will call https://api.doordash.com/v2/restaurant/[restaurantId]/ to display the restaurant's details view.

# Libraries used :

* Koin - Dependency Injection.
* Coroutines - For asynchronous calls
* LiveData - is a lifecycle-aware observer and is part of the Android Architecture components.
* Retrofit - REST client for Android.
* Gson - Library used for serializing/de-serializing JSON.
* Glide - An image loading and caching library for smooth scrolling.
* OkHttp MockWebServer - Used in testing Retrofit API
* Mockito - testing framework used for writing unit tests.
