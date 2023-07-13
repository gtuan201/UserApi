package com.example.userapi.api

import com.example.userapi.model.Results
import com.example.userapi.model.User
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    companion object {
        private val gson: Gson = GsonBuilder().create()
        val apiService: ApiService = Retrofit.Builder()
            .baseUrl("https://randomuser.me/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService::class.java)
    }
    @GET("api")
    fun getUser(@Query("results") results: Int): Call<Results>
}