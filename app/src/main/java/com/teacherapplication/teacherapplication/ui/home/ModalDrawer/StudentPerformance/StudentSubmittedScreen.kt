package com.teacherapplication.teacherapplication.ui.home.ModalDrawer.StudentPerformance

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.teacherapplication.teacherapplication.R
import com.teacherapplication.teacherapplication.ui.AppComponents.BackArrow
import com.teacherapplication.teacherapplication.ui.AppComponents.SmallCircle
import com.teacherapplication.teacherapplication.ui.Diary.DailyDiaryScreen
import com.teacherapplication.teacherapplication.ui.home.dashboard.DashboardViewModel
import com.teacherapplication.teacherapplication.ui.theme.nunitoFont

@Composable
fun StudentSubmittedScreen(navController: NavHostController) {
    val scrollState = rememberScrollState()
    val selectedItem = remember { mutableStateOf("Completed") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(start = 15.dp, top = 40.dp, end = 15.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            BackArrow(onClick = { navController.popBackStack() })
            Text(
                text = "Student Performance",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth(0.95f),
                textAlign = TextAlign.Center
            )
        }
        ChapterWiseDetails(
            chapterNo = 1,
            chapterName = "All About Me",
            image = R.drawable.land,
            navController = navController
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ){
            Box(
                modifier = Modifier
                    .height(40.dp)
                    .fillMaxWidth(0.5f)
                    .clip(RoundedCornerShape(16.dp))
                    .background(
                        color = if(selectedItem.value == "Completed") Color(0xFF1D1751) else Color.Transparent
                    )
                    .clickable {
                        selectedItem.value = "Completed"
                    },
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = "Completed",
                    style = TextStyle(
                        fontFamily = nunitoFont,
                        fontWeight = FontWeight(if(selectedItem.value == "Completed") 600 else 400),
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        color = if(selectedItem.value == "Completed") Color.White else Color(0xFF1D1751)
                    )
                )
            }
            Box(
                modifier = Modifier
                    .height(40.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(
                        color = if(selectedItem.value == "Pending") Color(0xFF1D1751) else Color.Transparent
                    )
                    .clickable {
                        selectedItem.value = "Pending"
                    },
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = "Pending",
                    style = TextStyle(
                        fontFamily = nunitoFont,
                        fontWeight = FontWeight(if(selectedItem.value == "Pending") 600 else 400),
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        color = if(selectedItem.value == "Pending") Color.White else Color(0xFF1D1751)
                    )
                )
            }
        }

        AssignmentNameCard(selectedItem)
        AssignmentNameCard(selectedItem)
    }
}

@Composable
private fun AssignmentNameCard(selectedItem: MutableState<String>) {
    Card(
        modifier = Modifier
            .height(152.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "Assignment Name",
                        style = TextStyle(
                            fontFamily = nunitoFont,
                            fontWeight = FontWeight(700),
                            fontSize = 20.sp,
                            lineHeight = 16.sp,
                            color = Color(0xFF2093C3)
                        )
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Text(
                            text = "Science",
                            style = TextStyle(
                                fontFamily = nunitoFont,
                                fontWeight = FontWeight(500),
                                fontSize = 14.sp,
                                lineHeight = 11.2.sp,
                                color = Color(0xFF129193)
                            )
                        )
                        SmallCircle(
                            dim = 4.dp,
                            containerColor = Color(0xFF129193),
                            borderColor = Color.Transparent
                        )
                        Text(
                            text = "Topic-1",
                            style = TextStyle(
                                fontFamily = nunitoFont,
                                fontWeight = FontWeight(600),
                                fontSize = 14.sp,
                                lineHeight = 11.2.sp,
                                color = Color(0xFF1D1751)
                            )
                        )
                        SmallCircle(
                            dim = 4.dp,
                            containerColor = Color(0xFF129193),
                            borderColor = Color.Transparent
                        )
                        Text(
                            text = "Nursery- A",
                            style = TextStyle(
                                fontFamily = nunitoFont,
                                fontWeight = FontWeight(500),
                                fontSize = 14.sp,
                                lineHeight = 11.2.sp,
                                color = Color(0xFF129193)
                            )
                        )
                    }
                }
                if (selectedItem.value != "Completed") {
                    PendingBox()
                } else {
                    SubmittedBox()
                }

            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "Created by",
                        style = TextStyle(
                            fontFamily = nunitoFont,
                            fontWeight = FontWeight(500),
                            fontSize = 12.sp,
                            lineHeight = 9.6.sp,
                            color = Color(0xFF1D1751)
                        )
                    )
                    Text(
                        text = "Teacher",
                        style = TextStyle(
                            fontFamily = nunitoFont,
                            fontWeight = FontWeight(600),
                            fontSize = 14.sp,
                            lineHeight = 11.2.sp,
                            color = Color(0xFF129193)
                        )
                    )
                }
                Column {
                    Text(
                        text = "Created on",
                        style = TextStyle(
                            fontFamily = nunitoFont,
                            fontWeight = FontWeight(500),
                            fontSize = 12.sp,
                            lineHeight = 9.6.sp,
                            color = Color(0xFF1D1751)
                        )
                    )
                    Text(
                        text = "22 August 2024",
                        style = TextStyle(
                            fontFamily = nunitoFont,
                            fontWeight = FontWeight(600),
                            fontSize = 14.sp,
                            lineHeight = 11.2.sp,
                            color = Color(0xFF129193)
                        )
                    )
                }
                Column {
                    Text(
                        text = "Deadline",
                        style = TextStyle(
                            fontFamily = nunitoFont,
                            fontWeight = FontWeight(500),
                            fontSize = 12.sp,
                            lineHeight = 9.6.sp,
                            color = Color(0xFF1D1751)
                        )
                    )
                    Text(
                        text = "22 August 2024",
                        style = TextStyle(
                            fontFamily = nunitoFont,
                            fontWeight = FontWeight(600),
                            fontSize = 14.sp,
                            lineHeight = 11.2.sp,
                            color = Color(0xFF129193)
                        )
                    )
                }
            }
        }
    }
}

@Composable
private fun SubmittedBox() {
    Box(
        modifier = Modifier
            .height(25.dp)
            .width(73.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFF0D2A3F), Color(0xFF2679B4))
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Submitted",
            style = MaterialTheme.typography.labelSmall.copy(
                fontWeight = FontWeight(500),
                lineHeight = 9.6.sp,
                color = Color.White
            )
        )
    }
}

@Composable
private fun PendingBox() {
    Box(
        modifier = Modifier
            .height(25.dp)
            .width(73.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFFE67E22), Color(0xFFFFC261))
                )
            ),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "Pending",
            style = MaterialTheme.typography.labelSmall.copy(
                fontWeight = FontWeight(500),
                lineHeight = 9.6.sp,
                color = Color.White
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun StudentSubmittedScreenPreview(){
    val navController = rememberNavController()
    StudentSubmittedScreen(
        navController = navController,
    )
}