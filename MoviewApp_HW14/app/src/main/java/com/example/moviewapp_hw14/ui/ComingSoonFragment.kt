package com.example.moviewapp_hw14.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.moviewapp_hw14.R
import com.example.moviewapp_hw14.databinding.ComingsoonFragmentBinding

class ComingSoonFragment: Fragment(R.layout.comingsoon_fragment),Share {

    private val viewModelComingSoon : ComingSoonViewModel by activityViewModels()
    lateinit var binding : ComingsoonFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = ComingsoonFragmentBinding.bind(view)

        binding.rvComingSoon.adapter = ComingSoonAdapter(viewModelComingSoon.listComingSoon, this)

    }

    override fun movieShare(position: Int) {
        val intent = viewModelComingSoon.shareComingSoonMovie(position)
        startActivity(Intent.createChooser(intent, "Soon"))
    }
}