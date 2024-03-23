package br.com.vtvinicius.basecomposetemplate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.Popup
import br.com.vtvinicius.navigation.navHost.FeatureHomeNavigationController
import br.com.vtvinicius.uikit.base.ApplicationTheme
import br.com.vtvinicius.uikit.base.black
import br.com.vtvinicius.uikit.ui.newTextField.DefaultTextField
import br.com.vtvinicius.uikit.ui.newTextField.NormalTextField

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApplicationTheme {

                var validate by remember {
                    mutableStateOf( true)
                }


                BoxWithConstraints(Modifier.fillMaxSize()) {


                    Column {

                        DefaultTextField(validationBoolean = validate)


                        Button(onClick = { validate = !validate}) {

                            Text(text = "Validate")
                        }
                    }
                }
            }
        }
    }
}