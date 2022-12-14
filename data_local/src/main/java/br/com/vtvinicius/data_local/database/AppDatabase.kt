package br.com.vtvinicius.data_local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.vtvinicius.data_local.database.dao.ViaCepDao
import br.com.vtvinicius.data_local.database.table.ViaCepLocal

@Database(entities = [ViaCepLocal::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun viaCepDao(): ViaCepDao

}