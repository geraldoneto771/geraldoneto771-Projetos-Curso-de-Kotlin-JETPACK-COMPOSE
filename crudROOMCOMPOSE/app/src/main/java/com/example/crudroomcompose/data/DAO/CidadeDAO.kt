package com.example.crudroomcompose.data.DAO

import androidx.room.*
import com.example.crudroomcompose.data.entities.Cidades
import kotlinx.coroutines.flow.Flow


@Dao
interface CidadeDAO {

    @Insert
    suspend fun insert(cidade: Cidades)

    @Update
    suspend fun update(cidades: Cidades)

    @Delete
    suspend fun delete(cidades: Cidades)

    @Query("SELECT * FROM cidades")
    fun getAllCidades(): Flow<List<Cidades>>
}