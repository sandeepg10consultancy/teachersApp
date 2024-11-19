package com.teacherapplication.teacherapplication.ui.SubjectChapterList.ArtContent

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teacherapplication.teacherapplication.R
import com.teacherapplication.teacherapplication.ui.theme.jostFont

@Composable
fun ChapterScreenButton(onClick:() -> Unit = {}){
    Column(modifier = Modifier.padding(0.dp)) {
        Box(
            modifier = Modifier
                .height(54.dp)
                .width(386.dp)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFF185573),
                            Color(0xFF14868D)
                        )
                    ),
                    shape = RoundedCornerShape(12.dp)
                )
        ) {
            Button(
                onClick = onClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ),
                enabled = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = "View All Topics",
                        style = MaterialTheme.typography.titleSmall.copy(
                            fontWeight = FontWeight(500),
                            fontSize = 20.sp,
                            color = Color.White
                        )
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = "arrow",
                        tint = Color.White
                    )
                }
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
}




//@Preview(showBackground = true)
@Composable
fun GetNCFContent(//navController: NavHostController
) {
    val contentList = listOf(
        "Sorts objects into groups and sub-\n  groups based on more than one property",
        "Sorts objects into groups and sub-\n  groups based on more than one property",
    )
    Column(
        modifier = Modifier.padding(15.dp)
            .fillMaxSize()
    ){
        contentList.forEach { content ->
            Row {
                Text(
                    text = ".",
                    fontSize = 18.sp,
                    fontWeight = FontWeight(500),
                    color = Color.Black,
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
                            append("  C-8.1: ")
                        }
                        withStyle(
                            style = SpanStyle(
                                fontFamily = jostFont,
                                fontSize = 18.sp,
                                fontWeight = FontWeight(400),
                                color = Color.Black
                            )
                        ) {
                            append(content)
                        }
                    },
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
    Spacer(modifier = Modifier.height(190.dp))
}

//@Preview(showBackground = true)
@Composable
fun GetObjectiveContent(//navController: NavHostController
) {
    val contentList = listOf(
        "To understand and identify the concepts of \"big\" and \"small.\"",
        "To compare the sizes of different objects and living beings.",
        "Observe and distinguish between big and small items in their environment.",
        "To group items based on size and arrange them in order."
    )

    Column(
        modifier = Modifier
            .padding(15.dp)
            .fillMaxSize()
    ) {
        contentList.forEach { content ->
            Row(
                modifier = Modifier.fillMaxSize()
            ){
                Text(
                    text = ".",
                    fontSize = 18.sp,
                    fontWeight = FontWeight(500),
                    color = Color.Black,
                    modifier = Modifier.align(Alignment.Top)
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
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
    Spacer(modifier = Modifier.height(50.dp))
}

//@Preview(showBackground = true)
@Composable
fun GetLearningOutcomeContent(//navController: NavHostController
) {
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
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
    Spacer(modifier = Modifier.height(25.dp))
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
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
    Spacer(modifier = Modifier.height(20.dp))
}
