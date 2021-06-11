package com.android.kuesionerku

import android.content.Context
import com.android.kuesionerku.Model.Kuesioner
import retrofit2.Call
import retrofit2.Response

class KuesionerPresenter(context: Context) {
    val kuesionerView = context as IKuesionerView

    fun getDataFromApi() {
        RetrofitService.create()
            .getAPI()
            .enqueue(object : retrofit2.Callback<Kuesioner> {
                override fun onResponse(call: Call<Kuesioner>, response: Response<Kuesioner>) {
                    kuesionerView.onDataCompleteFromApi(response.body() as Kuesioner)
                }

                override fun onFailure(call: Call<Kuesioner>, t: Throwable) {
                    kuesionerView.onDataErrorFromApi(t)
                }

            })
    }
}