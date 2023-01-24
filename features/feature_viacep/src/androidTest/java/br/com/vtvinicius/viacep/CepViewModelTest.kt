package br.com.vtvinicius.viacep

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import br.com.vtvinicius.base_feature.core.Async
import br.com.vtvinicius.domain.model.example.EnderecoEntity
import br.com.vtvinicius.domain.usecase.example.SaveAddressUseCase
import br.com.vtvinicius.domain.usecase.example.SearchCepUseCase
import br.com.vtvinicius.domain.usecase.shaerdPreferences.GetExampleUseCase
import br.com.vtvinicius.domain.usecase.shaerdPreferences.SaveExampleUseCase
import br.com.vtvinicius.viacep.ViaCepViewModelFactory.DUMMY_ADDRESS_ENTITY
import br.com.vtvinicius.viacep.ViaCepViewModelFactory.DUMMY_ADDRESS_LOCAL_ENTITY
import br.com.vtvinicius.viacep.ViaCepViewModelFactory.DUMMY_ADDRESS_LOCAL_ENTITY_ERROR
import br.com.vtvinicius.viacep.ViaCepViewModelFactory.DUMMY_ERROR_CEP
import br.com.vtvinicius.viacep.ViaCepViewModelFactory.DUMMY_SUCCESS_CEP
import br.com.vtvinicius.viacep.cepScreen.CepState
import br.com.vtvinicius.viacep.cepScreen.CepViewModel
import br.com.vtvinicius.viacep.cepScreen.EnderecoInteraction
import io.mockk.every
import io.mockk.invoke
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import org.mockito.ArgumentMatchers.any
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class CepViewModelTest {

    private lateinit var viewModel: CepViewModel

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var rule = TestStateRule<CepState?>()


    private val searchCepUseCase: SearchCepUseCase = mockk()
    private val saveAddressUseCase: SaveAddressUseCase = mockk()
    private val saveExampleUseCase: SaveExampleUseCase = mockk()
    private val getExampleUseCase: GetExampleUseCase = mockk()

    private val testModule = module {
        single { searchCepUseCase }
        single { saveAddressUseCase }
        single { saveExampleUseCase }
        single { getExampleUseCase }
    }

    @Before
    fun before() {
        startKoin { modules(testModule) }
        viewModel = CepViewModel()
    }

    @After
    fun after() {
        stopKoin()
    }


    @Test
    fun searchCepWhenReturnSuccess() = rule.testStates {



        viewModel.interact(EnderecoInteraction.SearchEndereco(DUMMY_SUCCESS_CEP))

        verifyExpectedStates(
            *initialStates,
            successState.copy(endereco = Async.Success(DUMMY_ADDRESS_ENTITY))
        )
        verifyExpectedStates(
            *initialStates,
            successState.copy(lastCep = Async.Success("success"))
        )


    }

    @Test
    fun searchCepWhenReturnError() = rule.testStates {

        viewModel.interact(EnderecoInteraction.SearchEndereco(DUMMY_SUCCESS_CEP))

        verifyExpectedStates(
            *initialStates,
            successState.copy(endereco = Async.Error("error"))
        )
    }

    @Test
    fun showLastCepWhenReturnSuccess() = rule.testStates {

        viewModel.interact(EnderecoInteraction.ShowLastCep)

        verifyExpectedStates(
            *initialStates,
            successState.copy(lastCep = Async.Success("error"))
        )
    }

    @Test
    fun showLastCepWhenReturnError() = rule.testStates {

        viewModel.interact(EnderecoInteraction.ShowLastCep)

        verifyExpectedStates(
            *initialStates,
            successState.copy(lastCep = Async.Error("error"))
        )
    }

    @Test
    fun searchCepUseCaseWhenSuccess() {

        stubSearchCepSuccess()
        viewModel.interact(EnderecoInteraction.SearchEndereco(DUMMY_SUCCESS_CEP))

    }


    //test de interec(EnderecoInteraction.SearchEndereco(DUMMY_SUCCESS_CEP)) com erro
    @Test
    fun searchCepUseCaseWhenError() {

        stubSearchCepError()
        viewModel.interact(EnderecoInteraction.SearchEndereco(DUMMY_ERROR_CEP))

    }


    private fun stubSearchCepSuccess() {
        every {
            searchCepUseCase.invoke(
                params = SearchCepUseCase.Params(DUMMY_SUCCESS_CEP),
                onError = any(),
                onSuccess = captureLambda()
            )
        } answers {
            lambda<(EnderecoEntity) -> Unit>().invoke(DUMMY_ADDRESS_ENTITY)
        }
    }

    private fun stubSearchCepError() {
        every {
            searchCepUseCase.invoke(
                params = SearchCepUseCase.Params(DUMMY_ERROR_CEP),
                onError = captureLambda(),
                onSuccess = any()
            )
        } answers {
            lambda<(Throwable) -> Unit>().invoke(Throwable())
        }
    }


    private fun saveAddressSuccess() {
        every {
            saveAddressUseCase.invoke(
                params = SaveAddressUseCase.Params(address = DUMMY_ADDRESS_LOCAL_ENTITY),
                onError = any(),
                onSuccess = captureLambda()
            )
        } answers {
            lambda<(Unit) -> Unit>().invoke(any())
        }
    }

    private fun saveAddressError() {
        every {
            saveAddressUseCase.invoke(
                params = SaveAddressUseCase.Params(DUMMY_ADDRESS_LOCAL_ENTITY_ERROR),
                onError = captureLambda(),
                onSuccess = any()
            )
        } answers {
            lambda<(Throwable) -> Unit>().invoke(Throwable())
        }
    }

    private fun stubGetExampleSuccess() {
        every {
            getExampleUseCase.invoke(
                params = null,
                onError = any(),
                onSuccess = captureLambda()
            )
        } answers {
            lambda<(String) -> Unit>().invoke(String())
        }
    }

    private fun stubGetExampleError() {
        every {
            getExampleUseCase.invoke(
                params= null,
                onError = captureLambda(),
                onSuccess = any()
            )
        } answers {
            lambda<(Throwable) -> Unit>().invoke(Throwable())
        }
    }

    private val successState =
        getInitialState(1).copy(endereco = Async.Success(DUMMY_ADDRESS_ENTITY))

    private val successState2 =
        getInitialState(1).copy(lastCep = Async.Success("success"))

    private val initialStates = arrayOf(
        successState,
        getInitialState(1),
        successState2
    )

    private fun getInitialState(score: Int) = CepState(
        endereco = Async.Loading,
        saveAddress = true,
        error = Throwable(),
        lastCep = Async.Waiting
    )
}