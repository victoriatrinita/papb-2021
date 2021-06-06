package com.android.kuesionerku.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val judul: String,
    val akses: String,
    val kategori: String,
    val tanggal: String,
    val reward: String

)