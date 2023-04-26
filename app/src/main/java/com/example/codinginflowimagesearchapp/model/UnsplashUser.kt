package com.example.codinginflowimagesearchapp.model

import android.os.Parcel
import android.os.Parcelable

//@Parcelize
data class UnsplashUser(
    val first_name: String?,
    val id: String?,
    val instagram_username: String?,
    val last_name: String?,
    val name: String?,
    val portfolio_url: String?,
    val profile_image: ProfileImage?,
    val twitter_username: String?,
    val username: String?
) : Parcelable {
    val attributionUrl get() = "https://unsplash.com/$username?utm_source=ImageSearchApp&utm_medium=referral"

    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readParcelable(ProfileImage::class.java.classLoader),
        parcel.readString().toString(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(first_name)
        parcel.writeString(id)
        parcel.writeString(instagram_username)
        parcel.writeString(last_name)
        parcel.writeString(name)
        parcel.writeString(portfolio_url)
        parcel.writeParcelable(profile_image, flags)
        parcel.writeString(twitter_username)
        parcel.writeString(username)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UnsplashUser> {
        override fun createFromParcel(parcel: Parcel): UnsplashUser {
            return UnsplashUser(parcel)
        }

        override fun newArray(size: Int): Array<UnsplashUser?> {
            return arrayOfNulls(size)
        }
    }
}