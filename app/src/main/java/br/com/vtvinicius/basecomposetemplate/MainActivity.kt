package br.com.vtvinicius.basecomposetemplate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import br.com.vtvinicius.navigation.navHost.EntryPointHostController
import br.com.vtvinicius.navigation.navHost.FeatureExampleNavigationController
import br.com.vtvinicius.uikit.base.ApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApplicationTheme {
                FeatureExampleNavigationController()
            }
        }
    }
}