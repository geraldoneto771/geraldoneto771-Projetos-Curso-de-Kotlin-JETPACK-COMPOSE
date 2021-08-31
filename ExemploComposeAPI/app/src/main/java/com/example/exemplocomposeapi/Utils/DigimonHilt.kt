package com.example.exemplocomposeapi.Utils

import android.app.Application
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@HiltAndroidApp
class DigimonHilt: Application() {
}

@Module
@InstallIn(SingletonComponent::class)
object AppModule{

}