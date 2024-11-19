package com.teacherapplication.teacherapplication.ui.SubjectChapterList.ArtContent

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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teacherapplication.teacherapplication.R
import com.teacherapplication.teacherapplication.ui.theme.jostFont

val videosList = listOf(
    "Flower" to R.drawable.flowers,
    "Shapes and colors" to R.drawable.shapes_colors_1,
    "Shapes and colors" to R.drawable.shapes_colors_2,
    "Shapes and colors" to R.drawable.shapes_colors_3,
    "Shapes and colors" to R.drawable.shapes_colors_4,
    "Shapes and colors" to R.drawable.shapes_colors_5,
    "Shapes and colors" to R.drawable.shapes_colors_6,
)


@Composable
fun VideosCards(){
    Column(modifier = Modifier.fillMaxSize()){
        videosList.forEach { item ->
            VideoCard(title = item.first, image = item.second)
        }
        Spacer(modifier = Modifier.height(10.dp))
        VideosButton(onClick = { }, text = "Add Video")
        Spacer(modifier = Modifier.height(100.dp))
    }
}


@Composable
fun VideosButton(onClick: () -> Unit = {},
                 text: String,
                 modifier: Modifier = Modifier){
    Box(
        modifier = modifier
            .height(54.dp)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFF185573), Color(0xFF14868D))
                ),
                shape = RoundedCornerShape(12.dp)
            )

    ) {
        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp)
        ) {
            Text(
                text = text,
                style = TextStyle(
                    fontFamily = jostFont,
                    fontWeight = FontWeight(500),
                    fontSize = 20.sp,
                    lineHeight = 28.9.sp
                )
            )
        }
        Image(
            painter = painterResource(id = R.drawable.elephant_button),
            contentDescription = "elephant background",
            modifier = Modifier
                .scale(1f)
                .offset(x = 30.dp, y = 2.dp)
        )
    }
}



@Composable
private fun VideoCard(title: String, image: Int) {
    Column(modifier = Modifier.padding(top = 20.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {

                }
                .padding(top = 0.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Box(
                modifier = Modifier
                    .height(82.12.dp)
                    .width(147.dp)
            ) {
                Image(
                    painter = painterResource(image),
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize()
                )
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(bottom = 5.dp, end = 5.dp)
                )
                {
                    Box(
                        modifier = Modifier
                            .height(14.dp)
                            .width(27.dp)
                            .background(color = Color(0xFFF1F1F1).copy(alpha = 0.6f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "2:30",
                            style = TextStyle(
                                fontFamily = jostFont,
                                fontWeight = FontWeight(400),
                                fontSize = 10.sp,
                                lineHeight = 8.sp,
                                color = Color(0xFF1D1751)
                            )
                        )
                    }
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(bottom = 5.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight(500),
                        lineHeight = 14.4.sp,
                        color = Color.Black
                    )
                )
                Text(
                    text = "3:00 min",
                    style = TextStyle(
                        fontFamily = jostFont,
                        fontWeight = FontWeight(400),
                        fontSize = 12.sp,
                        lineHeight = 9.6.sp,
                        color = Color.Black.copy(alpha = 0.5f)
                    )
                )
            }

        }
        Spacer(modifier = Modifier.height(20.dp))
        HorizontalDivider(
            thickness = 1.dp,
            color = Color(0xFFD7D7D7)
        )
    }
}