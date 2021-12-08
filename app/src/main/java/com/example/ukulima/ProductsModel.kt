package com.example.ukulima

import android.os.Parcel
import android.os.Parcelable

data class ProductsModel(
    val title: String?= null,
    val image: String?= null,
    val plant: String? = null,
    val place: String? = null,
    val diseases: String? = null,
    val prevention: String? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(image)
        parcel.writeString(plant)
        parcel.writeString(place)
        parcel.writeString(diseases)
        parcel.writeString(prevention)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ProductsModel> {
        override fun createFromParcel(parcel: Parcel): ProductsModel {
            return ProductsModel(parcel)
        }

        override fun newArray(size: Int): Array<ProductsModel?> {
            return arrayOfNulls(size)
        }
    }
}