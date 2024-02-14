package com.example.pokemon.model.details

import com.google.gson.annotations.SerializedName

data class PokemonDetails(
    val name: String,
    val weight: Int,
    val height: Int,
    val types: List<TypeItem>,
    val sprites: Sprite
)

data class TypeItem(val type: Type)

data class Type(val name: String, val url: String)

data class Sprite(
    @SerializedName("front_default")
    val frontDefault: String
)