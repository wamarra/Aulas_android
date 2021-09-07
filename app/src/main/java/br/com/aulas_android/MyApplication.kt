package br.com.aulas_android

import android.app.Application
import androidx.room.Room
import br.com.aulas_android.model.AppDatabase

class MyApplication : Application() {

    companion object {
        var database: AppDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "address_db")
            .fallbackToDestructiveMigration()
            .build()
    }
}