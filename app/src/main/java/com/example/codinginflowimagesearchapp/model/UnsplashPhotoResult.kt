package com.example.codinginflowimagesearchapp.model

import android.os.Parcel
import android.os.Parcelable

//@Parcelize
data class UnsplashPhotoResult(
    val blur_hash: String?,
    val color: String?,
    val created_at: String?,
    val description: String?,
    val height: Int,
    val id: String?,
    val liked_by_user: Boolean,
    val likes: Int,
    val links: Links?,
    val urls: UnsplashPhotoUrls?,
    val user: UnsplashUser?,
    val width: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readByte() != 0.toByte(),
        parcel.readInt(),
        parcel.readParcelable(Links::class.java.classLoader),
        parcel.readParcelable(UnsplashPhotoUrls::class.java.classLoader),
        parcel.readParcelable(UnsplashUser::class.java.classLoader),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
//        parcel.writeString(blur_hash)
//        parcel.writeString(color)
//        parcel.writeString(created_at)
//        parcel.writeString(description)
        parcel.writeInt(height)
        parcel.writeString(id)
        parcel.writeByte(if (liked_by_user) 1 else 0)
        parcel.writeInt(likes)
        parcel.writeParcelable(links, flags)
        parcel.writeParcelable(urls, flags)
        parcel.writeParcelable(user, flags)
        parcel.writeInt(width)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UnsplashPhotoResult> {
        override fun createFromParcel(parcel: Parcel): UnsplashPhotoResult {
            return UnsplashPhotoResult(parcel)
        }

        override fun newArray(size: Int): Array<UnsplashPhotoResult?> {
            return arrayOfNulls(size)
        }
    }

}