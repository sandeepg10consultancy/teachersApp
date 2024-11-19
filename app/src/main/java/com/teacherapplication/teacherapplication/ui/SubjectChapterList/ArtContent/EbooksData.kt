package com.teacherapplication.teacherapplication.ui.SubjectChapterList.ArtContent

import androidx.compose.foundation.Image
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
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teacherapplication.teacherapplication.R
import com.teacherapplication.teacherapplication.ui.theme.jostFont


val ebooksList = listOf(
    "Flower" to R.drawable.eb_flowers,
    "Shapes and colors" to R.drawable.eb_shapes_colors_1,
    "Shapes and colors" to R.drawable.eb_shapes_colors_2,
    "Shapes and colors" to R.drawable.eb_shapes_colors_3,
    "Shapes and colors" to R.drawable.eb_shapes_colors_4,
    "Shapes and colors" to R.drawable.eb_shapes_colors_5,
    "Sample" to R.drawable.eb_sample,
)

@Composable
fun EbooksCards(){
    Column(modifier = Modifier.fillMaxSize()){
        ebooksList.forEach { item ->
            EbookCard(title = item.first, image = item.second)
        }
        Spacer(modifier = Modifier.height(10.dp))
        VideosButton(onClick = { }, text = "Add Ebook")
        Spacer(modifier = Modifier.height(100.dp))
    }
}



@Composable
private fun EbookCard(title: String, image: Int) {
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
                    text = "3 pages",
                    style = TextStyle(
                        fontFamily = jostFont,
                        fontWeight = FontWeight(400),
                        fontSize = 14.sp,
                        lineHeight = 11.2.sp,
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