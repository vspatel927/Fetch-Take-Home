package com.example.fetchtakehome.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Using Retrofit Builder
object FetchAPIService {

    var base_url = "https://fetch-hiring.s3.amazonaws.com/"

    val fetchApi: FetchAPI by lazy{
        Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FetchAPI::class.java)
    }
}