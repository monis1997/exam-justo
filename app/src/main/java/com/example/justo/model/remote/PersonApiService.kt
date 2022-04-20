    package com.example.justo.model.remote

import com.example.justo.model.data.Person
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://randomuser.me/api/"


private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface PersonApiService{
    @GET(".")
    suspend fun getPerson(): Person
}

object PersonApi{
    val retrofitService: PersonApiService by lazy{
        retrofit.create(PersonApiService::class.java)
    }
}


