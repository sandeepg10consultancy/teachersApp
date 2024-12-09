package com.teacherapplication.teacherapplication.ui.home.ModalDrawer.StudentPerformance

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.teacherapplication.teacherapplication.R
import com.teacherapplication.teacherapplication.ui.AppComponents.BackArrow
import com.teacherapplication.teacherapplication.ui.AppComponents.SmallCircle


data class SubjectData(
    val title: String,
    val bgImage: Int,
    val bgImageColor: Color,
    val image: Int,
    val bgColor: List<Color>,
)

private val subjectDetails = listOf(
    SubjectData(
        title = "Science",
        bgImage = R.drawable.subject_rocket,
        bgImageColor = Color(0xFF93ECFF),
        image = R.drawable.subject_land,
        bgColor = listOf(Color(0xFF2093C3), Color(0xFF93ECFF))
    ),
    SubjectData(
        title = "Arts",
        bgImage = R.drawable.subject_arts,
        bgImageColor = Color(0xFFFDC194),
        image = R.drawable.subject_mountain,
        bgColor = listOf(Color(0xFFFF6020), Color(0xFFFDC194))
    ),
    SubjectData(
        title = "English",
        bgImage = R.drawable.literacy_img,
        bgImageColor = Color(0xFFFED276),
        image = R.drawable.subject_sky,
        bgColor = listOf(Color(0xFFE67D22), Color(0xFFFFC261))
    ),
    SubjectData(
        title = "General Knowledge",
        bgImage = R.drawable.gk_img,
        bgImageColor = Color(0xFFF2C0C0),
        image = R.drawable.subject_land,
        bgColor = listOf(Color(0xFFDA5151), Color(0xFFF2C0C0))
    )
)



@Composable
fun StudentOverallPerformance(navController: NavHostController) {
    val scrollState = rememberScrollState()
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
        StudentDetailsCard()
        subjectDetails.forEach { subjectData ->
            SubjectWithImage(
                title = subjectData.title,
                image = subjectData.image,
                bgColor = subjectData.bgColor,
                bgImage = subjectData.bgImage,
                bgImageColor = subjectData.bgImageColor,
                navController = navController
            )
        }

    }
}

@Composable
private fun SubjectWithImage(
    title: String,
    image: Int,
    bgColor: List<Color>,
    bgImage: Int,
    bgImageColor: Color,
    navController: NavHostController
) {
    Box(
        modifier = Modifier
            .height(112.dp)
            .fillMaxWidth()
            .clickable {
                navController.navigate(route = "studentWiseAssessment")
            }
    ) {
        Box(
            modifier = Modifier
                .height(76.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(
                    brush = Brush.linearGradient(
                        colors = bgColor
                    )
                )
                .align(Alignment.BottomCenter)
        ) {
            Icon(
                painter = painterResource(bgImage),
                contentDescription = "image",
                tint = bgImageColor.copy(alpha = 0.6f),
                modifier = Modifier
                    .height(132.dp)
                    .width(76.dp)
                    .fillMaxSize()
                    .scale(1.7f)
                    .offset(x = 52.dp, y= 0.dp)
            )
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontSize = 26.sp,
                    lineHeight = 37.57.sp,
                    color = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, top = 20.dp),

                )
        }
        Image(
            painter = painterResource(image),
            contentDescription = "land",
            modifier = Modifier
                .height(112.dp)
                .width(187.dp)
                .align(Alignment.CenterEnd)
        )
    }
}

@Composable
fun StudentDetailsCard() {
    Card(
        modifier = Modifier
            .height(105.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(R.drawable.profile_boy_2),
                contentDescription = "profile",
                modifier = Modifier
                    .size(84.dp)
                    .clip(CircleShape)
            )
            Column {
                Text(
                    text = "Vinay Poosarla",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        lineHeight = 21.6.sp,
                        color = Color(0xFF129193)
                    )
                )
                Spacer(modifier = Modifier.height(5.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(7.dp)
                ) {
                    Text(
                        text = "Nursery - A",
                        style = MaterialTheme.typography.labelMedium.copy(
                            lineHeight = 16.8.sp,
                            color = Color(0xFF1D1751)
                        )
                    )
                    SmallCircle(
                        dim = 5.dp,
                        containerColor = Color(0xFF808080),
                        borderColor = Color.Transparent
                    )
                    Text(
                        text = "Roll No- 02",
                        style = MaterialTheme.typography.labelMedium.copy(
                            lineHeight = 16.8.sp,
                            color = Color(0xFF1D1751)
                        )
                    )
                }
            }
            Image(
                painter = painterResource(R.drawable.profile_land),
                contentDescription = "land",
                modifier = Modifier
                    .height(67.dp)
                    .width(79.dp)
            )
        }
    }
}