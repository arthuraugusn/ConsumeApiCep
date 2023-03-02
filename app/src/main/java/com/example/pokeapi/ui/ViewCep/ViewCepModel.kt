package com.example.pokeapi.ui.ViewCep

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.pokeapi.service.RetrofitFactory
import com.example.pokeapi.service.model.CepModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun ViewCepModel(cep:String){

    var testeState by remember {
        mutableStateOf("Resultado")
    }
    
    Column(modifier = Modifier.fillMaxSize()) {
        Button(onClick = {

            val call = RetrofitFactory().getApi().getCep(cep)

            call.enqueue(object : Callback<CepModel>{
                override fun onResponse(call: Call<CepModel>, response: Response<CepModel>) {
                    if(response.body()==null){
                            testeState = "Cep Não encontrado"
                    }
                    else testeState = response.body()!!.cidade
                }

                override fun onFailure(call: Call<CepModel>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })

        }) {

        }
        
        Text(text = testeState)
    }



}
