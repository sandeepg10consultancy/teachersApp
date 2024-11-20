package com.teacherapplication.teacherapplication.ui.SubjectChapterList.ArtContent

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teacherapplication.teacherapplication.R
import com.teacherapplication.teacherapplication.ui.AppComponents.BackArrow
import com.teacherapplication.teacherapplication.ui.AppComponents.SmallCircle
import com.teacherapplication.teacherapplication.ui.AppComponents.SmallSquare
import com.teacherapplication.teacherapplication.ui.theme.italicSansFont
import com.teacherapplication.teacherapplication.ui.theme.jostFont
import com.teacherapplication.teacherapplication.ui.theme.openFont

@Composable
fun LessonPlansCard(title: String, time: String){
    var expanded by rememberSaveable {  mutableStateOf(false)  }
    val isContentSheetOpen = remember { mutableStateOf(false) }
    val extraPadding by animateDpAsState(
        targetValue = if (expanded) Dp.Unspecified else 72.dp,
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
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(
            width = 1.dp,
            color = Color(0xFFD2D2D2)
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically))
            {
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                fontFamily = jostFont,
                                fontSize = 18.sp,
                                fontWeight = FontWeight(600),
                                color = Color(0xFF1D1751)
                            )
                        ){
                            append(title.substringBefore(" "))
                        }
                        withStyle(
                            style = SpanStyle(
                                fontFamily = jostFont,
                                fontSize = 14.sp,
                                fontWeight = FontWeight(500),
                                color = Color(0xFF129193)
                            )
                        ){
                            if (expanded && ("Bodh" in title)){
                                append("\n" + title.substringAfter(" "))
                            } else {
                                append(" " + title.substringAfter(" "))
                            }
                        }
                    },
                    lineHeight = 14.4.sp
                )
                Text(
                    text = time,
                    style = MaterialTheme.typography.labelSmall.copy(
                        lineHeight = 9.6.sp,
                        fontWeight = FontWeight(600)
                    ),
                    color = Color(0xFF000000).copy(0.5f)
                )
            }
            Row(
                modifier = Modifier.padding(0.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                if (expanded){
                    Card(
                        modifier = Modifier
                            .size(33.dp)
                            .clickable { },
                        shape = RoundedCornerShape(100),
                        border = BorderStroke(
                            width = 1.dp,
                            color = Color(0xFF129193)
                        ),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        )
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.editing_pad),
                            contentDescription = null,
                            tint = Color(0xFF129193),
                            modifier = Modifier
                                .padding(8.dp)
                                .size(19.dp)
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(color = Color(0xFF1D1751))
                        .size(33.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.speaker),
                        contentDescription = null,
                        modifier = Modifier,
                        tint = Color.White
                    )
                }
                Card(
                    modifier = Modifier
                        .size(33.dp)
                        .clickable { expanded = !expanded},
                    shape = RoundedCornerShape(100),
                    border = BorderStroke(
                        width = 1.dp,
                        color = Color(0xFF129193)
                    ),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    )
                ) {
                    Icon(
                        imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                        contentDescription = null,
                        tint = Color(0xFF129193),
                        modifier = Modifier
                            .padding(5.dp)
                    )
                }

            }
        }
        if (expanded){
            when(title.substringBefore(" ")){
                "Adheeti" -> AdheetiCardExtension()
                "Bodh" -> BodhCardExtension()
                "Abhyas" -> AbhyasCardExtension()
                "Prayog" -> PrayogCardExtension()
                "Prasaar" -> PrasaarCardExtension()
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        AddContentButton(modifier = Modifier.padding(25.dp), onClick = { isContentSheetOpen.value = it } )
    }
    if(isContentSheetOpen.value){
        ContentBottomSheet(isContentSheetOpen)
    }
}

