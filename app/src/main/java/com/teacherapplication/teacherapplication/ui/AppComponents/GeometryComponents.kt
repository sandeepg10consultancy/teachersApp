package com.teacherapplication.teacherapplication.ui.AppComponents

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun SmallCircle(
    dim: Dp = 7.dp,
    containerColor: Color = Color.Black,
    borderColor: Color = Color.Black,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(dim)
            .clip(CircleShape)
            .border(0.7.dp, borderColor, CircleShape)
            .background(containerColor)
    )
}


@Composable
fun SmallSquare(
    dim: Dp = 6.dp,
    containerColor: Color = Color.Black,
    borderColor: Color = Color.Black,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(dim)
            .border(width = 0.7.dp, color = borderColor)
            .background(containerColor)
    )
}

@Composable
fun SmallRectangle() {
    Box(
        modifier = Modifier
            .size(width = 80.dp, height = 40.dp)
            .background(Color.Red)
    )
}