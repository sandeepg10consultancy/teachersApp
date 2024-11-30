package com.teacherapplication.teacherapplication.ui.SubjectChapterList.ArtContent

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.teacherapplication.teacherapplication.R
import com.teacherapplication.teacherapplication.ui.AppComponents.SmallCircle
import com.teacherapplication.teacherapplication.ui.home.dashboard.BottomNavigationBar
import com.teacherapplication.teacherapplication.ui.home.dashboard.DashboardViewModel
import com.teacherapplication.teacherapplication.ui.theme.italicSansFont
import com.teacherapplication.teacherapplication.ui.theme.jostFont


@Composable
fun AssignmentDetails(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: DashboardViewModel
){
    val scrollState = rememberScrollState()
    val isExpanded = remember { mutableStateOf(false) }
    val searchTextField = remember { mutableStateOf("") }
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(top = 40.dp)
                .verticalScroll(scrollState)
        ) {
            TopBox()
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                DataCard(isExpanded)
                Spacer(modifier = Modifier.height(20.dp))
                SearchBox(searchTextField)
                Spacer(modifier = Modifier.height(20.dp))
                TaskStatus(navController)
            }
        }
        BottomAppBar(
            modifier = Modifier.align(Alignment.BottomCenter)
                .background(color = Color.White)
        ) {
            BottomNavigationBar(navController, viewModel)
        }
    }
}

@Composable
fun SubmittedCandidates(index: Int, name: String, image: Int, navController: NavHostController){
    Card(
        modifier = Modifier
            .height(87.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(10.dp),
        onClick = { navController.navigate(route = "studentSubmissions")}
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = if (index < 10) "0$index" else "$index",
                style = MaterialTheme.typography.labelMedium.copy(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFF185573), Color(0xFF14868D))
                    ),
                    fontWeight = FontWeight(700)
                )
            )
            Image(
                painter = painterResource(image),
                contentDescription = "profile",
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
            )
            Column {
                Text(
                    text = name,
                    style = TextStyle(
                        fontFamily = jostFont,
                        fontWeight = FontWeight(500),
                        fontSize = 16.sp,
                        lineHeight = 23.12.sp,
                        color = Color(0xFF1D1751)
                    )
                )
                Text(
                    text = "Aug 22 at 4:00 pm",
                    style = MaterialTheme.typography.labelSmall.copy(
                        fontWeight = FontWeight(300),
                        lineHeight = 15.12.sp,
                        color = Color.Black.copy(alpha = 0.6f)
                    )
                )
            }
            Box(
                modifier = Modifier
                    .height(25.dp)
                    .width(75.dp)
                    .background(
                        color = Color(0xFF4CAF50),
                        shape = RoundedCornerShape(4.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Row {
                    Icon(
                        painter = painterResource(R.drawable.completed),
                        contentDescription = "completed",
                        modifier = Modifier.size(18.dp),
                        tint = Color.White
                    )
                    Text(
                        text = "Checked",
                        style = MaterialTheme.typography.labelSmall.copy(
                            lineHeight = 9.6.sp,
                            color = Color.White
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun NotSubmittedCandidates(index: Int, name: String, image: Int, navController: NavHostController){
    Card(
        modifier = Modifier
            .height(87.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(10.dp),
        onClick = { navController.navigate(route = "studentSubmissions")}
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = if (index < 10) "0$index" else "$index",
                style = MaterialTheme.typography.labelMedium.copy(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFF185573), Color(0xFF14868D))
                    ),
                    fontWeight = FontWeight(700)
                )
            )
            Image(
                painter = painterResource(image),
                contentDescription = "profile",
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
            )
            Column {
                Text(
                    text = name,
                    style = TextStyle(
                        fontFamily = jostFont,
                        fontWeight = FontWeight(500),
                        fontSize = 16.sp,
                        lineHeight = 23.12.sp,
                        color = Color(0xFF1D1751)
                    )
                )
                Text(
                    text = "Aug 22 at 4:00 pm",
                    style = MaterialTheme.typography.labelSmall.copy(
                        fontWeight = FontWeight(300),
                        lineHeight = 15.12.sp,
                        color = Color.Black.copy(alpha = 0.6f)
                    )
                )
            }
            Text(
                text = "Remind",
                style = MaterialTheme.typography.labelSmall.copy(
                    lineHeight = 9.6.sp,
                    color = Color(0xFF2679B4),
                    textDecoration = TextDecoration.Underline
                )
            )
        }
    }
}

@Composable
private fun PendingCandidates(
    index: Int,
    name: String,
    image: Int,
    navController: NavHostController
) {
    Card(
        modifier = Modifier
            .height(87.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(10.dp),
        onClick = { navController.navigate(route = "studentSubmissions/false")}
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = if (index < 10) "0$index" else "$index",
                style = MaterialTheme.typography.labelMedium.copy(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFF185573), Color(0xFF14868D))
                    ),
                    fontWeight = FontWeight(700)
                )
            )
            Image(
                painter = painterResource(image),
                contentDescription = "profile",
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
            )
            Column {
                Text(
                    text = name,
                    style = TextStyle(
                        fontFamily = jostFont,
                        fontWeight = FontWeight(500),
                        fontSize = 16.sp,
                        lineHeight = 23.12.sp,
                        color = Color(0xFF1D1751)
                    )
                )
                Text(
                    text = "Aug 22 at 4:00 pm",
                    style = MaterialTheme.typography.labelSmall.copy(
                        fontWeight = FontWeight(300),
                        lineHeight = 15.12.sp,
                        color = Color.Black.copy(alpha = 0.6f)
                    )
                )
            }
            Box(
                modifier = Modifier
                    .height(25.dp)
                    .width(75.dp)
                    .background(
                        color = Color(0xFFFFAD33),
                        shape = RoundedCornerShape(4.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Row {
                    Icon(
                        painter = painterResource(R.drawable.in_progress),
                        contentDescription = "pending",
                        modifier = Modifier.size(18.dp),
                        tint = Color.White
                    )
                    Text(
                        text = "Pending",
                        style = MaterialTheme.typography.labelSmall.copy(
                            lineHeight = 9.6.sp,
                            color = Color.White
                        )
                    )
                }
            }
        }
    }
}

