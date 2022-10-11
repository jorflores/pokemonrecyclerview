package com.example.pokemonrecyclerview

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pokemon (
    val id: String,
    val nombre: String,
    val imagen_url : String,
    val descripcion : String,
    val altura: String,
    val categoria : String,
    val habilidad: String
    ) : Parcelable