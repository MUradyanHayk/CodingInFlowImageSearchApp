package com.example.codinginflowimagesearchapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.codinginflowimagesearchapp.data.network.retrofit.UnsplashApi
import com.example.codinginflowimagesearchapp.data.paging.UnsplashPagingSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UnsplashRepository @Inject constructor(private val unsplashApi: UnsplashApi) {

    fun getSearchResults(query: String) = Pager(
        config = PagingConfig(pageSize = 20, maxSize = 100, enablePlaceholders = false),
        pagingSourceFactory = { UnsplashPagingSource(unsplashApi, query) }
    ).liveData
}