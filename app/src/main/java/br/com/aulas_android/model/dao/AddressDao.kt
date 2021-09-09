package br.com.aulas_android.model.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.aulas_android.model.Address

@Dao
interface AddressDao {

    @Query("SELECT * FROM Address WHERE cep=:cep")
    fun getAddressByCep(cep: String): LiveData<Address>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAddress(address: Address)
}