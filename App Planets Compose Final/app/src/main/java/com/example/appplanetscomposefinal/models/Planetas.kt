package com.example.appplanetscomposefinal.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Planetas(
    val nome: String,
    val Descricao: String,
    val Imagem: Int): Parcelable
