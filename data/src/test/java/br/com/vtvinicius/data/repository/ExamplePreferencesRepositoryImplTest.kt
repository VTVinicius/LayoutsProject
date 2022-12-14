package br.com.vtvinicius.data.repository

import ExamplePreferencesRepositoryImpl
import br.com.vtvinicius.data.factory.SharedPreferencesFactory.DUMMY_EXAMPLE_STRING
import br.com.vtvinicius.data.local.datasource.ExamplePreferencesDataSource
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.doNothing
import org.mockito.kotlin.whenever

class ExamplePreferencesRepositoryImplTest {

    @Mock
    private lateinit var dataSource: ExamplePreferencesDataSource
    private lateinit var repository: ExamplePreferencesRepositoryImpl

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        repository = ExamplePreferencesRepositoryImpl(dataSource)
    }


    @Test
    fun `saveExample must return Unit when has a success`() {
        stubSaveExampleSuccess()
        kotlin.test.assertEquals(
            expected = repository.saveExample(DUMMY_EXAMPLE_STRING),
            actual = Unit
        )
    }

    private fun stubSaveExampleSuccess() {
        doNothing().`when`(dataSource).saveExample(DUMMY_EXAMPLE_STRING)
    }


    @Test
    fun `getExample should return String when success`() {
        stubGetExampleSuccess()
        val response = repository.getExample()
        kotlin.test.assertEquals(
            expected = response,
            actual = DUMMY_EXAMPLE_STRING
        )
    }

    private fun stubGetExampleSuccess() {
        whenever(
            dataSource.getExample()
        ).thenReturn(DUMMY_EXAMPLE_STRING)
    }


}