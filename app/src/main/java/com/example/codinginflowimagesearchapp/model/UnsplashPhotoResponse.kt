package com.example.codinginflowimagesearchapp.model

data class UnsplashPhotoResponse(
    val results: List<UnsplashPhotoResult>,
    val total: Int,
    val total_pages: Int
)