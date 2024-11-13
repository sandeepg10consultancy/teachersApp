package com.teacherapplication.teacherapplication.ui.SubjectChapterList

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import androidx.compose.ui.zIndex
import com.teacherapplication.teacherapplication.R
import com.teacherapplication.teacherapplication.ui.AppComponents.BackArrow
import com.teacherapplication.teacherapplication.ui.AppComponents.TopProgressBar
import com.teacherapplication.teacherapplication.ui.home.dashboard.BottomNavigationBar
import com.teacherapplication.teacherapplication.ui.theme.jostFont

@Preview(showBackground = true)
@Composable
fun ContentViewScreen(){
    val verticalScroll = rememberScrollState()
    var dropDownStatus by remember { mutableStateOf(false) }
    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier.fillMaxWidth()
                .verticalScroll(verticalScroll)
        ) {
            TopProgressBar()
            BackArrow()
            Column(
                modifier = Modifier
                    .padding(15.dp)
            ){
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    ClassSubjectBox()
                    DropDownBar(
                        dropDownStatus = dropDownStatus,
                        onDropDownStatusChange = {dropDownStatus = it}
                        )
                }
                Text(
                    text = "1.Flower",
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
        if (dropDownStatus){
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.1f))
                    .clickable { dropDownStatus = false }
                    .zIndex(1f)
            )
        }

        BottomAppBar(
            modifier = Modifier.align(Alignment.BottomCenter)
        ){
            BottomNavigationBar()
        }
    }
}


@Composable
fun DropDownBar(dropDownStatus: Boolean, onDropDownStatusChange: (Boolean) -> Unit) {
    //var dropDownStatus by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf("In Progress") }
    var selectedColor by remember { mutableStateOf(Color(0xFFFFA043).copy(alpha = 0.1f)) }
    var selectedTextColor by remember { mutableStateOf(Color(0xFFFFA043)) }
    var selectedIcon by remember { mutableStateOf(R.drawable.in_progress) }

    val items = listOf(
        "In Progress" to Pair(Color(0xFFFFA043).copy(alpha = 0.1f), R.drawable.in_progress),
        "Completed" to Pair(Color(0xFF2D9549).copy(alpha = 0.1f), R.drawable.completed),
    )

        Box(
            modifier = Modifier
                .zIndex(2f)
        ) {
            Column(
                modifier = Modifier
                    .zIndex(1f)
            ){
                Box(
                    modifier = Modifier
                        .height(30.dp)
                        .width(143.dp)
                        .background(
                            color = selectedColor,
                            shape = RoundedCornerShape(15.dp)
                        )
                        .clickable { onDropDownStatusChange(true)}
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 8.dp, end = 8.dp),
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(selectedIcon),
                            contentDescription = selectedItem,
                            modifier = Modifier.size(18.dp)
                        )
                        Text(
                            text = selectedItem,
                            style = TextStyle(
                                fontFamily = jostFont,
                                fontSize = 14.sp,
                                fontWeight = FontWeight(400),
                                lineHeight = 11.2.sp,
                                color = selectedTextColor
                            )
                        )
                        Image(
                            painter = painterResource(R.drawable.down_arrow),
                            contentDescription = "Dropdown Arrow",
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }
                if (dropDownStatus) {
                    Column(
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.White)
                            .fillMaxHeight()
                            .width(143.dp)
                            .padding(start = 10.dp, end = 10.dp)
                            .zIndex(2f),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        items.forEachIndexed { index, item ->
                            DropdownMenuItem(
                                onClick = {
                                    selectedItem = item.first
                                    selectedColor = item.second.first
                                    selectedIcon = item.second.second
                                    selectedTextColor = when (item.first) {
                                        "In Progress" -> Color(0xFFFFA043)
                                        "Completed" -> Color(0xFF2D9549)
                                        else -> Color.Black
                                    }
                                    onDropDownStatusChange(false)
                                },
                                text = {
                                    Row(
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Image(
                                            painter = painterResource(item.second.second),
                                            contentDescription = item.first,
                                            modifier = Modifier.size(18.dp)
                                        )
                                        Text(
                                            text = item.first,
                                            style = TextStyle(
                                                fontFamily = jostFont,
                                                fontSize = 14.sp,
                                                fontWeight = FontWeight(400),
                                                lineHeight = 11.2.sp,
                                                color = when (item.first) {
                                                    "In Progress" -> Color(0xFFFFA043)
                                                    "Completed" -> Color(0xFF2D9549)
                                                    "Pending" -> Color(0xFF007BFF)
                                                    else -> Color.Black
                                                }
                                            ),
                                            modifier = Modifier.padding(start = 8.dp)
                                        )
                                    }
                                }
                            )
                            if (index < (items.size -1)){
                                HorizontalDivider(
                                    modifier = Modifier.padding(bottom = 5.dp)
                                )
                            }
                        }
                    }
                }
            }
        }

}




@Composable
private fun ClassSubjectBox() {
    Box(
        modifier = Modifier
            .height(30.dp)
            .width(169.dp)
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
            VerticalDivider(
                modifier = Modifier.height(14.dp),
                color = Color.White
            )
            Text(
                text = "CH1",
                style = MaterialTheme.typography.titleSmall.copy(
                    fontSize = 12.sp,
                    fontWeight = FontWeight(400),
                    lineHeight = 9.6.sp,
                    color = Color(0xFFFFFFFF)
                )
            )
        }
    }
}