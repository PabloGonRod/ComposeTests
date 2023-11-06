package com.pgonrod.composetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.pgonrod.composetest.ui.theme.ComposeTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            View01()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun View01() {
    val offset = Offset(5.0f, 10.0f)
    ConstraintLayout(Modifier.fillMaxSize()) {
        val title = createRef()
        val image = createRef()

        Text(
            text = "View01",
            style = TextStyle(
                fontSize = 32.sp,
                shadow = Shadow(
                    color = Color.Green,
                    offset = offset,
                    blurRadius = 3f
                )
            ),
            modifier = Modifier.constrainAs(title) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
            }
        )

        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Imagen de prueba",
            modifier = Modifier.constrainAs(image){

            }
        )

    }
}




