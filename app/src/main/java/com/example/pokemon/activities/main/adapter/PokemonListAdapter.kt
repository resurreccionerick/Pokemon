package com.example.pokemon.activities.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.pokemon.model.list.Result
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemon.databinding.PokemonItemBinding


class PokemonListAdapter() : RecyclerView.Adapter<PokemonListAdapter.PokemonListViewHolder>() {

    lateinit var onItemClick: ((Result) -> Unit)

    private var pokemonList = ArrayList<Result>()

    fun setData(pokemonList: List<Result>) {
        this.pokemonList = pokemonList as ArrayList<Result>
        notifyDataSetChanged()
    }

    class PokemonListViewHolder(val binding: PokemonItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonListViewHolder {
        return PokemonListViewHolder(
            PokemonItemBinding.inflate(
                LayoutInflater.from(
                    parent.context,
                )
            )
        )
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    override fun onBindViewHolder(holder: PokemonListViewHolder, position: Int) {
        val item = pokemonList[position]

        holder.binding.tvPokemonName.text = item.name

        holder.itemView.setOnClickListener {
            onItemClick.invoke(item)
        }
    }
}