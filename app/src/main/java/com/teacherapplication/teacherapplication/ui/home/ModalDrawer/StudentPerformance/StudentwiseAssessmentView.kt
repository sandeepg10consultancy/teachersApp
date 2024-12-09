package com.teacherapplication.teacherapplication.ui.home.ModalDrawer.StudentPerformance

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.teacherapplication.teacherapplication.R
import com.teacherapplication.teacherapplication.ui.AppComponents.BackArrow
import com.teacherapplication.teacherapplication.ui.theme.nunitoFont


val gradientColor = Brush.linearGradient(
    colors = listOf(Color(0xFF2093C3), Color(0xFF93ECFF))
)

@Composable
fun StudentWiseAssessmentView(navController: NavHostController) {
    val scrollState = rememberScrollState()
    val chaptersList = listOf(
        "Chapter 1" to R.drawable.land,
        "Chapter 2" to R.drawable.mountain,
        "chapter 3" to R.drawable.chapter_sky,
        "Chapter 4" to R.drawable.land,
        "Chapter 5" to R.drawable.mountain,
    )

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
        Box(
            modifier = Modifier
                .height(76.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(
                    brush = gradientColor
                )
        ) {
            Icon(
                painter = painterResource(R.drawable.subject_rocket),
                contentDescription = "image",
                tint = Color(0xFF93ECFF),
                modifier = Modifier
                    .height(132.dp)
                    .width(76.dp)
                    .fillMaxSize()
                    .scale(1.7f)
                    .offset(x = 52.dp, y= 0.dp)
            )
            Text(
                text = "Science",
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
        chaptersList.forEachIndexed { index, pair ->
            ChapterWiseDetails(
                chapterNo = index+1,
                chapterName = pair.first,
                image = pair.second,
                navController = navController
            )
        }
        Spacer(modifier = Modifier.height(50.dp))
    }
}

@Composable
fun ChapterWiseDetails(
    chapterNo: Int,
    chapterName: String,
    image: Int,
    navController: NavHostController
) {
    Card(
        modifier = Modifier
            .height(107.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        onClick = { navController.navigate(route = "studentSubmittedScreen")}
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = "Chapter $chapterNo",
                    style = TextStyle(
                        fontFamily = nunitoFont,
                        fontSize = 18.sp,
                        fontWeight = FontWeight(600),
                        brush = gradientColor
                    ),
                )
                Text(
                    text = "0$chapterNo:\t\tAll About Me",
                    style = TextStyle(
                        fontFamily = nunitoFont,
                        fontSize = 20.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF1D1751)
                    ),
                )
            }
            Image(
                painter = painterResource(image),
                contentDescription = "land",
                modifier = Modifier
                    .height(67.dp)
                    .width(79.dp)
                    .clip(CircleShape)
            )
        }
    }
}