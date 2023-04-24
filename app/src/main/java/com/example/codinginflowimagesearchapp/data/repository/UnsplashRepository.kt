package com.example.codinginflowimagesearchapp.data.repository

import com.example.codinginflowimagesearchapp.data.network.retrofit.UnsplashApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UnsplashRepository @Inject constructor(private val unsplashApi: UnsplashApi) {
}