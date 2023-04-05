package br.com.vtvinicius.di

import br.com.vtvinicius.domain.core.ThreadContextProvider
import br.com.vtvinicius.domain.usecase.example.GetAddressListUseCase
import br.com.vtvinicius.domain.usecase.example.SaveAddressUseCase
import br.com.vtvinicius.domain.usecase.example.SearchCepUseCase
import br.com.vtvinicius.domain.usecase.shaerdPreferences.GetExampleUseCase
import br.com.vtvinicius.domain.usecase.shaerdPreferences.IsUserLoggedUseCase
import br.com.vtvinicius.domain.usecase.shaerdPreferences.SaveExampleUseCase
import br.com.vtvinicius.domain.usecase.shaerdPreferences.SaveUserLoggedUseCase
import br.com.vtvinicius.domain.usecase.sort.BubbleSortUseCase
import kotlinx.coroutines.CoroutineScope
import org.koin.dsl.module

val domainModule = module {

    // Declaração do br.com.vtvinicius.domain.core.ThreadContextProvider no DI
    single {
        ThreadContextProvider()
    }

    // Declaração do br.com.vtvinicius.domain.core.UseCase no DI
    factory { (scope: CoroutineScope) ->
        SaveExampleUseCase(
            scope = scope,
            repository = get()
        )
    }
    factory { (scope: CoroutineScope) ->
        GetExampleUseCase(
            scope = scope,
            repository = get()
        )
    }

    factory { (scope: CoroutineScope) ->
        SearchCepUseCase(
            scope = scope,
            repository = get()
        )
    }
    factory { (scope: CoroutineScope) ->
        GetAddressListUseCase(
            scope = scope,
            repository = get()
        )
    }
    factory { (scope: CoroutineScope) ->
        SaveAddressUseCase(
            scope = scope,
            repository = get()
        )
    }
    factory { (scope: CoroutineScope) ->
        SaveUserLoggedUseCase(
            scope = scope,
            repository = get()
        )
    }
    factory { (scope: CoroutineScope) ->
        IsUserLoggedUseCase(
            scope = scope,
            repository = get()
        )
    }

    factory { (scope: CoroutineScope) ->
        BubbleSortUseCase(
            scope = scope,
        )
    }


}