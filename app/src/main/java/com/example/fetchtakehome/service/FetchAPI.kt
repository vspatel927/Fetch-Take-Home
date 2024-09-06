package com.example.fetchtakehome.service

import com.example.fetchtakehome.model.Item
import retrofit2.Response
import retrofit2.http.GET

//Calling API endpoint
interface FetchAPI {
    @GET("hiring.json")
    suspend fun getItems(): Response<List<Item>>
}