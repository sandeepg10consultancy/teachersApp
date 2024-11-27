package com.teacherapplication.teacherapplication.ui.SubjectChapterList.ArtContent

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.teacherapplication.teacherapplication.R
import com.teacherapplication.teacherapplication.ui.AppComponents.SmallCircle
import com.teacherapplication.teacherapplication.ui.theme.italicSansFont
import com.teacherapplication.teacherapplication.ui.theme.jostFont


@Composable
fun StudentSubmissions(navController: NavHostController, isDone: Boolean?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 40.dp)
    ){
        StudentInfo()
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Student Work",
            style = TextStyle(
                fontFamily = jostFont,
                fontWeight = FontWeight(500),
                fontSize = 20.sp,
                lineHeight = 28.9.sp,
                color = Color.Black
            ),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 2.dp
            )
        ){
            Column(
                modifier = Modifier
                    .padding(25.dp),
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                Text(
                    text = "Hi Nursery A explorers! \nFor your science homework, please find a small leaf or flower and upload a photo of it to our class portal.",
                    style = TextStyle(
                        fontFamily = jostFont,
                        fontWeight = FontWeight(400),
                        fontSize = 14.sp,
                        lineHeight = 20.23.sp,
                        color = Color.Black
                    )
                )
                Text(
                    text = "Attachment",
                    style = TextStyle(
                        fontFamily = jostFont,
                        fontWeight = FontWeight(600),
                        fontSize = 14.sp,
                        lineHeight = 20.23.sp
                    )
                )
                Column(
                    modifier = Modifier.padding(10.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ){
                    AttachmentTypeBox(
                        icon = R.drawable.pdf,
                        title = "Shapes and colors.pdf",
                        subtext = "1 Page"
                    )
                    AttachmentTypeBox(
                        icon = R.drawable.video_clip,
                        title = "Shapes and colors.mp4",
                        subtext = "2:30 mins"
                    )
                    AttachmentTypeBox(
                        icon = R.drawable.jpeg_icon,
                        title = "Shapes and colors.jpeg",
                        subtext = "2.00mb"
                    )
                }
            }
        }
        if (isDone == true){
            Spacer(modifier = Modifier.height(20.dp))
            MarkedCheckedBox()
            Spacer(modifier = Modifier.height(70.dp))
            StartMarkingBox(text = "Back to Assessment"){ navController.navigate(route = "assignmentDetails") }
        } else {
            Spacer(modifier = Modifier.height(150.dp))
            StartMarkingBox( onClick =  { navController.navigate(route = "studentMarking") })
        }
    }
}

@Composable
fun MarkedCheckedBox(){
    Box(
        modifier = Modifier
            .height(57.dp)
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp)
            .background(
                color = Color(0xFF2D9549),
                shape = RoundedCornerShape(10.dp)
            ),
        contentAlignment = Alignment.Center
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(
                painter = painterResource(R.drawable.completed),
                contentDescription = "checked",
                modifier = Modifier.size(28.dp),
                tint = Color.White
            )
            Text(
                text = "Checked",
                style = MaterialTheme.typography.labelSmall.copy(
                    color = Color.White,
                    fontWeight = FontWeight(600)
                )
            )
        }
    }
}


@Composable
fun StartMarkingBox(
    text: String = "Start Marking",
    onClick: () -> Unit = { }
){
    Box(
        modifier = Modifier
            .height(54.dp)
            .padding(start = 60.dp, end = 60.dp)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFF185573), Color(0xFF14868D))
                ),
                shape = RoundedCornerShape(10.dp)
            )
    ) {
        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            ),
            enabled = true,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight(500),
                    color = Color.White
                )
            )
        }
        Image(
            painter = painterResource(id = R.drawable.elephant_button),
            contentDescription = "elephant background",
            modifier = Modifier
                .offset(x = 30.dp, y = 2.dp)
        )
    }
}


@Composable
fun AttachmentTypeBox(
    icon: Int,
    title: String,
    subtext: String
){
    Box(
        modifier = Modifier
            .height(60.dp)
            .background(
                color = Color(0xFFE9F2F7),
                shape = RoundedCornerShape(8.dp)
            )
            .clickable {  },
        contentAlignment = Alignment.Center
    ){
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ){
            Image(
                painter = painterResource(icon),
                contentDescription = "pdf",
                modifier = Modifier.size(29.dp)
            )
            Column {
                Text(
                    text = title,
                    style = MaterialTheme.typography.labelMedium,
                    color = Color.Black
                )
                Text(
                    text = subtext,
                    style = TextStyle(
                        fontFamily = jostFont,
                        fontWeight = FontWeight(400),
                        fontSize = 12.sp,
                        lineHeight = 17.34.sp,
                        color = Color.Black.copy(alpha = 0.5f)
                    )
                )
            }
        }
    }
}


@Composable
private fun StudentInfo() {
    Box(
        modifier = Modifier
            .height(74.dp)
            .fillMaxWidth()
            .shadow(
                shape = RectangleShape,
                elevation = 5.dp,
            )
            .background(Color.White),
    ) {
        Row(
            modifier = Modifier
                .padding(start = 20.dp)
                .fillMaxSize(),
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.arrow_left),
                contentDescription = "back",
                modifier = Modifier.size(20.dp)
            )
            Image(
                painter = painterResource(R.drawable.profile_img_2),
                contentDescription = "profile",
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
            )
            Column {
                Text(
                    text = "Vinay Poosarla",
                    style = TextStyle(
                        fontFamily = jostFont,
                        fontWeight = FontWeight(500),
                        fontSize = 16.sp,
                        lineHeight = 23.12.sp,
                        color = Color(0xFF1D1751)
                    )
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "Junior KG - A",
                        style = TextStyle(
                            fontFamily = italicSansFont,
                            fontWeight = FontWeight(500),
                            fontSize = 12.sp,
                            lineHeight = 15.12.sp,
                            color = Color(0xFF129193)
                        )
                    )
                    SmallCircle(
                        dim = 5.dp,
                        containerColor = Color(0xFF129193),
                        borderColor = Color.Transparent
                    )
                    Text(
                        text = "Art",
                        style = TextStyle(
                            fontFamily = italicSansFont,
                            fontWeight = FontWeight(500),
                            fontSize = 12.sp,
                            lineHeight = 15.12.sp,
                            color = Color(0xFF129193)
                        )
                    )
                }
            }
        }
    }
}