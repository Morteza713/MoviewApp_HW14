package com.example.moviewapp_hw14.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkManager {

    private val client: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply{
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()


    val retrofit = Retrofit.Builder()
        .baseUrl("http://51.195.19.222")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
    val service = retrofit.create(ImageService::class.java)

}