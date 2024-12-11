package com.teacherapplication.teacherapplication.ui.home.ModalDrawer.StudentPerformance

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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teacherapplication.teacherapplication.R
import com.teacherapplication.teacherapplication.ui.AppComponents.BackArrow
import com.teacherapplication.teacherapplication.ui.theme.nunitoFont
import kotlin.math.absoluteValue
import kotlin.math.roundToInt


private val gradientColor = Brush.linearGradient(
    colors = listOf(Color(0xFF2093C3), Color(0xFF93ECFF))
)
@Composable
fun StudentWiseAssessmentSecond(){
    val scrollState = rememberScrollState()
    val chaptersWithPercent = listOf(
        "Chapter 1" to 0.7f,
        "Chapter 2" to 0.6f,
        "chapter 3" to 0.5f,
        "Chapter 4" to 0.8f,
        "Chapter 5" to 0.9f,
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
            BackArrow(onClick = { })
            Text(
                text = "Student Performance",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth(0.95f),
                textAlign = TextAlign.Center
            )
        }
        StudentPercentageCard()
        SubjectWithPercentage(
            title = "Science",
            percentage = 40,
            bgImage = R.drawable.subject_rocket,
            bgImageColor = Color(0xFF93ECFF),
            bgColor = listOf(Color(0xFF2093C3), Color(0xFF93ECFF))
        )
        chaptersWithPercent.forEachIndexed { index, pair ->
            ChapterWithPercentage(
                chapterNo = index + 1,
                title = pair.first,
                progress = pair.second
            )
        }
        Spacer(modifier = Modifier.height(50.dp))
    }
}

@Composable
private fun ChapterWithPercentage(
    chapterNo: Int,
    title: String,
    progress: Float
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
        onClick = { }
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
                    text = "0$chapterNo:\t\t$title",
                    style = TextStyle(
                        fontFamily = nunitoFont,
                        fontSize = 20.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF1D1751)
                    ),
                )
            }
            Box(
                contentAlignment = Alignment.Center
            ) {
                GradientCircularProgressIndicator(
                    progress = progress,
                    modifier = Modifier.size(55.98.dp),
                    strokeWidth = 3.17.dp,
                    gradientColors = listOf(Color(0xFF2093C3), Color(0xFF93ECFF)),
                    trackColor = Color(0xFFC3F1FF)
                )
                Text(
                    text = "${(progress*100).roundToInt()}%",
                    style = TextStyle(
                        fontFamily = nunitoFont,
                        fontWeight = FontWeight(700),
                        fontSize = 18.sp,
                        lineHeight = 27.sp
                    )
                )
            }
        }
    }
}