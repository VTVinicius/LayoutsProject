package com.example.feature_social_media.linkedin.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import br.com.vtvinicius.uikit.R


@Composable
fun CapeAndProfilePic() {

    val constraints = ConstraintSet {
        val profilePic = createRefFor("profilePic")
        val capePic = createRefFor("capePic")
        val editProfile = createRefFor("editProfile")
        val editCape = createRefFor("editCape")


        constrain(capePic) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.value(100.dp)
        }

        constrain(profilePic) {
            top.linkTo(capePic.bottom)
            bottom.linkTo(capePic.bottom)
            start.linkTo(parent.start)
            width = Dimension.value(140.dp)
            height = Dimension.value(140.dp)

        }

        constrain(editProfile) {
            top.linkTo(capePic.bottom)
            bottom.linkTo(profilePic.bottom)
            end.linkTo(parent.end)
            width = Dimension.value(35.dp)
            height = Dimension.value(35.dp)
        }

        constrain(editCape) {
            top.linkTo(capePic.top)
            end.linkTo(capePic.end )
            width = Dimension.value(35.dp)
            height = Dimension.value(35.dp)
        }
    }



    ConstraintLayout(constraints, modifier = Modifier.fillMaxSize()) {


        Image(
            painter = painterResource(id = R.drawable.capa_linkedin),
            contentDescription = null,
            modifier = Modifier
                .aspectRatio(1f)
                .layoutId("capePic")


        )
        Box(
            Modifier
                .layoutId("editCape")
                .offset(x = (-16).dp, y = 16.dp)){
            RoundedIcon(
                icon = R.drawable.ic_pencil,
                buttonColors = Color.White,
                iconColor = Color.Blue,
            )

        }
        RoundedLinkedinImage(
            painterResource(id = R.drawable.img_vini_2),
            modifier = Modifier
                .layoutId("profilePic")
                .padding(start = 8.dp)
        )

        Box(
            Modifier
                .layoutId("editProfile")
                .padding(end = 16.dp)) {
            Icon(
                painter = painterResource(id = R.drawable.ic_pencil),
                contentDescription = "Edit",
                modifier = Modifier
            )

        }
    }


}

@Preview
@Composable
fun PreviewPic() {
    CapeAndProfilePic()
}
