package com.teacherapplication.teacherapplication.ui.SubjectChapterList.ArtContent

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teacherapplication.teacherapplication.ui.AppComponents.SmallCircle
import com.teacherapplication.teacherapplication.ui.theme.jostFont


var bodhList = listOf(
    "How a picture of an elephant and a mouse. Ask, \"Which one is big? Which one is small?\" Encourage them to respond aloud.",
    "Use your hands to demonstrate big and small. Stretch your arms wide to show \"big\" and bring them close together to show \"small.\"",
    "Explain that some things in the world are big, like a tree, while others are small, like a plant.",
    "Discuss the concept of size using the classroom environment. Show a big chair and a small chair and ask the students to identify which is big and which is small.",
    "Use simple language like, \"Big things are large. Small things are little.\"",
    "Play a \"Stand Up if It's Big\" game where you say the name of an object (e.g., tree, leaf) and students stand if it’s big or stay seated if it’s small.",
)


@Preview(showBackground = true)
@Composable
fun BodhCardExtension(){
    Column(
        modifier = Modifier
            .padding(start = 15.dp, end = 15.dp)
    ){
        CardDashedLine()
        bodhList.forEach { text ->
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 14.dp, top = 14.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                SmallCircle(containerColor = Color.Transparent,
                    modifier = Modifier
                        .size(7.dp)
                        .offset(y = (10).dp))
                Text(
                    text = text,
                    style = TextStyle(
                        fontFamily = jostFont,
                        fontWeight = FontWeight(400),
                        fontSize = 16.sp,
                        lineHeight = 23.12.sp,
                        color = Color.Black
                    ),
                    modifier = Modifier.alignByBaseline()
                )
            }
        }
    }
}