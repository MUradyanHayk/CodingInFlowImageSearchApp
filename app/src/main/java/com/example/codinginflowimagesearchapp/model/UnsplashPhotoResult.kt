package com.example.codinginflowimagesearchapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UnsplashPhotoResult(
    val blur_hash: String,
    val color: String,
    val created_at: String,
    val description: String,
    val height: Int,
    val id: String,
    val liked_by_user: Boolean,
    val likes: Int,
    val links: Links,
    val urls: UnsplashPhotoUrls,
    val user: UnsplashUser,
    val width: Int
) : Parcelable {

}