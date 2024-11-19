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


var abhyasList: MutableMap<String, List<String>> = mutableMapOf(
    "Family Size Comparison:" to listOf(
        "Integrate with \"All About Me\" by discussing who in their family is big and who is small.",
        "They can draw their family and identify the biggest and smallest members.",
    ),
    "Activity 2: Big and Small Box page no 3." to listOf(
        "Children find items in the classroom and decide if they belong in the \"Big\" or \"Small\" box.",
        "Ask \"Which box does this go in? Is it big or small?\"",
        "Complete the activity on page no 3."
    )
)

@Composable
fun AbhyasCardExtension(){
    Column(
        modifier = Modifier
            .padding(start = 15.dp, end = 15.dp)
    ){
        CardDashedLine()
        abhyasList.forEach { (title, subTopics) ->
            AbhyasCardData(
                title = title,
                subTopics = subTopics
            )
        }
    }
}

@Composable
private fun AbhyasCardData(
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