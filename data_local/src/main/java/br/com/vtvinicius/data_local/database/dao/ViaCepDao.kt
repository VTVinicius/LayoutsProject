package br.com.vtvinicius.data_local.database.dao

import androidx.room.*
import br.com.vtvinicius.data_local.database.table.ViaCepLocal
import kotlinx.coroutines.flow.Flow

@Dao
interface ViaCepDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAddress(address: ViaCepLocal)

    @Query("SELECT * FROM ViaCepTable")
    fun getAll(): Flow<List<ViaCepLocal>>

    @Query("SELECT * FROM ViaCepTable WHERE cep = :cepId")
    fun getSingleAddress(cepId: String): Flow<ViaCepLocal>

    @Delete
    fun deleteAddress(vararg address: ViaCepLocal)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateAddress(gitUser: ViaCepLocal)
}