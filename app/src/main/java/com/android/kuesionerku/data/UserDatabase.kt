package com.android.kuesionerku.data

import android.content.Context
import android.service.autofill.UserData
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import okhttp3.internal.Internal.instance

// Mendeklarisikan basis data User
@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    // Memungkinkan objek yang dibuat untuk digunakan oleh class lain
    companion object {

        // Volatile menandakan 'write' yang dilakukan di basis data User
        // akan langsung dapat dilihat oleh thread lain
        @Volatile
        private var INSTANCE: UserDatabase? = null

        // Buat instance room db baru jika belum ada
        fun getDatabase(context: Context): UserDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            //  'synchronized' menandakan isi blok (membuat instance dari room db)
            //  akan dilindungi dari concurrent execeution oleh multiple thread
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user_database"
                ).build()

                // meng-assign nilai instance yang baru saja dibuat ke variabel INSTANCE
                INSTANCE = instance
                return instance
            }
        }
    }
}