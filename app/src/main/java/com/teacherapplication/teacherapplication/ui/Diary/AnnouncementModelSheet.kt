package com.teacherapplication.teacherapplication.ui.Diary

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teacherapplication.teacherapplication.R
import com.teacherapplication.teacherapplication.ui.AppComponents.brush
import com.teacherapplication.teacherapplication.ui.theme.italicJost
import com.teacherapplication.teacherapplication.ui.theme.jostFont
import com.teacherapplication.teacherapplication.ui.theme.openFont

@Composable
fun AnnouncementModelSheet(modifier: Modifier = Modifier, onClick: () -> Unit = {}){
    val announcementType = remember { mutableStateOf("") }
    val subjectType = remember { mutableStateOf("") }
    val priorityType = remember { mutableStateOf("") }
    val festivalType = remember { mutableStateOf("") }
    val announcementDropDown = remember { mutableStateOf(false) }
    val subjectDropDown = remember { mutableStateOf(false) }
    val priorityDropDown = remember { mutableStateOf(false) }
    val festivalDropDown = remember { mutableStateOf(false) }
    val announcementList = listOf("Bring to School", "Holiday Alert", "Homework", "Notice", "Special Request")
    val subjectList = listOf("Mathematics", "Science", "English", "GK", "General Awareness")
    val priorityList = listOf("High", "Medium", "Low")
    val festivalList = listOf("Ganesh Festival", "Sankranti", "Republic Day","Independence Day")
    val descriptionField = remember { mutableStateOf("") }
    val fromDateField = remember { mutableStateOf("") }
    val dueDateField = remember { mutableStateOf("") }
    val isCalenderOpen = remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(10.dp)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ){
        Text(
            text = "Announcement",
            style = TextStyle(
                fontFamily = jostFont,
                fontWeight = FontWeight(500),
                fontSize = 20.sp,
                lineHeight = 28.9.sp,
                color = Color(0xFF1D1751)
            ),
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        TypeOfDropDown(title = "Announcement Type", labelText = "Select any type",announcementType, announcementDropDown, announcementList)
        TypeOfDropDown(title = "Select Subject", labelText = "Select Subject",subjectType, subjectDropDown, subjectList)

        when(announcementType.value){
            "Bring to School" -> {
                DescriptionField(descriptionField)
                UploadDocumentBox()
                SelectDateBox(title = "Bring on", labelText = "Select Date",dueDateField, isCalenderOpen)
                TypeOfDropDown(title = "Priority", labelText = "Select Priority",priorityType, priorityDropDown, priorityList)
            }
            "Holiday Alert" ->{
                TypeOfDropDown(title = "Select Occasion", labelText = "Select Festival",festivalType, festivalDropDown, festivalList)
                DescriptionField(descriptionField)
                UploadDocumentBox()
                SelectDateBox(title = "From Date", labelText = "Select from Date",fromDateField, isCalenderOpen)
                SelectDateBox(title = "End Date", labelText = "Select end Date",dueDateField, isCalenderOpen)
            }
            "Notice" -> {
                DescriptionField(descriptionField)
                UploadDocumentBox()
                SelectDateBox(title = "From Date", labelText = "Select from Date",fromDateField, isCalenderOpen)
                SelectDateBox(title = "End Date", labelText = "Select end Date",dueDateField, isCalenderOpen)
            }
            "Homework" -> {
                DescriptionField(descriptionField)
                UploadDocumentBox()
                SelectDateBox(title = "End Date", labelText = "Select end Date",dueDateField, isCalenderOpen)
                TypeOfDropDown(title = "Priority", labelText = "Select Priority",priorityType, priorityDropDown, priorityList)
            }
            else -> {
                DescriptionField(descriptionField)
                UploadDocumentBox()
                SelectDateBox(title = "Due Date", labelText = "Set Due Date",dueDateField, isCalenderOpen)
                TypeOfDropDown(title = "Priority", labelText = "Select Priority",priorityType, priorityDropDown, priorityList)
            }
        }
        Spacer(modifier = Modifier.height(5.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Box(
                modifier = Modifier
                    .height(53.dp)
                    .width(180.dp)
                    .border(
                        width = 1.dp,
                        brush = brush,
                        shape = RoundedCornerShape(5.dp)
                    )
                    .clickable {
                        onClick()
                    },
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = "CANCEL",
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
            Box(
                modifier = Modifier
                    .height(53.dp)
                    .width(180.dp)
                    .background(
                        brush = brush,
                        shape = RoundedCornerShape(5.dp)
                    )
                    .clickable {

                    },
                contentAlignment = Alignment.Center
            ){
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 15.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ){
                    Image(
                        painter = painterResource(R.drawable.elephant_button),
                        contentDescription = "elephant"
                    )
                    Text(
                        text = "ADD",
                        style = TextStyle(
                            fontFamily = jostFont,
                            fontWeight = FontWeight(400),
                            fontSize = 16.sp,
                            lineHeight = 12.sp,
                            letterSpacing = 0.15.sp,
                            color = Color.White
                        )
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(50.dp))
    }
}

@Composable
private fun SelectDateBox(
    title: String,
    labelText: String,
    dueDateField: MutableState<String>,
    isCalenderOpen: MutableState<Boolean>,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            text = title,
            style = TextStyle(
                fontFamily = jostFont,
                fontWeight = FontWeight(500),
                fontSize = 16.sp,
                lineHeight = 23.12.sp,
                color = Color.Black
            ),
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Start
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .border(
                    width = 1.dp,
                    brush = brush,
                    shape = RoundedCornerShape(4.dp)
                )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextField(
                    value = dueDateField.value,
                    onValueChange = { dueDateField.value = it },
                    modifier = Modifier
                        .fillMaxWidth(0.9f),
                    placeholder = {
                        Text(
                            text = labelText,
                            style = MaterialTheme.typography.bodySmall.copy(
                                fontWeight = FontWeight(500),
                                color = Color(0xFF707070)
                            )
                        )
                    },
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                    ),
                    textStyle = MaterialTheme.typography.bodySmall.copy(
                        fontWeight = FontWeight(500),
                        color = Color.Black
                    ),
                    readOnly = true
                )
                Icon(
                    painter = painterResource(R.drawable.due_calender),
                    contentDescription = "dropDown",
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            isCalenderOpen.value = true
                        },
                    tint = Color(0xFF129193)
                )
            }
        }
    }
}

