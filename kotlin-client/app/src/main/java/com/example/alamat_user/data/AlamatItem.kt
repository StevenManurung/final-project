package com.example.alamat_user.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AlamatItem(
    val id : Int?,
    val nama : String?,
    val nohp : Int?
) : Parcelable