package br.com.vtvinicius.basecomposetemplate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import br.com.vtvinicius.navigation.navHost.FeatureHomeNavigationController
import br.com.vtvinicius.uikit.base.ApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApplicationTheme {
                FeatureHomeNavigationController()
            }
        }
    }
}