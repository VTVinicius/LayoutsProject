package br.com.vtvinicius.domain.usecase.sharedpreferences

import br.com.vtvinicius.domain.factory.SharedPreferencesFactory.DUMMY_EXAMPLE_PARAMS
import br.com.vtvinicius.domain.factory.SharedPreferencesFactory.DUMMY_EXAMPLE_STRING
import br.com.vtvinicius.domain.mocks.testFlow
import br.com.vtvinicius.domain.mocks.testModule
import br.com.vtvinicius.domain.repository.sharedPreferences.ExamplePreferencesRepository
import br.com.vtvinicius.domain.usecase.shaerdPreferences.SaveExampleUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.doNothing

class SaveExampleUseCaseTest {


    @Mock
    private lateinit var repository: ExamplePreferencesRepository
    private lateinit var subject: SaveExampleUseCase


    @Before
    fun before() {
        MockitoAnnotations.openMocks(this)
        startKoin { modules(testModule) }
        subject = SaveExampleUseCase(
            scope = CoroutineScope(Dispatchers.Unconfined),
            repository
        )
    }

    @After
    fun after() {
        stopKoin()
    }

    @Test
    fun `WHEN succeed MUST return Unit value`() {
        stubOnSuccess()
        subject.run(DUMMY_EXAMPLE_PARAMS).testFlow {
            kotlin.test.assertEquals(Unit, this)
        }
    }

    @Test(expected = Exception::class)
    fun `WHEN fails MUST throw an exception`() {
        stubOnError()
        subject.run(DUMMY_EXAMPLE_PARAMS)
    }

    private fun stubOnSuccess() {
        doNothing().`when`(repository).saveExample(DUMMY_EXAMPLE_STRING)
    }

    private fun stubOnError() {
        Mockito.`when`(repository.saveExample(DUMMY_EXAMPLE_STRING)).thenThrow(Exception())
    }
}
