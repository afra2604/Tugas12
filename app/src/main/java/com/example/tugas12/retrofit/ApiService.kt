package com.example.tugas12.retrofit

import com.example.tugas12.model.Data
import retrofit2.Call
import retrofit2.http.GET

//untuk mengambil data end point
interface ApiService {
    @GET("restrooms")
    fun getAllPengungsi() : Call<ArrayList<Data>>
}