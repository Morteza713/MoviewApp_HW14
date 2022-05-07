package com.example.moviewapp_hw14.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.moviewapp_hw14.R
import com.example.moviewapp_hw14.data.model.User
import com.example.moviewapp_hw14.databinding.HomeFragmentBinding

class HomeFragment:Fragment(R.layout.home_fragment),FilmClick {

    lateinit var binding: HomeFragmentBinding
    private val homeViewModel : HomeViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = HomeFragmentBinding.bind(view)

        binding.rvHome.adapter = HomeAdapter(homeViewModel.listFilm, this)

    }
    override fun click(position: Int) {
        if (User.isSign) {
            homeViewModel.likePosition(position)
            binding.rvHome.adapter?.notifyItemChanged(position)
        }
    }
}