package com.teacherapplication.teacherapplication.ui.home.notifications

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.teacherapplication.teacherapplication.R
import com.teacherapplication.teacherapplication.ui.AppComponents.BackArrow
import com.teacherapplication.teacherapplication.ui.home.ModalDrawer.FilterBottomSheet
import com.teacherapplication.teacherapplication.ui.home.ModalDrawer.SearchFieldFunction
import com.teacherapplication.teacherapplication.ui.theme.jostFont


data class NotificationData(
    val character: String,
    val bgColor: Color,
    val title: String,
    val time: String,
    val subTopic: String
)



@Composable
fun NotificationsScreen(navController: NavHostController) {
    val scrollState = rememberScrollState()
    val searchNotification = remember { mutableStateOf("") }
    val isFilterClicked = remember { mutableStateOf(false) }

    val notifications = listOf(
        NotificationData(
            character = "R",
            bgColor = Color(0xFFFFB866),
            title = "Upcoming Class Reminder",
            time = "10:45 PM",
            subTopic = "Your Nursery-A Math class starts in 15 minutes."
        ),
        NotificationData(
            character = "R",
            bgColor = Color(0xFFF2C94C),
            title = "Meeting Reminder",
            time = "Yesterday",
            subTopic = "Parent-Teacher meeting with Mr. Smith is tom..."
        ),
        NotificationData(
            character = "N",
            bgColor = Color(0xFF5458F7),
            title = "New Resource Available",
            time = "Yesterday",
            subTopic = "A new study guide has been added to your..."
        ),
        NotificationData(
            character = "M",
            bgColor = Color(0xFF00CC99),
            title = "New Message from Sarah",
            time = "12th Aug",
            subTopic = "You have a new message from Sarah.."
        ),
        NotificationData(
            character = "S",
            bgColor = Color(0xFFEB5757),
            title = "New Submission Alert",
            time = "12th Aug",
            subTopic = "John Doe has submitted the Science assignment."
        ),
        NotificationData(
            character = "R",
            bgColor = Color(0xFFF2C94C),
            title = "Meeting Reminder",
            time = "Yesterday",
            subTopic = "Parent-Teacher meeting with Mr. Smith is tom..."
        ),
        NotificationData(
            character = "N",
            bgColor = Color(0xFF5458F7),
            title = "New Resource Available",
            time = "10th Aug",
            subTopic = "A new study guide has been added to your..."
        ),

    )


    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(start = 15.dp, top = 40.dp, end = 15.dp)
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
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
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            SearchFieldFunction(
                labelText = "Search your bookmarks here",
                searchValue = searchNotification,
                modifier = Modifier.fillMaxWidth(0.85f)
            )
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(
                        color = Color(0xFFF3F9FA),
                        shape = RoundedCornerShape(9.dp)
                    )
                    .clickable {
                        isFilterClicked.value = true
                    },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(R.drawable.filter_bookmarks),
                    contentDescription = "filter",
                    tint = Color(0xFF129193),
                    modifier = Modifier
                        .height(22.56.dp)
                        .width(24.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        notifications.forEach { notification ->
            NotificationCard(
                character = notification.character,
                bgColor = notification.bgColor,
                title = notification.title,
                time = notification.time,
                subTopic = notification.subTopic,
                navController = navController
            )
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
    if (isFilterClicked.value){
        FilterBottomSheet(isFilterClicked)
    }
}

@Composable
private fun NotificationCard(
    character: String,
    bgColor: Color,
    title: String,
    time: String,
    subTopic: String,
    navController: NavHostController,
) {

    Card(
        modifier = Modifier
            .height(93.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        onClick = { navController.navigate(route = "notificationDetails")}
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .background(
                        color = bgColor,
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = character,
                    style = MaterialTheme.typography.titleSmall.copy(
                        fontSize = 22.sp,
                        lineHeight = 17.6.sp,
                        color = Color.White
                    )
                )
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontSize = 16.sp,
                            lineHeight = 23.12.sp
                        ),
                        modifier = Modifier.fillMaxWidth(0.8f)
                    )
                    Text(
                        text = time,
                        style = TextStyle(
                            fontFamily = jostFont,
                            fontWeight = FontWeight(400),
                            fontSize = 12.sp,
                            lineHeight = 17.34.sp
                        )
                    )
                }
                Text(
                    text = subTopic,
                    style = TextStyle(
                        fontFamily = jostFont,
                        fontWeight = FontWeight(400),
                        fontSize = 14.sp,
                        lineHeight = 20.23.sp,
                        color = Color.Black.copy(alpha = 0.6f)
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

