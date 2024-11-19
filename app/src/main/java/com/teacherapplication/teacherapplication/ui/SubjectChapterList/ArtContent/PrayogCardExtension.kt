package com.teacherapplication.teacherapplication.ui.SubjectChapterList.ArtContent

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teacherapplication.teacherapplication.ui.AppComponents.SmallCircle
import com.teacherapplication.teacherapplication.ui.theme.jostFont


var prayogList: MutableMap<String, List<String>> = mutableMapOf(
    "Sorting" to listOf(
        "Children sort pictures into \"Big\" and \"Small\" categories.",
        "Discuss why they chose to place each picture in its category.",
        "Ask questions like- Why do you think the elephant goes in the 'Big' group and the mouse in the 'Small' group?\"",
        "Complete the activity from page no 4.",
    ),
    "Integrate with \"My Face\":" to listOf(
        "Have students look in the mirror and discuss which parts of their face are big or small (e.g., \"Is your nose big or small?\").",
        "They can draw their face and point out what is big and what is small."
    )
)

@Composable
fun PrayogCardExtension(modifier: Modifier = Modifier){
    Column(
        modifier = Modifier
            .padding(start = 15.dp, end = 15.dp)
    ){
        CardDashedLine()
        prayogList.forEach { (title, subTopics) ->
            PrayogCardData(
                title = title,
                subTopics = subTopics
            )
        }

    }
}

@Composable
fun PrayogCardData(
    title: String,
    subTopics: List<String>
) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(top = 15.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        SmallCircle()
        Text(
            text = title,
            style = TextStyle(
                fontFamily = jostFont,
                fontWeight = FontWeight(500),
                fontSize = 16.sp,
                lineHeight = 23.12.sp
            )
        )
    }
    for(subPoint in subTopics) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 15.dp, top = 10.dp),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                SmallCircle(
                    containerColor = Color.Transparent, modifier = Modifier
                        .offset(y = (9).dp)
                )
                Text(
                    text = subPoint,
                    style = TextStyle(
                        fontFamily = jostFont,
                        fontSize = 16.sp,
                        fontWeight = FontWeight(400),
                        lineHeight = 23.12.sp
                    )
                )
            }
        }
    }
}