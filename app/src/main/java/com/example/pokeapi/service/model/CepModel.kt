package com.example.pokeapi.service.model

import com.google.gson.annotations.SerializedName

data class CepModel(
    val bairro: String,
    val cep: String,
    val complemento: String,
    @SerializedName("localidade")val cidade: String,
    val logradouro: String,
    val uf: String
)