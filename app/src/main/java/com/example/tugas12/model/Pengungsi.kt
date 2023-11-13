package com.example.tugas12.model

import com.google.gson.annotations.SerializedName

data class Pengungsi(
    @SerializedName("data")
    var data: List<Data>
)
