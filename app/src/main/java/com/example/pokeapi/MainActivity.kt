package com.example.pokeapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.pokeapi.ui.ViewCep.ViewCepModel
import com.example.pokeapi.ui.theme.PokeApiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokeApiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting(){

    var cep by remember {
        mutableStateOf("")
    }
    var cepError by remember {
        mutableStateOf(false)
    }

    Column(modifier = Modifier.fillMaxSize()) {
        
        Text(text = "Digite um cep")
        
        OutlinedTextField(value = cep, onValueChange = {newCep->
            var lastChar =if(newCep.length == 0){
                cepError = true
                newCep
            }else{
                cepError = false
                newCep.get(newCep.length -1)
            }

            var finalId =if (lastChar == '.' || lastChar == '/' || lastChar == '?') newCep.dropLast(1) else newCep

            cep =finalId
        })
        ViewCepModel(cep = cep)
    }
}