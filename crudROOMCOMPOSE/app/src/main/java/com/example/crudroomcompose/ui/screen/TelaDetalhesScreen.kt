package com.example.crudroomcompose.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.crudroomcompose.data.entities.Cidades
import com.example.crudroomcompose.tela.TelaDetalhesViewModel
import dagger.hilt.android.lifecycle.HiltViewModel


@Composable
fun TelaDetalhesScreen(
    navController: NavController,
    viewModel: TelaDetalhesViewModel = hiltViewModel(),
    cidades: Cidades
){

    val nome: String by viewModel.nomeCidade.observeAsState(cidades.nome_cidade.toString())
    val cep: String by viewModel.nomeCidade.observeAsState(cidades.cep_cidade.toString())
    val uf: String by viewModel.nomeCidade.observeAsState(cidades.uf_cidade.toString())

    viewModel.id = cidades.id!!.toInt()

    viewModel.onChangeCepCidade(nome)
    viewModel.onChangeCepCidade(cep)
    viewModel.onChangeUfCidade(uf)

    val status = viewModel.status.observeAsState()

    if(status.value == true){
        navController.popBackStack()
    }

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(label = { Text(text = "Informe o nome da cidade...") },value = nome, onValueChange = {
            viewModel.onChangeNomeCidade(it)
        })
        Spacer(modifier = Modifier.height(10.dp))
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(label = { Text(text = "Informe o CEP da cidade...") },value = cep, onValueChange = {
            viewModel.onChangeCepCidade(it)
        })
        Spacer(modifier = Modifier.height(10.dp))
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(label = { Text(text = "Informe a UF da cidade...") },value = uf, onValueChange = {
            viewModel.onChangeUfCidade(it)
        })
        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = {
            viewModel.Alterar()
        }){
            Text(text = "Alterar")
        }
        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = {
            viewModel.Remover()
        }){
            Text(text = "Remover")
        }

    }
}

