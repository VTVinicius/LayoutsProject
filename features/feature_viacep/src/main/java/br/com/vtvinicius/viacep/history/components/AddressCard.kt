package br.com.vtvinicius.viacep.history.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.vtvinicius.uikit.ui.text.LabelLargeText


@Preview
@Composable
fun Preview() {
    AddressCard(
        address = "Rua dos Bobos, 0",
        city = "São Paulo",
        uf = "SP",
        zipCode = "00000-000",
        neighborhood = "Centro"
    )
}

@Composable
fun AddressCard(
    zipCode: String?,
    uf: String?,
    city: String?,
    neighborhood: String?,
    address: String?,
) {

    Card(
        border = BorderStroke(1.dp, Color.Black),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        Box(
        ) {

            Row() {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .align(alignment = Alignment.CenterVertically)
                        .padding(horizontal = 24.dp)
                ) {

                    Image(
                        painter = painterResource(id = br.com.vtvinicius.uikit.R.drawable.ic_location),
                        contentDescription = "Location icon",
                        Modifier.size(36.dp, 43.dp)
                    )
                }
                Column(
                    verticalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
                ) {

                    Row(Modifier.fillMaxWidth()) {
                        LabelLargeText(text = "$zipCode")
                    }
                    Row(Modifier.fillMaxWidth()) {
                        LabelLargeText(text = "$city / $uf")
                    }
                    Row(Modifier.fillMaxWidth()) {
                        LabelLargeText(text = "$neighborhood")
                    }
                    Row(Modifier.fillMaxWidth()) {
                        LabelLargeText(text = "$address")
                    }
                }
            }
        }
    }
}