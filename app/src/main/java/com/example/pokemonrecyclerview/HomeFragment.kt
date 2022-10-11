package com.example.pokemonrecyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonrecyclerview.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {


    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

      //  val adapter = adapter(pokeList)


        val adapter = adapterDetail(pokeList){
           val bundle = Bundle()
            bundle.putParcelable("pokemon",it)
            findNavController().navigate(R.id.action_homeFragment_to_detailFragment,bundle)

        }

         binding.rvpokemon.adapter =adapter
        binding.rvpokemon.layoutManager=   GridLayoutManager(requireActivity(),
            2, RecyclerView.VERTICAL, false)
    }
}