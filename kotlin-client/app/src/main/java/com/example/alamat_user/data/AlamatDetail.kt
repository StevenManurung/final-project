package com.example.alamat_user.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AlamatDetail(
    var id : Int?,
    var nama : String?,
    var nohp : Int?,
    var provinsi : String?,
    var kota : String?,
    var kecamatan : String?,
    var kodepos: Int?,
    var namajalan: String?,
    var detailalamat: String?
) : Parcelable