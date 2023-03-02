package com.example.pokeapi.service

import com.example.pokeapi.service.constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()

    fun getApi() : ApiService{
        return retrofit.create(ApiService::class.java)
    }
}