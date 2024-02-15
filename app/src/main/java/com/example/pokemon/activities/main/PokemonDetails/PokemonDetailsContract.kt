package com.example.pokemon.activities.main.PokemonDetails

import com.example.pokemon.model.details.PokemonDetails

interface PokemonDetailsContract {
    interface View {
        fun showDetails(details: PokemonDetails)
        fun showMessage(msg: String)
        fun setUpRecyclerView()
    }

    interface Presenter {
        fun getDetails(id: String)
    }
}
