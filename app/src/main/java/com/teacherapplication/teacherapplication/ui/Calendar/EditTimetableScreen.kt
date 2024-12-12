package com.teacherapplication.teacherapplication.ui.Calendar

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import com.teacherapplication.teacherapplication.R
import com.teacherapplication.teacherapplication.ui.AppComponents.BackArrow
import com.teacherapplication.teacherapplication.ui.AppComponents.brush
import com.teacherapplication.teacherapplication.ui.theme.jostFont

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditTimetableScreen(){
    val scrollState = rememberScrollState()
    val daysList = listOf("M" to "08", "T" to "09", "W" to "10", "T" to "11", "F" to "12", "S" to "13", "S" to "14")
    val today = "10"
    val isCalenderOpen = remember { mutableStateOf(false) }
    val editClicked = remember { mutableStateOf(false) }
    val addNewClassClicked = remember { mutableStateOf(false) }
    val deleteClassDialog = remember { mutableStateOf(false) }
    val completedChapterDialog = remember { mutableStateOf(false) }
    val subjectName = remember { mutableStateOf("Science") }
    val chapterName = remember { mutableStateOf("Chapter -3   What is Living And Non Living...") }
    val topicName = remember { mutableStateOf("What is Living And Non Living Things........") }
    val subjectItems = listOf(
        "Science", "Mathematics", "Social", "Numeracy", "English"
    )
    val chapterItems = listOf(
        "Chapter -1   What is Living And Non Living..." to "Completed",
        "Chapter -2   What is Living And Non Living..." to "Pending",
        "Chapter -3   What is Living And Non Living..." to "Pending",
        "Chapter -4   What is Living And Non Living..." to "Pending",
        "Chapter -5   What is Living And Non Living..." to "Completed",
        "Chapter -6   What is Living And Non Living..." to "Completed",
        "Chapter -7   What is Living And Non Living..." to "Completed",
        "Chapter -8   What is Living And Non Living..." to "Completed",
    )
    val topicItems = listOf(
        "What is Living And Non Living Things........" to "Complete",
        "What is Living And Non Living Things........" to "Complete",
        "What is Living And Non Living Things........" to "Pending",
        "What is Living And Non Living Things........" to "Pending",
        "What is Living And Non Living Things........" to "Pending",
        "What is Living And Non Living Things........" to "Pending",
    )
    val subjectDropDown = remember { mutableStateOf(false) }
    val chapterDropDown = remember { mutableStateOf(false) }
    val topicDropDown = remember { mutableStateOf(false) }
    Box(modifier = Modifier
        .fillMaxSize()
    )
    {
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
                            addNewClassClicked.value = true
                        }

                )
            }
            Spacer(modifier = Modifier.height(20.dp))

            timeTableList.forEach { timeTable ->
                EditTimetableCard(timeTable, editClicked, deleteClassDialog)
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
        if (editClicked.value) {
            EditTimetableClicked(
                title = "Edit Timetable",
                buttonText = "Update",
                subjectName,
                subjectDropDown,
                scrollState,
                chapterName,
                chapterDropDown,
                chapterItems,
                topicName,
                topicDropDown,
                topicItems,
                editClicked,
                completedChapterDialog
            )
        }else if (addNewClassClicked.value){
            EditTimetableClicked(
                title = "Add New Class",
                buttonText = "Add",
                subjectName,
                subjectDropDown,
                scrollState,
                chapterName,
                chapterDropDown,
                chapterItems,
                topicName,
                topicDropDown,
                topicItems,
                addNewClassClicked,
                completedChapterDialog
            )
        }
        if (deleteClassDialog.value) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.5f))
            ) {
                Popup(
                    alignment = Alignment.Center,
                    properties = PopupProperties(focusable = true)
                ) {
                    Box(
                        modifier = Modifier
                            .height(218.dp)
                            .width(387.dp)
                            .clip(RoundedCornerShape(15.dp))
                            .background(color = Color.White),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(0.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Text(
                                text = "Are you sure you want to delete this class ?",
                                style = MaterialTheme.typography.bodyLarge.copy(
                                    fontWeight = FontWeight(400),
                                    color = Color.Black
                                ),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 20.dp),
                                textAlign = TextAlign.Center
                            )
                            Spacer(modifier = Modifier.height(50.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ){
                                EditCancelButton(deleteClassDialog)
                                EditAddBox(text = "Delete")
                            }
                        }
                    }
                }
            }

        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun EditTimetableClicked(
    title: String,
    buttonText: String,
    subjectName: MutableState<String>,
    subjectDropDown: MutableState<Boolean>,
    scrollState: ScrollState,
    chapterName: MutableState<String>,
    chapterDropDown: MutableState<Boolean>,
    chapterItems: List<Pair<String, String>>,
    topicName: MutableState<String>,
    topicDropDown: MutableState<Boolean>,
    topicItems: List<Pair<String, String>>,
    editClicked: MutableState<Boolean>,
    completedChapterDialog: MutableState<Boolean>
) {
    ModalBottomSheet(
        sheetState = rememberModalBottomSheetState(),
        onDismissRequest = {
            editClicked.value = false
        },
        dragHandle = { BottomSheetDefaults.ExpandedShape},
        containerColor = Color.White
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp, bottom = 10.dp),
                textAlign = TextAlign.Center
            )
            EditTimeTableSelection(
                label = "Subject",
                subjectName,
                subjectDropDown,
                scrollState,
                completedChapterDialog = completedChapterDialog
            )

            EditTimeTableSelection(
                label = "Chapter",
                chapterName,
                chapterDropDown,
                scrollState,
                chapterItems,
                completedChapterDialog
            )

            EditTimeTableSelection(
                label = "Topic",
                topicName,
                topicDropDown,
                scrollState,
                topicItems,
                completedChapterDialog
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(3.dp)
                ) {
                    Text(
                        text = "Start Time",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Black
                    )
                    EditTimeBox(time = "10:00 AM")
                }
                Column(
                    verticalArrangement = Arrangement.spacedBy(3.dp)
                ) {
                    Text(
                        text = "End Time",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Black
                    )
                    EditTimeBox(time = "10:30 AM")
                }
            }
            Spacer(modifier = Modifier.height(50.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                EditCancelButton(editClicked)

                EditAddBox(buttonText)

            }
            if (completedChapterDialog.value) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.Black.copy(alpha = 0.5f))
                ) {
                    Popup(
                        alignment = Alignment.Center,
                        properties = PopupProperties(focusable = true)
                    ) {
                        Box(
                            modifier = Modifier
                                .height(284.dp)
                                .width(387.dp)
                                .clip(RoundedCornerShape(15.dp))
                                .background(color = Color.White)
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.alert_pop_up),
                                    contentDescription = "alert",
                                    modifier = Modifier.size(100.dp)
                                )
                                Text(
                                    text = "You've selected a completed chapter. \n" +
                                            "Do you want to schedule class on this chapter again?",
                                    style = MaterialTheme.typography.bodySmall,
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = TextAlign.Center
                                )
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceEvenly
                                ) {
                                    EditCancelButton(completedChapterDialog)
                                    EditAddBox(text = "Yes")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun EditAddBox(text: String) {
    Box(
        modifier = Modifier
            .height(54.dp)
            .width(180.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(
                brush = brush,
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.elephant_button),
                contentDescription = "elephant",
                modifier = Modifier
                    .height(52.dp)
                    .width(47.68.dp)
            )
            Text(
                text = text,
                style = TextStyle(
                    fontFamily = jostFont,
                    fontWeight = FontWeight(400),
                    fontSize = 16.sp,
                    lineHeight = 12.sp,
                    letterSpacing = 0.15.sp,
                    color = Color.White,
                )
            )
        }
    }
}

