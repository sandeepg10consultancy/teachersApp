package com.teacherapplication.teacherapplication.ui.Calendar

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teacherapplication.teacherapplication.R
import com.teacherapplication.teacherapplication.ui.AppComponents.SmallCircle
import com.teacherapplication.teacherapplication.ui.AppComponents.brush
import com.teacherapplication.teacherapplication.ui.theme.jostFont
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class TimeTable(
    val section: String,
    val time: String,
    val subject: String,
    val chapter: String,
    val timings: String,
    val bgImage: Int,
    val bgColor: List<Color>
)

val timeTableList = listOf(
    TimeTable(
        section = "Nursery - A",
        time = "30",
        subject = "Science",
        chapter = "What is Living And...",
        timings = "09:00 - 09:30",
        bgImage = R.drawable.calender_science,
        bgColor = listOf(Color(0xFF2093C3),Color(0xFF93ECFF))
    ),
    TimeTable(
        section = "Nursery - A",
        time = "30",
        subject = "English",
        chapter = "A Green World",
        timings = "10:30 - 11:00",
        bgImage = R.drawable.literacy_img,
        bgColor = listOf(Color(0xFFFF992E),Color(0xFFFED276))
    ),
    TimeTable(
        section = "Nursery - A",
        time = "30",
        subject = "Art",
        chapter = "A Green World",
        timings = "11:00 - 11:30",
        bgImage = R.drawable.art_img,
        bgColor = listOf(Color(0xFFFF6020),Color(0xFFFDC194))
    ),
    TimeTable(
        section = "Nursery - A",
        time = "30",
        subject = "Science",
        chapter = "What is Living And...",
        timings = "11:30 - 12:30",
        bgImage = R.drawable.gk_img,
        bgColor = listOf(Color(0xFFDA5151),Color(0xFFF2C0C0))
    ),
    TimeTable(
        section = "Nursery - A",
        time = "30",
        subject = "Numeracy",
        chapter = "Numbers",
        timings = "12:00 - 12:30",
        bgImage = R.drawable.numeracy_img,
        bgColor = listOf(Color(0xFF2C84DA),Color(0xFF99D6FC))
    ),

)

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun StepperScreen() {
    val currentTime = remember { mutableStateOf("") }
    val timetable = listOf(
        "09:00 AM" to timeTableList[0],
        "10:30 AM" to timeTableList[1],
        "11:00 AM" to timeTableList[2],
        "11:30 AM" to timeTableList[3],
        "12:00 PM" to timeTableList[4]
    )

    //CurrentTimeDisplay(currentTime)
    currentTime.value = "10:45"

    Column() {

        Spacer(modifier = Modifier.height(16.dp))
        Stepper(
            steps = timetable,
            currentTime = currentTime.value,
            modifier = Modifier.fillMaxWidth()
        )



    }
}

val timetable2 = listOf(
    "09:00 AM" to timeTableList[0],
    "10:30 AM" to timeTableList[1],
    "11:00 AM" to timeTableList[2],
    "11:30 AM" to timeTableList[3],
    "12:00 PM" to timeTableList[4]
)

