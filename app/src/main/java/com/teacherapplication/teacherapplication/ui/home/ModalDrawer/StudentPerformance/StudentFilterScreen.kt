package com.teacherapplication.teacherapplication.ui.home.ModalDrawer.StudentPerformance

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.teacherapplication.teacherapplication.ui.AppComponents.BackArrow
import com.teacherapplication.teacherapplication.ui.Diary.DailyDiaryScreen
import com.teacherapplication.teacherapplication.ui.home.dashboard.DashboardViewModel

@Composable
fun StudentFilterScreen(navController: NavHostController) {
    val scrollState = rememberScrollState()
    val classesList = mapOf(
        "Nursery" to listOf("Section - A", "Section - B", "Section - C", "Section - D", "Section - E"),
        "Junior KG" to listOf("Section - A", "Section - B", "Section - C", "Section - D", "Section - E"),
        "Senior KG" to listOf("Section - A", "Section - B", "Section - C", "Section - D", "Section - E"),
    )
    val selectedSection = remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(start = 15.dp, top = 40.dp, end = 15.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
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
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "Select Class",
            style = MaterialTheme.typography.titleMedium,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(5.dp))
        classesList.forEach { item ->
            item.value.forEach { section ->
                EachSectionBox(
                    classTitle = item.key,
                    sectionTitle = section,
                    selectedSection = selectedSection,
                    navController = navController
                )
            }
        }
        Spacer(modifier = Modifier.height(50.dp))
    }
}

@Composable
private fun EachSectionBox(
    classTitle: String,
    sectionTitle: String,
    selectedSection: MutableState<String>,
    navController: NavHostController
) {
    val sectionId = (classTitle + sectionTitle)
    val isSelected = sectionId == selectedSection.value
    val textColor = if (isSelected) Color.White else Color(0xFF1D1751)
    Box(
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .border(
                width = 2.dp,
                color = Color(0xFF1D1751),
                shape = RoundedCornerShape(8.dp)
            )
            .background(
                color = if (isSelected) Color(0xFF1D1751) else Color.White,
            )
            .clickable {
                if (selectedSection.value == sectionId){
                    navController.navigate(route = "studentListScreen")
                }
                selectedSection.value = sectionId
            },
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = classTitle,
                style = MaterialTheme.typography.titleMedium.copy(
                    lineHeight = 23.4.sp,
                    color = textColor
                )
            )
            Text(
                text = sectionTitle,
                style = MaterialTheme.typography.labelMedium.copy(
                    lineHeight = 18.2.sp,
                    color = textColor
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StudentFilterScreenPreview(){
    val navController = rememberNavController()
    StudentFilterScreen(
        navController = navController,
    )
}