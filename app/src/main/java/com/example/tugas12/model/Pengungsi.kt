package com.example.tugas12.model

import com.google.gson.annotations.SerializedName

//untuk menampung data
data class Pengungsi(
    @SerializedName("data")
    var data: List<Data>
)
