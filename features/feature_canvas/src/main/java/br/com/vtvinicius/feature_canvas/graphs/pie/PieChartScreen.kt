package br.com.vtvinicius.feature_canvas.graphs.pie

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.vtvinicius.uikit.base.*


@Composable
fun PieChartScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(gray)
            .padding(5.dp),
        verticalArrangement = Arrangement.spacedBy(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Preferred Programming Languages",
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
            color = white,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 30.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            PieChartComponent(
                modifier = Modifier
                    .size(500.dp),
                input = listOf(
                    PieChartInput(
                        color = blueCanvasDark,
                        value = 29,
                        description = "Python"
                    ),
                    PieChartInput(
                        color = purpleUikitDark,
                        value = 21,
                        description = "Swift"
                    ),
                    PieChartInput(
                        color = greenExperimentsDark,
                        value = 32,
                        description = "JavaScript"
                    ),
                    PieChartInput(
                        color = redClonesDark,
                        value = 18,
                        description = "Java"
                    ),
                    PieChartInput(
                        color = yellowGamesDark,
                        value = 12,
                        description = "Ruby"
                    ),
                    PieChartInput(
                        color = greenFeaturesDark,
                        value = 38,
                        description = "Kotlin"
                    ),
                )
            )
        }
    }
}

