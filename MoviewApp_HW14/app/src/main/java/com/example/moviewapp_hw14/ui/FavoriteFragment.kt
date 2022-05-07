package com.example.moviewapp_hw14.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.moviewapp_hw14.R
import com.example.moviewapp_hw14.databinding.FavoriteFragmentBinding

class FavoriteFragment:Fragment(R.layout.favorite_fragment) {

    lateinit var binding: FavoriteFragmentBinding
    private val favoriteViewModel : FavoriteViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FavoriteFragmentBinding.bind(view)

        binding.rvFavorite.adapter = FavoriteAdapter(favoriteViewModel.addFavorite())

    }
}