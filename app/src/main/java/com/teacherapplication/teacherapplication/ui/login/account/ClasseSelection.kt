package com.teacherapplication.teacherapplication.ui.login.account

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.teacherapplication.teacherapplication.R
import com.teacherapplication.teacherapplication.ui.AppComponents.BackArrow
import com.teacherapplication.teacherapplication.ui.AppComponents.LoginScreenButton
import com.teacherapplication.teacherapplication.ui.theme.jostFont
import com.teacherapplication.teacherapplication.ui.utills.exelaGradient


var sectionName = "5 Sections"
//@Preview
@Composable
fun ClassSelection(modifier: Modifier = Modifier, navController: NavHostController){

    val scrollState = rememberScrollState()
    val classesMap = mapOf("Nursery" to R.drawable.nursery_img,
                            "Junior KG" to R.drawable.junior_kg_img,
                            "Senior KG" to R.drawable.senior_kg_img
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 15.dp, top = 40.dp, end = 15.dp)
                .verticalScroll(scrollState)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                BackArrow( onClick = {navController.popBackStack()} )
                Text(
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(
                            fontFamily = jostFont,
                            fontWeight = FontWeight(600),
                            fontSize = 20.sp,
                            brush = exelaGradient,
                        )){
                            append("Classes I Teach")
                        }
                        withStyle(style = SpanStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight(400),
                            baselineShift = BaselineShift.Superscript
                        )
                        ){
                        append("*")
                        }
                    },
                    lineHeight = 28.9.sp,
                    modifier = Modifier.paddingFromBaseline(20.dp)
                )
            }
            Text(
                text = "Please select the classes that you teach",
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center,
                color = Color(0xFF333333)
            )
            Spacer(modifier = Modifier.height(40.dp))
            SchoolCard()
            Spacer(modifier = Modifier.height(40.dp))
            classesMap.forEach{ (key, value) ->
                ClassCard(
                    name = key,
                    image = value,
                )
                Spacer(modifier = Modifier.height(20.dp))
            }

            Spacer(modifier = Modifier.height(275.dp))

        }
        Box(
            modifier = Modifier.fillMaxSize()
                .padding(horizontal = 15.dp, vertical = 50.dp),
            contentAlignment = Alignment.BottomCenter
        ){
            LoginScreenButton(
                text = "Save & Select Subjects",
                enabled = true
            ){
                navController.navigate(route = "subject")
            }
        }

        Image(
            painter = painterResource(id = R.drawable.elephant_color),
            contentDescription = "coloured elephant",
            modifier = Modifier
                .height(276.95.dp)
                .width(296.41.dp)
                .align(Alignment.BottomStart),
            alpha = 0.3f

        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ClassCard(
    name: String,
    image: Int,
    )
{
    val sectionSwitch = remember { mutableStateOf(false) }
    val sections = listOf("Section - A", "Section - B", "Section - C", "Section - D", "Section - E")
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF5F5F5)
        )
    ){
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 15.dp, end = 15.dp),
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
                    modifier = Modifier
                        .clip(RoundedCornerShape(5.dp))
                        .size(54.dp)
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
                checked = sectionSwitch.value,
                onCheckedChange = { sectionSwitch.value = !sectionSwitch.value},
                modifier = Modifier
                    .height(26.dp)
                    .width(43.dp),
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.White,
                    uncheckedThumbColor = Color.White,
                    checkedTrackColor = Color(0xFF129193),
                    uncheckedTrackColor = Color(0xFFC4C4C4),
                    uncheckedBorderColor = Color.Transparent,
                )
            )
        }
    }
    if (sectionSwitch.value) {
        Spacer(modifier = Modifier.height(20.dp))
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ){
            sections.forEach { section ->
                SectionCard(sec = section)
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
            .width(110.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (sectionClick) Color(0xFF1D1751) else Color(0xFFFFFFFF)
        ),
        border = BorderStroke(
            width = 2.dp,
            color = Color(0xFF1D1751),
            ),
        shape = RoundedCornerShape(8.dp),
        onClick = {
            sectionClick = !sectionClick
            sectionName = sec
        },
    ) {
        Text(
            text = sec,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp),
            color = if (sectionClick) Color(0xFFFFFFFF) else Color(0xFF1D1751),
            style = MaterialTheme.typography.labelMedium.copy(
                lineHeight = 18.2.sp,
                color = Color(0xFF1D1751)
            ),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun SchoolCard() {
    Card(
        modifier = Modifier
            .height(100.dp)
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
                modifier = Modifier
                    .size(75.dp)
                    .clip(CircleShape)
                    .scale(1.1f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ClassSelectionScreenPreview(){
    val navController = rememberNavController()
    ClassSelection(navController = navController)
}


