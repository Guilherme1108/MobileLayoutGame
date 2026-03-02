package com.aulasandroid.gamelayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aulasandroid.gamelayout.ui.theme.GameLayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GameLayoutTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GameScreen( modifier = Modifier.padding(innerPadding) )
//                    ScreenGameOver(modifier = Modifier.padding(innerPadding))

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
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Score(
                    modifier = Modifier,
                    points = "0050"
                )

                Column(
                    modifier = Modifier
                        .weight(1f),
                    horizontalAlignment = Alignment.End
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "LIVES:",
                            color = Color.White,
                            textAlign = TextAlign.End,
                            fontWeight = FontWeight.W600

                            )

                        AndroidImages(
                            modifier = Modifier
                                .size(16.dp),
                            color = Color(74, 168, 77, 255)
                        )

                        AndroidImages(
                            modifier = Modifier
                                .size(16.dp),
                            color = Color(74, 168, 77, 255)
                        )

                        AndroidImages(
                            modifier = Modifier
                                .size(16.dp),
                            color = Color(74, 168, 77, 255)
                        )
                    }

                }

            }

            AndroidEnemies()

        }


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(110.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween

        ) {

            Image(
                modifier = Modifier
                    .size(64.dp),
                painter = painterResource(R.drawable.outline_adb_24),
                contentDescription = "Nave",
                colorFilter = ColorFilter.tint(Color.White)
            )

            Row() {
                Text(
                    text = "PRESS START",
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(61, 61, 61, 144))
                        .padding(all = 4.dp)
                        .padding(horizontal = 20.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 24.sp,
                    color = Color.White,
                    fontWeight = FontWeight.W600
                )
            }
        }

    }
}

@Composable
fun AndroidImages(modifier: Modifier = Modifier, color: Color) {
    Image(
        modifier = modifier,
        painter = painterResource(R.drawable.outline_android_24),
        contentDescription = "Android Enemy",
        colorFilter = ColorFilter.tint(color)

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
            textAlign = TextAlign.End,
            fontWeight = FontWeight.W600
        )

    }
}

@Composable
fun AndroidEnemies(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        AndroidImages(
            modifier = Modifier
                .size(64.dp),
            color = Color(74, 168, 77, 255)
        )

        AndroidImages(
            modifier = Modifier
                .size(64.dp),
            color = Color.Red
        )

        AndroidImages(
            modifier = Modifier
                .size(64.dp),
            color = Color.Blue
        )

        AndroidImages(
            modifier = Modifier
                .size(64.dp),
            color = Color.Yellow
        )

        AndroidImages(
            modifier = Modifier
                .size(64.dp),
            color = Color(74, 168, 77, 255)
        )
    }
    
}

@Composable
fun ScreenGameOver(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Box(
        ) {
            AndroidEnemies()
        }

        Box(
        ) {
            Text(
                text = "GAME OVER",
                color = Color.White,
                fontSize = 64.sp,
                fontWeight = FontWeight.W600
            )
        }
    }

}