@Composable
private fun TaskStatus(navController: NavHostController) {
    val tasksList = listOf("All", "Submitted", "Not Submitted")
    var selectedItem  by remember { mutableStateOf(tasksList[0]) }
    val pendingCandidates = listOf("Chandini" to R.drawable.profile_img_1,"Shyam" to R.drawable.profile_img_2)
    val submittedCandidates = listOf("Vinay" to R.drawable.profile_img_2,"Ramya" to R.drawable.profile_img_3)
    val notSubmittedCandidates = listOf("Raj" to R.drawable.profile_img_2,"Kamala" to R.drawable.profile_img_1 )
    val allCandidates  = pendingCandidates + submittedCandidates

    Card(
        modifier = Modifier
            .height(56.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp)
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            tasksList.forEachIndexed { index, task ->
                val isSelected = selectedItem == task
                Box(
                    modifier = Modifier
                        .height(37.dp)
                        .background(
                            color = if (isSelected) Color(
                                0xFF1D1751
                            ) else Color.Transparent,
                            shape = RoundedCornerShape(6.dp)
                        )
                        .clickable {
                            selectedItem = task
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = task,
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight(if (isSelected) 600 else 400),
                        color = if (isSelected) Color.White else Color.Black.copy(alpha = 0.5f),
                        modifier = Modifier.padding(
                            start = 20.dp,
                            top = 10.dp,
                            end = 20.dp,
                            bottom = 10.dp
                        )
                    )
                }
                if (index != tasksList.lastIndex) {
                    VerticalDivider(modifier = Modifier.height(30.dp))
                }
            }
        }
    }
    Spacer(modifier = Modifier.height(20.dp))
    when(selectedItem){
        tasksList[0] -> {
            allCandidates.forEachIndexed { index, (name, image) ->
                if (index < pendingCandidates.size) {
                    PendingCandidates(index + 1, name, image, navController)
                    Spacer(modifier = Modifier.height(10.dp))
                }else{
                    SubmittedCandidates(index+1, name, image, navController)
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
        tasksList[1] -> {
            submittedCandidates.forEachIndexed { index, (name,image) ->
                SubmittedCandidates(index + 1, name, image, navController)
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
        tasksList[2] -> {
            notSubmittedCandidates.forEachIndexed { index, (name, image) ->
                NotSubmittedCandidates(index + 1, name, image, navController)
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
    Spacer(modifier = Modifier.height(150.dp))

}

@Composable
private fun SearchBox(searchTextField: MutableState<String>) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(3.dp)
    ) {
        Box(
            modifier = Modifier
                .height(50.dp)
                .width(327.dp)
                .background(
                    color = Color(0xFFF3F9FA),
                    shape = RoundedCornerShape(8.dp)
                ),
        ) {
            Row(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.search),
                    contentDescription = "search",
                    modifier = Modifier
                        .size(21.dp)
                        .clickable { }
                )

                TextField(
                    value = searchTextField.value,
                    onValueChange = { searchTextField.value = it },
                    modifier = Modifier.fillMaxSize(),
                    placeholder = {
                        Text(
                            text = "Search By Name",
                            style = MaterialTheme.typography.labelSmall.copy(
                                brush = Brush.linearGradient(
                                    colors = listOf(Color(0xFF185573), Color(0xFF14868D))
                                ),
                                lineHeight = 15.12.sp
                            )
                        )
                    },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        cursorColor = Color.Black,
                        focusedTextColor = Color.Black
                    ),
                )
            }
        }
        Box(
            modifier = Modifier
                .height(45.dp)
                .width(53.dp)
                .background(
                    color = Color(0xFFF3F9FA),
                    shape = RoundedCornerShape(8.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.modify),
                contentDescription = "modify",
                modifier = Modifier
                    .width(23.dp)
                    .height(26.54.dp)
                    .clickable {  }
            )
        }
    }
}

@Composable
private fun DataCard(isExpanded: MutableState<Boolean>) {
    Card(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        shape = RoundedCornerShape(12.dp)
    ) {
        Box(modifier = Modifier) {
            Column(
                modifier = Modifier
                    .padding(10.dp),
            ) {
                Column(
                    modifier = Modifier
                        .padding(15.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text = "Assignment Name",
                                style = MaterialTheme.typography.titleMedium.copy(
                                    lineHeight = 14.4.sp
                                )
                            )
                            Row(
                                modifier = Modifier,
                                horizontalArrangement = Arrangement.spacedBy(10.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Art",
                                    style = TextStyle(
                                        fontFamily = italicSansFont,
                                        fontWeight = FontWeight(500),
                                        fontSize = 14.sp,
                                        lineHeight = 11.2.sp,
                                        color = Color(0xFF129193)
                                    ),
                                    modifier = Modifier.alignByBaseline()
                                )
                                SmallCircle(
                                    dim = 4.dp,
                                    containerColor = Color(0xFF129193),
                                    borderColor = Color.Transparent
                                )
                                Text(
                                    text = "Ch-4",
                                    style = TextStyle(
                                        fontFamily = italicSansFont,
                                        fontWeight = FontWeight(500),
                                        fontSize = 14.sp,
                                        lineHeight = 11.2.sp,
                                        color = Color(0xFF129193)
                                    ),
                                    modifier = Modifier.alignByBaseline()
                                )
                                SmallCircle(
                                    dim = 4.dp,
                                    containerColor = Color(0xFF129193),
                                    borderColor = Color.Transparent
                                )
                                Text(
                                    text = "JuniorKG-A",
                                    style = TextStyle(
                                        fontFamily = italicSansFont,
                                        fontWeight = FontWeight(500),
                                        fontSize = 14.sp,
                                        lineHeight = 11.2.sp,
                                        color = Color(0xFF129193)
                                    ),
                                    modifier = Modifier.alignByBaseline()
                                )
                            }
                        }
                        Box(
                            modifier = Modifier
                                .height(25.dp)
                                .width(73.dp)
                                .clip(RoundedCornerShape(4.dp))
                                .background(
                                    brush = Brush.linearGradient(
                                        colors = listOf(
                                            Color(0xFFE67E22),
                                            Color(0xFFFFC261)
                                        )
                                    )
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Pending",
                                style = MaterialTheme.typography.labelSmall.copy(
                                    fontWeight = FontWeight(500),
                                    lineHeight = 9.6.sp,
                                    color = Color.White
                                )
                            )
                        }
                    }
                    Row(
                        modifier = Modifier.padding(top = 10.dp),
                        horizontalArrangement = Arrangement.spacedBy(15.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .width(56.dp)
                                .height(22.dp)
                                .clip(RoundedCornerShape(20.dp))
                                .background(
                                    color = Color(0xFFE5EFFF)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "CG-1.1",
                                style = MaterialTheme.typography.labelSmall.copy(
                                    lineHeight = 9.6.sp,
                                    color = Color(0xFF1D6BF3)
                                )
                            )
                        }
                        Box(
                            modifier = Modifier
                                .width(56.dp)
                                .height(22.dp)
                                .clip(RoundedCornerShape(20.dp))
                                .background(
                                    color = Color(0xFFE5EFFF)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "CG-1.2",
                                style = MaterialTheme.typography.labelSmall.copy(
                                    lineHeight = 9.6.sp,
                                    color = Color(0xFF1D6BF3)
                                )
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(2.dp),
                        ) {
                            Text(
                                text = "Created by",
                                style = MaterialTheme.typography.labelSmall.copy(
                                    lineHeight = 9.6.sp,
                                    color = Color(0xFF2679B4)
                                )
                            )
                            Text(
                                text = "Teacher",
                                style = MaterialTheme.typography.labelSmall.copy(
                                    lineHeight = 9.6.sp,
                                    color = Color.Black
                                )
                            )
                        }
                        Column(
                            verticalArrangement = Arrangement.spacedBy(2.dp),
                        ) {
                            Text(
                                text = "Created On",
                                style = MaterialTheme.typography.labelSmall.copy(
                                    lineHeight = 9.6.sp,
                                    color = Color(0xFF2679B4)
                                )
                            )
                            Text(
                                text = "22 August 2024",
                                style = MaterialTheme.typography.labelSmall.copy(
                                    lineHeight = 9.6.sp,
                                    color = Color.Black
                                )
                            )
                        }
                        Column(
                            verticalArrangement = Arrangement.spacedBy(2.dp),
                        ) {
                            Text(
                                text = "Deadline",
                                style = MaterialTheme.typography.labelSmall.copy(
                                    lineHeight = 9.6.sp,
                                    color = Color(0xFF2679B4)
                                )
                            )
                            Text(
                                text = "22 August 2024",
                                style = MaterialTheme.typography.labelSmall.copy(
                                    lineHeight = 9.6.sp,
                                    color = Color.Black
                                )
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier.height(1.dp),
                    color = Color.Black.copy(alpha = 0.2f)
                )
                Text(
                    text = "Hi Nursery A explorers! \nFor your science homework, please find a small leaf or flower and upload a photo of it to our class portal \nRead More.",
                    style = TextStyle(
                        fontFamily = jostFont,
                        fontWeight = FontWeight(400),
                        fontSize = 14.sp,
                        lineHeight = 20.23.sp
                    ),
                    maxLines = if (isExpanded.value) Int.MAX_VALUE else 3,
                    modifier = Modifier
                        .padding(15.dp)
                        .alpha(if (isExpanded.value) 1f else 0.2f)
                )
                if (isExpanded.value){
                    Column(
                        modifier = Modifier
                            .padding(15.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ){
                        Text(
                            text = "Attachment File",
                            style = TextStyle(
                                fontFamily = jostFont,
                                fontWeight = FontWeight(500),
                                fontSize = 14.sp,
                                lineHeight = 20.23.sp
                            )
                        )
                        PDFBox()
                    }
                }
                Spacer(modifier = Modifier.height(50.dp))
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { isExpanded.value = !isExpanded.value }
                    .align(Alignment.BottomCenter),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                if (isExpanded.value) {
                    Image(
                        painter = painterResource(R.drawable.up_arrow_img),
                        contentDescription = "up",
                        modifier = Modifier
                            .size(20.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                    Text(
                        text = "View Less",
                        style = MaterialTheme.typography.labelMedium.copy(
                            brush = Brush.linearGradient(
                                colors = listOf(Color(0xFF185573), Color(0xFF14868D))
                            ),
                            fontWeight = FontWeight(600)
                        )
                    )
                } else {
                    Text(
                        text = "View More",
                        style = MaterialTheme.typography.labelMedium.copy(
                            brush = Brush.linearGradient(
                                colors = listOf(Color(0xFF185573), Color(0xFF14868D))
                            ),
                            fontWeight = FontWeight(600)
                        )
                    )
                    Image(
                        painter = painterResource(R.drawable.down_arrow),
                        contentDescription = "down",
                        modifier = Modifier
                            .size(20.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}

@Composable
fun PDFBox(){
    Box(
        modifier = Modifier
            .height(60.dp)
            .background(
                color = Color(0xFFE9F2F7),
                shape = RoundedCornerShape(8.dp)
            )
            .clickable {  }
    ){
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ){
                Image(
                    painter = painterResource(R.drawable.pdf),
                    contentDescription = "pdf",
                    modifier = Modifier.size(29.dp)
                )
                Column {
                    Text(
                        text = "Shapes and colors",
                        style = MaterialTheme.typography.labelMedium,
                        color = Color.Black
                    )
                    Text(
                        text = "1 Page",
                        style = TextStyle(
                            fontFamily = jostFont,
                            fontWeight = FontWeight(400),
                            fontSize = 12.sp,
                            lineHeight = 17.34.sp,
                            color = Color.Black.copy(alpha = 0.5f)
                        )
                    )
                }
            }
            Image(
                painter = painterResource(R.drawable.download),
                contentDescription = "pdf",
                modifier = Modifier.size(20.dp)
            )
        }
    }
}


@Composable
private fun TopBox() {
    Box(
        modifier = Modifier
            .height(74.dp)
            .fillMaxWidth()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFF185573), Color(0xFF14868D))
                )
            )
            .padding(20.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "back",
                modifier = Modifier.size(24.dp),
                tint = Color.White
            )
            Text(
                text = "Art",
                style = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight(600),
                    lineHeight = 12.8.sp,
                    color = Color.White
                ),
                modifier = Modifier.alignByBaseline()
            )
            SmallCircle(
                dim = 4.dp,
                containerColor = Color(0xFFF4F4F4),
                borderColor = Color.Transparent
            )
            Text(
                text = "Ch-4",
                style = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight(600),
                    lineHeight = 12.8.sp,
                    color = Color.White
                ),
                modifier = Modifier.alignByBaseline()
            )
            SmallCircle(
                dim = 4.dp,
                containerColor = Color(0xFFF4F4F4),
                borderColor = Color.Transparent
            )
            Text(
                text = "JuniorKG-A",
                style = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight(600),
                    lineHeight = 12.8.sp,
                    color = Color.White
                ),
                modifier = Modifier.alignByBaseline()
            )
        }
    }
}