@Composable
private fun EditCancelButton(editClicked: MutableState<Boolean>) {
    TextButton(
        onClick = { editClicked.value = false },
        modifier = Modifier
            .height(54.dp)
            .width(180.dp)
            .clip(RoundedCornerShape(5.dp))
            .border(
                width = 1.dp,
                brush = brush,
                shape = RoundedCornerShape(5.dp)
            )
    ) {
        Text(
            text = "Cancel",
            style = TextStyle(
                fontFamily = jostFont,
                fontWeight = FontWeight(400),
                fontSize = 16.sp,
                lineHeight = 12.sp,
                letterSpacing = 0.15.sp,
                brush = brush
            )
        )
    }
}

@Composable
private fun EditTimeBox(time: String) {
    Box(
        modifier = Modifier
            .height(52.dp)
            .width(180.dp)
            .clip(RoundedCornerShape(6.dp))
            .border(
                width = 2.dp,
                brush = brush,
                shape = RoundedCornerShape(6.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = time,
                style = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight(500)
                ),
                color = Color(0xFF707070)
            )
            Image(
                painter = painterResource(R.drawable.edit_clock),
                contentDescription = "clock",
                modifier = Modifier
                    .size(24.dp)
            )
        }
    }
}

@Composable
private fun EditTimeTableSelection(
    label: String,
    subjectName: MutableState<String>,
    showDropDown: MutableState<Boolean>,
    scrollState: ScrollState,
    chapterItems: List<Pair<String, String>> = listOf("" to ""),
    completedChapterDialog: MutableState<Boolean>
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(3.dp)
    ){
        Text(
            text = "Select $label",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Black
        )
        OutlinedTextField(
            value = subjectName.value,
            onValueChange = { subjectName.value = it },
            modifier = Modifier
                .height(52.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(6.dp))
                .border(
                    width = 2.dp,
                    brush = brush,
                    shape = RoundedCornerShape(6.dp)
                ),
            textStyle = MaterialTheme.typography.bodySmall.copy(
                color = Color.Black
            ),
            readOnly = true,
            trailingIcon = {
                Image(
                    painter = painterResource(if (showDropDown.value) R.drawable.time_table_drop_up else R.drawable.time_table_drop_down),
                    contentDescription = "drop",
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            showDropDown.value = !showDropDown.value
                        }
                )
            }
        )
        if (label != "Subject")
        DropdownMenu(
            expanded = showDropDown.value,
            onDismissRequest = { showDropDown.value = false },
            modifier = Modifier
                .height(340.dp)
                .width(382.dp)
                .background(
                    color = Color.White
                )
                .clip(RoundedCornerShape(20.dp))
                .padding(horizontal = 10.dp),
            scrollState = rememberScrollState(),
        ) {
            Box(
                modifier = Modifier
                    .height(340.dp)
                    .width(382.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState)
                        .padding()
                ) {
                    chapterItems.forEachIndexed { index, item ->
                        DropdownMenuItem(
                            onClick = {
                                if (item.second == "Completed") completedChapterDialog.value = true
                                subjectName.value = item.first
                            },
                            text = {
                                Column {
                                    Spacer(modifier = Modifier.height(10.dp))
                                    Text(
                                        text = item.first,
                                        style = MaterialTheme.typography.bodySmall
                                    )
                                    Spacer(modifier = Modifier.height(5.dp))
                                    Text(
                                        text = item.second,
                                        style = MaterialTheme.typography.labelSmall.copy(
                                            lineHeight = 15.12.sp,
                                            color = Color(0xFF2D9549)
                                        )
                                    )
                                }
                            },
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        if (index < chapterItems.size - 1) {
                            HorizontalDivider(
                                thickness = 1.dp,
                                color = Color(0xFFE3E3E3),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 5.dp, end = 15.dp)
                            )
                        }
                    }
                }
                val scrollProgress =
                    (scrollState.value.toFloat() / scrollState.maxValue.toFloat())
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                ) {
                    Box(
                        modifier = Modifier
                            .width(5.dp)
                            .height(340.dp)
                            .padding(vertical = 15.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color(0xFFD9D9D9))
                    )
                    Box(
                        modifier = Modifier
                            .width(8.dp)
                            .height(33.dp)
                            .offset(x = (-1).dp, y = (scrollProgress * 300.dp))
                            .clip(RoundedCornerShape(10.dp))
                            .background(brush = brush)
                    )
                }
            }
        }
    }
}


@Composable
private fun EditTimetableCard(
    timeTable: TimeTable,
    editClicked: MutableState<Boolean>,
    deleteClassDialog: MutableState<Boolean>
) {
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
                            deleteClassDialog.value = true
                        }
                )
            }
        }
    }

}