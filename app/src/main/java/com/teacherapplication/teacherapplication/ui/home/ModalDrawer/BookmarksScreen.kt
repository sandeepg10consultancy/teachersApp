package com.teacherapplication.teacherapplication.ui.home.ModalDrawer

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.teacherapplication.teacherapplication.R
import com.teacherapplication.teacherapplication.ui.AppComponents.BackArrow
import com.teacherapplication.teacherapplication.ui.AppComponents.SmallCircle
import com.teacherapplication.teacherapplication.ui.login.account.ClassCard
import com.teacherapplication.teacherapplication.ui.theme.italicJost
import com.teacherapplication.teacherapplication.ui.theme.jostFont
import com.teacherapplication.teacherapplication.ui.theme.openFont
import com.teacherapplication.teacherapplication.ui.utills.exelaGradient

@Composable
fun BookmarksScreen(navController: NavHostController) {
    val searchText = remember { mutableStateOf("") }
    val subjectsList = listOf("Show ALL", "Mathematics", "Science", "Drawing", "Social", "General")
    val isFilterClicked = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 15.dp, top = 40.dp, end = 15.dp)
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            BackArrow(onClick = { navController.popBackStack() })
            Text(
                text = "Bookmarks",
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
                searchValue = searchText,
                modifier = Modifier.fillMaxWidth(0.85f)
            )
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(
                        color = Color(0xFFF3F9FA),
                        shape = RoundedCornerShape(9.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(R.drawable.filter_bookmarks),
                    contentDescription = "filter",
                    tint = Color(0xFF129193),
                    modifier = Modifier
                        .height(22.56.dp)
                        .width(24.dp)
                        .clickable {
                            isFilterClicked.value = true
                        }
                )
            }
        }
        var selectedSubject by remember { mutableStateOf(subjectsList[0]) }
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 5.dp, top = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(30.dp)
        ){
            items(subjectsList){ subject ->
                val isSubjectSelected = (selectedSubject == subject)
                Text(
                    text = subject,
                    style = TextStyle(
                        fontFamily = jostFont,
                        fontWeight = FontWeight(if (isSubjectSelected) 500 else 400),
                        fontSize = 18.sp,
                        lineHeight = 26.01.sp,
                        color = if (isSubjectSelected) Color(0xFF1D1751) else Color(0xFFB5B5B5)
                    ),
                    modifier = Modifier
                        .clickable {
                            selectedSubject = subject
                        }
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        EachBookmarkCard(
            section = "Nursery - A",
            subject = "Mathematics",
            chapterNo = "1",
            chapterTitle = "Additions",
            progress = 0.5f
        )
        Spacer(modifier = Modifier.height(20.dp))
        EachBookmarkCard(
            section = "Nursery - A",
            subject = "Mathematics",
            chapterNo = "1",
            chapterTitle = "Subtractions",
            progress = 0.5f
        )
        Spacer(modifier = Modifier.height(20.dp))
        EachBookmarkCard(
            section = "Nursery - A",
            subject = "Science",
            chapterNo = "1",
            chapterTitle = "Living and non living things",
            progress = 0.5f
        )
        if (isFilterClicked.value){
            FilterBottomSheet(isFilterClicked)
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterBottomSheet(isFilterClicked: MutableState<Boolean>) {
    val classesMap = mapOf("Nursery" to R.drawable.nursery_img,
        "Junior KG" to R.drawable.junior_kg_img,
        "Senior KG" to R.drawable.senior_kg_img
    )
    ModalBottomSheet(
        onDismissRequest = { isFilterClicked.value = false },
        containerColor = Color.White,
        shape = RoundedCornerShape(25.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ){
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    painter = painterResource(R.drawable.filter_bookmarks),
                    contentDescription = "filter",
                    tint = Color(0xFF129193),
                    modifier = Modifier
                        .height(22.56.dp)
                        .width(24.dp)
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = "Filter",
                    style = TextStyle(
                        fontFamily = openFont,
                        fontWeight = FontWeight(600),
                        fontSize = 20.sp,
                        lineHeight = 27.24.sp,
                        letterSpacing = 0.03.sp,
                        color = Color.Black
                    )
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            HorizontalDivider(
                color = Color(0xFFDEDEDE),
                thickness = 1.dp
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp)
            ){
                Text(
                    text = "Filter by Classes",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(20.dp))
                classesMap.forEach{ (key, value) ->
                    ClassCard(name = key, image = value,)
                    Spacer(modifier = Modifier.height(20.dp))
                }
                Spacer(modifier = Modifier.height(50.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ){
                    Button(
                        onClick = { isFilterClicked.value = false },
                        modifier = Modifier
                            .height(54.dp)
                            .width(190.dp)
                            .border(
                                width = 1.dp,
                                brush = exelaGradient,
                                shape = RoundedCornerShape(4.dp)
                            ),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent
                        )
                    ) {
                        Text(
                            text = "Cancel",
                            style = TextStyle(
                                fontFamily = openFont,
                                fontWeight = FontWeight(600),
                                fontSize = 16.sp,
                                lineHeight = 36.sp,
                                brush = exelaGradient
                            )
                        )
                    }
                    Box(
                        modifier = Modifier
                            .width(190.dp)
                            .height(54.dp)
                            .background(
                                brush = exelaGradient,
                                shape = RoundedCornerShape(4.dp)
                            )
                    ){
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(start = 10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Image(
                                painter = painterResource(R.drawable.elephant_button),
                                contentDescription = "elephant"
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(
                                text = "Apply",
                                style = TextStyle(
                                    fontFamily = openFont,
                                    fontWeight = FontWeight(600),
                                    fontSize = 16.sp,
                                    lineHeight = 36.sp,
                                    color = Color.White
                                ),
                            )
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun EachBookmarkCard(
    section: String,
    subject: String,
    chapterNo: String,
    chapterTitle: String,
    progress: Float = 0.5f,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .height(112.dp)
            .width(387.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        text = section,
                        style = TextStyle(
                            fontFamily = italicJost,
                            fontWeight = FontWeight(500),
                            fontSize = 12.sp,
                            lineHeight = 17.34.sp,
                            color = Color(0xFF010101)
                        )
                    )
                    SmallCircle(
                        dim = 4.dp,
                        containerColor = Color.Black.copy(alpha = 0.4f),
                        borderColor = Color.Transparent
                    )
                    Text(
                        text = subject,
                        style = TextStyle(
                            fontFamily = italicJost,
                            fontWeight = FontWeight(500),
                            fontSize = 12.sp,
                            lineHeight = 17.34.sp,
                            brush = Brush.linearGradient(
                                colors = listOf(Color(0xFFF55CC9), Color(0xFFF80759))
                            )
                        )
                    )
                    SmallCircle(
                        dim = 4.dp,
                        containerColor = Color.Black.copy(alpha = 0.4f),
                        borderColor = Color.Transparent
                    )
                    Text(
                        text = "CH$chapterNo",
                        style = TextStyle(
                            fontFamily = italicJost,
                            fontWeight = FontWeight(500),
                            fontSize = 12.sp,
                            lineHeight = 17.34.sp,
                            color = Color(0xFF1D1751)
                        )
                    )
                }
                Image(
                    painter = painterResource(R.drawable.filled_book_mark),
                    contentDescription = "bookmark",
                    modifier = Modifier
                        .height(20.dp)
                        .width(22.dp)
                )
            }
            Text(
                text = chapterTitle,
                style = MaterialTheme.typography.titleMedium.copy(
                    lineHeight = 14.4.sp,
                    color = Color.Black
                ),
                modifier = Modifier.fillMaxWidth(),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "In progress",
                    style = TextStyle(
                        fontFamily = italicJost,
                        fontWeight = FontWeight(400),
                        fontSize = 14.sp,
                        lineHeight = 11.2.sp,
                        color = Color(0xFFFFA043)
                    )
                )
                Icon(
                    painter = painterResource(R.drawable.in_progress),
                    contentDescription = "progress",
                    tint = Color(0xFFFFA043),
                    modifier = Modifier.size(20.dp)
                )
            }
            Spacer(modifier = Modifier.height(5.dp))
            BookmarkProgressBar(progress)
        }
    }
}

@Composable
private fun BookmarkProgressBar(progress: Float = 0.5f) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(5.dp)
    ) {
        Canvas(
            modifier = Modifier.fillMaxSize()
        ) {
            drawRoundRect(
                color = Color(0xFFE7E7E7),
                size = size,
                cornerRadius = CornerRadius(10.dp.toPx())
            )
        }
        Canvas(
            modifier = Modifier.fillMaxSize()
        ) {
            drawRoundRect(
                color = Color(0xFF2679B4),
                size = Size(size.width * progress, size.height),
                cornerRadius = CornerRadius(10.dp.toPx())
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BookmarksScreenPreview(){
    val navController = rememberNavController()
    BookmarksScreen(
        navController = navController,
    )
}