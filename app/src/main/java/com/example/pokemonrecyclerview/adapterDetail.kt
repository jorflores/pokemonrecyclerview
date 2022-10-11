package com.example.pokemonrecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokemonrecyclerview.databinding.ItemPokemonBinding

class adapterDetail (var data: List<Pokemon>, private val funcionX: (Pokemon) -> Unit) : RecyclerView.Adapter<adapterDetail.ViewHolder> ()  {

    lateinit var context: Context


    class ViewHolder (val binding: ItemPokemonBinding, funcionZ: (Int) -> Unit) : RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                funcionZ(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemPokemonBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        context = parent.context;
        return ViewHolder(view) {
            funcionX(data[it])
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.apply {
            textViewId.text = data[position].id
            textViewNombre.text = data[position].nombre
        }


        Glide.with(context)
            .load(data[position].imagen_url)
            .into(holder.binding.imageView)

    }

    override fun getItemCount(): Int {
        return data.size
    }
}