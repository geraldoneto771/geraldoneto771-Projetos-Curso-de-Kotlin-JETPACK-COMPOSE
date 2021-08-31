package com.example.exemplocomposeapi.Response


import com.google.gson.annotations.SerializedName

data class DigimonListItem(
    @SerializedName("img")
    val img: String,
    @SerializedName("level")
    val level: String,
    @SerializedName("name")
    val name: String
)