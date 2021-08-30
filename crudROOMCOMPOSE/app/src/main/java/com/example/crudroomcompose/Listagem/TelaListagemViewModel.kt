package com.example.crudroomcompose.Listagem

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.crudroomcompose.data.entities.Cidades
import com.example.crudroomcompose.data.repositories.CidadesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TelaListagemViewModel @Inject constructor(private val dao: CidadesRepository): ViewModel(){

    val cidadesList: LiveData<List<Cidades>> = dao.getAllCidades.asLiveData()
}