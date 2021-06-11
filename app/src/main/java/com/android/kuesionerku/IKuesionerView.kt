package com.android.kuesionerku

import com.android.kuesionerku.Model.Kuesioner

interface IKuesionerView {
    fun onDataCompleteFromApi(kuesioner: Kuesioner)
    fun onDataErrorFromApi(throwable: Throwable)
}