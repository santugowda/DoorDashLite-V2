package com.example.ddlite

import android.content.Context
import com.github.leonardoxh.livedatacalladapter.LiveDataCallAdapterFactory
import com.github.leonardoxh.livedatacalladapter.LiveDataResponseBodyConverterFactory
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import okhttp3.mockwebserver.MockWebServer
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

object UtilClass {

    @Throws(IOException::class)
    @JvmStatic
    fun getStringFromAssets(
        context: Context,
        fileName: String?
    ): String {
        val builder = StringBuilder()
        var inputStream: InputStream? = null
        try {
            inputStream = context.assets.open(fileName!!)
            val br =
                BufferedReader(InputStreamReader(inputStream))
            var line: String?
            while (br.readLine().also { line = it } != null) {
                builder.append(line).append("\n")
            }
        } finally {
            inputStream?.close()
        }
        return builder.toString()
    }

    fun getMockRetrofitInstance(server: MockWebServer): Retrofit {
        val gson = GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()
        return Retrofit.Builder()
            .baseUrl(server.url(""))
            .addCallAdapterFactory(LiveDataCallAdapterFactory.create())
            .addConverterFactory(LiveDataResponseBodyConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}