package br.com.vtvinicius.di.navigation

import br.com.vtvinicius.feature_canvas.FeatureCanvasNavigation
import br.com.vtvinicius.feature_clones.FeatureClonesNavigation
import br.com.vtvinicius.feature_home.lobby.FeatureHomeNavigation
import br.com.vtvinicius.feature_uikit.FeatureUikitNavigation
import br.com.vtvinicius.navigation.navigators.*
import br.com.vtvinicius.viacep.navigation.FeatureExampleNavigation
import org.koin.dsl.module

val navigationModule = module {

    factory<FeatureExampleNavigation> {
        FeatureExampleNavigationImpl()
    }

    factory<FeatureHomeNavigation> {
        FeatureHomeNavigationImpl()
    }

    factory<FeatureClonesNavigation> {
        FeatureClonesNavigationImpl()
    }
    factory<FeatureCanvasNavigation> {
        FeatureCanvasNavigationImpl()
    }

    factory<FeatureUikitNavigation> {
        FeatureUikitNavigationImpl()
    }
}