package com.teacherapplication.teacherapplication.ui.SubjectChapterList.ArtContent

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
import androidx.compose.foundation.layout.requiredSizeIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.teacherapplication.teacherapplication.R
import com.teacherapplication.teacherapplication.ui.AppComponents.BackArrow
import com.teacherapplication.teacherapplication.ui.AppComponents.TopProgressBar
import com.teacherapplication.teacherapplication.ui.home.dashboard.BottomNavigationBar
import com.teacherapplication.teacherapplication.ui.home.dashboard.DashboardViewModel
import com.teacherapplication.teacherapplication.ui.theme.jostFont

val contentList = listOf("Lesson Plans", "Assessments", "Videos", "Ebooks")

@Composable
fun ContentViewScreen(navController: NavHostController, viewModel: DashboardViewModel) {
    val verticalScroll = rememberScrollState()
    var dropDownStatus by remember { mutableStateOf(false) }
    var isCardClicked by remember { mutableStateOf(true) }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Column(
            modifier = Modifier.fillMaxSize()
                .verticalScroll(verticalScroll)
        ) {
            TopProgressBar()
            Column(
                modifier = Modifier
                    .padding(15.dp)
            ){
                BackArrow {navController.popBackStack()}
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    ClassSubjectBox()
                    DropDownBar(
                        dropDownStatus = dropDownStatus,
                        onDropDownStatusChange = {dropDownStatus = it}
                        )
                }
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = "1.Flower",
                    style = MaterialTheme.typography.titleMedium.copy(
                        lineHeight = 14.4.sp
                    ),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(30.dp))
                Box(
                    modifier = Modifier,
                    contentAlignment = Alignment.CenterEnd
                ){
                    HorizontalDivider()
                    Row(modifier = Modifier.padding(end = 10.dp)){
                        ChapterObjectives()
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                TopicContentRow(contentList, navController = navController)
            }
        }
        if (dropDownStatus){
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.2f))
                    .clickable { dropDownStatus = false }
            )
        }
        if (isCardClicked) {
            BottomAppBar(
                modifier = Modifier.align(Alignment.BottomCenter),
                containerColor = Color.White
            ) {
                BottomNavigationBar(navController, viewModel)
            }
        }
    }
}

@Composable
fun TopicContentRow(courseContent: List<String>, navController: NavHostController) {
    var selectedContent by remember { mutableStateOf(courseContent[0]) }

    LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)){
        items(courseContent) { content ->
            val isSelected = content == selectedContent
            TopicContent(
                course = content,
                isSelected = isSelected,
                onCourseSelected = { selectedContent = it})
        }
    }
    Column(modifier = Modifier.padding(top = 10.dp)){
        when (selectedContent) {
            "Lesson Plans" -> {
                lessonPlans.forEach { lesson ->
                    LessonPlansCard(lesson.title,lesson.time)
                }
            }
            "Assessments" -> AssessmentsCards(navController = navController)
            "Videos" -> VideosCards(navController = navController)
            "Ebooks" -> EbooksCards(navController = navController)
        }
    }
}

@Composable
fun TopicContent(course: String, isSelected: Boolean, onCourseSelected: (String) -> Unit,) {

    TextButton(
        onClick = {
            onCourseSelected(course)

        },
        modifier = Modifier,
    ) {
        Text(
            text = course,
            style = MaterialTheme.typography.titleMedium.copy(
                color = if (isSelected) Color(0xFF1D1751) else Color.Gray,
                fontWeight = if (isSelected) FontWeight(600) else FontWeight(400),

                ),
            modifier = Modifier
                .padding(bottom = 4.dp)
                .drawWithContent {
                    drawContent()
                    if (isSelected){
                        val gap = 8.dp.toPx()
                        drawLine(
                            color = Color(0xFF1D1751),
                            start = Offset(0f, size.height + gap),
                            end = Offset(size.width, size.height + gap),
                            strokeWidth = 2.dp.toPx(),
                            cap = StrokeCap.Round
                        )
                    }
                }
        )
    }
}



@Composable
private fun ChapterObjectives() {
    Box(
        modifier = Modifier
            .height(28.dp)
            .width(136.dp)
            .background(Color.White)
            .border(
                width = 1.dp,
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFF185573), Color(0xFF14868D))
                ),
                shape = RoundedCornerShape(14.dp)
            )
            .padding(3.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Chapter Objectives",
            style = MaterialTheme.typography.bodySmall.copy(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFF185573), Color(0xFF14868D))
                ),
                lineHeight = 11.2.sp,
                fontSize = 13.sp
            ),
        )
    }
}


