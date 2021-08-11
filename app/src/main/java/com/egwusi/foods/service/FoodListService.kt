package com.egwusi.foods.service

import android.util.Log
import com.egwusi.foods.model.Food
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.Collections.emptyList
import com.egwusi.foods.BuildConfig


private const val TAG = "FoodListService" //retrofit

/**
 * Get all Food
 */
fun requestFoods(
    service: FoodListService,
    onSuccess: (skiResorts: List<Food>) -> Unit,
    onError: (error: String) -> Unit) {

    service.getFoods().enqueue(
        object : Callback<List<Food>> {
            override fun onFailure(call: Call<List<Food>>?, t: Throwable) {
                Log.e(TAG, "fail to get data", t)
                onError(t.message ?: "unknown error")
            }

            override fun onResponse(
                call: Call<List<Food>>?,
                response: Response<List<Food>>
            ) {
                Log.d(TAG, "got a response $response")
                if (response.isSuccessful) {
                    val skiResorts = response.body() ?: emptyList()
                    onSuccess(skiResorts)
                } else {
                    onError(response.errorBody()?.string() ?: "Unknown error")
                }
            }
        }
    )
}

interface FoodListService{

    /**
     * Get ski resort list.
     */
    @GET("/meals")
    fun getFoods(): Call<List<Food>>

    companion object {
        private const val BASE_URL = "http://192.168.122.1:8001" //"http://localhost:8001"

        fun create(): FoodListService {
            val logger = HttpLoggingInterceptor()
            logger.level = if(BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BASIC else HttpLoggingInterceptor.Level.NONE

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(FoodListService::class.java)
        }
    }
}