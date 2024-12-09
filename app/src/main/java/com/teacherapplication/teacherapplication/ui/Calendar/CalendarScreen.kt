package com.teacherapplication.teacherapplication.ui.Calendar

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.teacherapplication.teacherapplication.R
import com.teacherapplication.teacherapplication.ui.AppComponents.BackArrow
import com.teacherapplication.teacherapplication.ui.AppComponents.brush
import com.teacherapplication.teacherapplication.ui.home.dashboard.BottomNavigationBar
import com.teacherapplication.teacherapplication.ui.home.dashboard.DashboardViewModel

@Composable
fun CalendarScreen(navController: NavHostController, viewModel: DashboardViewModel) {
    val scrollState = rememberScrollState()
    val daysList = listOf("M" to "08", "T" to "09", "W" to "10", "T" to "11", "F" to "12", "S" to "13", "S" to "14")
    val today = "10"

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(start = 15.dp, top = 40.dp, end = 15.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                BackArrow(onClick = {
                    viewModel.setSelectedIcon("Home")
                    navController.popBackStack()
                })
                Text(
                    text = "Calendar",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontSize = 20.sp,
                        lineHeight = 28.9.sp,
                        color = Color.Black
                    ),
                )
                Icon(
                    painter = painterResource(R.drawable.display_calendar),
                    contentDescription = "calendar",
                    tint = Color(0xFF129193),
                    modifier = Modifier
                        .size(24.dp)
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "August, 2024",
                style = MaterialTheme.typography.bodyLarge.copy(
                    brush = brush
                ),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                daysList.forEach { day ->
                    DateAndDayCard(
                        day = day.first,
                        date = day.second,
                        isToday = (day.second == today)
                    )
                }
            }

            DashedLine(
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth(),
                color = Color(0xFF1D1751)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Wed, August 10",
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontWeight = FontWeight(700),
                        color = Color.Black.copy(alpha = 0.8f)
                    )
                )
                Text(
                    text = "Edit Timetable",
                    style = MaterialTheme.typography.titleMedium.copy(
                        brush = brush,
                        fontWeight = FontWeight(500)
                    ),
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier
                        .clickable {

                        }

                )
            }
        }
        BottomAppBar(
            modifier = Modifier
                .align(Alignment.BottomCenter),
            containerColor = Color.White
        ){
            BottomNavigationBar(navController, viewModel)
        }
    }
}

@Composable
fun DashedLine(
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
    dashLength: Float = 18f,
    gapLength: Float = 18f,
    strokeWidth: Float = 2f
) {
    Canvas(modifier = modifier) {
        val totalWidth = size.width
        var startX = 0f

        while (startX < totalWidth) {
            drawLine(
                color = color,
                start = Offset(x = startX, y = size.height / 2),
                end = Offset(x = startX + dashLength, y = size.height / 2),
                strokeWidth = strokeWidth
            )
            startX += dashLength + gapLength
        }
    }
}


@Composable
private fun DateAndDayCard(
    day: String,
    date: String,
    isToday: Boolean
) {
    val gradientColor = if (isToday) brush else Brush.linearGradient(
        colors = listOf(Color(0xFFF6F6F6),Color(0xFFF6F6F6))
    )

    Box(
        modifier = Modifier
            .width(45.dp)
            .height(75.dp)
            .background(
                brush = gradientColor,
                shape = RoundedCornerShape(8.dp),
            )
            .shadow(
                elevation = 0.dp,
                shape = RoundedCornerShape(8.dp),
            ),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = day,
                style = MaterialTheme.typography.labelLarge.copy(
                    fontWeight = FontWeight(600),
                    color = if (isToday) Color.White else Color(0xFF1D1751)
                )
            )
            Text(
                text = date,
                style = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight(500),
                    color = if (isToday) Color.White else Color(0xFF8F8F8F)
                )
            )
        }
    }
}