package br.com.vtvinicius.feature_canvas.gender_picker
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.vtvinicius.feature_canvas.gender_picker.Gender

@Composable
fun GenderScreen() {

    var genero by remember {
        mutableStateOf("Feminino")
    }
    GenderPickerResponsivo(onGenderSelected = {
        genero = when (it) {
            Gender.Female -> "Feminino"
            else -> "Masculino"
        }
    }, modifier = Modifier.fillMaxSize())
    Row(
        Modifier
            .fillMaxSize()
            .padding(top = 64.dp),
        horizontalArrangement = Arrangement.Center
    ) {

        Text(text = "Selecionado: $genero", fontSize = 30.sp)

    }

}