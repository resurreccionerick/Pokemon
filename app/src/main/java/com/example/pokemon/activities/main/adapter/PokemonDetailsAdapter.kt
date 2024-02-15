package com.example.pokemon.activities.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemon.databinding.PokemonTypeItemBinding
import com.example.pokemon.model.details.Type

class PokemonDetailsAdapter :
    RecyclerView.Adapter<PokemonDetailsAdapter.PokemonDetailsViewHolder>() {

    private var typeList = ArrayList<Type>()

    fun setData(typeList: List<Type>) {
        this.typeList.clear()
        this.typeList.addAll(typeList)
        notifyDataSetChanged()
    }

    class PokemonDetailsViewHolder(val binding: PokemonTypeItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PokemonDetailsViewHolder {
        val binding = PokemonTypeItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PokemonDetailsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return typeList.size
    }

    override fun onBindViewHolder(holder: PokemonDetailsViewHolder, position: Int) {
        val currentType = typeList[position]
        holder.binding.tvPokemonType.text = currentType.name
    }
}
