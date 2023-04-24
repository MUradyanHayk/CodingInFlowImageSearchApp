package com.example.codinginflowimagesearchapp.viewModel

import androidx.lifecycle.ViewModel
import com.example.codinginflowimagesearchapp.data.repository.UnsplashRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor(private val repository: UnsplashRepository) : ViewModel() {
}