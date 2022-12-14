package br.com.vtvinicius.data_local.database.table

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import br.com.vtvinicius.data_local.database.Converter
import br.com.vtvinicius.data_local.database.model.AddressDataLocal

@Entity(tableName = "ViaCepTable")
data class ViaCepLocal(
    @TypeConverters(Converter::class) var addressData: AddressDataLocal,
    @PrimaryKey val cep: String,
)