@Composable
private fun UploadDocumentBox() {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            text = "Upload Document",
            style = TextStyle(
                fontFamily = jostFont,
                fontWeight = FontWeight(500),
                fontSize = 16.sp,
                lineHeight = 23.12.sp,
                color = Color.Black
            ),
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Start
        )
        Box(
            modifier = Modifier
                .height(162.dp)
                .width(386.dp)
                .background(
                    color = Color(0xFFB6DFE6).copy(alpha = 0.15f),
                    shape = RoundedCornerShape(20.dp)
                )
                .border(
                    width = 1.dp,
                    color = Color.Transparent,
                    shape = RoundedCornerShape(20.dp)
                )
                .drawBehind {
                    val borderWidth = 1.dp.toPx()
                    val dashWidth = 5.dp.toPx()
                    val dashGap = 5.dp.toPx()
                    val paint = Paint().apply {
                        strokeWidth = borderWidth
                        pathEffect = PathEffect.dashPathEffect(floatArrayOf(dashWidth, dashGap), 0f)
                    }
                    drawRoundRect(
                        brush = brush,
                        size = size,
                        style = Stroke(width = borderWidth, pathEffect = paint.pathEffect),
                        cornerRadius = CornerRadius(20.dp.toPx())
                    )
                }
                .padding(20.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.upload_icon),
                        contentDescription = "upload",
                        modifier = Modifier.size(24.dp)
                    )
                    Text(
                        text = "Upload Doc",
                        style = MaterialTheme.typography.labelLarge.copy(
                            brush = Brush.linearGradient(
                                colors = listOf(Color(0xFF185573), Color(0xFF14868D))
                            ),
                            fontSize = 18.sp,
                            lineHeight = 12.sp,
                            letterSpacing = 0.15.sp
                        )
                    )
                }
                Text(
                    text = "Supports: JPEG , PNG. Keep the files under 5MB.",
                    style = MaterialTheme.typography.labelSmall.copy(
                        fontSize = 12.sp,
                        lineHeight = 12.sp,
                        letterSpacing = 0.15.sp,
                        color = Color(0xFF5A5A5A)
                    )
                )
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    ),
                    enabled = true,
                    modifier = Modifier
                        .width(296.dp)
                        .height(53.dp)
                        .background(
                            brush = Brush.linearGradient(
                                colors = listOf(Color(0xFF185573), Color(0xFF14868D))
                            ),
                            shape = RoundedCornerShape(5.dp)
                        )
                ) {
                    Text(
                        text = "Browse Files",
                        style = TextStyle(
                            fontFamily = openFont,
                            color = Color.White,
                            fontWeight = FontWeight(600),
                            fontSize = 16.sp,
                            lineHeight = 12.sp,
                            letterSpacing = 0.15.sp
                        )
                    )
                }
            }
        }
        // if () Have to give condition
        Text(
            text = "Uploaded Files",
            style = TextStyle(
                fontFamily = jostFont,
                fontWeight = FontWeight(500),
                fontSize = 16.sp,
                lineHeight = 23.12.sp,
                color = Color.Black
            ),
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Start
        )
        FilesUploadingCard()
        Spacer(modifier = Modifier.height(10.dp))
        FilesUploadingCard(1f)
    }
}

