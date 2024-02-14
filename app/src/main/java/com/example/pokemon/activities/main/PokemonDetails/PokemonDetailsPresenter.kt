package com.example.pokemon.activities.main.PokemonDetails

import android.util.Log
import com.example.pokemon.model.details.PokemonDetails
import com.example.pokemon.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonDetailsPresenter(private val view: PokemonDetailsActivity) :
    PokemonDetailsContract.Presenter {
    override fun getDetails(id: String) {
        RetrofitInstance.api.getPokemonDetails(id).enqueue(
            object : Callback<PokemonDetails> {
                override fun onResponse(
                    call: Call<PokemonDetails>,
                    response: Response<PokemonDetails>
                ) {
                    if (response.isSuccessful) {
                        val pokemon = response.body()
                        if (pokemon != null) {
                            view.showDetails(pokemon) // Pass single PokemonDetails object
                        } else {
                            Log.d("pokemon details", "Response body is null")
                        }
                    } else {
                        Log.d("pokemon details", "Response not successful: ${response.code()}")
                    }
                }

                override fun onFailure(call: Call<PokemonDetails>, t: Throwable) {
                    //Toast.makeText(this@HomeFragment, t.message.toString(), Toast.LENGTH_SHORT).show()
                    Log.d("pokemon details", t.message.toString())
                }
            }
        )
    }
}