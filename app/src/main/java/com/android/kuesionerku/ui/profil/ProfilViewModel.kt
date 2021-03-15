package com.android.kuesionerku.ui.profil

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfilViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Fragment Profil"
    }
    val text: LiveData<String> = _text
}