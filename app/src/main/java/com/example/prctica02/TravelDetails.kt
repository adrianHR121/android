package com.example.prctica02

import android.os.Parcel
import android.os.Parcelable

data class TravelDetails(
    val destination: String,
    val hotelName: String,
    val location: String,
    val cost: Double,
    val transportOptions: String,
    val companions: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readDouble(),
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(destination)
        parcel.writeString(hotelName)
        parcel.writeString(location)
        parcel.writeDouble(cost)
        parcel.writeString(transportOptions)
        parcel.writeString(companions)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TravelDetails> {
        override fun createFromParcel(parcel: Parcel): TravelDetails {
            return TravelDetails(parcel)
        }

        override fun newArray(size: Int): Array<TravelDetails?> {
            return arrayOfNulls(size)
        }
    }
}
