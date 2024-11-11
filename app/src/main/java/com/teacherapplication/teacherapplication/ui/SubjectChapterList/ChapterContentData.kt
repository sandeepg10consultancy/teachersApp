package com.teacherapplication.teacherapplication.ui.SubjectChapterList

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teacherapplication.teacherapplication.ui.theme.jostFont

@Preview(showBackground = true)
@Composable
fun GetNCFContent(){
    Column(
        modifier = Modifier.padding(15.dp)
            .fillMaxSize()
    ){
        Row {
            Text(
                text = ".",
                fontSize = 18.sp,
                fontWeight = FontWeight(500),
                color = Color.Black
            )

            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontFamily = jostFont,
                            fontSize = 18.sp,
                            fontWeight = FontWeight(500),
                            color = Color.Black
                        )
                    ) {
                        append(" C-8.1: ")
                    }
                    withStyle(
                        style = SpanStyle(
                            fontFamily = jostFont,
                            fontSize = 18.sp,
                            fontWeight = FontWeight(400),
                            color = Color.Black
                        )
                    ) {
                        append("Sorts objects into groups and sub-\n groups based on more than one property")
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GetObjectiveContent() {
    val contentList = listOf(
        "To understand and identify the concepts of \n\"big\" and \"small.\"",
        "To compare the sizes of different objects and \nliving beings.",
        "Observe and distinguish between big and \nsmall items in their environment.",
        "To group items based on size and arrange \nthem in order."
    )

    Column(
        modifier = Modifier
            .padding(15.dp)
            .fillMaxSize()
    ) {
        contentList.forEach { content ->
            Row {
                Text(
                    text = ".",
                    fontSize = 18.sp,
                    fontWeight = FontWeight(500),
                    color = Color.Black
                )
                Text(
                    text = content,
                    fontSize = 18.sp,
                    fontWeight = FontWeight(400),
                    color = Color.Black,
                    fontFamily = jostFont,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GetLearningOutcomeContent(){
    val contentList = listOf(
        "Students can identify and compare objects and living beings based on their size.",
        "Students will effectively categorise items into \"big\" and \"small\" groups and arrange them in order.",
        "Students will be able to categorize and arrange objects based on their size.",
        "Students will understand the concept of ordering by size."
    )
    Column(
        modifier = Modifier
            .padding(15.dp)
            .fillMaxSize()
    ) {
        contentList.forEach { content ->
            Row {
                Text(
                    text = ".",
                    fontSize = 18.sp,
                    fontWeight = FontWeight(500),
                    color = Color.Black
                )
                Text(
                    text = content,
                    fontSize = 18.sp,
                    fontWeight = FontWeight(400),
                    color = Color.Black,
                    fontFamily = jostFont,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GetMaterialContent(){
    val contentList = listOf(
        "Kitty the cat puppet/toy (e.g., elephant and mouse)",
        "Real objects of varying sizes (e.g., big and small balls)",
        "Large and small toys",
        "A set of big and small objects (balls, books, toys).",
        "Pictures of animals, fruits, or everyday objects in different sizes.",
        "mirror",
        "Large sheets of paper, crayons",
        "Chart paper for group activities",
        "Stickers (big and small shapes)",
        "Picture cards of various objects (e.g., apples, trees)",
        "Sorting trays or baskets",
        "Blocks or stacking toys of different sizes",
        "Old magazines, scissors, glue, large sheets of paper."
    )
    Column(
        modifier = Modifier
            .padding(15.dp)
            .fillMaxSize()
    ) {
        contentList.forEach { content ->
            Row {
                Text(
                    text = ".",
                    fontSize = 18.sp,
                    fontWeight = FontWeight(500),
                    color = Color.Black
                )
                Text(
                    text = content,
                    fontSize = 18.sp,
                    fontWeight = FontWeight(400),
                    color = Color.Black,
                    fontFamily = jostFont,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }
        }
    }
}
