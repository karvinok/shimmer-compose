package com.karvinok.shimmer

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp

sealed class ShimmerItem(val size: DpSize, val shape: Shape) {
    class Circle(
        size: DpSize = DpSize(50.dp, 50.dp)
    ) : ShimmerItem(size, CircleShape)

    class Square(
        size: DpSize = DpSize(50.dp, 50.dp),
        shape: Shape = RoundedCornerShape(7.dp),
    ) : ShimmerItem(size, shape)

    class Line(
        size: DpSize = DpSize(200.dp, 50.dp),
        shape: Shape = RoundedCornerShape(7.dp),
    ) : ShimmerItem(size, shape)

    class Row(
        vararg val list: ShimmerItem,
        size: DpSize = DpSize(300.dp, 50.dp)
    ) : ShimmerItem(size, RectangleShape)

    class Spacer(
        size: DpSize = DpSize(30.dp, 50.dp)
    ) : ShimmerItem(size, RectangleShape)
}