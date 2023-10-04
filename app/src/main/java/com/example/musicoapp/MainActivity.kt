package com.example.musicoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var recylerView : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recylerView = findViewById<RecyclerView>(R.id.recylerView)

        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://deezerdevs-deezer.p.rapidapi.com")
            .build()
            .create(ApiInterface::class.java)


        val retrofitData = retrofitBuilder.getData("eminem")

        retrofitData.enqueue(object : Callback<DataClass?> {
            override fun onResponse(call: Call<DataClass?>, response: Response<DataClass?>) {
                var dataList = response.body()?.data!!
//                val adapter = dataList?.let { MusicAdapter(this@MainActivity, it) }
                val adapter = MusicAdapter(this@MainActivity,dataList)
                recylerView.layoutManager = LinearLayoutManager(this@MainActivity)
                recylerView.adapter = adapter

            }

            override fun onFailure(call: Call<DataClass?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }
}