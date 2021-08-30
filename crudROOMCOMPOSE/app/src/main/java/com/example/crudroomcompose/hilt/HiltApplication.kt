package com.example.crudroomcompose.hilt

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.crudroomcompose.data.database.AppDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@HiltAndroidApp
class HiltApplication: Application()

@Module
@InstallIn(SingletonComponent::class)
object DbModule{

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AppDB {

        return Room.databaseBuilder(
            appContext,
            AppDB::class.java,
            "meuBanco.db")
            .fallbackToDestructiveMigration().build()
    }

    @Provides
    fun CidadesRepository(db: AppDB) = db.CidadeDAO()
}