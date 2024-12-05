package com.teacherapplication.teacherapplication.ui.home

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teacherapplication.teacherapplication.R
import com.teacherapplication.teacherapplication.ui.AppComponents.BackArrow
import com.teacherapplication.teacherapplication.ui.home.ModalDrawer.FilterBottomSheet
import com.teacherapplication.teacherapplication.ui.home.ModalDrawer.SearchFieldFunction


@Composable
fun NotificationsScreen(){
    val searchNotification = remember { mutableStateOf("") }
    val isFilterClicked = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 15.dp, top = 40.dp, end = 15.dp)
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            BackArrow(onClick = {  })
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
                searchValue = searchNotification,
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
        if (isFilterClicked.value){
            FilterBottomSheet(isFilterClicked)
        }
    }
}

