package com.example.ddlite.data.remote

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.ddlite.CoroutineTestRule
import com.example.ddlite.data.DoorDashApi
import com.example.ddlite.data.model.Restaurant
import com.example.ddlite.data.model.RestaurantDetails
import com.example.ddlite.presentation.viewmodel.RestaurantViewModel
import com.example.ddlite.utils.DoorDashConstants.DEFAULT_LAT
import com.example.ddlite.utils.DoorDashConstants.DEFAULT_LNG
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.verify
import junit.framework.TestCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.BufferedReader
import java.io.File
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import javax.net.ssl.HttpsURLConnection

//todo add more coverage

@RunWith(JUnit4::class)
@ExperimentalCoroutinesApi
class DoorDashApiClientImplTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Rule
    @JvmField
    val coroutinesRule = CoroutineTestRule()

    @Mock
    lateinit var doorDashApiClient: DoorDashApiClient

    @Mock
    private lateinit var restaurantList: List<Restaurant>

    @Mock
    private lateinit var restaurant: Restaurant

    @Mock
    private lateinit var restaurantResponse: Response<List<Restaurant>>

    @Mock
    private lateinit var restaurantDetailsResponse : Response<RestaurantDetails>

    private var doorDashApi: DoorDashApi = mock()

    private val testDispatcher = TestCoroutineDispatcher()


    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        doorDashApiClient = DoorDashApiClientImpl(doorDashApi)
        Dispatchers.setMain(testDispatcher)
    }

    @After
    @Throws(IOException::class)
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    @Test
    fun getAllRestaurantsTest() {
        runBlockingTest(testDispatcher) {
            `when`(
                doorDashApi.fetchAllRestaurants(
                    DEFAULT_LAT,
                    DEFAULT_LNG
                )
            ).thenAnswer {restaurantList}
        }

        restaurantResponse = mockk()
        every { restaurantResponse.code() } returns HttpsURLConnection.HTTP_OK
        every { restaurantResponse.message() } returns ""
        every { restaurantResponse.errorBody() } returns null
    }

    @Test
    @Throws(IOException::class, InterruptedException::class)
    fun fetchRestaurantTest() {
        runBlockingTest(testDispatcher) {
            `when`(
                doorDashApi.fetchRestaurant(3)
            ).thenAnswer {restaurant}
        }

        restaurantDetailsResponse = mockk()
        every { restaurantDetailsResponse.code() } returns HttpsURLConnection.HTTP_OK
        every { restaurantDetailsResponse.message() } returns ""
        every { restaurantDetailsResponse.errorBody() } returns null
    }

    private inline fun <reified T> mock(): T = Mockito.mock(T::class.java)
}
