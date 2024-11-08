package com.teacherapplication.teacherapplication.ui.SubjectChapterList

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teacherapplication.teacherapplication.R

@Preview(showBackground = true)
@Composable
fun ChapterList(modifier: Modifier = Modifier){
    val verticalScroll = rememberScrollState()
    Column(
        modifier = Modifier.fillMaxSize()
            .verticalScroll(verticalScroll)
    ){
        TopProgressBar()
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(start = 20.dp, end = 20.dp)
        ){
            IconButton(onClick = {
                //navController.popBackStack()
            }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "back",
                    modifier = Modifier.size(24.dp)
                        .padding(end = 3.dp)
                )
            }
            SubjectSurface()
            Spacer(modifier = Modifier.height(40.dp))
                Card(
                    modifier = Modifier.fillMaxWidth()
                        .height(99.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFFFFFFF)
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 1.dp
                    )
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(start = 20.dp,
                            top = 10.dp, end = 10.dp)
                    ) {

                        Box(
                            modifier = Modifier
                                .size(50.dp)
                                .clip(CircleShape)
                                .background(
                                    brush = Brush.linearGradient(
                                        colors = listOf(
                                            Color(0xFF185573),
                                            Color(0xFF14868D)
                                        )
                                    )
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "CH1",
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight(600),
                                    color = Color(0xFFFFFFFF)
                                )
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Column(
                            modifier = Modifier,
                            verticalArrangement = Arrangement.SpaceBetween,
                        ) {
                            Text(
                                text = "14 Days",
                                style = MaterialTheme.typography.titleMedium.copy(
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight(500),
                                    lineHeight = 17.34.sp,
                                    color = Color(0xFF129193)
                                )
                            )
                            Text(
                                text = "Primary Colours",
                                style = MaterialTheme.typography.titleMedium.copy(
                                    lineHeight = 14.4.sp,
                                    color = Color(0xFF000000)
                                )
                            )
                            Text(
                                text = "3/14 topics",
                                style = MaterialTheme.typography.titleMedium.copy(
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight(500),
                                    lineHeight = 17.34.sp,
                                    color = Color(0xFF595959)
                                )
                            )
                            LinearProgressIndicator(
                                progress = { 0.3f },
                                color = Color.Blue,
                                trackColor = Color.Gray,
                                modifier = Modifier.width(264.dp)
                            )
                        }
                        Icon(
                            painter = painterResource(R.drawable.right_arrow),
                            contentDescription = "right",
                            modifier = Modifier
                                .height(14.dp)
                                .width(16.dp),
                            tint = Color(0xFF129193)
                        )
                    }
                }
        }
    }
}

@Composable
fun SubjectSurface() {
    Box(
        modifier = Modifier
            .height(162.dp)
            .fillMaxWidth()
    ) {
        Surface(
            color = Color.Transparent,
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(14.dp))
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFFFF6020),
                            Color(0xFFFDC194),
                        )
                    )
                )
                .align(Alignment.BottomCenter)
        ) {
            Row(
                modifier = Modifier.padding(start = 45.dp, top = 45.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "Nursery - A",
                        style = MaterialTheme.typography.labelMedium.copy(
                            fontWeight = FontWeight(600),
                            color = Color(0xFFFFFFFF)
                        )
                    )
                    Text(
                        text = "Art",
                        style = MaterialTheme.typography.titleSmall.copy(
                            fontSize = 22.sp,
                            color = Color(0xFFFFFFFF),
                            lineHeight = 24.2.sp
                        )
                    )
                }
                Column(
                    modifier = Modifier.padding(end = 15.dp),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = "12 Chapters",
                        style = MaterialTheme.typography.labelMedium.copy(
                            fontWeight = FontWeight(600),
                            color = Color(0xFFFFFFFF)
                        )
                    )
                    Text(
                        text = "30 Topics",
                        style = MaterialTheme.typography.labelMedium.copy(
                            fontWeight = FontWeight(600),
                            color = Color(0xFFFFFFFF)
                        ),
                    )
                }
            }
        }
        Box(
            modifier = Modifier.offset(x = 50.dp, y = 8.dp)
        ) {
            Surface(
                color = Color.Transparent,
                modifier = Modifier
                    .height(94.dp)
                    .width(94.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                Color(0xFFFF6020),
                                Color(0xFFFDC194),
                            )
                        )
                    )
                    .align(Alignment.TopStart)
            ) {
                Image(
                    painter = painterResource(R.drawable.art_img),
                    contentDescription = "art"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopProgressBar(progress: Float = 0.5f) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 40.dp)
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
        ) {
            // background track with rounded corners
            drawRect(
                color = Color( 0xFFD9D9D9),
                size = Size(size.width, size.height),
            )

            // progress track with gradient and rounded corners
            if (progress > 0) {
                drawRoundRect(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFF185573), Color(0xFF14868D))
                    ),
                    size = Size(size.width * progress, size.height),
                    cornerRadius = CornerRadius(10f, 10f)
                )
            }
        }
    }
}
