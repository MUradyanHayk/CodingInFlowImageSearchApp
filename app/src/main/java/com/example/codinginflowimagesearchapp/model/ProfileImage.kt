package com.example.codinginflowimagesearchapp.model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//@Parcelize
data class ProfileImage(
    val large: String?,
    val medium: String?,
    val small: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(large)
        parcel.writeString(medium)
        parcel.writeString(small)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ProfileImage> {
        override fun createFromParcel(parcel: Parcel): ProfileImage {
            return ProfileImage(parcel)
        }

        override fun newArray(size: Int): Array<ProfileImage?> {
            return arrayOfNulls(size)
        }
    }
}