@Composable
fun AdheetiCardExtension(){
    Column(
        modifier = Modifier
            .padding(start = 15.dp, end = 15.dp)
    ){
        CardDashedLine()
        Spacer(modifier = Modifier.height(15.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            SmallCircle(containerColor = Color.Black, borderColor = Color.Black)
            Text(
                text = "Welcome, and Circle Time:",
                style = TextStyle(
                    fontFamily = jostFont,
                    fontWeight = FontWeight(500),
                    fontSize = 16.sp,
                    lineHeight = 23.12.sp,
                    color = Color.Black
                ),
            )
        }
        Row(modifier = Modifier.fillMaxWidth()
            .padding(start = 14.dp, top = 14.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Box(
                modifier = Modifier
                    .size(7.dp)
                    .offset(y = (-10).dp)
            ) {
                SmallCircle(containerColor = Color.Transparent)
            }
            Text(
                text = "Sing a welcome song to gather students and create a friendly environment. ",
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
        Row(modifier = Modifier.fillMaxWidth()
            .padding(start = 14.dp, top = 14.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Box(
                modifier = Modifier
                    .size(7.dp)
                    .offset(y = (-10).dp)
            ) {
                SmallCircle(containerColor = Color.Transparent)
            }
            Text(
                text = "Introduce Kitty the Cat to the students by using a cat puppet or toy: ",
                style = TextStyle(
                    fontFamily = jostFont,
                    fontWeight = FontWeight(400),
                    fontSize = 16.sp,
                    lineHeight = 23.12.sp,
                    color = Color.Black
                ),
            )
        }
        Row(modifier = Modifier.fillMaxWidth()
            .padding(start = 40.dp, top = 14.dp),
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Box(
                modifier = Modifier
                    .size(7.dp)
                    .offset(y = (-46).dp)
            ) {
                SmallSquare(containerColor = Color.Black)
            }
            Text(
                text = "\"Hello, friends! I'm Kitty, the cat! Did you know I used to be a tiny kitten? Now, I'm a big cat! Just like me, things around us can be big or small. Let’s explore the world of big and small together!\" ",
                style = TextStyle(
                    fontFamily = jostFont,
                    fontWeight = FontWeight(400),
                    fontSize = 16.sp,
                    lineHeight = 23.12.sp,
                    color = Color.Black
                ),
            )
        }
        Row(modifier = Modifier.fillMaxWidth()
            .padding(start = 40.dp, top = 14.dp),
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Box(
                modifier = Modifier
                    .size(7.dp)
                    .offset(y = (-23).dp)
            ) {
                SmallSquare(containerColor = Color.Black)
            }
            Text(
                text = "\"Can you think of something big? How about something small? Let’s find out more!\"",
                style = TextStyle(
                    fontFamily = jostFont,
                    fontWeight = FontWeight(400),
                    fontSize = 16.sp,
                    lineHeight = 23.12.sp,
                    color = Color.Black
                ),
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
    }
}

@Composable
fun AddContentButton(onClick: (Boolean) -> Unit = {},modifier: Modifier = Modifier){
    Box(
        modifier = modifier
            .height(54.dp)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFF185573), Color(0xFF14868D))
                ),
                shape = RoundedCornerShape(8.dp)
            )

    ) {
        Button(
            onClick = { onClick(true) },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            ),
            enabled = true,
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ){
                Icon(imageVector = Icons.Filled.Add,
                    contentDescription = "add",
                    modifier = Modifier.size(21.dp))
                Text(
                    text = "Add Content",
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = Color.White,
                        lineHeight = 14.4.sp
                    )
                )
            }
        }
        Image(
            painter = painterResource(id = R.drawable.elephant_button),
            contentDescription = "elephant background",
            modifier = Modifier
                .scale(1f)
                .offset(x = 20.dp, y = 2.dp)
        )
    }
}


