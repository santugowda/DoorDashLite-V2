package com.example

import android.app.Application
import com.example.ddlite.modules.doordashApiClientModule
import com.example.ddlite.modules.doordashApiModule
import com.example.ddlite.modules.restaurantViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class Application : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@Application)
            modules(
                listOf(
                    doordashApiModule,
                    doordashApiClientModule,
                    restaurantViewModel

                )
            )
        }
    }

}