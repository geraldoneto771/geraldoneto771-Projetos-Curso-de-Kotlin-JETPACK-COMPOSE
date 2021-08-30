package com.example.crudroomcompose.data.repositories

import com.example.crudroomcompose.data.database.AppDB
import com.example.crudroomcompose.data.entities.Cidades
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow

import javax.inject.Inject


@ViewModelScoped
class CidadesRepository @Inject constructor(appDB: AppDB){

    private val dao = appDB.CidadeDAO()

    val getAllCidades: Flow<List<Cidades>> = dao.getAllCidades()

    suspend fun addCidade(c: Cidades){
        dao.insert(c)
    }
    suspend fun updateCidade(c: Cidades){
        dao.update(c)
    }
    suspend fun deleteCidade(c: Cidades){
        dao.delete(c)
    }

}