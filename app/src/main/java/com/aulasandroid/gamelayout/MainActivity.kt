package com.aulasandroid.gamelayout

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aulasandroid.gamelayout.ui.theme.GameLayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GameLayoutTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GameScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun GameScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Score(
                modifier = Modifier
                    .weight(1f)
                    .background(Color.Blue)
                    .size(70.dp),
                points = "0050"
            )

            Column(
                modifier = Modifier
                    .weight(1f),
                horizontalAlignment = Alignment.End
            ) {
                Row() {
                    Text(
                        text = "LIVES:",
                        color = Color.White,
                        textAlign = TextAlign.End
                    )

                    AndroidEnemy(
                        modifier = Modifier
                            .size(16.dp),
                        color = Color.Red
                    )

                    AndroidEnemy(
                        modifier = Modifier
                            .size(16.dp),
                        color = Color.Red
                    )

                    AndroidEnemy(
                        modifier = Modifier
                            .size(16.dp),
                        color = Color.Red
                    )
                }


            }

        }
    }
}

@Composable
fun AndroidEnemy(modifier: Modifier = Modifier, color: Color) {
    Image(
        modifier = modifier,
        painter = painterResource(R.drawable.checkbox_on_background),
        contentDescription = "Android Enemy",
        colorFilter = ColorFilter.tint((color))

    )
}


@Composable
fun Score(
    points: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
    ) {
        Text(
            text = "SCORE: ${points}",
            color = Color.White,
            textAlign = TextAlign.End
        )

    }
}
