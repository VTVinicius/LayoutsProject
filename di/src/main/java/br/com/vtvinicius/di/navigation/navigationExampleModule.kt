package br.com.vtvinicius.di.navigation

import br.com.vtvinicius.base_feature.lobby.EntryPointNavigation
import br.com.vtvinicius.feature_canvas.FeatureCanvasNavigation
import br.com.vtvinicius.feature_clones.SocialMediaNavigation
import br.com.vtvinicius.navigation.navigators.EntryPointNavigationImpl
import br.com.vtvinicius.navigation.navigators.FeatureCanvasNavigationImpl
import br.com.vtvinicius.navigation.navigators.FeatureExampleNavigationImpl
import br.com.vtvinicius.navigation.navigators.SocialMediaNavigationImpl
import br.com.vtvinicius.viacep.navigation.FeatureExampleNavigation
import org.koin.dsl.module

val navigationExampleModule = module {


    factory<FeatureExampleNavigation> {
        FeatureExampleNavigationImpl()
    }

    factory<EntryPointNavigation> {
        EntryPointNavigationImpl()
    }

    factory<SocialMediaNavigation> {
        SocialMediaNavigationImpl()
    }
    factory<FeatureCanvasNavigation> {
        FeatureCanvasNavigationImpl()
    }

}