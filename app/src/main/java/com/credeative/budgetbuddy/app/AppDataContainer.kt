package com.credeative.budgetbuddy.app

import android.content.Context
import com.credeative.budgetbuddy.dependency.db.IncomeDatabase
import com.credeative.budgetbuddy.dependency.db.repository.OfflineRepositoryController
import com.credeative.budgetbuddy.dependency.db.repository.RoomRepository
import com.credeative.budgetbuddy.dependency.http.RESTApiController
import com.credeative.budgetbuddy.dependency.http.RESTApiEndpoint
import com.credeative.budgetbuddy.dependency.http.repository.RESTApiRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class AppDataContainer(private val context: Context):AppContainer {
    companion object{
        private val RESTApiClient = OkHttpClient().newBuilder().addInterceptor(
            HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY})
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()

        private val RetrofitClient = Retrofit.Builder()
            .baseUrl("https://api.imgflip.com/")
            .client(RESTApiClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    override val incomeRepository: RoomRepository by lazy {
        OfflineRepositoryController(IncomeDatabase.getDatabase(context).itemDao())
    }
    override val restApiRepository: RESTApiRepository by lazy {
        RESTApiController(RetrofitClient.create(RESTApiEndpoint::class.java))
    }
}