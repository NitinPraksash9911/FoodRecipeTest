package com.example.androidstudyjam.ui.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.androidstudyjam.R.layout
import com.example.androidstudyjam.databinding.FragmentHomeBinding
import com.example.androidstudyjam.viewmodel.RecipeViewModel

class HomeFragment : Fragment(layout.fragment_home) {

    val recipeViewModel: RecipeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentHomeBinding.bind(view)

//        recipeViewModel.searchFood("banana")
//
//        recipeViewModel.foodRecipeLiveData.observe(viewLifecycleOwner) {
//
//            Glide.with(this).load(it.searchResults[0].results[0].image).into(binding.im)
//        }

        binding.searchBtn.setOnClickListener {

            val searchtext = binding.searchEt.text.toString()

            if (searchtext.isEmpty()) {
                Toast.makeText(requireContext(), "Please enter food name", Toast.LENGTH_LONG).show()
            } else {
                val action = HomeFragmentDirections.actionHomeFragment2ToRecipeDetailFragment(searchtext)
                findNavController().navigate(action)
            }

        }

    }
}