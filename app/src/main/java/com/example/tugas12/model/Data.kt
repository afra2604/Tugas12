package com.example.tugas12.model

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("name")
    var nama: String,
    @SerializedName("street")
    var jalan: String,
    @SerializedName("city")
    var kota: String
)
