package br.com.vtvinicius.domain.usecase.viacep

import br.com.vtvinicius.domain.mocks.testFlow
import br.com.vtvinicius.domain.mocks.testModule
import br.com.vtvinicius.domain.model.example.AddressLocalEntity
import br.com.vtvinicius.domain.repository.exampleRepository.AddressLocalRepository
import br.com.vtvinicius.domain.usecase.example.GetAddressListUseCase
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

class GetAddressListUseCaseTest {

    @Mock
    private lateinit var response: List<AddressLocalEntity>


    @Mock
    private lateinit var repository: AddressLocalRepository
    private lateinit var subject: GetAddressListUseCase


    @Before
    fun before() {
        MockitoAnnotations.openMocks(this)
        startKoin { modules(testModule) }
        subject = GetAddressListUseCase(
            scope = CoroutineScope(Dispatchers.Unconfined),
            repository
        )
    }

    @After
    fun after() {
        stopKoin()
    }

    @Test
    fun `WHEN succeed MUST return List of AddressLocalEntity value`() {
        stubOnSuccess()
        subject.run(Unit)
            .testFlow {
                kotlin.test.assertEquals(response, this)

            }
    }

    @Test(expected = Exception::class)
    fun `WHEN fails MUST throw an exception`() {
        stubOnError()
        subject.run(Unit)
    }


    private fun stubOnSuccess() {
        whenever(repository.getAddress()).thenReturn(
            flowOf(response)
        )
    }

    private fun stubOnError() {
        whenever(repository.getAddress()).thenThrow(
            Exception()
        )
    }
}

