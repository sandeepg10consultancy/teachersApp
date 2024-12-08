package com.teacherapplication.teacherapplication.ui.Diary

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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.teacherapplication.teacherapplication.R
import com.teacherapplication.teacherapplication.ui.AppComponents.BackArrow
import com.teacherapplication.teacherapplication.ui.AppComponents.brush
import com.teacherapplication.teacherapplication.ui.theme.jostFont

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GroupDiscussionScreen(modifier: Modifier = Modifier, navController: NavHostController){
    val itemsList = listOf("All", "Homework", "Bring to school", "Special Request", "Notice", "Holiday Alert")
    var selectedItem by remember { mutableStateOf(itemsList[0]) }
    val messageField = remember { mutableStateOf("") }
    val isModelSheet = remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 40.dp)
        ){
            TopSectionCard(isModelSheet,navController)
            Spacer(modifier = Modifier.height(20.dp))
            LazyRow(){
                items(itemsList){ item ->
                    val isSelected = (selectedItem == item)
                    Box(modifier = Modifier
                        .height(30.dp)
                        .padding(start = 10.dp)
                        .background(
                            color = if (isSelected) Color(0xFF129193) else Color(0xFFF5F5F5),
                            shape = RoundedCornerShape(15.dp)
                        )
                        .clickable {
                            selectedItem = item
                        },
                        contentAlignment = Alignment.Center
                    ){
                        Text(
                            text = item,
                            style = MaterialTheme.typography.labelMedium.copy(
                                fontWeight = FontWeight(600),
                                color = if (isSelected) Color.White else Color.Black.copy(alpha = 0.6f)
                            ),
                            modifier = Modifier
                                .padding(start = 20.dp, end = 20.dp)
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Spacer(modifier = Modifier.height(20.dp))
        }
        TextingBox(modifier = Modifier.align(Alignment.BottomCenter), messageField)
        if (isModelSheet.value){
            ModalBottomSheet(
                onDismissRequest = { isModelSheet.value = false},
                dragHandle = { BottomSheetDefaults.ExpandedShape },
                containerColor = Color.White,
                modifier = Modifier.fillMaxSize()
            ) {
                AnnouncementModelSheet(isModelSheet)
            }
        }
    }
}

@Composable
private fun TextingBox(modifier: Modifier = Modifier, messageField: MutableState<String>) {
    Row(
        modifier = modifier
            .padding(start = 10.dp, end = 10.dp, bottom = 30.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Box(
            modifier = Modifier
                .height(42.93.dp)
                .fillMaxWidth(0.85f)
                .border(
                    width = 1.07.dp,
                    brush = brush,
                    shape = RoundedCornerShape(21.46.dp)
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 10.dp, top = 5.dp, end = 10.dp, bottom = 5.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.emoji),
                    contentDescription = "emoji",
                    modifier = Modifier
                        .size(25.76.dp)
                        .clickable { }
                )
                VerticalDivider(
                    thickness = 1.07.dp,
                    color = Color(0xFF9F9F9F)
                )
                TextField(
                    value = messageField.value,
                    onValueChange = { messageField.value = it },
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(0.7f),
                    placeholder = {
                        Text(
                            text = "Type here",
                            style = TextStyle(
                                fontFamily = jostFont,
                                fontWeight = FontWeight(400),
                                fontSize = 16.sp,
                                lineHeight = 21.46.sp,
                                color = Color(0xFF575757).copy(alpha = 0.3f)
                            )
                        )
                    },
                    singleLine = true, // Ensure single-line text behavior
                    textStyle = TextStyle(
                        fontFamily = jostFont,
                        fontWeight = FontWeight(400),
                        fontSize = 16.sp,
                        lineHeight = 21.46.sp,
                        color = Color.Black // Ensure the text value is visible
                    ),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        cursorColor = Color.Black,
                        focusedTextColor = Color.Black
                    ),
                )
                Image(
                    painter = painterResource(R.drawable.add_link),
                    contentDescription = "emoji",
                    modifier = Modifier
                        .size(25.76.dp)
                        .clickable { }
                )
                Image(
                    painter = painterResource(R.drawable.camera),
                    contentDescription = "emoji",
                    modifier = Modifier
                        .size(25.76.dp)
                        .clickable { }
                )
            }
        }
        Box(
            modifier = Modifier
                .size(42.93.dp)
                .border(
                    width = 1.07.dp,
                    brush = brush,
                    shape = CircleShape
                )
                .padding(7.dp),
        ) {
            Image(
                painter = painterResource(R.drawable.post),
                contentDescription = "post",
                modifier = Modifier
                    .size(25.76.dp)
            )
        }
    }
}

@Composable
private fun TopSectionCard(isModelSheet: MutableState<Boolean>, navController: NavHostController) {
    Card(
        modifier = Modifier
            .height(78.dp)
            .fillMaxWidth(),
        shape = RectangleShape,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 10.dp, end = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                BackArrow(onClick = { navController.popBackStack() })
                Image(
                    painter = painterResource(R.drawable.nursery_a_diary),
                    contentDescription = "icon",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                )
                Column {
                    Text(
                        text = "Nursery A",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight(500),
                            color = Color.Black
                        )
                    )
                    Text(
                        text = "15 Members",
                        style = TextStyle(
                            fontFamily = jostFont,
                            fontWeight = FontWeight(300),
                            fontSize = 12.sp,
                            lineHeight = 17.34.sp,
                            color = Color(0xFF129193)
                        )
                    )
                }
            }
            Icon(
                imageVector = Icons.Filled.MoreVert,
                contentDescription = "more",
                modifier = Modifier
                    .size(24.dp)
                    .clickable { isModelSheet.value = true }
            )

        }
    }
}