@Composable
fun CardDashedLine() {
    Canvas(modifier = Modifier.fillMaxWidth()) {
        val canvasWidth = size.width
        val dashWidth = 10f
        val dashSpacing = 10f
        var startX = 0f

        while (startX < canvasWidth) {

            drawLine(
                color = Color.Gray,
                start = Offset(x = startX, y = 0f),
                end = Offset(x = startX + dashWidth, y = 0f),
                strokeWidth = 1f,
                cap = StrokeCap.Round
            )
            startX += (dashWidth + dashSpacing)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ContentBottomSheet(isSheetOpen: MutableState<Boolean>) {
        val sheetState = rememberModalBottomSheetState()
        var buttonSelection by rememberSaveable { mutableStateOf("Text") }
        val textFieldData = rememberSaveable { mutableStateOf("let the student say the poem to gather students and create a friendly environment") }
        val fileTitle = rememberSaveable { mutableStateOf("Shapes and colours") }
        var contentSaved by rememberSaveable { mutableStateOf(false) }
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = {
                isSheetOpen.value = false
            },
            dragHandle = { BottomSheetDefaults.ExpandedShape},
            containerColor = Color.White
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(30.dp),
            ){
                BackArrow(onClick = {isSheetOpen.value = false})
                if (contentSaved){
                    ContentSubmitted()
                }else {
                    Spacer(modifier = Modifier.height(20.dp))
                    Box(
                        modifier = Modifier
                            .height(50.dp)
                            .fillMaxWidth()
                            .background(
                                color = Color(0xFFE2F2F5),
                                shape = RoundedCornerShape(10.dp)
                            )
                    ) {
                        Row(
                            modifier = Modifier.fillMaxSize(),
                        ) {
                            Button(
                                onClick = {
                                    buttonSelection = "Text"
                                },
                                modifier = Modifier
                                    .padding(5.dp)
                                    .height(40.dp)
                                    .fillMaxWidth(0.5f),
                                shape = RoundedCornerShape(10.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = if (buttonSelection == "Text") Color.White else Color.Transparent
                                )
                            ) {
                                Text(
                                    text = "Text",
                                    style = TextStyle(
                                        fontFamily = jostFont,
                                        fontWeight = FontWeight(400),
                                        fontSize = 18.sp,
                                        lineHeight = 12.sp
                                    ),
                                    color = Color(0xFF1D1751)
                                )
                            }
                            Button(
                                onClick = {
                                    buttonSelection = "Files"
                                },
                                modifier = Modifier
                                    .padding(5.dp)
                                    .height(40.dp)
                                    .fillMaxWidth(),
                                shape = RoundedCornerShape(10.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = if (buttonSelection == "Files") Color.White else Color.Transparent
                                )
                            ) {
                                Text(
                                    text = "Files",
                                    style = TextStyle(
                                        fontFamily = jostFont,
                                        fontWeight = FontWeight(400),
                                        fontSize = 18.sp,
                                        lineHeight = 12.sp
                                    ),
                                    color = Color(0xFF1D1751)
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        if (buttonSelection == "Files") {
                            AddingMediaScreen(fileTitle)
                        } else {
                            AddingTextContent(textFieldData)
                        }
                        SaveButton(onClick = {contentSaved = true})
                    }
                }
            }
        }
}

@Preview(showBackground = true)
@Composable
fun ContentSubmitted(){
    Column(
        modifier = Modifier
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Image(
            painter = painterResource(R.drawable.submission),
            contentDescription = "submit",
            modifier = Modifier.size(141.dp)
        )
        Text(
            text = "Content Added",
            style = TextStyle(
                fontFamily = jostFont,
                fontWeight = FontWeight(500),
                fontSize = 28.sp,
                lineHeight = 40.46.sp,
                color = Color(0xFF1D1751)
            )
        )
        Text(
            text = "Successfully !",
            style = TextStyle(
                fontFamily = jostFont,
                fontWeight = FontWeight(700),
                fontSize = 44.sp,
                lineHeight = 63.58.sp,
                color = Color(0xFF1D1751)
            )
        )
        Spacer(modifier = Modifier.height(80.dp))
        SaveButton( onClick = { }, text = "View Content" )
    }
}


@Composable
private fun AddingTextContent(textFieldData: MutableState<String>) {
    Text(
        text = buildAnnotatedString {
            append("Content")
            withStyle(
                style = SpanStyle(
                    color = Color.Red
                )
            ) {
                append("*")
            }
        },
        style = MaterialTheme.typography.bodySmall.copy(
            fontWeight = FontWeight(500)
        ),
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Start,
    )
    Spacer(modifier = Modifier.height(10.dp))
    Box(
        modifier = Modifier
            .drawBehind {
                val strokeWidth = 1.5.dp.toPx()
                val gradient = Brush.linearGradient(
                    colors = listOf(Color(0xFF185573), Color(0xFF14868D))
                )
                drawRoundRect(
                    brush = gradient,
                    size = size,
                    style = Stroke(strokeWidth),
                    cornerRadius = CornerRadius(x = 5.dp.toPx(), y = 5.dp.toPx()),
                )
            }
    ) {
        OutlinedTextField(
            value = textFieldData.value,
            textStyle = MaterialTheme.typography.bodySmall,
            onValueChange = { textFieldData.value = it },
            label = { },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
    Spacer(modifier = Modifier.height(100.dp))
}

@Composable
fun AddingMediaScreen(fileTitle: MutableState<String>){
    Text(
        text = buildAnnotatedString {
            append("File Title")
            withStyle(style = SpanStyle(
                color = Color.Red
            )){
                append("*")
            }
        },
        style = MaterialTheme.typography.bodySmall.copy(
            fontWeight = FontWeight(500)
        ),
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Start,
    )
    Spacer(modifier = Modifier.height(10.dp))
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .drawBehind {
                val strokeWidth = 2.dp.toPx()
                val gradient = Brush.linearGradient(
                    colors = listOf(Color(0xFF185573), Color(0xFF14868D))
                )
                drawRoundRect(
                    brush = gradient,
                    size = size,
                    style = Stroke(strokeWidth),
                    cornerRadius = CornerRadius(x = 6.dp.toPx(), y = 6.dp.toPx()),                                            )
            },
    ) {
        OutlinedTextField(
            value = fileTitle.value,
            textStyle = MaterialTheme.typography.bodySmall,
            onValueChange = { fileTitle.value = it },
            label = {  },
            maxLines = 1,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            ),
            modifier = Modifier
                .offset(y = (-8).dp)
        )
    }
    Spacer(modifier = Modifier.height(20.dp))
    DashedBorderBox()
    Spacer(modifier = Modifier.height(20.dp))
    MediaUploadingCard()
    Spacer(modifier = Modifier.height(20.dp))
    MediaUploadingCard(progress = 1f)
    Spacer(modifier = Modifier.height(20.dp))
}

@Composable
private fun DashedBorderBox(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .height(179.dp)
            .fillMaxWidth()
            .background(
                color = Color(0xFFB6DFE6).copy(alpha = 0.15f),
                shape = RoundedCornerShape(18.9.dp)
            )
            .border(width = 4.dp, color = Color.Transparent, RoundedCornerShape(8.dp))
            .drawBehind {
                val borderWidth = 1.dp.toPx()
                val dashWidth = 5.dp.toPx()
                val dashGap = 5.dp.toPx()
                val paint = Paint().apply {
                    strokeWidth = borderWidth
                    pathEffect = PathEffect.dashPathEffect(floatArrayOf(dashWidth, dashGap), 0f)
                }
                drawRoundRect(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFF185573), Color(0xFF14868D))
                    ),
                    size = size,
                    style = Stroke(width = borderWidth, pathEffect = paint.pathEffect),
                    cornerRadius = CornerRadius(18.9.dp.toPx())
                )
            }
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ){
                Image(
                    painter = painterResource(R.drawable.upload_icon),
                    contentDescription = "upload",
                    modifier = Modifier.size(22.68.dp)
                )
                Text(
                    text = "Upload media",
                    color = Color.Black,
                    style = MaterialTheme.typography.labelLarge.copy(
                        brush = Brush.linearGradient(
                            colors = listOf(Color(0xFF185573), Color(0xFF14868D))
                        ),
                        fontSize = 17.01.sp,
                        lineHeight = 11.34.sp,
                        letterSpacing = 0.14.sp
                    )
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Click on the button or Drag and Drop files here",
                style = MaterialTheme.typography.labelSmall.copy(
                    fontSize = 11.34.sp,
                    lineHeight = 11.34.sp,
                    letterSpacing = 0.14.sp,
                    color = Color(0xFF5A5A5A)
                )
            )
            Spacer(modifier = Modifier.height(30.dp))
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ),
                enabled = true,
                modifier = Modifier
                    .width(247.37.dp)
                    .height(44.29.dp)
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(Color(0xFF185573), Color(0xFF14868D))
                        ),
                        shape = RoundedCornerShape(4.18.dp)
                    )
            ) {
                Text(
                    text = "Browse Files",
                    style = TextStyle(
                        fontFamily = openFont,
                        color = Color.White,
                        fontWeight = FontWeight(600),
                        fontSize = 13.37.sp,
                        lineHeight = 10.03.sp,
                        letterSpacing = 0.13.sp
                    )
                )
            }
        }
    }
}

