package com.example.exemplocomposeapi.api

import com.example.exemplocomposeapi.Response.DigimonList
import retrofit2.http.GET

interface DigimonApi {

    @GET("digimon")
    suspend fun getDigimonList(): DigimonList
}