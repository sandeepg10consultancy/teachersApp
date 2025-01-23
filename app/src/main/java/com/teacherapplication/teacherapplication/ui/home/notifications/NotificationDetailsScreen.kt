package com.teacherapplication.teacherapplication.ui.home.notifications

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.teacherapplication.teacherapplication.ui.AppComponents.BackArrow
import com.teacherapplication.teacherapplication.ui.Diary.DailyDiaryScreen
import com.teacherapplication.teacherapplication.ui.home.dashboard.DashboardViewModel
import com.teacherapplication.teacherapplication.ui.theme.jostFont


data class ClassDetails(
    val title: String,
    val time: String,
    val activity: String,
    val location: String,
    val students: String,
    val preparationTips: List<String>,
    val additionalNotes: List<String>
)



@Composable
fun NotificationDetailsScreen(modifier: Modifier = Modifier, navController: NavHostController){
    val scrollState = rememberScrollState()
    val classDetails = ClassDetails(
        title = "Math Fun",
        time = "Starts at 10:00 AM (in 15 minutes) \n \t\t\t\t\tEnds at 10:30 AM",
        activity = "Counting and Number Matching Games",
        location = "Classroom Nursery-A",
        students = "12 kids",
        preparationTips = listOf(
            "Set up the counting blocks and number cards on each table.",
            "Have some fun songs ready to play for the counting activity.",
            "Prepare to engage kids with a quick, playful warm-up before starting."
        ),
        additionalNotes = listOf(
            "Keep the atmosphere lively and interactive.",
            "Encourage each child to participate and help them as needed.",
            "Plan a short break with a fun story after the activity."
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(start = 15.dp, top = 40.dp, end = 15.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            BackArrow(onClick = { navController.popBackStack() })
            Text(
                text = "Notifications",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontSize = 20.sp,
                    lineHeight = 28.9.sp,
                    color = Color.Black
                ),
                modifier = Modifier
                    .fillMaxWidth(0.95f),
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFF8F8F8)
            ),
            shape = RoundedCornerShape(15.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 2.dp
            )
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 20.dp, top = 20.dp, end = 15.dp),
            ){
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Upcoming Class Reminder",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontSize = 16.sp,
                            lineHeight = 23.12.sp
                        ),
                        modifier = Modifier.fillMaxWidth(0.85f)
                    )
                    Text(
                        text = "10:45 PM",
                        style = TextStyle(
                            fontFamily = jostFont,
                            fontWeight = FontWeight(400),
                            fontSize = 12.sp,
                            lineHeight = 17.34.sp
                        )
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                Column(
                    verticalArrangement = Arrangement.spacedBy(15.dp)
                ){
                    Text(
                        text = "Upcoming Class: ${classDetails.title}",
                        style = MaterialTheme.typography.labelMedium,
                        color = Color.Black.copy(alpha = 0.8f)
                    )
                    Text(
                        text = "Time: ${classDetails.time}",
                        style = MaterialTheme.typography.labelMedium,
                        color = Color.Black.copy(alpha = 0.8f)
                    )
                    Text(
                        text = "Activity: ${classDetails.activity}",
                        style = MaterialTheme.typography.labelMedium,
                        color = Color.Black.copy(alpha = 0.8f)
                    )
                    Text(
                        text = "Location: ${classDetails.location}",
                        style = MaterialTheme.typography.labelMedium,
                        color = Color.Black.copy(alpha = 0.8f)
                    )
                    Text(
                        text = "Students: ${classDetails.students}",
                        style = MaterialTheme.typography.labelMedium,
                        color = Color.Black.copy(alpha = 0.8f)
                    )
                }
                Spacer(modifier = Modifier.height(25.dp))
                Text(
                    text = "Preparation Tips:",
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontWeight = FontWeight(600)
                    ),
                    color = Color.Black.copy(alpha = 0.8f)
                )
                Spacer(modifier = Modifier.height(15.dp))
                classDetails.preparationTips.forEach { tip ->
                    BulletPointText(text = tip)
                }
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = "Additional Notes:",
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontWeight = FontWeight(600)
                    ),
                    color = Color.Black.copy(alpha = 0.8f)
                )
                Spacer(modifier = Modifier.height(15.dp))
                classDetails.additionalNotes.forEach { tip ->
                    BulletPointText(text = tip)
                }
                Spacer(modifier = Modifier.height(100.dp))
            }
        }
    }
}

@Composable
fun BulletPointText(text: String) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "\u2022",
            style = MaterialTheme.typography.labelMedium,
            color = Color.Black.copy(alpha = 0.8f),
            modifier = Modifier.padding(start = 8.dp,end = 8.dp) // Space between bullet and text
        )
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium,
            color = Color.Black.copy(alpha = 0.8f),
            modifier = Modifier.weight(1f) // Ensures text wraps correctly
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NotificationDetailsScreenPreview(){
    val navController = rememberNavController()
    NotificationDetailsScreen(
        navController = navController,
    )
}