@Composable
fun MediaUploadingCard(progress: Float = 0.5f){
    Box(
        modifier = Modifier
            .height(68.dp)
            .fillMaxWidth()
            .background(
                color = Color(0xFFF1F8FC),
                shape = RoundedCornerShape(10.dp)
            )
            .padding(start = 20.dp, top = 10.dp, end = 30.dp, bottom = 10.dp)
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Row(
                horizontalArrangement = Arrangement.spacedBy(15.dp)
            ){
                Image(
                    painter = painterResource(R.drawable.video_clip),
                    contentDescription = "video",
                    modifier = Modifier.size(44.dp)
                )
                Column(){
                    Text(
                        text = "Sample.mp4",
                        style = MaterialTheme.typography.labelMedium.copy(
                            fontWeight = FontWeight(600),
                            color = Color(0xFF1D1751)
                        )
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = if (progress == 1f) "Uploaded" else "Uploading",
                        style = TextStyle(
                            fontFamily = italicSansFont,
                            fontSize = 10.sp,
                            lineHeight = 13.62.sp,
                            color = Color(0xFF2679B4)
                        )
                    )
                    UploadingProgressBar(progress)
                }
            }
            Image(
                painter = painterResource(R.drawable.delete),
                contentDescription = "delete",
                modifier = Modifier
                    .width(11.65.dp)
                    .height(13.92.dp)
            )

        }

    }
}

