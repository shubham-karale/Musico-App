package com.example.musicoapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterface {

//    @Headers("X-RapidAPI-Key : 1584d33281mshe2e35984169d58dp1e5bddjsnef50f301705f" ,
//        "X-RapidAPI-Host : deezerdevs-deezer.p.rapidapi.com")
    @Headers("X-RapidAPI-Key: 1584d33281mshe2e35984169d58dp1e5bddjsnef50f301705f",
        "X-RapidAPI-Host: deezerdevs-deezer.p.rapidapi.com")
    @GET("search")
    fun getData(@Query("q") query: String): Call<DataClass>

}