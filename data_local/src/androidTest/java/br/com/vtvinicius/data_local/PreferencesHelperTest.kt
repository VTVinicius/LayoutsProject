package br.com.vtvinicius.data_local

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import br.com.vtvinicius.data.utils.keys.TestPreferencesKeys
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class PreferencesHelperTest {

    @get: Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var preferencesHelper: PreferencesHelper

    @Before
    fun setup() {
        val context: Context = ApplicationProvider.getApplicationContext()
        preferencesHelper = PreferencesHelper(context)
    }

    @Test
    fun saveStringTest() {
        val result = preferencesHelper.saveString(TestPreferencesKeys.TEST_KEY.name, "a")
        val resultKey = preferencesHelper.getString(TestPreferencesKeys.TEST_KEY.name)

        Assert.assertEquals(Unit, result)
        Assert.assertEquals("a", resultKey)
    }


    @Test
    fun getStringTest() {
        preferencesHelper.saveString(TestPreferencesKeys.TEST_KEY.name, "a")
        val result = preferencesHelper.getString(TestPreferencesKeys.TEST_KEY.name)

        Assert.assertEquals("a", result)
    }

    @Test
    fun saveBooleanTest() {
        val result = preferencesHelper.saveBoolean(TestPreferencesKeys.TEST_KEY.name, true)
        val resultKey = preferencesHelper.getBoolean(TestPreferencesKeys.TEST_KEY.name)

        Assert.assertEquals(Unit, result)
        Assert.assertEquals(true, resultKey)
    }

    @Test
    fun getBooleanTest() {
        preferencesHelper.saveBoolean(TestPreferencesKeys.TEST_KEY.name, true)
        val result = preferencesHelper.getBoolean(TestPreferencesKeys.TEST_KEY.name)

        Assert.assertEquals(true, result)
    }

    @Test
    fun saveFloatTest() {
        val result = preferencesHelper.saveFloat(TestPreferencesKeys.TEST_KEY.name, 1F)
        val resultKey = preferencesHelper.getFloat(TestPreferencesKeys.TEST_KEY.name)

        Assert.assertEquals(Unit, result)
        Assert.assertEquals(1F, resultKey)
    }

    @Test
    fun getFloatTest() {
        preferencesHelper.saveFloat(TestPreferencesKeys.TEST_KEY.name, 1F)
        val result = preferencesHelper.getFloat(TestPreferencesKeys.TEST_KEY.name)

        Assert.assertEquals(1F, result)
    }

    @Test
    fun saveIntTest() {
        val result = preferencesHelper.saveInt(TestPreferencesKeys.TEST_KEY.name, 1)
        val resultKey = preferencesHelper.getInt(TestPreferencesKeys.TEST_KEY.name)

        Assert.assertEquals(Unit, result)
        Assert.assertEquals(1, resultKey)
    }


    @Test
    fun getIntTest() {
        preferencesHelper.saveInt(TestPreferencesKeys.TEST_KEY.name, 1)
        val result = preferencesHelper.getInt(TestPreferencesKeys.TEST_KEY.name)

        Assert.assertEquals(1, result)
    }

    @Test
    fun removeValueTest() {
        preferencesHelper.saveString(TestPreferencesKeys.TEST_KEY.name, "a")
        val result = preferencesHelper.removeValue(TestPreferencesKeys.TEST_KEY.name)
        val resultKey = preferencesHelper.getString(TestPreferencesKeys.TEST_KEY.name)

        Assert.assertEquals(Unit, result)
        Assert.assertEquals(null, resultKey)
    }
}
