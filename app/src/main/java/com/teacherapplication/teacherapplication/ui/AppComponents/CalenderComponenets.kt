package com.teacherapplication.teacherapplication.ui.AppComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teacherapplication.teacherapplication.ui.theme.openFont

fun splitTime(time: String): Triple<Int, Int, String>{
    val parts = time.split(":"," ").toMutableList()
    if (parts[2].uppercase() == "PM" && parts[0].toInt() != 12) {
        parts[0] = (parts[0].toInt() + 12).toString()
    } else if (parts[2].uppercase() == "AM" && parts[0].toInt() == 12) {
        parts[0] = "0"
    }
    return Triple(parts[0].toInt(), parts[1].toInt(), parts[2].uppercase())
}

@Composable
fun CustomCalendar2(daysInMonth: Int = 31) {
    val weeks = (daysInMonth / 7) + if (daysInMonth % 7 > 0) 1 else 0 // Calculate the number of weeks

    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Days of the Week Header
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            listOf("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat").forEach {
                Text(text = it, modifier = Modifier.padding(8.dp))
            }
        }

        // Calendar Days Grid
        for (week in 0 until weeks) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                for (day in 1..7) {
                    val dayNumber = week * 7 + day

                    if (dayNumber > daysInMonth) {
                        // Empty cell for days beyond the month's range
                        Box(modifier = Modifier.size(40.dp))
                    } else {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .background(Color.Gray),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "$dayNumber")
                        }
                    }
                }
            }
        }
    }
}



@Composable
fun CustomCalendar() {
    Column(
        modifier = Modifier.fillMaxWidth().padding(0.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            listOf("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat").forEach {
                Text(
                    text = it,
                    style = TextStyle(
                        fontFamily = openFont,
                        fontWeight = FontWeight(600),
                        fontSize = 17.29.sp,
                        lineHeight = 23.55.sp,
                        color = Color(0xFF1D1751)
                    ),
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
        for (week in 0..4) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                for (day in 1..7) {
                    val num = week * 7 + day
                    if (num>31) {
                        for (i in 1..4){
                            Box(
                                modifier = Modifier
                                    .size(32.dp)
                                    .clip(CircleShape)
                                    .background(Color.Transparent),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "$i",
                                    style = TextStyle(
                                        fontFamily = openFont,
                                        fontWeight = FontWeight(600),
                                        fontSize = 17.2.sp,
                                        lineHeight = 23.43.sp,
                                        color = Color.Black.copy(alpha = 0.2f)
                                    ),
                                )
                            }
                        }
                        break
                    }
                    else {
                        Box(
                            modifier = Modifier
                                .size(32.dp)
                                .clip(CircleShape)
                                .background(Color.Transparent),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "${week * 7 + day}",
                                style = TextStyle(
                                    fontFamily = openFont,
                                    fontWeight = FontWeight(600),
                                    fontSize = 17.2.sp,
                                    lineHeight = 23.43.sp,
                                    color = Color(0xFF636161)
                                ),
                            )
                        }
                    }
                }
            }
        }
    }
}