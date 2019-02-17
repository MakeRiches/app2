package com.apps.app2

import android.support.multidex.MultiDex
import android.support.multidex.MultiDexApplication
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppConfig: MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

        MultiDex.install(this)
        initRetrofit()
    }

    companion object {
        const val BASE_URL = "https://fortnite-public-api.theapinetwork.com"

        lateinit var endpoints: Endpoints

        fun initRetrofit() {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY

            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor {chain ->
                val original = chain.request()
                val request = original.newBuilder()
                request.addHeader("Accept", "application/json")
                val request1 = request.build()
                chain.proceed(request1)
            }
            httpClient.connectTimeout(60, java.util.concurrent.TimeUnit.SECONDS)
            httpClient.readTimeout(60, java.util.concurrent.TimeUnit.SECONDS)
            httpClient.addInterceptor(logging)

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build()

            endpoints = retrofit.create(Endpoints::class.java)
        }
    }

}
