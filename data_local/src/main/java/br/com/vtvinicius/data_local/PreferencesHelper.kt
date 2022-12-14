package br.com.vtvinicius.data_local

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import br.com.vtvinicius.data_local.Base64tHelper.fromBase64
import br.com.vtvinicius.data_local.Base64tHelper.toBase64

class PreferencesHelper(context: Context) {

    private val sharedPreferences = createEncryptedSharedPreferences(context)

    private fun createEncryptedSharedPreferences(context: Context): SharedPreferences {
        val masterKey = MasterKey.Builder(context, MasterKey.DEFAULT_MASTER_KEY_ALIAS)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build()

        return EncryptedSharedPreferences.create(
            context,
            SHARED_PREFERENCES_APP_NAME,
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

    fun saveString(key: String, data: String?) = sharedPreferences.edit().run {
        putString(toBase64(key), data?.let { toBase64(it) })
        apply()
    }

    fun getString(key: String) = sharedPreferences.run {
        getString(toBase64(key), null)?.let {
            fromBase64(it)
        }
    }

    fun saveFloat(key: String, value: Float) = sharedPreferences.edit {
        putFloat(toBase64(key), value)
    }

    fun getFloat(key: String) =
        sharedPreferences.getFloat(toBase64(key), 0f)

    fun saveBoolean(key: String, value: Boolean) = sharedPreferences.edit {
        putBoolean(toBase64(key), value)
    }

    fun getBoolean(key: String, defaultValue: Boolean = false) =
        sharedPreferences.getBoolean(toBase64(key), defaultValue)

    fun saveInt(key: String, value: Int) = sharedPreferences.edit {
        putInt(toBase64(key), value)
    }

    fun saveLong(key: String, value: Long) = sharedPreferences.edit {
        putLong(toBase64(key), value)
    }

    fun getInt(key: String, defaultValue: Int = 0) =
        sharedPreferences.getInt(toBase64(key), defaultValue)

    fun getLong(key: String, defaultValue: Long = 0L) =
        sharedPreferences.getLong(toBase64(key), defaultValue)

    fun removeValue(key: String) {
        sharedPreferences.edit {
            remove(toBase64(key))
        }
    }

    companion object {
        private const val SHARED_PREFERENCES_APP_NAME =
            "br.com.vtvinicius.data_local.utils.PreferencesHelper"
    }


}