package br.com.vtvinicius.di.navigation

import br.com.vtvinicius.base_feature.loby.EntryPointNavigation
import br.com.vtvinicius.feature_example.navigation.FeatureExampleNavigation
import br.com.vtvinicius.navigation.navigators.EntryPointNavigationImpl
import br.com.vtvinicius.navigation.navigators.FeatureExampleNavigationImpl
import org.koin.dsl.module

val navigationExampleModule = module {


    factory<FeatureExampleNavigation> {
        FeatureExampleNavigationImpl()
    }

    factory<EntryPointNavigation> {
        EntryPointNavigationImpl()
    }

}