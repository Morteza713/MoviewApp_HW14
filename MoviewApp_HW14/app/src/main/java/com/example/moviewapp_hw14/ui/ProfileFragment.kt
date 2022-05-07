package com.example.moviewapp_hw14.ui

import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.moviewapp_hw14.R
import com.example.moviewapp_hw14.databinding.ProfileFragmentBinding
import com.example.moviewapp_hw14.network.glide

class ProfileFragment:Fragment(R.layout.profile_fragment) {

    lateinit var binding: ProfileFragmentBinding
    private val viewModelProfile: ProfileViewModel by activityViewModels()
    private lateinit var bitmap: Bitmap


    private val takePicturePreview =
        registerForActivityResult(ActivityResultContracts.TakePicturePreview()) { Bitmap ->
            binding.getImageView.setImageBitmap(Bitmap)
            bitmap = Bitmap
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.profile_fragment,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModelProfile.register.observe(viewLifecycleOwner) { registered ->
            if (registered) {
                binding.showImage.glide(viewModelProfile.urlPic.toString())
                binding.getProfileLayout.visibility = View.GONE
                binding.showProfileLayout.visibility = View.VISIBLE
            }
        }

        binding.getImageView.setOnClickListener {
            takePicturePreview.launch(null)
        }

        binding.register.setOnClickListener {
            viewModelProfile.register(bitmap)
        }
    }
}