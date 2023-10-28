package com.credeative.budgetbuddy.dependency.http

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

object RESTApiObject {
    private const val BASE_HTTP_URL2="https://api.imgflip.com/"
//    level = if (com.example.coroutinesexample.BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE

    private val RESTApiClient = OkHttpClient().newBuilder().addInterceptor(
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY})
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    private val RetrofitClient = Retrofit.Builder()
        .baseUrl(BASE_HTTP_URL2)
        .client(RESTApiClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val restApiObject by lazy {
        RetrofitClient.create(RESTApiEndpoint::class.java)
    }
    fun getRetrofit():RESTApiEndpoint{
        return restApiObject
    }

}