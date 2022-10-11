package com.example.pokemonrecyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.pokemonrecyclerview.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

arguments?.let {

    val pokemon = it.get("pokemon")as Pokemon

    binding.textViewNombrePlaceholder.text = pokemon.nombre
    binding.textViewAltura.text = pokemon.altura
    binding.textViewCategoria.text = pokemon.categoria
    binding.textViewHabilidad.text = pokemon.habilidad
    binding.textViewDescripcion.text = pokemon.descripcion


    Glide.with(this)
        .load(pokemon.imagen_url)
        .into(binding.imageView2)

}

    }
}