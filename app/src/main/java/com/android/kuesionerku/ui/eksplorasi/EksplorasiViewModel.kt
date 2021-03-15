package com.android.kuesionerku.ui.eksplorasi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EksplorasiViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Fragment Eksplorasi"
    }
    val text: LiveData<String> = _text
}