package br.com.vtvinicius.feature_canvas.graphs.line_graph
import androidx.compose.runtime.Composable

@Composable
fun LineGraphScreen() {

    val pointsList = mutableListOf<Points>()

    //Add 10 items to the br.com.vtvinicius.feature_canvas.graphs.line_graph.Points list
    pointsList.add(Points( valueY = 300f))
    pointsList.add(Points( valueY = 100f))
    pointsList.add(Points( valueY = 300f))
    pointsList.add(Points(valueY = 100f))
    pointsList.add(Points( valueY = 300f))
    pointsList.add(Points( valueY = 100f))
    pointsList.add(Points( valueY = 300f))
    pointsList.add(Points( valueY = 100f))
    pointsList.add(Points( valueY =300f))
    pointsList.add(Points( valueY =100f))
    pointsList.add(Points( valueY =300f))


    //oganize the list by the X value in ascending order



    LineGraph(pointsList = pointsList)
}