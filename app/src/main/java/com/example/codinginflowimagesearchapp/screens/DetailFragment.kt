package com.example.codinginflowimagesearchapp.screens

import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
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
            .error(R.drawable.ic_error)
            .listener(object :RequestListener<Drawable>{
                override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                    binding.progressBar.isVisible = false
                    return false
                }

                override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                    binding.progressBar.isVisible = false
                    binding.textViewCreator.isVisible = true
                    binding.textViewDescription.isVisible = _currentPhoto.description != null
                    return false
                }

            })
            .into(binding.imageView)

        binding.textViewDescription.text = _currentPhoto.description?:""
        binding.textViewCreator.text = "Photo by ${_currentPhoto.user?.name ?: ""} on Unsplash"


        val uri = Uri.parse(_currentPhoto.user?.attributionUrl)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        binding.textViewCreator.paint.isUnderlineText = true
        binding.textViewCreator.setOnClickListener {
            context?.startActivity(intent)
        }
    }
}