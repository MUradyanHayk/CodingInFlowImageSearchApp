package com.example.codinginflowimagesearchapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Links(
    val download: String,
    val html: String,
    val self: String
) : Parcelable