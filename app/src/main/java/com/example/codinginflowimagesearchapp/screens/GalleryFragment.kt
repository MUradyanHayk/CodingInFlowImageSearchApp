package com.example.codinginflowimagesearchapp.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.codinginflowimagesearchapp.R
import com.example.codinginflowimagesearchapp.adapter.UnsplashPhotoAdapter
import com.example.codinginflowimagesearchapp.adapter.UnsplashPhotoLoadStateAdapter
import com.example.codinginflowimagesearchapp.databinding.FragmentGalleryBinding
import com.example.codinginflowimagesearchapp.viewModel.GalleryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GalleryFragment : Fragment() {
    private lateinit var binding: FragmentGalleryBinding
    private val viewModel: GalleryViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentGalleryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = UnsplashPhotoAdapter()
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.adapter = adapter.withLoadStateHeaderAndFooter(
            header = UnsplashPhotoLoadStateAdapter { adapter.retry() },
            footer = UnsplashPhotoLoadStateAdapter { adapter.retry() }
        )

        viewModel.photos.observe(viewLifecycleOwner) {
            adapter.submitData(viewLifecycleOwner.lifecycle, it)
        }
    }
}