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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teacherapplication.teacherapplication.R
import com.teacherapplication.teacherapplication.ui.AppComponents.BackArrow
import com.teacherapplication.teacherapplication.ui.AppComponents.SmallCircle
import com.teacherapplication.teacherapplication.ui.home.dashboard.BottomNavigationBar
import com.teacherapplication.teacherapplication.ui.theme.italicSansFont
import com.teacherapplication.teacherapplication.ui.theme.jostFont


@Composable
fun StudentMarking(modifier: Modifier = Modifier){
    val topicsList = listOf("Physical Development","Socio-Emotional and Social","Cognitive Development","Language and Literacy","Aesthetic and Cultural")
    val topicSelected = remember { mutableStateOf(topicsList[0]) }
    val CGList = listOf("CG -1","CG - 2", "CG - 3", "CG - 4")
    val CGSelected = remember { mutableStateOf(CGList[0]) }
    val contentList = listOf("Land" to R.drawable.land, "Mountain" to R.drawable.mountain, "Sky" to R.drawable.sky)
    val scrollState = rememberScrollState()
    Box(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 40.dp, start = 20.dp)
                .verticalScroll(scrollState)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(15.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                BackArrow(onClick = { })
                Image(
                    painter = painterResource(R.drawable.profile_img_2),
                    contentDescription = "profile",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                )
                Column {
                    Text(
                        text = "Vinay Poosarla",
                        style = TextStyle(
                            fontFamily = jostFont,
                            fontWeight = FontWeight(500),
                            fontSize = 16.sp,
                            lineHeight = 23.12.sp,
                            color = Color(0xFF1D1751)
                        )
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = "Junior KG - A",
                            style = TextStyle(
                                fontFamily = italicSansFont,
                                fontWeight = FontWeight(500),
                                fontSize = 12.sp,
                                lineHeight = 15.12.sp,
                                color = Color(0xFF129193)
                            )
                        )
                        SmallCircle(
                            dim = 5.dp,
                            containerColor = Color(0xFF129193),
                            borderColor = Color.Transparent
                        )
                        Text(
                            text = "Art",
                            style = TextStyle(
                                fontFamily = italicSansFont,
                                fontWeight = FontWeight(500),
                                fontSize = 12.sp,
                                lineHeight = 15.12.sp,
                                color = Color(0xFF129193)
                            )
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(topicsList) { topic ->
                    TopicSelection(topic, topicSelected)
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Box(
                modifier = Modifier
                    .height(44.dp)
                    .fillMaxWidth()
                    .padding(end = 20.dp)
                    .background(
                        color = Color(0xFFF2FFFF),
                        shape = RoundedCornerShape(220.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(0.dp)
                ) {
                    CGList.forEach { title ->
                        CourseGradeBox(title, CGSelected)
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            CGStatusCard()
            Spacer(modifier = Modifier.height(20.dp))
            for (i in 1..2) {
                ContentRepresentation(contentList, i)
                Spacer(modifier = Modifier.height(20.dp))
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (CGSelected.value == CGList[CGList.size - 1]){
                    Box(
                        modifier = Modifier
                            .height(40.dp)
                            .weight(1f)
                            .background(
                                brush = Brush.linearGradient(
                                colors = listOf(Color(0xFF185573), Color(0xFF14868D))
                            ),
                            shape = RoundedCornerShape(5.dp),
                        ),
                        contentAlignment = Alignment.Center){
                        Text(
                            text = "Done",
                            style = TextStyle(
                                fontFamily = jostFont,
                                fontWeight = FontWeight(500),
                                fontSize = 16.sp,
                                lineHeight = 23.12.sp,
                                color = Color.White
                            )
                        )
                    }
                }else {
                    Spacer(modifier = Modifier.weight(1f))
                }
                Box(
                    modifier = Modifier
                        .height(40.dp)
                        .width(85.dp)
                        .border(
                            width = 1.dp,
                            brush = Brush.linearGradient(
                                colors = listOf(Color(0xFF185573), Color(0xFF14868D))
                            ),
                            shape = RoundedCornerShape(5.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Next",
                        style = TextStyle(
                            fontFamily = jostFont,
                            fontWeight = FontWeight(500),
                            fontSize = 16.sp,
                            lineHeight = 23.12.sp,
                            brush = Brush.linearGradient(
                                colors = listOf(Color(0xFF185573), Color(0xFF14868D))
                            )
                        )
                    )
                }
            }
            Spacer(modifier = Modifier.height(150.dp))
        }
        BottomAppBar(
            modifier = Modifier.align(Alignment.BottomCenter)
                .background(color = Color.White)
        ) {
            BottomNavigationBar()
        }
    }
}

@Composable
private fun ContentRepresentation(contentList: List<Pair<String, Int>>, i: Int) {
    Column(
        modifier = Modifier
            //.height(386.dp)
            .padding(end = 20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        CGDivider(i)
        Text(
            text = "Shows a liking and understanding of nutritious food and does not waste food.",
            style = TextStyle(
                fontFamily = jostFont,
                fontWeight = FontWeight(400),
                fontSize = 16.sp,
                lineHeight = 23.12.sp,
                color = Color.Black
            )
        )
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            items(contentList) { content ->
                Column(
                    verticalArrangement = Arrangement.spacedBy(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(content.second),
                        contentDescription = content.first,
                        modifier = Modifier
                            .height(67.dp)
                            .width(79.dp)
                    )
                    Text(
                        text = content.first,
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontWeight = FontWeight(600),
                            lineHeight = 15.12.sp,
                            color = Color.Black
                        )
                    )
                }
            }
        }
    }
}

@Composable
private fun CGDivider(i: Int) {
    Box(
        modifier = Modifier
            .height(28.dp)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        HorizontalDivider(
            thickness = 1.dp,
            color = Color.Black.copy(alpha = 0.3f)
        )
        Box(
            modifier = Modifier
                .height(28.dp)
                .width(83.dp)
                .background(
                    color = Color(0xFF129193),
                    shape = RoundedCornerShape(16.dp)
                )
                .border(
                    width = 4.dp,
                    color = Color.White,
                    shape = RoundedCornerShape(16.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "CG - 1.$i",
                style = MaterialTheme.typography.labelMedium.copy(
                    fontWeight = FontWeight(500),
                    color = Color.White
                ),
                modifier = Modifier.padding(2.dp)
            )
        }
    }
}

@Composable
private fun CGStatusCard() {
    Card(
        modifier = Modifier
            .height(126.dp)
            .fillMaxWidth()
            .padding(end = 20.dp),
        shape = RoundedCornerShape(15.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Text(
            text = "Children develop habits that keep them healthy and safe",
            style = TextStyle(
                fontFamily = jostFont,
                fontWeight = FontWeight(400),
                fontSize = 18.sp,
                lineHeight = 26.01.sp,
                color = Color(0xFF1D1751)
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(10.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Box(
            modifier = Modifier
                .height(26.dp)
                .width(120.dp)
                .align(Alignment.CenterHorizontally)
                .background(
                    color = Color(0xFF25A455),
                    shape = RoundedCornerShape(13.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.tick_mark),
                    contentDescription = "tick",
                    modifier = Modifier.size(18.dp),
                    tint = Color.White
                )
                Text(
                    text = "Completed",
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontWeight = FontWeight(500),
                        color = Color.White
                    )
                )
            }
        }

    }
}

@Composable
private fun CourseGradeBox(title: String, CGSelected: MutableState<String>) {

    val isSelected = title == CGSelected.value
    Box(
        modifier = Modifier
            .height(if (isSelected) 34.dp else 34.dp)
            .width(if (isSelected) 109.dp else 85.dp)
            .background(
                color = if (isSelected) Color(0xFF129193) else Color.Transparent,
                shape = RoundedCornerShape(58.dp)
            )
            .clickable {
                CGSelected.value = title
            },
        contentAlignment = Alignment.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.tick_mark),
                contentDescription = "tick",
                modifier = Modifier.size(14.dp),
                tint = if (isSelected) Color.White else Color.Black.copy(alpha = 0.5f)
            )
            Text(
                text = title,
                style = TextStyle(
                    fontFamily = jostFont,
                    fontWeight = FontWeight(500),
                    fontSize = 16.sp,
                    lineHeight = 23.12.sp,
                    color = if (isSelected) Color.White else Color.Black.copy(alpha = 0.5f)
                )
            )
        }
    }
}

@Composable
private fun TopicSelection(topic: String, topicSelected: MutableState<String>) {
    val isSelected = topic == topicSelected.value
    Box(
        modifier = Modifier
            .height(39.dp)
            .width(205.dp)
            .background(
                color = if (isSelected) Color(0xFF129193) else Color.White,
                shape = RoundedCornerShape(22.dp)
            )
            .border(
                width = 1.dp,
                color = Color(0xFF129193),
                shape = RoundedCornerShape(22.dp)
            )
            .clickable { topicSelected.value = topic },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = topic,
            style = TextStyle(
                fontFamily = jostFont,
                fontWeight = FontWeight(500),
                fontSize = 16.sp,
                lineHeight = 23.12.sp,
                color = if (isSelected) Color.White else Color(0xFF129193)
            ),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(start = 20.dp, end = 20.dp)
        )
    }
}