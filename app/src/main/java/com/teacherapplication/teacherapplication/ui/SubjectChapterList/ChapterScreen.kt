package com.teacherapplication.teacherapplication.ui.SubjectChapterList

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teacherapplication.teacherapplication.R
import com.teacherapplication.teacherapplication.ui.AppComponents.BackArrow
import com.teacherapplication.teacherapplication.ui.AppComponents.TopProgressBar
import com.teacherapplication.teacherapplication.ui.home.dashboard.BottomNavigationBar
import com.teacherapplication.teacherapplication.ui.theme.italicSansFont





@Preview
@Composable
fun ChapterScreen(
    modifier: Modifier = Modifier
){
    val verticalScroll = rememberScrollState()
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxWidth()
                .verticalScroll(verticalScroll)
                .padding(bottom = 400.dp)
        ) {
            TopProgressBar()
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(end = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                BackArrow()
                Image(painter = painterResource(R.drawable.book_mark),
                    contentDescription = "bookMark",
                    modifier = Modifier.size(24.dp)
                )
            }
            TopCard()
            Spacer(modifier = Modifier.height(20.dp))
            GradientLine()
            Spacer(modifier = Modifier.height(20.dp))
            var showLine by remember { mutableStateOf(false) }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                TextButton(
                    onClick = { showLine = true},
                    modifier = Modifier
                ) {
                    Text(
                        text = "Outcomes",
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                }
                if (true){
                    HorizontalDivider(
                        modifier = Modifier
                            .width(IntrinsicSize.Min)
                            .height(2.dp),
                        color = Color.Black
                    )
                }

            }
        }
        BottomAppBar(
            modifier = Modifier.align(Alignment.BottomCenter)
        ){
            BottomNavigationBar()
        }
    }
}

@Composable
fun GradientLine() {
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(7.dp)

    ) {

        drawLine(
            brush = Brush.horizontalGradient(
                colors = listOf(
                    Color.White,
                    Color.Black,
                    Color.White
                ),
                startX = 0f,
                endX = size.width
            ),
            start = Offset(0f, size.height / 2),
            end = Offset(size.width, size.height / 2),
            strokeWidth = 0.5.dp.toPx() // Adjust line thickness as needed
        )
    }
}

@Composable
fun TopCard() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            color = Color.Transparent,
            modifier = Modifier
                .height(94.dp)
                .width(93.dp)
                .clip(RoundedCornerShape(14.dp))
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFFFF6020),
                            Color(0xFFFDC194),
                        )
                    )
                )
        ) {
            Image(
                painter = painterResource(R.drawable.art_img),
                contentDescription = "art",
                modifier = Modifier
                    .size(83.dp)
                    .padding(top = 10.dp)
                    .scale(1.2f)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Box(
            modifier = Modifier
                .height(22.dp)
                .width(120.dp)
                .background(
                    color = Color(0xFF129193),
                    shape = RoundedCornerShape(20.dp)
                ),
            contentAlignment = Alignment.Center

        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 8.dp, end = 8.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Nursery - A",
                    style = MaterialTheme.typography.titleSmall.copy(
                        fontSize = 12.sp,
                        fontWeight = FontWeight(400),
                        lineHeight = 9.6.sp,
                        color = Color(0xFFFFFFFF)
                    )
                )
                VerticalDivider(
                    modifier = Modifier.height(14.dp),
                    color = Color(0xFFA9E9EA)
                )
                Text(
                    text = "Art",
                    style = MaterialTheme.typography.titleSmall.copy(
                        fontSize = 12.sp,
                        fontWeight = FontWeight(400),
                        lineHeight = 9.6.sp,
                        color = Color(0xFFFFFFFF)
                    )
                )
            }
        }
        Text(
            text = "CH 1.Primary Colours",
            style = MaterialTheme.typography.titleMedium.copy(
                fontSize = 24.sp,
                lineHeight = 19.2.sp,
                color = Color(0xFF000000)
            )
        )
        Text(
            text = "1/14 Topics",
            fontFamily = italicSansFont,
            fontSize = 14.sp,
            lineHeight = 17.64.sp,
            color = Color(0xFF1D1751)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ChapterScreenPreview(){
    ChapterScreen()
}