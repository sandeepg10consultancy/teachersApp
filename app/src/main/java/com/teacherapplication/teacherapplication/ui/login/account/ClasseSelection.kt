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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.teacherapplication.teacherapplication.R
import com.teacherapplication.teacherapplication.ui.AppComponents.LoginScreenButton


var sectionName = "5 Sections"
//@Preview
@Composable
fun ClassSelection(modifier: Modifier = Modifier, navController: NavHostController){

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
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "back",
                    )
                }
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Classes I Teach",
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
                Text(
                    text = "*",
                    color = Color.Black,
                    modifier = Modifier
                        .padding(bottom = 7.dp)
                        .align(Alignment.CenterVertically)
                )
            }
            Text(text = "Please select the classes that you teach",
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(start = 50.dp),
                color = Color(0xFF333333)
            )

            SchoolCard()
            classesMap.forEach{ (key, value) ->
                ClassCard(name = key, image = value)
            }

            Spacer(modifier = Modifier.height(275.dp))

        }
        Box(
            modifier = Modifier.fillMaxSize()
                .padding(20.dp),
            contentAlignment = Alignment.BottomCenter
        ){
            LoginScreenButton(text = "Save & Select Subjects", gradientBrush = gradientBrush) {
                navController.navigate(route = "subject")
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
fun ClassCard(name: String, image:Int){
    var sectionSwitch by remember {
        mutableStateOf(false)
    }
    Card(
        modifier = Modifier
            .padding(start = 20.dp, top = 10.dp, bottom = 10.dp, end = 20.dp)
            .width(377.dp)
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
                horizontalArrangement = Arrangement.spacedBy(15.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = painterResource(image),
                    contentDescription = "nursery",
                    modifier = Modifier.scale(1.2f)
                )
                Column {
                    Text(text = name,
                        style = MaterialTheme.typography.titleMedium.copy(
                            lineHeight = 23.4.sp
                        )
                    )
                    Text(text = sectionName,
                        style = MaterialTheme.typography.labelMedium.copy(
                            lineHeight = 18.2.sp,
                            color = Color(0xFF5A5A5A)
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
        border = BorderStroke(width = 2.dp, color = Color(0xFF1D1751)),
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "Section - $sec",
                modifier = Modifier.width(73.dp)
                    .height(18.dp),
                color = if (sectionClick) Color(0xFFFFFFFF) else Color(0xFF1D1751),
                style = MaterialTheme.typography.labelMedium.copy(
                    lineHeight = 18.2.sp,
                    color = Color(0xFF1D1751)
                ),
            )
        }
    }
}

@Composable
fun SchoolCard() {
    Card(
        modifier = Modifier
            .padding(start = 20.dp, top = 40.dp, end = 20.dp, bottom = 20.dp)
            .height(100.dp)
            .width(378.dp),
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
                    text = "Exela pvt.school",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "School Code: 1313",
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontWeight = FontWeight(300),
                        color = Color(0xFF000000)
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



