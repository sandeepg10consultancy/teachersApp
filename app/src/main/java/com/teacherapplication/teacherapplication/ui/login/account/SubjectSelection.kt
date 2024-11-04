package com.teacherapplication.teacherapplication.ui.login.account

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teacherapplication.teacherapplication.R


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
        .background(color = Color(0xFFFFFFFF))) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp, top = 40.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "back",
                        modifier = Modifier.scale(1.2f)
                    )
                }
                Text(
                    text = "Subjects I Teach",
                    color = Color(0xFF14868D),
                    fontSize = 20.sp,
                    fontWeight = FontWeight(600),
                    modifier = Modifier.align(Alignment.CenterVertically)
                )

            }
            Text(
                text = "Please select the subjects that you teach",
                modifier = Modifier
                    .padding(start = 50.dp)
                    .fillMaxWidth(),
                color = Color(0xFF333333),
                style = TextStyle(
                    fontWeight = FontWeight(400),
                    fontSize = 16.sp
                )
            )
            SchoolCard()


            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier.padding(start = 10.dp, end = 20.dp)
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
        Box(modifier = Modifier.align(Alignment.BottomStart))
        {
            Box(
                modifier = Modifier
                    .height(70.dp)
                    .background(
                        brush = gradientBrush,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .align(Alignment.Center)

            ) {
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    ),
                    enabled = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp)
                ) {
                    Text(
                        text = "Save & Proceed",
                        fontSize = 18.sp,
                        fontWeight = FontWeight(700)
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.elephant_button),
                    contentDescription = "elephant background",
                    modifier = Modifier
                        .scale(1.3f)
                        .offset(x = 25.dp, y = 7.dp)
                )
            }
            Image(
                painter = painterResource(id = R.drawable.elephant_light),
                contentDescription = "coloured elephant",
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(bottom = 10.dp)
                    .scale(1.2f)

            )
        }
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
            .width(150.dp)
            .clickable { cardClick = !cardClick },
        border = BorderStroke(width = 2.dp, color = Color(0xFFF18A90)),
        colors = CardDefaults.cardColors(
            containerColor = if (cardClick || allSubject) Color(0xFFF18A90) else Color(0xFFFFFFFF)
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(
            text = name,
            color = if (cardClick || allSubject) Color(0xFFFFFFFF) else Color(0xFFF18A90),
            modifier = Modifier
                .padding(top = 20.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}