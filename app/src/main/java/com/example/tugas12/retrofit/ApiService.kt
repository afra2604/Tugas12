package com.example.tugas12.retrofit

import com.example.tugas12.model.Data
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("restrooms")
    fun getAllPengungsi() : Call<ArrayList<Data>>
}