package br.com.vtvinicius.domain.usecase.viacep


import br.com.vtvinicius.domain.exception.MissingParamsException
import br.com.vtvinicius.domain.mocks.testFlow
import br.com.vtvinicius.domain.mocks.testModule
import br.com.vtvinicius.domain.model.example.EnderecoEntity
import br.com.vtvinicius.domain.repository.exampleRepository.ExampleRepository
import br.com.vtvinicius.domain.usecase.example.SearchCepUseCase
import br.com.vtvinicius.domain.usecase.viacep.ViaCepFactory.DUMMY_CEP_STRING
import br.com.vtvinicius.domain.usecase.viacep.ViaCepFactory.DUMMY_EMPTY_CEP
import br.com.vtvinicius.domain.usecase.viacep.ViaCepFactory.DUMMY_SEARCH_CEP_PARAMS
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

class SearchCepUseCaseTest {

    @Mock
    private lateinit var response: EnderecoEntity

    @Mock
    private lateinit var repository: ExampleRepository
    private lateinit var subject: SearchCepUseCase


    @Before
    fun before() {
        MockitoAnnotations.openMocks(this)
        startKoin { modules(testModule) }
        subject = SearchCepUseCase(
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


    @Test(expected = MissingParamsException::class)
    fun `WHEN receive an empty name MUST throw MissingParamsException`() {
        subject.run(
            params = SearchCepUseCase.Params(
                cep = DUMMY_EMPTY_CEP
            )
        )
    }

    @Test
    fun `WHEN succeed MUST return EnderecoEntity value`() {
        stubOnSuccess()
        subject.run(DUMMY_SEARCH_CEP_PARAMS).testFlow {
            kotlin.test.assertEquals(response, this)

        }
    }

    @Test(expected = Exception::class)
    fun `WHEN fails MUST throw an exception`() {
        stubOnError()
        subject.run(DUMMY_SEARCH_CEP_PARAMS)
    }


    private fun stubOnSuccess() {
        whenever(repository.searchCep(DUMMY_CEP_STRING)).thenReturn(flowOf(response))
    }

    private fun stubOnError() {
        whenever(repository.searchCep(DUMMY_CEP_STRING)).thenThrow(Exception())
    }
}

