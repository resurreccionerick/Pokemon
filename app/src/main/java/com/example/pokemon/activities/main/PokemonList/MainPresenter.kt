package com.example.pokemon.activities.main.PokemonList

import android.util.Log
import com.example.pokemon.model.list.PokemonList
import com.example.pokemon.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(private val view: MainContract.View) : MainContract.Presenter {
    override fun loadPokemonList() {
        RetrofitInstance.api.getPokemonList().enqueue(
            object : Callback<PokemonList> {
                override fun onResponse(call: Call<PokemonList>, response: Response<PokemonList>) {
                    if (response.isSuccessful) {
                        val pokemonList = response.body()
                        if (pokemonList != null) {
                            view.showList(pokemonList.results)
                        } else {
                            Log.d("erick", "Response body is null")
                        }
                    } else {
                        Log.d("erick", "Response not successful: ${response.code()}")
                    }
                }


                override fun onFailure(call: Call<PokemonList>, t: Throwable) {
                    Log.d("erick", t.message.toString())
                }
            }
        )
    }
}
