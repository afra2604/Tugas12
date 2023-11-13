package com.example.tugas12.Retrofit

import com.example.tugas12.model.Pengungsi
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("restrooms")
    fun getAllPengungsi() : Call<Pengungsi>
}