package com.teacherapplication.teacherapplication.ui.home.ModalDrawer.StudentPerformance

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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.teacherapplication.teacherapplication.R
import com.teacherapplication.teacherapplication.ui.AppComponents.BackArrow
import com.teacherapplication.teacherapplication.ui.AppComponents.SmallCircle
import com.teacherapplication.teacherapplication.ui.AppComponents.brush
import com.teacherapplication.teacherapplication.ui.theme.nunitoFont

data class SubjectPercentageData(
    val title: String,
    val percentage: Int,
    val bgImage: Int,
    val bgImageColor: Color,
    val bgColor: List<Color>,
)

private val subjectPercentDetails = listOf(
    SubjectPercentageData(
        title = "Science",
        percentage = 40,
        bgImage = R.drawable.subject_rocket,
        bgImageColor = Color(0xFF93ECFF),
        bgColor = listOf(Color(0xFF2093C3), Color(0xFF93ECFF))
    ),
    SubjectPercentageData(
        title = "Arts",
        percentage = 40,
        bgImage = R.drawable.subject_arts,
        bgImageColor = Color(0xFFFDC194),
        bgColor = listOf(Color(0xFFFF6020), Color(0xFFFDC194))
    ),
    SubjectPercentageData(
        title = "English",
        percentage = 80,
        bgImage = R.drawable.literacy_img,
        bgImageColor = Color(0xFFFED276),
        bgColor = listOf(Color(0xFFE67D22), Color(0xFFFFC261))
    ),
    SubjectPercentageData(
        title = "General Knowledge",
        percentage = 60,
        bgImage = R.drawable.gk_img,
        bgImageColor = Color(0xFFF2C0C0),
        bgColor = listOf(Color(0xFFDA5151), Color(0xFFF2C0C0))
    )
)


@Composable
fun StudentOverallSecond(){
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
            BackArrow(onClick = {  })
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
        Spacer(modifier = Modifier.height(5.dp))
        subjectPercentDetails.forEach { subject ->
            SubjectWithPercentage(
                title = subject.title,
                percentage = subject.percentage,
                bgImage = subject.bgImage,
                bgImageColor = subject.bgImageColor,
                bgColor = subject.bgColor
            )
        }
    }
}

@Composable
fun StudentPercentageCard() {
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
            Box(
                contentAlignment = Alignment.Center
            ) {
                GradientCircularProgressIndicator(
                    progress = 0.7f,
                    strokeWidth = 3.17.dp,
                    modifier = Modifier
                        .size(55.98.dp),
                    gradientColors = listOf(Color(0xFF2093C3), Color(0xFF93ECFF)),
                    trackColor = Color(0xFFC3F1FF)
                )
                Text(
                    text = "70%",
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

@Composable
fun GradientCircularProgressIndicator(
    progress: Float,
    strokeWidth: Dp,
    modifier: Modifier = Modifier,
    gradientColors: List<Color> = listOf(Color.Cyan, Color.Blue),
    trackColor: Color = Color.LightGray,
) {
    Canvas(modifier = modifier) {
        val diameter = size.minDimension
        val stroke = strokeWidth.toPx()
        val radius = (diameter - stroke) / 2
        drawCircle(
            color = trackColor,
            radius = radius,
            style = Stroke(stroke, cap = StrokeCap.Round)
        )
        val sweepAngle = 360f * progress
        val gradient = Brush.linearGradient(gradientColors)

        drawArc(
            brush = gradient,
            startAngle = -90f,
            sweepAngle = sweepAngle,
            useCenter = false,
            topLeft = Offset(stroke / 2, stroke / 2),
            size = Size(diameter- stroke, diameter - stroke),
            style = Stroke(stroke, cap = StrokeCap.Round)
        )
    }
}

@Composable
fun SubjectWithPercentage(
    title: String,
    percentage: Int,
    bgColor: List<Color>,
    bgImage: Int,
    bgImageColor: Color,
//    navController: NavHostController
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
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, top = 20.dp, end = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontSize = 26.sp,
                    lineHeight = 37.57.sp,
                    color = Color.White
                )
                )
            Text(
                text = "$percentage%",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontSize = 26.sp,
                    lineHeight = 37.57.sp,
                    color = Color.White
                ),
            )
        }
    }
}


