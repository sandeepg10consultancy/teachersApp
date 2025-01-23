package com.teacherapplication.teacherapplication.ui.home.ModalDrawer.StudentPerformance

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
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
import com.teacherapplication.teacherapplication.ui.home.ModalDrawer.SearchFieldFunction
import com.teacherapplication.teacherapplication.ui.theme.jostFont
import com.teacherapplication.teacherapplication.ui.utills.exelaGradient


@Composable
fun StudentListScreen(navController: NavHostController) {
    val scrollState = rememberScrollState()
    val searchedValue = remember { mutableStateOf("") }
    val subjectsList = mapOf(
        "All" to listOf(listOf(Color(0xFF185573), Color(0xFF14868D)), listOf(Color.White, Color.White), R.drawable.perform_all),
        "Arts" to listOf(listOf(Color(0xFFFDC194), Color(0xFFFF6020)), listOf(Color.White, Color.White), R.drawable.perform_arts),
        "Numeracy" to listOf(listOf(Color(0xFF99D6FC), Color(0xFF2C84DA)), listOf(Color(0xFF2F86DB), Color(0xFF7BC0F3)), R.drawable.perform_numeracy),
        "Literacy" to listOf(listOf(Color(0xFFE67E22), Color(0xFFFFC261)), listOf(Color.White, Color.White), R.drawable.perform_literacy),
        "General Awareness" to listOf(listOf(Color(0xFF93ECFF), Color(0xFF2093C3)), listOf(Color.White, Color.White), R.drawable.general_img),
    )
    val selectedSubject = remember { mutableStateOf("All") }
    val studentDetails = listOf(
        "Akshata S." to listOf(R.drawable.profile_girl,"01"),
        "Pravin" to listOf(R.drawable.profile_boy,"11"),
        "Rushikesh." to listOf(R.drawable.profile_boy,"08"),
        "Keval" to listOf(R.drawable.profile_boy,"07"),
        "Vinay" to listOf(R.drawable.profile_boy,"02"),
        "Swapnil" to listOf(R.drawable.profile_boy,"03"),
        "Sanjay" to listOf(R.drawable.profile_boy,"06"),
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
        SearchFieldFunction(
            searchValue = searchedValue,
            labelText = "Search student here"
        )
        SelectedSectionCard()
        LazyRow(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ){
            subjectsList.forEach { (title, attributes) ->
                item {
                    val outerColors = attributes[0] as List<Color>
                    val innerColors = attributes[1] as List<Color>
                    val image = attributes[2] as Int
                    SubjectIconTitle(
                        title = title,
                        outerColorsList = outerColors,
                        innerColorsList = innerColors,
                        image = image,
                        selectedSubject = selectedSubject
                    )
                }
            }
        }
        EachTopicCard(studentDetails = studentDetails, navController = navController)
    }

}

@Composable
fun EachTopicCard(studentDetails: List<Pair<String, List<Any>>>, navController: NavHostController) {
    Box(
        modifier = Modifier
            .width(310.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(
                color = Color.Gray,
                shape = RoundedCornerShape(20.dp)
            )
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ){
            Box(
                modifier = Modifier
                    .height(41.dp)
                    .width(282.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        color = Color.White.copy(alpha = 0.27f)
                    ),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = "Land",
                    style = MaterialTheme.typography.titleSmall,
                    color = Color.White
                )
            }
            Spacer(
                modifier = Modifier
                    .height(15.dp)
            )
            Box(
                modifier = Modifier
                    .width(282.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(
                        color = Color.Black.copy(alpha = 0.2f)
                    )
                    .padding(20.dp)
            ){
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ){
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Text(
                            text = "Name",
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontSize = 14.sp,
                                lineHeight = 20.23.sp,
                                color = Color.White
                            )
                        )
                        Text(
                            text = "Roll - No",
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontSize = 14.sp,
                                lineHeight = 20.23.sp,
                                color = Color.White
                            )
                        )
                    }
                    HorizontalDivider(
                        thickness = 0.2.dp,
                        color = Color.White
                    )
                    studentDetails.forEach{ student ->
                        val image = student.second[0] as Int
                        val rollNumber = student.second[1] as String
                        StudentDetails(
                            image = image,
                            name = student.first,
                            rollNumber = rollNumber,
                            navController = navController
                        )

                    }
                }
            }
        }

    }
}