@Composable
fun UploadingProgressBar(progress: Float = 0.5f){
    Spacer(modifier = Modifier.height(10.dp))
    Box(
        modifier = Modifier
            .width(183.dp)
            .height(3.dp)
            .background(
                shape = RoundedCornerShape(8.dp),
                color = Color.White
            )
    ){
        Canvas(modifier = Modifier.fillMaxSize()) {
            if (progress > 0){
                drawRoundRect(
                    color = Color(0xFF25A455),
                    size = Size(size.width * progress, size.height),
                    cornerRadius = CornerRadius(18f, 18f)
                )
            }
        }
    }
}


@Composable
private fun SaveButton(onClick:() -> Unit = { }, text: String = "Save"){
    Box(
        modifier = Modifier
            .height(54.dp)
            .width(314.dp)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFF185573), Color(0xFF14868D))
                ),
                shape = RoundedCornerShape(8.dp)
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
            Text(
                text = text,
                style = MaterialTheme.typography.titleMedium.copy(
                    color = Color.White,
                    fontWeight = FontWeight(500)
                )
            )
        }
        Image(
            painter = painterResource(id = R.drawable.elephant_button),
            contentDescription = "elephant background",
            modifier = Modifier
                .offset(x = 40.dp, y = 2.dp)
        )
    }
}
