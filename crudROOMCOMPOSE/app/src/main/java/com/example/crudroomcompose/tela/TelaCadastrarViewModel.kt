package com.example.crudroomcompose.tela

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crudroomcompose.data.entities.Cidades
import com.example.crudroomcompose.data.repositories.CidadesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class TelaCadastrarViewModel @Inject constructor(private val dao: CidadesRepository): ViewModel() {
    val nomeCidade = mutableStateOf("")
    val cepCidade = mutableStateOf("")
    val ufCidade = mutableStateOf("")

    fun onChangeNomeCidade(newValue: String){

        nomeCidade.value = newValue
    }
    fun onChangeCepCidade(newValue: String){

        cepCidade.value = newValue
    }
    fun onChangeUfCidade(newValue: String){

        ufCidade.value = newValue
    }

    val status: MutableLiveData<Boolean> = MutableLiveData()

    fun Cadastrar(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                dao.addCidade(Cidades(nome_cidade = nomeCidade.value, cep_cidade = cepCidade.value, uf_cidade = ufCidade.value ))
                status.postValue(true)
            }
        }
    }
}