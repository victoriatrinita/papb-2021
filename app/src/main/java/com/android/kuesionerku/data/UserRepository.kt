package com.android.kuesionerku.data

import androidx.lifecycle.LiveData

// Mendeklarisikan repository User, yaitu kelas
// yang meng-abstract akses ke berbagai sumber data

// Repository bukan merupakan bagian Architecture Components library
// tapi disarankan untuk digunakan untuk pemisahan kode yang arsitektur lebih baik

class UserRepository(private val userDao: UserDao) {

    // Membaca data dari DAO User
    val readAllData: LiveData<List<User>> = userDao.readAllData()

    // Fungi untuk menambahkan User
    // Ditambahkan keyword 'suspend' agar nantinya
    // dapat diterapkan coroutines di ViewModel
    suspend fun addUser(user: User) {
        userDao.addUser(user)
    }
}