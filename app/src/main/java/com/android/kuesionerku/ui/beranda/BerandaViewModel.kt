package com.android.kuesionerku.ui.beranda

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BerandaViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Fragment Beranda"
    }
    val text: LiveData<String> = _text
}