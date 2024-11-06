package com.teacherapplication.teacherapplication.ui.login.account

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teacherapplication.teacherapplication.R
import com.teacherapplication.teacherapplication.ui.AppComponents.LoginScreenButton


@Preview
@Composable
fun SubjectSelection(modifier: Modifier = Modifier){

    val subjectsList = listOf("Mathematics", "Science","Reading", "Writing","Social Studies", "Drawing","Mathematics","Science","Reading","Writing")

    var allSubject by remember {
        mutableStateOf(false)
    }

    val gradientBrush = if (allSubject){
        Brush.linearGradient(
            colors = listOf(Color(0xFF185573), Color(0xFF14868D)),
            start = Offset(0f, 0f),
            end = Offset(Float.POSITIVE_INFINITY, 0f)
        )
    }else{
        Brush.linearGradient(
            colors = listOf(
                Color(0x66129193).copy(alpha = 0.4f),
                Color(0x66185472).copy(alpha = 0.4f)
            ),
            start = Offset.Infinite.copy(x = 1f),
            end = Offset.Zero
        )
    }
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xFFFFFFFF)))
    {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 10.dp, top = 40.dp, end = 10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "back",
                    )
                }
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Subjects I Teach",
                    style = MaterialTheme.typography.titleSmall.copy(
                        brush = Brush.linearGradient(
                            colors = listOf(Color(0xFF185573), Color(0xFF14868D)),
                            start = Offset(0f, 0f),
                            end = Offset(Float.POSITIVE_INFINITY, 0f)
                        ),
                        fontWeight = FontWeight(600),
                        fontSize = 20.sp,
                        lineHeight = 28.9.sp
                    ),
                    modifier = Modifier
                        .padding(top = 10.dp)
                )
            }
            Text(text = "Please select the subjects that you teach",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .padding(start = 50.dp),
                color = Color(0xFF333333)
            )
            SchoolCard()
            Spacer(modifier = Modifier.height(10.dp))
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier.padding(start = 20.dp, end = 20.dp)
            ) {
                items(subjectsList){ item ->
                    SubjectCard(item,allSubject)

                }
                
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                Checkbox(checked = allSubject,
                    onCheckedChange = { allSubject = !allSubject},
                    colors = CheckboxDefaults.colors(
                        uncheckedColor = Color(0xFF129193),
                        checkedColor = Color(0xFF129193))
                )
                Text(text = "Select all Subjects",
                    fontSize = 14.sp,
                    fontWeight = FontWeight(500))
            }

        }
        Box(
            modifier = Modifier.fillMaxSize()
                .padding(20.dp),
            contentAlignment = Alignment.BottomCenter
        ){
            LoginScreenButton(text = "Save & Proceed", gradientBrush = gradientBrush) {

            }
        }

        Image(
            painter = painterResource(id = R.drawable.elephant_light),
            contentDescription = "coloured elephant",
            modifier = Modifier
                .align(Alignment.BottomStart)

        )
    }
}

@Composable
private fun SubjectCard(name: String,allSubject: Boolean) {
    var cardClick by remember {
        mutableStateOf(false)
    }
    Card(
        modifier = Modifier
            .height(60.dp)
            .width(180.dp)
            .clickable { cardClick = !cardClick },
        border = BorderStroke(width = 2.dp, color = Color(0xFFF18A90)),
        colors = CardDefaults.cardColors(
            containerColor = if (cardClick || allSubject) Color(0xFFF18A90) else Color(0xFFFFFFFF)
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ){
            Text(
                text = name,
                style = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight(500),
                    lineHeight = 20.8.sp
                ),
                color = if (cardClick || allSubject) Color(0xFFFFFFFF) else Color(0xFFF18A90),
            )
        }
    }
}