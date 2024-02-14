package com.example.pokemon.activities.main.PokemonList

import com.example.pokemon.model.list.Result

interface MainContract {

    interface View {
        fun showList(results: List<Result>)
        fun showMessage(msg: String)
        fun setUpRecyclerView()
        fun onPokemonClicked()
    }

    interface Presenter {
        fun loadPokemonList()
    }

}