@Preview(showBackground = true)
@Composable
fun Stepper(
    steps: List<Pair<String, TimeTable>> = timetable2,
    modifier: Modifier = Modifier,
    currentTime: String = "10:45",
) {
    val currentParts = currentTime.split(":")
    val currentHours = currentParts[0].trim().toIntOrNull() ?: 0
    //val currentMin = currentParts[1].trim().toIntOrNull() ?: 0


    Column(modifier = modifier
    ) {
        steps.forEachIndexed { index, step ->
            val time = step.first
            val parts = time.split(":"," ")
            val hours = parts[0].toInt()
            val minutes = parts[1].toInt()
            val period = parts[2]

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Top
            ) {
                Text(
                    text = step.first,
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontWeight = FontWeight(600),
                        color = Color(0xFF1D1751)
                    ),
                    modifier = Modifier.width(75.dp)
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Box(
                        modifier = Modifier
                            .size(18.dp)
                            .clip(CircleShape)
                            .background(
                                color = if ((hours <= currentHours)) Color(0xFFB6DFE6) else Color(0xFFE8E8E8)
                            ),
                        contentAlignment = Alignment.Center,
                    ){
                        Box(
                            modifier = Modifier
                                .size(12.dp)
                                .clip(CircleShape)
                                .background(
                                    brush = brush
                                )
                        )
                    }
                    if (index < steps.size - 1) {
                        if (hours <= currentHours) {
                            Box(
                                modifier = Modifier
                                    .width(3.dp)
                                    .height(105.dp)
                                    .background(
                                        brush = brush
                                    )
                            )
                        }
                        else{
                            VerticalDashedLine(
                                color = Color(0xFF129193),
                                dashLength = 6.dp,
                                dashSpacing = 6.dp,
                                modifier = Modifier
                                    .width(4.dp)
                                    .height(105.dp)
                                    .padding(end = 0.dp)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.width(8.dp))
                SubjectBox(step.second)
            }
            if (index == 0) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 79.2.dp),
                    verticalArrangement = Arrangement.Center,
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            contentAlignment = Alignment.Center
                        ) {
                            if (hours <= currentHours) {
                                Box(
                                    modifier = Modifier
                                        .width(3.dp)
                                        .height(50.dp)
                                        .background(
                                            brush = brush
                                        )
                                )
                            }else{
                                VerticalDashedLine(
                                    color = Color(0xFF129193),
                                    dashLength = 6.dp,
                                    dashSpacing = 6.dp,
                                    modifier = Modifier
                                        .width(4.dp)
                                        .height(50.dp)
                                )
                            }
                            SmallCircle(
                                dim = 10.dp,
                                containerColor = Color(0xFF129193),
                                borderColor = Color.Transparent
                            )
                        }
                        Box(
                            modifier = Modifier
                                .height(1.dp)
                                .width(15.dp)
                                .background(
                                    color = Color(0xFF129193)
                                )
                        )
                        Box(
                            modifier = Modifier
                                .height(50.dp)
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(8.dp))
                                .background(
                                    color = Color(0xFFE6F4FF)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "1 Hour Break",
                                style = MaterialTheme.typography.bodySmall.copy(
                                    fontWeight = FontWeight(600),
                                    color = Color(0xFF1D1751)
                                )
                            )
                        }
                    }
                    if (hours <= currentHours) {
                        Box(
                            modifier = Modifier
                                .offset(x = 3.4.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .width(3.dp)
                                    .height(20.dp)
                                    .background(
                                        brush = brush
                                    )
                            )
                        }
                    }else{
                        VerticalDashedLine(
                            color = Color(0xFF129193),
                            dashLength = 6.dp,
                            dashSpacing = 6.dp,
                            modifier = Modifier
                                .width(4.dp)
                                .height(20.dp)
                                .offset(x = 3.2.dp)
                        )
                    }
                }
            }


        }
    }
}
@Composable
fun VerticalDashedLine(
    color: Color = Color.Gray,
    dashLength: Dp = 4.dp,
    dashSpacing: Dp = 4.dp,
    modifier: Modifier = Modifier
        .width(2.dp)
        .height(100.dp)
) {
    Canvas(modifier = modifier) {
        val totalHeight = size.height
        val dashPx = dashLength.toPx()
        val spacingPx = dashSpacing.toPx()

        var currentHeight = 0f
        while (currentHeight < totalHeight) {
            drawLine(
                color = color,
                start = Offset(x = size.width / 2, y = currentHeight),
                end = Offset(x = size.width / 2, y = currentHeight + dashPx),
                strokeWidth = size.width
            )
            currentHeight += dashPx + spacingPx
        }
    }
}


@Composable
fun SubjectBox(timeTable: TimeTable, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .height(103.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(5.dp))
            .background(
                brush = Brush.linearGradient(
                    colors = timeTable.bgColor
                )
            ),
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource(timeTable.bgImage),
            contentDescription = "book",
            modifier = Modifier
                .size(93.54.dp)
                .align(Alignment.Center)
                .scale(1.6f)
                .offset(x = 20.dp, y = 2.dp),
            alpha = 0.4f
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text = timeTable.section,
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontWeight = FontWeight(500),
                        color = Color.White
                    )
                )
                Text(
                    text = "${timeTable.time} Min",
                    style = MaterialTheme.typography.labelSmall.copy(
                        fontWeight = FontWeight(300),
                        lineHeight = 15.12.sp,
                        color = Color.White
                    )
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ){
                Text(
                    text = timeTable.subject,
                    style = TextStyle(
                        fontFamily = jostFont,
                        fontWeight = FontWeight(800),
                        fontSize = 16.sp,
                        lineHeight = 17.6.sp,
                        color = Color.White
                    )
                )
                Text(
                    text = "- ${timeTable.chapter}",
                    style = TextStyle(
                        fontFamily = jostFont,
                        fontWeight = FontWeight(400),
                        fontSize = 14.sp,
                        lineHeight = 11.2.sp,
                        color = Color.White
                    )
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ){
                Icon(
                    painter = painterResource(R.drawable.clock),
                    contentDescription = "timer",
                    tint = Color.White,
                    modifier = Modifier.size(18.dp)
                )
                Text(
                    text = timeTable.timings,
                    style = MaterialTheme.typography.labelMedium,
                    color = Color.White
                )
            }
        }


    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CurrentTimeDisplay(currentTime: MutableState<String>) {

    LaunchedEffect(Unit) {
        while (true){
            val now = LocalDateTime.now()
            val formatter = DateTimeFormatter.ofPattern("HH:mm")
            currentTime.value = now.format(formatter)
            kotlinx.coroutines.delay(1000L)
        }
    }

}