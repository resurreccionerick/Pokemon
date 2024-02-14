package com.example.pokemon.activities.main.PokemonList

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pokemon.activities.main.PokemonDetails.PokemonDetailsActivity
import com.example.pokemon.activities.main.adapter.PokemonListAdapter
import com.example.pokemon.databinding.ActivityMainBinding
import com.example.pokemon.model.list.Result

class MainActivity : AppCompatActivity(), MainContract.View {

    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: MainPresenter
    private lateinit var pokemonAdapter: PokemonListAdapter

    companion object {
        const val POKEMON_ID = "pokemonID"
        const val POKEMON_NAME = "pokemonName"
        const val POKEMON_PIC = "pokemonPic"
        const val POKEMON_WEIGHT = "pokemonWeight"
        const val POKEMON_HEIGHT = "pokemonHeight"
        const val POKEMON_TYPE = "pokemonType"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        pokemonAdapter = PokemonListAdapter()

        presenter = MainPresenter(this)

        presenter.loadPokemonList()

        setUpRecyclerView()
        onPokemonClicked()

    }

    override fun showList(results: List<Result>) {
        pokemonAdapter.setData(results)
    }


    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }


    override fun setUpRecyclerView() {
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(
                this@MainActivity,
                1, GridLayoutManager.VERTICAL,
                false
            )

            adapter = pokemonAdapter
        }
    }

    override fun onPokemonClicked() {
        pokemonAdapter.onItemClick = { pokemon ->
            val intent = Intent(CategoryDetailsActivity@ this, PokemonDetailsActivity::class.java)
            intent.putExtra(POKEMON_ID, pokemon.name)
            startActivity(intent)
        }
    }
}