package com.example.pokemon.activities.main.PokemonDetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.pokemon.R
import com.example.pokemon.activities.main.PokemonList.MainActivity
import com.example.pokemon.databinding.ActivityPokemonDetailsBinding
import com.example.pokemon.model.details.PokemonDetails

class PokemonDetailsActivity : AppCompatActivity(), PokemonDetailsContract.View {
    private lateinit var binding: ActivityPokemonDetailsBinding
    private lateinit var presenter: PokemonDetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityPokemonDetailsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        presenter = PokemonDetailsPresenter(this)

        // Get the intent
        val intent = intent

        // Extract the ID from the intent extras
        val id = intent.getStringExtra(MainActivity.POKEMON_ID)

        //progress bar
        binding.loadingIndicator.visibility = View.VISIBLE
        binding.pokemonLayout.visibility = View.INVISIBLE

        // Check if ID is not null before passing it to the presenter
        id?.let {
            presenter.getDetails(id)
            binding.loadingIndicator.visibility = View.INVISIBLE
            binding.pokemonLayout.visibility = View.VISIBLE
        } ?: run {
            // Handle the case where ID is null
            showMessage("Pokemon ID not found.")
            finish() // Finish the activity if ID is not found
        }
    }


    override fun showDetails(details: PokemonDetails) {
        if (details.sprites.frontDefault != null) {
            Glide.with(this)
                .load(details.sprites.frontDefault)
                .error(R.drawable.baseline_error_24)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(binding.pokemonImg)

            Log.d("erick img", details.sprites.frontDefault)
        } else {
            Log.d("erick img", "Front default URL is null")
        }

        binding.txtName.text = details.name

        binding.txtHeight.text = "Height:" + details.height.toString()

        binding.txtWeight.text = "Weight:" + details.weight.toString()
    }


    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}