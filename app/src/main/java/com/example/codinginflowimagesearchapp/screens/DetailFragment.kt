package com.example.codinginflowimagesearchapp.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.codinginflowimagesearchapp.R
import com.example.codinginflowimagesearchapp.databinding.FragmentDetailBinding
import com.example.codinginflowimagesearchapp.model.UnsplashPhotoResult

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private var currentPhoto: UnsplashPhotoResult? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        currentPhoto = arguments?.getParcelable("currentPhoto") as? UnsplashPhotoResult?
        val _currentPhoto = currentPhoto ?: return
        Glide.with(requireContext())
            .load(_currentPhoto.urls?.regular)
            .centerCrop()
            .into(binding.imageView)
    }
}