package com.teacherapplication.teacherapplication.ui.SubjectChapterList.ArtContent

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
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.teacherapplication.teacherapplication.R
import com.teacherapplication.teacherapplication.ui.AppComponents.BackArrow
import com.teacherapplication.teacherapplication.ui.AppComponents.TopProgressBar
import com.teacherapplication.teacherapplication.ui.home.dashboard.BottomNavigationBar
import com.teacherapplication.teacherapplication.ui.theme.italicJost
import com.teacherapplication.teacherapplication.ui.theme.italicSansFont
import com.teacherapplication.teacherapplication.ui.theme.jostFont


//@Preview(showBackground = true)
@Composable
fun TopicListingScreen(navController: NavHostController) {
    val verticalScroll = rememberScrollState()
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxWidth()
                .verticalScroll(verticalScroll)
        ) {
            TopProgressBar()
            Column(modifier = Modifier.padding(15.dp)){
                BackArrow(onClick = {navController.popBackStack()})
                Spacer(modifier = Modifier.height(10.dp))
                TopSurface()
                Spacer(modifier = Modifier.height(20.dp))
                HorizontalDivider(
                    modifier = Modifier.fillMaxWidth()
                        .height(1.dp),
                    color = Color(0xFF000000).copy(alpha = 0.3f)
                )
                Spacer(modifier = Modifier.height(20.dp))
                ChapterObjective(navController)
                Spacer(modifier = Modifier.height(30.dp))
                TopicCard(
                    days = "3",
                    date = "1st Jul 2024",
                    title = "Flower",
                    progress = 1f,
                    onClick = { navController.navigate(route = "chapterOneContent") },
                    chapterNo = 1

                )
                Spacer(modifier = Modifier.height(30.dp))
                TopicCard(
                    days = "3",
                    date = "2nd Jul 2024",
                    title = "Chick",
                    progress = 1f,
                    onClick = { },
                    chapterNo = 2

                )


            }


        }
        BottomAppBar(
            modifier = Modifier.align(Alignment.BottomCenter)
        ){
            BottomNavigationBar()
        }
    }
}

@Composable
fun TopicCard(
    days: String,
    date: String,
    title: String,
    progress: Float = 0.5f,
    onClick: () -> Unit = {},
    chapterNo: Int,
    modifier: Modifier = Modifier
) {
    val bookMarkClicked = remember { mutableStateOf(false) }
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(112.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFFFFF)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        ),
        onClick = onClick
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {

            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                Color(0xFF544D8F),
                                Color(0xFF1D1751)
                            )
                        )
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "$chapterNo",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 24.sp,
                        fontWeight = FontWeight(600),
                        color = Color(0xFFFFFFFF)
                    )
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.SpaceBetween,
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Text(
                        text = "$days days",
                        style = TextStyle(
                            fontFamily = jostFont,
                            fontSize = 14.sp,
                            fontWeight = FontWeight(500),
                            lineHeight = 11.2.sp,
                            color = Color(0xFF129193)
                        )
                    )
                    Image(painter = painterResource(if (bookMarkClicked.value) R.drawable.filled_book_mark else R.drawable.book_mark),
                        contentDescription = "bookMark",
                        modifier = Modifier
                            .size(20.dp)
                            .clickable {
                                bookMarkClicked.value = !bookMarkClicked.value
                            }
                    )
                }
                Text(
                    text = title,
                    style = TextStyle(
                        fontFamily = jostFont,
                        fontSize = 16.sp,
                        fontWeight = FontWeight(600),
                        lineHeight = 12.8.sp,
                        color = Color(0xFF000000)
                    )
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Row {
                        Text(
                            text = "Completed on:",
                            style = TextStyle(
                                fontFamily = italicJost,
                                fontSize = 14.sp,
                                fontWeight = FontWeight(400),
                                lineHeight = 11.2.sp,
                                color = Color(0xFF2D9549)
                            )
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = buildAnnotatedString {
                                append(date[0])
                                withStyle(
                                    style = SpanStyle(
                                        fontSize = 10.sp,
                                        baselineShift = BaselineShift.Superscript
                                    ),
                                ) {
                                    append(date.substring(1,3))
                                }
                                append(date.substring(4))
                            },
                            style = TextStyle(
                                fontFamily = italicSansFont,
                                fontSize = 12.sp
                            ),
                            modifier = Modifier.padding(bottom = 2.dp)
                        )
                    }
                    Image(
                        painter = painterResource(R.drawable.completed),
                        contentDescription = "completed",
                        modifier = Modifier
                            .size(20.dp)
                    )
                }
                Spacer(modifier = Modifier.height(5.dp))
                TopicCardBar(progress)
            }
        }
    }
}

@Composable
fun TopicCardBar(progress: Float = 0.5f){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(5.dp)
    ){
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawRoundRect(
                color = Color(0xFFE9E9E9),
                size = Size(size.width, size.height),
                cornerRadius = CornerRadius(18f, 18f)
            )
            if (progress > 0){
                drawRoundRect(
                    color = Color(0xFF2679B4),
                    size = Size(size.width * progress, size.height),
                    cornerRadius = CornerRadius(18f, 18f)
                )
            }
        }
    }
}


@Composable
private fun ChapterObjective(navController: NavHostController) {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .height(38.dp)
            .fillMaxWidth()
            .background(Color.Transparent)
            .border(
                width = 1.dp,
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFF185573), Color(0xFF14868D))
                ),
                shape = RoundedCornerShape(30.dp)
            )
    ) {
        OutlinedButton(
            onClick = { navController.popBackStack()},
            modifier = Modifier
                .height(38.dp)
                .fillMaxWidth(),
            border = null,
            colors = ButtonDefaults.outlinedButtonColors(

            )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Chapter Objectives",
                    style = MaterialTheme.typography.bodySmall.copy(
                        brush = Brush.linearGradient(
                            colors = listOf(Color(0xFF185573), Color(0xFF14868D))
                        ),
                        lineHeight = 12.8.sp
                    )
                )
                Spacer(modifier = Modifier.width(10.dp))
                Image(
                    painter = painterResource(R.drawable.arrow_right),
                    contentDescription = "arrow",
                    modifier = Modifier.scale(1.5f)
                )
            }
        }
    }
}

@Composable
fun TopSurface() {

    Row(
        modifier = Modifier.fillMaxWidth()
            .height(84.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ){
            Box(
                modifier = Modifier
                    .height(22.dp)
                    .width(120.dp)
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
                }
            }
            Text(
                text = "CH 1.Primary Colours",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontSize = 24.sp,
                    lineHeight = 19.2.sp,
                    color = Color(0xFF000000)
                )
            )
            Text(
                text = "1/14 Topics",
                fontFamily = italicJost,
                fontSize = 14.sp,
                lineHeight = 17.64.sp,
                color = Color(0xFF595959)
            )
        }
        Surface(
            color = Color.Transparent,
            modifier = Modifier
                .size(66.dp)
                .clip(RoundedCornerShape(14.dp))
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFFFF6020),
                            Color(0xFFFDC194),
                        )
                    )
                )
        ) {
            Image(
                painter = painterResource(R.drawable.art_img),
                contentDescription = "art",
                modifier = Modifier
                    .size(58.dp)
                    .padding(top = 10.dp)
                    .scale(1.2f)
            )
        }
    }
}