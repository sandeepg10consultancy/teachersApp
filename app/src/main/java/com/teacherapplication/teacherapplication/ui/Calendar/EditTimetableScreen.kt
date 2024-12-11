package com.teacherapplication.teacherapplication.ui.Calendar

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teacherapplication.teacherapplication.R
import com.teacherapplication.teacherapplication.ui.AppComponents.BackArrow
import com.teacherapplication.teacherapplication.ui.AppComponents.brush

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditTimetableScreen(){
    val scrollState = rememberScrollState()
    val daysList = listOf("M" to "08", "T" to "09", "W" to "10", "T" to "11", "F" to "12", "S" to "13", "S" to "14")
    val today = "10"
    val isCalenderOpen = remember { mutableStateOf(false) }
    val editClicked = remember { mutableStateOf(false) }
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
            BackArrow(onClick = { })
            Text(
                text = "Edit Timetable",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontSize = 20.sp,
                    lineHeight = 28.9.sp,
                    color = Color.Black
                ),
            )
            Icon(
                painter = painterResource(if (isCalenderOpen.value) R.drawable.close_calendar else R.drawable.display_calendar),
                contentDescription = "calendar",
                tint = Color(0xFF129193),
                modifier = Modifier
                    .size(24.dp)
                    .clickable {
                        isCalenderOpen.value = !isCalenderOpen.value
                    }
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        if (isCalenderOpen.value) {
            Box(
                modifier = Modifier
                    .height(55.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(7.96.dp))
                    .background(
                        brush = brush
                    )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Icon(
                        painter = painterResource(R.drawable.left_side),
                        contentDescription = "left",
                        tint = Color.White,
                        modifier = Modifier
                            .size(16.47.dp)
                            .clickable {

                            }
                    )
                    Text(
                        text = "August 2024",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontWeight = FontWeight(700),
                            color = Color.White
                        )
                    )
                    Icon(
                        painter = painterResource(R.drawable.right_side),
                        contentDescription = "right",
                        tint = Color.White,
                        modifier = Modifier
                            .size(16.47.dp)
                            .clickable {

                            }
                    )
                }
            }
            DashedLine(
                modifier = Modifier
                    .height(40.dp)
                    .fillMaxWidth(),
                color = Color(0xFF1D1751)
            )
            Spacer(modifier = Modifier.height(250.dp))
            DashedLine(
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth(),
                color = Color(0xFF5A5A5A)
            )
        } else {
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
        }
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
                text = "Add New Class",
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
        Spacer(modifier = Modifier.height(20.dp))

        timeTableList.forEach { timeTable ->
            EditTimetableCard(timeTable, editClicked)
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
    if (editClicked.value){
        ModalBottomSheet(
            onDismissRequest = { editClicked.value = false },
            dragHandle = { BottomSheetDefaults.HiddenShape }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp)
            ){
                Text(
                    text = "Edit Timetable",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Black,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
private fun EditTimetableCard(timeTable: TimeTable, editClicked: MutableState<Boolean>) {
    Card(
        modifier = Modifier
            .height(126.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,

            ) {
            SubjectBox(
                timeTable,
                modifier = Modifier.fillMaxWidth(0.85f)
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    painter = painterResource(R.drawable.time_table_edit),
                    contentDescription = "edit",
                    tint = Color(0xFF129193),
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            editClicked.value = true
                        }
                )
                Icon(
                    painter = painterResource(R.drawable.delete),
                    contentDescription = "edit",
                    tint = Color(0xFF129193),
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {

                        }
                )
            }
        }
    }
}