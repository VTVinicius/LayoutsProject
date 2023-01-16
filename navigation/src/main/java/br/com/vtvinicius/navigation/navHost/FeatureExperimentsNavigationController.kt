package br.com.vtvinicius.navigation.navHost

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.vtvinicius.feature_experiments.ExperimentsLobby
import br.com.vtvinicius.feature_experiments.bottom_sheet.BottomSheetScreen
import br.com.vtvinicius.feature_experiments.buttons.CheckBoxes
import br.com.vtvinicius.feature_experiments.buttons.RadioButtonsTest
import br.com.vtvinicius.feature_experiments.buttons.SwitchButtonsScreen
import br.com.vtvinicius.feature_experiments.carousel.CarouselScreen
import br.com.vtvinicius.feature_experiments.carousel.ProductsPagerScreen
import br.com.vtvinicius.feature_experiments.dialogs.MaterialDialogScreen
import br.com.vtvinicius.feature_experiments.motion_layout.motion_buttons.MotionButtonsScreen
import br.com.vtvinicius.feature_experiments.motion_layout.motion_top_bar.MotionTopBarScreen
import br.com.vtvinicius.feature_experiments.shimmer.ShimmerScreen
import br.com.vtvinicius.feature_experiments.side_modal.SideModalScreen
import br.com.vtvinicius.feature_experiments.slider.RangeSliderScreen
import br.com.vtvinicius.navigation.navigators.FeatureExperimentsNavigationImpl

@Composable
fun FeatureExperimentsNavigationController() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "lobby_experiments"
    ) {
        composable("lobby_experiments") {
            ExperimentsLobby(navController, FeatureExperimentsNavigationImpl())
        }
        composable("lobby_screen") {
            FeatureHomeNavigationController()
        }
        composable("motion_top_bar") {
            MotionTopBarScreen(
                navController = navController,
                navigation = FeatureExperimentsNavigationImpl()
            )
        }
        composable("motion_button") {
            MotionButtonsScreen(
                navController = navController,
                navigation = FeatureExperimentsNavigationImpl()
            )
        }
        composable("bottom_sheet_1") {
            BottomSheetScreen(
                navController = navController,
                navigation = FeatureExperimentsNavigationImpl()
            )
        }
        composable("side_modal_1") {
            SideModalScreen(
                navController = navController,
                navigation = FeatureExperimentsNavigationImpl()
            )
        }
        composable("dialogs_1") {
            MaterialDialogScreen(
                navController = navController,
                navigation = FeatureExperimentsNavigationImpl()
            )
        }
        composable("radio_buttons") {
            RadioButtonsTest(
                navController = navController,
                navigation = FeatureExperimentsNavigationImpl()
            )
        }
        composable("check_boxes") {
            CheckBoxes(
                navController = navController,
                navigation = FeatureExperimentsNavigationImpl()
            )
        }
        composable("products_pager") {
            ProductsPagerScreen(
                navController = navController,
                navigation = FeatureExperimentsNavigationImpl()
            )
        }
        composable("carousel_pager") {
            CarouselScreen(
                navController = navController,
                navigation = FeatureExperimentsNavigationImpl()
            )
        }
        composable("range_slider") {
            RangeSliderScreen(
                navController = navController,
                navigation = FeatureExperimentsNavigationImpl()
            )
        }
        composable("shimmer_screen") {
            ShimmerScreen(
                navController = navController,
                navigation = FeatureExperimentsNavigationImpl()
            )
        }
        composable("switch_buttons") {
            SwitchButtonsScreen(
                navController = navController,
                navigation = FeatureExperimentsNavigationImpl()
            )
        }
    }
}