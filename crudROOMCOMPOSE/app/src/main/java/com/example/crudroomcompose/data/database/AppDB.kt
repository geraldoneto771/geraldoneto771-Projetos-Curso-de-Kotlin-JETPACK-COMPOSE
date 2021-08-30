package com.example.crudroomcompose.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.crudroomcompose.data.DAO.CidadeDAO
import com.example.crudroomcompose.data.entities.Cidades

@Database(entities = [Cidades::class], version = 1, exportSchema = false)
abstract class AppDB: RoomDatabase() {
    abstract fun CidadeDAO(): CidadeDAO
}