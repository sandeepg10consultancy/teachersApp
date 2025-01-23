package com.teacherapplication.teacherapplication.ui.Diary

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.teacherapplication.teacherapplication.R
import com.teacherapplication.teacherapplication.ui.AppComponents.BackArrow
import com.teacherapplication.teacherapplication.ui.home.dashboard.BottomNavigationBar
import com.teacherapplication.teacherapplication.ui.home.dashboard.DashboardViewModel
import com.teacherapplication.teacherapplication.ui.theme.jostFont
import com.teacherapplication.teacherapplication.ui.utills.exelaGradient

@Composable
fun DailyDiaryScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: DashboardViewModel
){
    val searchedGroup = remember { mutableStateOf("") }
    Box(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 15.dp, top = 40.dp, end = 15.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                BackArrow(onClick = {
                    viewModel.setSelectedIcon("Home")
                    navController.popBackStack()
                })
                Text(
                    text = "Daily Diary",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontSize = 20.sp,
                        lineHeight = 28.9.sp,
                        color = Color(0xFF333333)
                    )
                )
                Text(
                    text = "Create",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight(500),
                        brush = exelaGradient
                    ),
                    modifier = Modifier.clickable {
                        navController.navigate(route = "newGroupScreen")
                    }
                )
            }
            SearchGroupBox(searchedGroup)
            EachGroupCard(
                section = "Nursery A",
                members = "15",
                navController = navController
            )
            EachGroupCard(
                section = "Nursery B",
                members = "20",
                navController = navController
            )
            EachGroupCard(
                section = "Junior.KG A",
                members = "25",
                navController = navController
            )
        }
        BottomAppBar(
            modifier = Modifier
                .align(Alignment.BottomCenter),
            containerColor = Color.White
        ){
            BottomNavigationBar(navController, viewModel)
        }
    }
}

@Composable
private fun EachGroupCard(
    section: String,
    members: String,
    navController: NavHostController
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
        shape = RoundedCornerShape(15.dp),
        onClick = { navController.navigate(route = "groupDiscussion") }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.nursery_a_diary),
                contentDescription = "icon",
                modifier = Modifier
                    .clip(CircleShape)
                    .size(60.dp)
            )
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = section,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "$members Members",
                    style = TextStyle(
                        fontFamily = jostFont,
                        fontWeight = FontWeight(400),
                        fontSize = 14.sp,
                        lineHeight = 20.23.sp,
                        color = Color(0xFF129193)
                    )
                )
            }
        }
    }
}

@Composable
private fun SearchGroupBox(searchedGroup: MutableState<String>) {
    Box(
        modifier = Modifier
            .height(48.dp)
            .fillMaxWidth()
            .background(
                color = Color(0xFFF3F9FA),
                shape = RoundedCornerShape(8.dp)
            )
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
                    .size(15.dp)
                    .clickable {
                        //Log.d("section",searchedGroup.value)
                    }
            )
            TextField(
                value = searchedGroup.value,
                onValueChange = { searchedGroup.value = it },
                textStyle = MaterialTheme.typography.bodySmall,
                modifier = Modifier.fillMaxSize(),
                placeholder = {
                    Text(
                        text = "Search your Group here",
                        style = MaterialTheme.typography.labelMedium.copy(
                            brush = exelaGradient,
                            lineHeight = 11.12.sp
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
}

@Preview(showBackground = true)
@Composable
fun DailyDiaryScreenPreview(){
    val navController = rememberNavController()
    val viewModel: DashboardViewModel = viewModel()
    DailyDiaryScreen(
        navController = navController,
        viewModel = viewModel
    )
}