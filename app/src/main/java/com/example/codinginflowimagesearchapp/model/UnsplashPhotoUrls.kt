package com.example.codinginflowimagesearchapp.model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//@Parcelize
data class UnsplashPhotoUrls(
    val full: String?,
    val raw: String?,
    val regular: String?,
    val small: String?,
    val thumb: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(full)
        parcel.writeString(raw)
        parcel.writeString(regular)
        parcel.writeString(small)
        parcel.writeString(thumb)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UnsplashPhotoUrls> {
        override fun createFromParcel(parcel: Parcel): UnsplashPhotoUrls {
            return UnsplashPhotoUrls(parcel)
        }

        override fun newArray(size: Int): Array<UnsplashPhotoUrls?> {
            return arrayOfNulls(size)
        }
    }

}