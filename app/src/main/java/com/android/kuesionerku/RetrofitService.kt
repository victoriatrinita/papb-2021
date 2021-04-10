package com.android.kuesionerku

import com.android.kuesionerku.model.Kuesioner
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {

    @GET("kuesioner")
    fun getAPI() : Call<Kuesioner>

    companion object {
        fun create(): RetrofitService {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://60718a2350aaea0017284c14.mockapi.io")
                .build()
            return retrofit.create(RetrofitService::class.java)
        }
    }
}