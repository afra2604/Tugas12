package com.example.tugas12

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.tugas12.retrofit.ApiClient
import com.example.tugas12.databinding.ActivityMainBinding
import com.example.tugas12.model.Data
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    //mendeklarasi variabel pengungsiName
    private lateinit var pengungsiName: ArrayList<Data>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        pengungsiName = ArrayList()

        val client = ApiClient.getInstance()
        val response = client.getAllPengungsi()
        response.enqueue(object : Callback<ArrayList<Data>> {
            override fun onResponse(
                call: Call<ArrayList<Data>>, response: Response<ArrayList<Data>>
            ) {
                // Clear the existing list before adding new data
                pengungsiName.clear()

                response.body()?.let {
                    // Assuming Data class has a property 'nama' for name
                    pengungsiName.addAll(it)
                }

                // Create an adapter using the pengungsiName list
                val adapter = ArrayAdapter(
                    this@MainActivity,
                    R.layout.simple_list_item_1,
                    pengungsiName.map { it.nama}
                )

                // Set the adapter to the ListView
                binding.lsView.adapter = adapter
            }

            override fun onFailure(call: Call<ArrayList<Data>>, t: Throwable) {
                //  Menangani kasus ketika permintaan jaringan gagal
            }
        }
        )
    }
}