@Composable
fun ClassSubjectBox() {
    Box(
        modifier = Modifier
            .height(30.dp)
            .width(169.dp)
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
                color = Color.White
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
            VerticalDivider(
                modifier = Modifier.height(14.dp),
                color = Color.White
            )
            Text(
                text = "CH1",
                style = MaterialTheme.typography.titleSmall.copy(
                    fontSize = 12.sp,
                    fontWeight = FontWeight(400),
                    lineHeight = 9.6.sp,
                    color = Color(0xFFFFFFFF)
                )
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownBar(dropDownStatus: Boolean, onDropDownStatusChange: (Boolean) -> Unit)
{
    var dropDownDialog by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf("In progress") }
    var selectedColor by remember { mutableStateOf(Color(0xFFFFA043).copy(alpha = 0.1f)) }
    var selectedTextColor by remember { mutableStateOf(Color(0xFFFFA043)) }
    var selectedIcon by remember { mutableStateOf(R.drawable.in_progress) }

    val items = listOf(
        "In progress" to Pair(Color(0xFFFFA043).copy(alpha = 0.1f), R.drawable.in_progress),
        "Completed" to Pair(Color(0xFF2D9549).copy(alpha = 0.1f), R.drawable.completed),
    )
    Column {
        Box(
            modifier = Modifier
                .height(30.dp)
                .width(143.dp)
                .background(
                    color = selectedColor,
                    shape = RoundedCornerShape(15.dp)
                )
                .clickable { onDropDownStatusChange(true) }
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 8.dp, end = 8.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(selectedIcon),
                    contentDescription = selectedItem,
                    modifier = Modifier.size(18.dp)
                )
                Text(
                    text = selectedItem,
                    style = TextStyle(
                        fontFamily = jostFont,
                        fontSize = 14.sp,
                        fontWeight = FontWeight(400),
                        lineHeight = 11.2.sp,
                        color = selectedTextColor
                    )
                )
                Image(
                    painter = painterResource(R.drawable.down_arrow),
                    contentDescription = "Dropdown Arrow",
                    modifier = Modifier.size(18.dp)
                )
            }
        }
        DropdownMenu(
            expanded = dropDownStatus,
            onDismissRequest = { onDropDownStatusChange(false) },
            modifier = Modifier.requiredSizeIn(maxHeight = 200.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.White)
                .width(143.dp)
                .padding(start = 10.dp, end = 10.dp)
        ) {
            items.forEachIndexed { index, item ->
                DropdownMenuItem(
                    onClick = {
                        selectedItem = item.first
                        selectedColor = item.second.first
                        selectedIcon = item.second.second
                        selectedTextColor = when (item.first) {
                            "In progress" -> Color(0xFFFFA043)
                            "Completed" -> Color(0xFF2D9549)
                            else -> Color.Black
                        }
                        onDropDownStatusChange(false)
                        dropDownDialog = true
                    },
                    text = {
                        Row(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Image(
                                painter = painterResource(item.second.second),
                                contentDescription = item.first,
                                modifier = Modifier.size(18.dp)
                            )
                            Text(
                                text = item.first,
                                style = TextStyle(
                                    fontFamily = jostFont,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight(400),
                                    lineHeight = 11.2.sp,
                                    color = when (item.first) {
                                        "In progress" -> Color(0xFFFFA043)
                                        "Completed" -> Color(0xFF2D9549)
                                        else -> Color.Black
                                    }
                                ),
                                modifier = Modifier.padding(start = 8.dp)
                            )
                        }
                    }
                )
                if (index < (items.size - 1)) {
                    HorizontalDivider(
                        modifier = Modifier.padding(bottom = 5.dp)
                    )
                }
            }
        }
    }
    if (dropDownDialog && (selectedItem == "Completed")){
        BasicAlertDialog(onDismissRequest = { dropDownDialog = false },
            modifier = Modifier.height(218.dp)
                .width(387.dp)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(15.dp)
                )
                .padding(0.dp),
            content = {
                Column(
                    modifier = Modifier.fillMaxSize()
                        .padding(start = 8.dp, top = 30.dp, end = 8.dp, bottom = 10.dp),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(
                        text = "Are you sure you want to change the Topic Status from In Progress to Completed ?",
                        style = MaterialTheme.typography.bodySmall.copy(
                            fontSize = 18.sp,
                            lineHeight = 22.68.sp
                        ),
                        textAlign = TextAlign.Center
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .padding(start = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        TextButton(onClick = {
                            dropDownDialog = false
                            selectedItem = "In progress"
                            selectedIcon = R.drawable.in_progress
                            selectedColor = Color(0xFFFFA043).copy(alpha = 0.1f)
                            selectedTextColor = Color(0xFFFFA043)
                        }) {
                            Text(
                                text = "Cancel",
                                style = TextStyle(
                                    fontFamily = jostFont,
                                    fontWeight = FontWeight(400),
                                    fontSize = 18.sp,
                                    lineHeight = 20.sp,
                                    brush = Brush.linearGradient(
                                        colors = listOf(Color(0xFF185573), Color(0xFF14868D))
                                    )
                                )
                            )
                        }
                        Box(
                            modifier = Modifier.height(47.dp)
                                .width(170.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(
                                    brush = Brush.linearGradient(
                                        colors = listOf(Color(0xFF185573), Color(0xFF14868D))
                                    )
                                )
                                .clickable {
                                    dropDownDialog = false
                                    selectedItem = "Completed"
                                    selectedIcon = R.drawable.completed
                                    selectedColor = Color(0xFF2D9549).copy(alpha = 0.1f)
                                    selectedTextColor = Color(0xFF2D9549)
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Yes",
                                style = TextStyle(
                                    fontFamily = jostFont,
                                    fontWeight = FontWeight(400),
                                    fontSize = 18.sp,
                                    lineHeight = 20.sp,
                                    color = Color.White
                                )
                            )
                        }
                    }
                }
            },
        )
    }
}