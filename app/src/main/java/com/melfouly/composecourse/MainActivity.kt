package com.melfouly.composecourse

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.melfouly.composecourse.ui.theme.ComposeCourseTheme
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val constraintSet = ConstraintSet {
                val greenBox = createRefFor("greenBox")
                val redBox = createRefFor("redBox")
                val yellowBox = createRefFor("yellowBox")
                val blackBox = createRefFor("blackBox")
                val guideline = createGuidelineFromTop(0.5f)

                constrain(greenBox) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    width = Dimension.value(100.dp)
                    height = Dimension.value(100.dp)
                }

                constrain(redBox) {
                    top.linkTo(parent.top)
                    start.linkTo(greenBox.end)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                    height = Dimension.value(100.dp)
                }

                constrain(yellowBox) {
                    top.linkTo(greenBox.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(blackBox.start)
                    width = Dimension.fillToConstraints
                    height = Dimension.value(100.dp)
                }

                constrain(blackBox) {
                    top.linkTo(guideline)
                    start.linkTo(yellowBox.end)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                    height = Dimension.value(100.dp)
                }
            }

            Column(modifier = Modifier.fillMaxSize()) {
                LazyColumn(
                    modifier = Modifier
                        .weight(1f)
                        .background(Color.LightGray)
                        .fillMaxSize()
                ) {
                    items(100) {
                        Text(
                            modifier = Modifier.fillMaxWidth().padding(6.dp),
                            text = "item $it",
                            textAlign = TextAlign.Center,
                            fontSize = 30.sp
                        )
                    }
                }
                ConstraintLayout(
                    constraintSet = constraintSet,
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxSize()
                ) {
                    Box(modifier = Modifier
                        .background(Color.Green)
                        .layoutId("greenBox"))
                    Box(modifier = Modifier
                        .background(Color.Red)
                        .layoutId("redBox"))
                    Box(modifier = Modifier
                        .background(Color.Yellow)
                        .layoutId("yellowBox"))
                    Box(modifier = Modifier
                        .background(Color.Black)
                        .layoutId("blackBox"))
                }

            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeCourseTheme {

    }
}