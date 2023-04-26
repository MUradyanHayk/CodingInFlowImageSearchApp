package com.example.codinginflowimagesearchapp.model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//@Parcelize
data class Links(
    val download: String?,
    val html: String?,
    val self: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(download)
        parcel.writeString(html)
        parcel.writeString(self)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Links> {
        override fun createFromParcel(parcel: Parcel): Links {
            return Links(parcel)
        }

        override fun newArray(size: Int): Array<Links?> {
            return arrayOfNulls(size)
        }
    }

}