@Composable
private fun FilesUploadingCard( progress: Float = 0.5f) {
    Card(
        modifier = Modifier
            .height(81.dp)
            .width(386.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF75B6E4).copy(alpha = 0.1f)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 15.dp, end = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.pdf),
                contentDescription = "pdf",
                modifier = Modifier.size(29.dp)
            )
            Column() {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "Filename.pdf",
                            style = TextStyle(
                                fontFamily = jostFont,
                                fontWeight = FontWeight(400),
                                fontSize = 14.sp,
                                lineHeight = 20.23.sp,
                                color = Color(0xFF1D1751)
                            )
                        )
                        Text(
                            text = if (progress == 1f) "Completed" else "Uploading",
                            style = TextStyle(
                                fontFamily = italicJost,
                                fontWeight = FontWeight(400),
                                fontSize = 14.sp,
                                lineHeight = 11.2.sp,
                                color = if (progress == 1f) Color(0xFF2679B4) else Color(0xFFEF6464)
                            )
                        )
                    }
                    Icon(
                        painter = painterResource( if (progress == 1f) R.drawable.delete else R.drawable.close),
                        contentDescription = "close",
                        modifier = Modifier
                            .size(24.dp)
                            .clickable {

                            },
                        tint = Color(0xFF129193)
                    )
                }
                Spacer(modifier = Modifier.height(5.dp))
                Box(
                    modifier = Modifier
                        .height(5.dp)
                        .fillMaxWidth()
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(20.dp)
                        )
                ) {
                    Canvas(modifier = Modifier.fillMaxSize()) {
                        drawRoundRect(
                            color = Color(0xFF25A455),
                            size = Size(size.width * progress, size.height),
                            cornerRadius = CornerRadius(20.dp.toPx())
                        )
                    }
                }

            }
        }
    }
}

@Composable
private fun DescriptionField(descriptionField: MutableState<String>) {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            text = "Description",
            style = TextStyle(
                fontFamily = jostFont,
                fontWeight = FontWeight(500),
                fontSize = 16.sp,
                lineHeight = 23.12.sp,
                color = Color.Black
            ),
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Start
        )
        Box(
            modifier = Modifier
                .height(148.dp)
                .width(390.dp)
                .border(
                    width = 2.dp,
                    brush = brush,
                    shape = RoundedCornerShape(6.dp)
                )
        ) {
            TextField(
                value = descriptionField.value,
                onValueChange = { descriptionField.value = it },
                modifier = Modifier.fillMaxSize(),
                placeholder = {
                    Text(
                        text = "Type here",
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = Color.Black.copy(alpha = 0.4f)
                        )
                    )
                },
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                ),
                textStyle = TextStyle(
                    fontFamily = jostFont,
                    fontWeight = FontWeight(400),
                    fontSize = 16.sp,
                    lineHeight = 23.12.sp,
                    color = Color.Black
                )
            )
        }
    }
}

@Composable
private fun TypeOfDropDown(
    title: String,
    labelText: String,
    titleType: MutableState<String>,
    dropDownType: MutableState<Boolean>,
    listType: List<String>
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            text = title,
            style = TextStyle(
                fontFamily = jostFont,
                fontWeight = FontWeight(500),
                fontSize = 16.sp,
                lineHeight = 23.12.sp,
                color = Color.Black
            ),
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Start
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .border(
                    width = 1.dp,
                    brush = brush,
                    shape = RoundedCornerShape(4.dp)
                )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextField(
                    value = titleType.value,
                    onValueChange = { titleType.value = it },
                    modifier = Modifier
                        .fillMaxWidth(0.9f),
                    placeholder = {
                        Text(
                            text = labelText,
                            style = MaterialTheme.typography.bodySmall.copy(
                                fontWeight = FontWeight(500),
                                lineHeight = 24.sp,
                                letterSpacing = 0.5.sp,
                                color = Color.Black.copy(alpha = 0.4f)
                            )
                        )
                    },
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                    ),
                    textStyle = MaterialTheme.typography.labelSmall.copy(
                        fontWeight = FontWeight( if (title == "Announcement Type") 600 else 500),
                        fontSize = 16.sp,
                        color = Color.Black
                    ),
                    readOnly = true
                )
                Icon(
                    painter = painterResource(R.drawable.drop_down_arrow),
                    contentDescription = "dropDown",
                    modifier = Modifier
                        .height(10.19.dp)
                        .width(16.5.dp)
                        .clickable {
                            dropDownType.value = true
                        },
                    tint = Color(0xFF129193)
                )
            }
        }
        DropdownMenu(
            expanded = dropDownType.value,
            onDismissRequest = { dropDownType.value = false },
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(Color.White)
                .width(391.dp)
                .padding(start = 0.dp, end = 10.dp)
        ) {
            listType.forEachIndexed { index, type ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = type,
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontWeight = FontWeight(500),
                                fontSize = 16.sp,
                                color = Color.Black.copy(alpha = 0.6f)
                            )
                        )
                    },
                    onClick = {
                        titleType.value = type
                        dropDownType.value = false
                    }
                )
                if (index < (listType.size - 1)) {
                    HorizontalDivider(
                        thickness = 0.5.dp,
                        color = Color.Black.copy(alpha = 0.1f),
                        modifier = Modifier.padding(start = 10.dp)
                    )
                }
            }
        }
    }
}