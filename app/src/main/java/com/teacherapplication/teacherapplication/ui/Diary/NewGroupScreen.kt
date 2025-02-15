package com.teacherapplication.teacherapplication.ui.Diary

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
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
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
import com.teacherapplication.teacherapplication.ui.login.account.ClassCard
import com.teacherapplication.teacherapplication.ui.theme.jostFont
import com.teacherapplication.teacherapplication.ui.utills.exelaGradient

@Composable
fun NewGroupScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: DashboardViewModel
){
    val groupDescriptionField = remember { mutableStateOf("Welcome to Nursery A!") }
    val classesMap = mapOf("Nursery" to R.drawable.nursery_img,
        "Junior KG" to R.drawable.junior_kg_img,
        "Senior KG" to R.drawable.senior_kg_img
    )
    Box(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 15.dp, top = 40.dp, end = 15.dp),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                BackArrow(onClick = { navController.popBackStack() })
                Text(
                    text = "New Group",
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

                    }
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            GroupDescriptionBox(groupDescriptionField)
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Select Class",
                style = TextStyle(
                    fontFamily = jostFont,
                    fontWeight = FontWeight(500),
                    fontSize = 16.sp,
                    lineHeight = 23.12.sp,
                    color = Color.Black
                )
            )
            Spacer(modifier = Modifier.height(20.dp))
            classesMap.forEach{ (key, value) ->
                ClassCard(name = key, image = value,)
                Spacer(modifier = Modifier.height(20.dp))
            }
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
private fun GroupDescriptionBox(groupDescriptionField: MutableState<String>) {
    Text(
        text = "Group Description",
        style = TextStyle(
            fontFamily = jostFont,
            fontWeight = FontWeight(500),
            fontSize = 16.sp,
            lineHeight = 23.12.sp,
            color = Color.Black
        )
    )
    Spacer(modifier = Modifier.height(10.dp))
    Box(
        modifier = Modifier
            .drawBehind {
                val strokeWidth = 2.dp.toPx()
                drawRoundRect(
                    brush = exelaGradient,
                    size = size,
                    style = Stroke(strokeWidth),
                    cornerRadius = CornerRadius(x = 6.dp.toPx(), y = 6.dp.toPx()),
                )
            }
            .height(148.dp)
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxSize(),
            value = groupDescriptionField.value,
            textStyle = MaterialTheme.typography.bodySmall,
            onValueChange = { groupDescriptionField.value = it },
            placeholder = {
                Text(
                    text = "Enter Description",
                    style = MaterialTheme.typography.bodySmall,
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            ),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NewGroupScreenPreview(){
    val navController = rememberNavController()
    val viewModel: DashboardViewModel = viewModel()
    NewGroupScreen(
        navController = navController,
        viewModel = viewModel
    )
}