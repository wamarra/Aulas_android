package br.com.aulas_android.model

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.aulas_android.model.dao.AddressDao

@Database(entities = [Address::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun addressDao(): AddressDao
}