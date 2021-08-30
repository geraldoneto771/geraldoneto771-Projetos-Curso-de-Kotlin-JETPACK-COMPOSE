package com.example.crudroomcompose.tela

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
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
class TelaDetalhesViewModel @Inject constructor(private val dao: CidadesRepository): ViewModel(){

    var id by mutableStateOf(0)

    private var _nomeCidade = MutableLiveData<String>()
    val nomeCidade: LiveData<String> = _nomeCidade

    private var _cepCidade = MutableLiveData<String>()
    val cepCidade: LiveData<String> = _cepCidade

    private var _ufCidade = MutableLiveData<String>()
    val ufCidade: LiveData<String> = _ufCidade


    fun onChangeNomeCidade(newValue: String){

        _nomeCidade.value = newValue
    }
    fun onChangeCepCidade(newValue: String){

        _cepCidade.value = newValue
    }
    fun onChangeUfCidade(newValue: String){

        _ufCidade.value = newValue
    }

    val status: MutableLiveData<Boolean> = MutableLiveData()


    fun Alterar(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                dao.updateCidade(Cidades(
                    nome_cidade = nomeCidade.value,
                    cep_cidade = cepCidade.value,
                    uf_cidade = ufCidade.value,
                    id = id
                    ))
                status.postValue(true)
            }
        }
    }
    fun Remover(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                dao.deleteCidade(Cidades(
                    nome_cidade = nomeCidade.value,
                    cep_cidade = cepCidade.value,
                    uf_cidade = ufCidade.value,
                    id = id
                ))
                status.postValue(true)
            }
        }
    }

}