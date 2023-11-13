package com.example.tugas12

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.tugas12.Retrofit.ApiClient
import com.example.tugas12.databinding.ActivityMainBinding
import com.example.tugas12.model.Pengungsi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val client = ApiClient.getInstance()
        val response = client.getAllPengungsi()
        response.enqueue(object : Callback<Pengungsi> {
            override fun onResponse(call: Call<Pengungsi>, response: Response<Pengungsi>) {
                val pengungsiName = arrayListOf<String>()
                for (data in response.body()?.data ?: arrayListOf()) {
                    pengungsiName.add(data.nama)
                    pengungsiName.add(data.jalan)
                    pengungsiName.add(data.kota)
                }
                val adapter = ArrayAdapter(
                    this@MainActivity,
                    R.layout.simple_list_item_1,
                    pengungsiName
                )
                binding.lsView.adapter = adapter
            }

            override fun onFailure(call: Call<Pengungsi>, t: Throwable) {

            }
        }
        )
    }
}