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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
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



var sectionName = "5 Sections"
@Preview
@Composable
fun ClassSelection(modifier: Modifier = Modifier){

    var classesMap = mapOf("Nursery" to R.drawable.nursery_img,
                            "Junior KG" to R.drawable.junior_kg_img,
                            "Senior KG" to R.drawable.senior_kg_img
    )
    val gradientBrush = if (true){
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
                    text = "Classes I Teach",
                    color = Color(0xFF14868D),
                    fontSize = 20.sp,
                    fontWeight = FontWeight(600),
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                Text(
                    text = "*",
                    color = Color.Black,
                    modifier = Modifier
                        .padding(bottom = 7.dp)
                        .align(Alignment.CenterVertically)
                )

            }
            Text(
                text = "Please select the classes that you teach",
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
            classesMap.forEach{ (key, value) ->
                ClassCard(name = key, image = value)
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
                        text = "Save & Select Subjects",
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
fun ClassCard(name: String, image:Int){
    var sectionSwitch by remember {
        mutableStateOf(false)
    }
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .height(70.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF5F5F5)
        )
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, top = 10.dp, end = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = painterResource(image),
                    contentDescription = "nursery",
                    modifier = Modifier.scale(1.1f)
                )
                Column {
                    Text(text = name,
                        style = TextStyle(
                            fontWeight = FontWeight(600),
                            fontSize = 15.sp
                        )
                    )
                    Text(text = sectionName,
                        style = TextStyle(
                            fontWeight = FontWeight(400),
                            fontSize = 14.sp
                        )
                    )
                }
            }
            Switch(
                checked = sectionSwitch,
                onCheckedChange = { sectionSwitch = !sectionSwitch},
                modifier = Modifier.scale(0.8f),
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.White,
                    uncheckedThumbColor = Color.White,
                    checkedTrackColor = Color(0xFF129193),
                    uncheckedTrackColor = Color(0xFFC4C4C4)
                )
            )
        }
    }
    if (sectionSwitch) {
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            modifier = Modifier.padding(start = 20.dp, end = 20.dp)
        ){
            for (i in 'A'..'C'){
                SectionCard(sec = i.toString())
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row(
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            modifier = Modifier.padding(start = 20.dp, end = 20.dp)
        ){
            for (i in 'D'..'E'){
                SectionCard(sec = i.toString())
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
    }
}




@Composable
fun SectionCard(sec: String) {
    var sectionClick by remember {
        mutableStateOf(false)
    }
    Card(
        modifier = Modifier
            .height(60.dp)
            .width(110.dp)
            .clickable {
                sectionClick = !sectionClick
                sectionName = "Section - $sec"
            },
        colors = CardDefaults.cardColors(
            containerColor = if (sectionClick) Color(0xFF1D1751) else Color(0xFFFFFFFF)
        ),
        border = BorderStroke(width = 2.dp, color = Color(0xFF1D1751))
    ) {
        Text(
            text = "Section - $sec",
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            color = if (sectionClick) Color(0xFFFFFFFF) else Color(0xFF1D1751),
            style = TextStyle(
                fontWeight = FontWeight(400),
                fontSize = 14.sp
            ),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun SchoolCard() {
    Card(
        modifier = Modifier
            .padding(start = 12.dp, top = 40.dp, end = 20.dp, bottom = 20.dp)
            .height(90.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFCC8A4).copy(alpha = 0.4f)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "school name",
                    style = TextStyle(
                        fontWeight = FontWeight(600),
                        fontSize = 18.sp
                    )
                )
                Text(
                    text = "School Code: 1313",
                    style = TextStyle(
                        fontWeight = FontWeight(300),
                        fontSize = 14.sp
                    )
                )
            }

            Image(
                painter = painterResource(id = R.drawable.school_img),
                contentDescription = "school image",
                modifier = Modifier.scale(1.3f)
            )
        }
    }
}



