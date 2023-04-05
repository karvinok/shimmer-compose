package com.karvinok.shimmer

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ShimmerAnimation(
    modifier: Modifier = Modifier,
    items: List<ShimmerItem>,
    itemsPaddingDp: Dp = 16.dp
) {
    val shimmerColors = listOf(
        Color.LightGray.copy(alpha = 0.05f),
        Color.LightGray.copy(alpha = 0.3f),
        Color.LightGray.copy(alpha = 0.02f),
    )
    val transition = rememberInfiniteTransition()
    val translateAnim = transition.animateFloat(
        initialValue = 0f,
        targetValue = 3000f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1500,
                easing = FastOutSlowInEasing
            )
        )
    )
    val brush = Brush.linearGradient(
        colors = shimmerColors,
        start = Offset.Zero,
        end = Offset(translateAnim.value, translateAnim.value)
    )

    Column(modifier = modifier) {
        items.forEach { item ->
            when(item) {
                is ShimmerItem.Row -> {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        item.list.forEach { rowItem ->
                            Spacer(
                                modifier = Modifier
                                    .background(
                                        brush = if (rowItem is ShimmerItem.Spacer)
                                            SolidColor(Color.Transparent) else brush,
                                        shape = rowItem.shape
                                    )
                                    .width(rowItem.size.width)
                                    .height(rowItem.size.height)
                            )
                            Spacer(modifier = Modifier.size(itemsPaddingDp))
                        }
                    }
                }
                else -> {
                    Spacer(modifier = Modifier
                        .background(
                            brush = if (item is ShimmerItem.Spacer)
                                SolidColor(Color.Transparent) else brush,
                            shape = item.shape
                        )
                        .width(item.size.width)
                        .height(item.size.height)
                    )
                }
            }
            Spacer(modifier = Modifier.size(itemsPaddingDp))
        }
    }
}