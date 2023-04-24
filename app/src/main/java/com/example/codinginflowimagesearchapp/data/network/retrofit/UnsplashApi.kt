package com.example.codinginflowimagesearchapp.data.network.retrofit

import android.provider.ContactsContract.Contacts
import com.example.codinginflowimagesearchapp.model.UnsplashPhotoResponse
import com.example.codinginflowimagesearchapp.utils.Constants.CLIENT_ID
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface UnsplashApi {
    @Headers("Accept-Version: v1", "Authorization: Client-ID $CLIENT_ID")
    @GET("/search/photos")
    suspend fun searchPhotos(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
    ): Response<UnsplashPhotoResponse>
}