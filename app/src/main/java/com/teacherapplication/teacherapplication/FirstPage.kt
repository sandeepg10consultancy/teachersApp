package com.teacherapplication.teacherapplication

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.teacherapplication.teacherapplication.ui.SubjectChapterList.ArtContent.lessonPlans

@Preview
@Composable
fun FirstPage( modifier: Modifier = Modifier)
{
    val lessonState = remember {        mutableStateOf(false)    }
    val courseList = listOf("Lesson Plans", "Assessments", "Videos", "Ebooks")
    Scaffold(modifier = Modifier
        .fillMaxSize()
        .padding(15.dp)) { innerPadding ->
        Spacer(modifier = Modifier.padding(innerPadding))
        Column {
            TopOnes()
            Row(modifier = Modifier
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically)
            {
                HorizontalDivider( modifier = Modifier
                    .weight(1f)
                    .height(1.dp))
                Button(onClick = { /*TODO*/ }
                    ,modifier = Modifier
                        .height(35.dp)
                        .width(160.dp)
                        .alignByBaseline()
                        .offset(x = -20.dp, y = 0.dp),
                    border = BorderStroke(0.5.dp, Color.Cyan),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White
                    )) {
                    Text(text = "Chapter Objectives",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Cyan
                    )
                }
            }
            LazyRow {
                items(courseList){item ->
                    CoursesRow(item = item)
                }
            }
            LazyColumn {
                items(lessonPlans){ item ->
                    ExtendColumn(title = item.title, time = item.time)
                }
            }
        }

    }
}

@Composable
fun CoursesRow(item: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        OutlinedButton(
            onClick = { },
            modifier = Modifier,
            border = BorderStroke(0.dp, Color.White),
            //enabled = lessonState.value
        ) {
            Text(text = item)
        }
        HorizontalDivider(
            modifier = Modifier.height(2.dp)
                .width(30.dp),
            color = Color.Black        )
    }
}

@Composable
fun TopOnes() {
    Column {
        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "BAck Button",
            modifier = Modifier.clickable { }
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Cyan,
                    contentColor = Color.White
                ),
                modifier = Modifier.height(35.dp)
            ) {
                Text(text = "Nursery-A | Art | CH1")
            }
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.height(35.dp),
                colors = ButtonDefaults.buttonColors(
                    //containerColor = Color.
                )
            ) {
                Row(
                    modifier = Modifier.width(100.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(
                            id = R.drawable.hourglass
                        ),
                        contentDescription = "progress"
                    )
                    Text(
                        text = "In Progress",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Black
                    )
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = null,
                        modifier = Modifier
                            .scale(2f)
                    )
                }
            }
        }
        Text(
            text = "1.Flower",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.Companion
                .align(Alignment.CenterHorizontally)
                .padding(20.dp),
            textAlign = TextAlign.Center
        )
    }
}


@Composable
private fun ExtendColumn(title: String, time: String) {
    var expanded by rememberSaveable {        mutableStateOf(false)    }
    val extraPadding by animateDpAsState(
        targetValue = if (expanded) 170.dp else 70.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )
    Card(
        modifier = Modifier
            .padding(10.dp)
            .height(extraPadding)
            .fillMaxWidth(),
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(7.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically))
            {
                Text(text = title)
                Text(text = time)
            }
                Row(
                    modifier = Modifier.padding(2.dp)
                ) {
                    if (expanded){
                        Icon(painter = painterResource(id = R.drawable.editing_pad),
                            contentDescription = "notes",
                            modifier = Modifier
                                .padding(top = 3.dp)
                                .scale(1.3f)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Icon(
                            painter = painterResource(id = R.drawable.speaker),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(top = 3.dp)
                                .scale(1.5f)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowUp,
                            contentDescription = null,
                            modifier = Modifier
                                .scale(2f)
                                .clickable { expanded = !expanded }
                        )
                    }else {
                        Spacer(modifier = Modifier.width(10.dp))
                        Icon(
                            painter = painterResource(id = R.drawable.speaker),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(top = 3.dp)
                                .scale(1.5f)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowDown,
                            contentDescription = null,
                            modifier = Modifier
                                .scale(2f)
                                .clickable { expanded = !expanded }
                        )
                    }
                }
        }
        Spacer(modifier = Modifier.height(15.dp))
        if (expanded){
            TextExtension()
        }
    }
}



@Composable
fun TextExtension(){
    Column(
        modifier = Modifier
            .padding(7.dp)
    ){
        DashedLine()
        Text(text = "Welcome, and Circle Time:",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 7.dp),
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Button(onClick = { /*TODO*/ }) {
                Text(text = "+ Add Content")
            }
        }
    }
}
@Composable
fun DashedLine(
    color: Color = MaterialTheme.colorScheme.onSurface,
    lineThickness: Float = 5f,
    dashLength: Float = 10f,
    gapLength: Float = 5f)
{
    Canvas(modifier = Modifier
        .fillMaxWidth()
        .height(lineThickness.dp)
    ){
        val paint = Paint().apply {
            this.color = color
            this.pathEffect = PathEffect.dashPathEffect(floatArrayOf(dashLength, gapLength), 0f)
            this.strokeWidth = lineThickness
        }
        drawLine(
            color = color,
            start = Offset(0f, size.height / 2),
            end = Offset(size.width, size.height / 2),
            strokeWidth = lineThickness,
            pathEffect = paint.pathEffect
        )
    }
}
