package com.karvinok.shimmereffect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.karvinok.shimmer.ShimmerAnimation
import com.karvinok.shimmer.ShimmerItem
import com.karvinok.shimmer.ShimmerItem.*
import com.karvinok.shimmereffect.ui.theme.KarvinokShimmerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KarvinokShimmerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Screen()
                }
            }
        }
    }
}

@Composable
fun Screen() {
    val list = remember { mutableStateListOf<ShimmerItem>() }

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        ShimmerAnimation(
            modifier = Modifier.wrapContentHeight(),
            items = list
        )
        Row(modifier = Modifier.fillMaxWidth().height(50.dp)) {
            Text(text = "Circle", modifier = Modifier
                .weight(1f)
                .background(Color.White)
                .clickable {
                    list.add(Circle())
                })
            Text(text = "Square", modifier = Modifier
                .weight(1f)
                .background(Color.White)
                .clickable {
                    list.add(Square())
                })
            Text(text = "Line", modifier = Modifier
                .weight(1f)
                .background(Color.White)
                .clickable {
                    list.add(Line(randomSize))
                })
            Text(text = "Row", modifier = Modifier
                .weight(1f)
                .background(Color.White)
                .clickable {
                    list.add(Row(Circle(), Square(), Line(randomSize)))
                })
            Text(text = "Clear", modifier = Modifier
                .weight(1f)
                .background(Color.White)
                .clickable {
                    list.clear()
                })
        }
    }
}

val randomSize get() = DpSize((20..300).random().dp, (20..70).random().dp)

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KarvinokShimmerTheme {
        Screen()
    }
}