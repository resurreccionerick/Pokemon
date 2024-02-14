package com.example.pokemon.retrofit

import com.example.pokemon.model.details.PokemonDetails
import com.example.pokemon.model.list.PokemonList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("pokemon")
    fun getPokemonList(): Call<PokemonList>

    @GET("pokemon/{id}")
    fun getPokemonDetails(@Path("id") id: String): Call<PokemonDetails>
}