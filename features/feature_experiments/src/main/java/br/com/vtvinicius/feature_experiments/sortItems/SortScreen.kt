package br.com.vtvinicius.feature_experiments.sortItems

import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.vtvinicius.uikit.base.gray
import br.com.vtvinicius.uikit.base.yellowGamesLight
import org.koin.androidx.compose.viewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SortScreen() {

    val viewModel by viewModel<SortViewModel>()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(gray)
            .padding(20.dp)
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ){
        Button(onClick = {
            viewModel.startSorting()
        }, colors = ButtonDefaults.buttonColors(backgroundColor = yellowGamesLight)
        ) {
            Text(
                "Sort List",
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
        }
        LazyColumn(
            modifier = Modifier,
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ){
            items(
                viewModel.listToSort.size
            ){
                val borderStroke = if(viewModel.listToSort[it].isCurrentlyCompared){
                    BorderStroke(width = 3.dp,Color.White,)
                }else{
                    BorderStroke(width = 0.dp,Color.Transparent)
                }
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .background(viewModel.listToSort[it].color, RoundedCornerShape(15.dp))
                        .border(borderStroke, RoundedCornerShape(15.dp))
                        .animateItemPlacement(
                            tween(300)
                        ),
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        "${viewModel.listToSort[it].value}",
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp
                    )
                }
            }
        }
    }
}