@Composable
private fun StudentDetails(
    image: Int,
    name: String,
    rollNumber: String,
    navController: NavHostController
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(0.94f),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = "profile",
                modifier = Modifier
                    .size(25.dp)
                    .clip(CircleShape)
            )
            Text(
                text = name,
                style = TextStyle(
                    fontFamily = jostFont,
                    fontWeight = FontWeight(500),
                    fontSize = 16.sp,
                    lineHeight = 23.12.sp,
                    color = Color.White
                ),
                modifier = Modifier
                    .width(79.dp)
                    .clickable {
                        navController.navigate(route = "studentOverall")
                    },
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        Text(
            text = rollNumber,
            style = TextStyle(
                fontFamily = jostFont,
                fontWeight = FontWeight(500),
                fontSize = 16.sp,
                lineHeight = 23.12.sp,
                color = Color.White
            )
        )
    }
}

@Composable
private fun SubjectIconTitle(
    title: String,
    outerColorsList: List<Color>,
    innerColorsList: List<Color>,
    image: Int,
    selectedSubject: MutableState<String>
) {
    val isSelected = selectedSubject.value == title
    Column(
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                selectedSubject.value = title
            },
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Box(
            modifier = Modifier
                .size(70.dp)
                .clip(CircleShape)
                .background(
                    brush = Brush.linearGradient(
                        colors = outerColorsList
                    ),
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(
                        brush = Brush.linearGradient(
                            colors = innerColorsList
                        ),
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(image),
                    contentDescription = "all",
                    modifier = Modifier
                        .scale(1.2f)
                )
            }
        }
        Text(
            text = title,
            style = TextStyle(
                fontFamily = jostFont,
                fontWeight = FontWeight(if (isSelected) 700 else 500),
                fontSize = 16.sp,
                lineHeight = 23.12.sp,
                letterSpacing = 0.03.sp,
                color = if (isSelected) Color(0xFF1D1751) else Color.Black.copy(alpha = 0.6f)
            ),
            modifier = Modifier
                .width(80.dp),
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }

}

@Composable
private fun SelectedSectionCard() {
    Card(
        modifier = Modifier
            .height(61.dp)
            .fillMaxWidth()
            .shadow(
                elevation = 5.dp,
                shape = RoundedCornerShape(8.dp)
            ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "You are viewing",
                    style = TextStyle(
                        fontFamily = jostFont,
                        fontWeight = FontWeight(400),
                        fontSize = 12.sp,
                        lineHeight = 9.6.sp
                    )
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        text = "Nursery",
                        style = TextStyle(
                            fontFamily = jostFont,
                            fontWeight = FontWeight(500),
                            fontSize = 18.sp,
                            lineHeight = 14.4.sp,
                            brush = exelaGradient
                        )
                    )
                    SmallCircle(
                        dim = 4.dp,
                        containerColor = Color(0xFF1D1751),
                        borderColor = Color.Transparent
                    )
                    Text(
                        text = "A",
                        style = TextStyle(
                            fontFamily = jostFont,
                            fontWeight = FontWeight(500),
                            fontSize = 18.sp,
                            lineHeight = 14.4.sp,
                            brush = exelaGradient
                        )
                    )
                }
            }
            Box(
                modifier = Modifier
                    .size(26.dp)
                    .clip(CircleShape)
                    .border(
                        width = 0.8.dp,
                        color = Color(0xFF1D1751),
                        shape = CircleShape
                    )
                    .clickable {

                    },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.performance_edit),
                    contentDescription = "edit",
                    modifier = Modifier
                        .size(13.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StudentListScreenPreview(){
    val navController = rememberNavController()
    StudentListScreen(
        navController = navController,
    )
}