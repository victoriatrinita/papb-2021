package com.android.kuesionerku.Model


import com.google.gson.annotations.SerializedName

data class Kuesioner(
    @SerializedName("akses")
    val akses: String,
    @SerializedName("judul")
    val judul: String,
    @SerializedName("kategori")
    val kategori: String,
    @SerializedName("pengisi")
    val pengisi: String,
    @SerializedName("saldo")
    val saldo: String,
    @SerializedName("tanggal")
    val tanggal: String
)