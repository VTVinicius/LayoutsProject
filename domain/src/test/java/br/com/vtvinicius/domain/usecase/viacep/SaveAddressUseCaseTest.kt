package br.com.vtvinicius.domain.usecase.viacep

import br.com.vtvinicius.domain.mocks.testFlow
import br.com.vtvinicius.domain.mocks.testModule
import br.com.vtvinicius.domain.repository.exampleRepository.AddressLocalRepository
import br.com.vtvinicius.domain.usecase.example.SaveAddressUseCase
import br.com.vtvinicius.domain.usecase.viacep.ViaCepFactory.DUMMY_ADDRESS_LOCAL_ENTITY
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOf
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.whenever

class SaveAddressUseCaseTest {


    @Mock
    private lateinit var repository: AddressLocalRepository
    private lateinit var subject: SaveAddressUseCase


    @Before
    fun before() {
        MockitoAnnotations.openMocks(this)
        startKoin { modules(testModule) }
        subject = SaveAddressUseCase(
            scope = CoroutineScope(Dispatchers.Unconfined),
            repository
        )
    }

    @After
    fun after() {
        stopKoin()
    }


    @Test(expected = NullPointerException::class)
    fun `WHEN params is null MUST throw NullPointerException`() {
        subject.run()
    }

    @Test
    fun `WHEN succeed MUST return Unit value`() {
        stubOnSuccess()
        subject.run(params = SaveAddressUseCase.Params(DUMMY_ADDRESS_LOCAL_ENTITY)).testFlow {
            kotlin.test.assertEquals(Unit, this)

        }
    }

    @Test(expected = Exception::class)
    fun `WHEN fails MUST throw an exception`() {
        stubOnError()
        subject.run(params = SaveAddressUseCase.Params(DUMMY_ADDRESS_LOCAL_ENTITY))
    }


    private fun stubOnSuccess() {
        whenever(repository.saveAddress(DUMMY_ADDRESS_LOCAL_ENTITY)).thenReturn(flowOf(Unit))
    }

    private fun stubOnError() {
        whenever(repository.saveAddress(DUMMY_ADDRESS_LOCAL_ENTITY)).thenThrow(Exception())
    }
}

