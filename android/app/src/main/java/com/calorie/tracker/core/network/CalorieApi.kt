package com.calorie.tracker.core.network

import retrofit2.http.*
import okhttp3.MultipartBody
import retrofit2.Response

interface CalorieApi {
    
    @GET("api/v1/meals/daily")
    suspend fun getDailyMeals(@Query("date") date: String): Response<List<Any>> // Using Any for brevity in plan

    @POST("api/v1/meals")
    suspend fun addMeal(@Body request: Any): Response<Any>

    @Multipart
    @POST("api/v1/meals/analyze")
    suspend fun analyzeMealImage(@Part file: MultipartBody.Part): Response<List<Any>>
}
