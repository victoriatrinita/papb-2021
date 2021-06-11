package com.android.kuesionerku.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// Mendeklarasikan ViewModel untuk entity User
// ViewModel menyediakan data untuk UI,
// penengah komunikasi antara Repository dengan UI

class UserViewModel(application: Application) : AndroidViewModel(application) {

    val readAllData: LiveData<List<User>>
    private val repository: UserRepository

    // Blok pertama yang dieksekusi setiap kali UserViewModel dipanggil
    init {
        val userDao = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        readAllData = repository.readAllData
    }

    //  viewModelScope merupakan bagian dari coroutines
    //  Parameter Dispatcher IO menandakan blok tersebut dijalankan di background thread
    //  Menjalankan tugas-tugas database di main thread merupakan bad practice
    fun addUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }
}