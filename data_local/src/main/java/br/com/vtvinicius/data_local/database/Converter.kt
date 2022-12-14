package br.com.vtvinicius.data_local.database

import android.text.TextUtils
import androidx.room.TypeConverter
import br.com.vtvinicius.data_local.database.model.AddressDataLocal
import com.google.gson.Gson

class Converter {
    @TypeConverter
    fun stringToAddress(string: String): AddressDataLocal? {
        if (TextUtils.isEmpty(string))
            return null
        return Gson().fromJson(string, AddressDataLocal::class.java)
    }

    @TypeConverter
    fun addressToString(gitUserData: AddressDataLocal): String {
        return Gson().toJson(gitUserData)
    }


}