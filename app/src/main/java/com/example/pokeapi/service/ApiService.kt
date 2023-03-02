package com.example.pokeapi.service

import com.example.pokeapi.service.model.CepModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("{cepNumber}/json/")
    fun getCep(@Path("cepNumber")cepNumber: String): Call<CepModel>

}