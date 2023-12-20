package com.example.alamat_user.rest

import com.example.alamat_user.data.*
import retrofit2.Call
import retrofit2.http.*

interface API {
    @GET("read.php")
    fun getAlamatt():Call<ArrayList<AlamatItem>>

    @GET("detail.php")
    fun getAlamatDetail(
        @Query("id") id: String?
    ):Call<AlamatDetail>

    @FormUrlEncoded
    @POST("add.php")
    fun addAlamatDetail(
        @Field("nama") nama: String?,
        @Field("nohp") nohp: String,
        @Field("provinsi") provinsi: String?,
        @Field("kota") kota: String?,
        @Field("kecamatan") kecamatan: String?,
        @Field("kodepos") kodepos: String,
        @Field("namajalan") namajalan: String?,
        @Field("detailalamat") detailalamat: String?
    ): Call<Response>

    @FormUrlEncoded
    @POST("update.php")
    fun ubahAlamatDetail(
        @Field("id") id: String?,
        @Field("nama") nama: String?,
        @Field("nohp") nohp: String?,
        @Field("provinsi") provinsi: String?,
        @Field("kota") kota: String?,
        @Field("kecamatan") kecamatan: String?,
        @Field("kodepos") kodepos: String?,
        @Field("namajalan") namajalan: String?,
        @Field("detailalamat") detailalamat: String?
    ): Call<Response>

    @FormUrlEncoded
    @POST("delete.php")
    fun deleteAlamatDetail(
        @Field("id") id: String?
    ): Call<Response>
}