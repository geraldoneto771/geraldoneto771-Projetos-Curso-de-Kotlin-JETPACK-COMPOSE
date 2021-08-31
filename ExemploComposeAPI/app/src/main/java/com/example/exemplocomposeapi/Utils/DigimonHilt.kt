package com.example.exemplocomposeapi.Utils

import android.app.Application
import com.example.exemplocomposeapi.api.DigimonApi
import com.example.exemplocomposeapi.api.DigimonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@HiltAndroidApp
class DigimonHilt: Application() {
}

@Module
@InstallIn(SingletonComponent::class)
object AppModule{

    @Singleton
    @Provides
    fun provideDigimonResporitory(api: DigimonApi) = DigimonRepository(api)

    @Singleton
    @Provides
    fun provideDigimonApi(): DigimonApi{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://digimon-api.vercel.app/api/")
            .build()
            .create(DigimonApi::class.java)
    }

}