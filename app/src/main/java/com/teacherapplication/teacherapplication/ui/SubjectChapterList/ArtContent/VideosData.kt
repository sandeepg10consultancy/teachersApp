package com.teacherapplication.teacherapplication.ui.SubjectChapterList.ArtContent

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.teacherapplication.teacherapplication.R
import com.teacherapplication.teacherapplication.ui.AppComponents.BackArrow
import com.teacherapplication.teacherapplication.ui.home.dashboard.BottomNavigationBar
import com.teacherapplication.teacherapplication.ui.home.dashboard.DashboardViewModel
import com.teacherapplication.teacherapplication.ui.theme.fonts
import com.teacherapplication.teacherapplication.ui.theme.italicSansFont
import com.teacherapplication.teacherapplication.ui.theme.jostFont
import com.teacherapplication.teacherapplication.ui.theme.openFont

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
fun VideosCards(navController: NavHostController) {
    if (videosList.isNotEmpty()) {
        Column(modifier = Modifier.fillMaxSize()) {
            videosList.forEach { item ->
                VideoCard(title = item.first, image = item.second)
            }
            Spacer(modifier = Modifier.height(10.dp))
            VideosButton(
                onClick = { navController.navigate(route = "videoUpload") },
                text = "Add Video"
            )
            Spacer(modifier = Modifier.height(100.dp))
        }
    }else{
        EmptyVideosScreen(navController)
    }
}

@Composable
private fun EmptyVideosScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Image(
            painter = painterResource(R.drawable.empty_video),
            contentDescription = "empty Video",
            modifier = Modifier.size(150.dp)
        )
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontFamily = jostFont,
                        fontWeight = FontWeight(600),
                    )
                ) {
                    append("\"Oops")
                }
                withStyle(
                    style = SpanStyle(
                        fontFamily = fonts,
                        fontWeight = FontWeight(400),
                    )
                ) {
                    append("!")
                }
            },
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "No videos have been added for this \n" +
                    "topic yet.",
            style = TextStyle(
                fontFamily = fonts,
                fontWeight = FontWeight(300),
                fontSize = 18.sp,
                lineHeight = 22.68.sp,
                color = Color.Black
            ),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(50.dp))
        VideosButton(
            onClick = { navController.navigate(route = "videoUpload") },
            text = "Add Video"
        )
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
fun UploadVideoScreen(viewModel: DashboardViewModel, navController: NavHostController) {
    var buttonSelection by rememberSaveable { mutableStateOf("Files") }
    val videoTitle = rememberSaveable { mutableStateOf("") }
    val videoDescription = rememberSaveable { mutableStateOf("") }
    val verticalScroll = rememberScrollState()
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.padding(start = 10.dp, top = 40.dp, end = 10.dp)
                .verticalScroll(verticalScroll)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                BackArrow(onClick = { })
                Text(
                    text = "Upload Video",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight(500),
                        lineHeight = 14.4.sp,
                        color = Color.Black
                    ),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Box(
                modifier = Modifier
                    .height(50.dp)
                    .width(330.dp)
                    .background(
                        color = Color(0xFFB6DFE6).copy(alpha = 0.4f),
                        shape = RoundedCornerShape(10.dp)
                    )
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Button(
                        onClick = {
                            buttonSelection = "Files"
                        },
                        modifier = Modifier
                            .padding(5.dp)
                            .height(40.dp)
                            .width(165.dp),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (buttonSelection == "Files") Color.White else Color.Transparent
                        )
                    ) {
                        Row(
                            modifier = Modifier.fillMaxSize(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Image(
                                painter = painterResource(R.drawable.files),
                                contentDescription = "files",
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(
                                text = "Files",
                                style = TextStyle(
                                    fontFamily = jostFont,
                                    fontWeight = FontWeight(400),
                                    fontSize = 18.sp,
                                    lineHeight = 12.sp,
                                    letterSpacing = 0.15.sp
                                ),
                                color = Color(0xFF1D1751)
                            )
                        }
                    }
                    Button(
                        onClick = {
                            buttonSelection = "URL"
                        },
                        modifier = Modifier
                            .padding(5.dp)
                            .height(40.dp)
                            .width(165.dp),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (buttonSelection == "URL") Color.White else Color.Transparent
                        )
                    ) {
                        Row(
                            modifier = Modifier.fillMaxSize(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Image(
                                painter = painterResource(R.drawable.url_link),
                                contentDescription = "url",
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(
                                text = "URL",
                                style = TextStyle(
                                    fontFamily = jostFont,
                                    fontWeight = FontWeight(400),
                                    fontSize = 18.sp,
                                    lineHeight = 12.sp,
                                    letterSpacing = 0.15.sp
                                ),
                                color = Color(0xFF1D1751)
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(30.dp))
            if (buttonSelection == "URL") {
                DashedURLBox()
                Spacer(modifier = Modifier.height(30.dp))
                AddedFilesCard(
                    title = "Added Files",
                    text = "NEW! The colours of the rain..",
                    subText = "youtube.com",
                    image = R.drawable.add_url_sample
                )
            } else {
                DashedVideoBox(text = "Video")
                Spacer(modifier = Modifier.height(30.dp))
                UploadedFilesCard(
                    title = "Uploaded Files",
                    text = "Sample.mp4",
                    subText = "2:30",
                    image = R.drawable.sample_video
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            VideoTitleField(
                text = videoTitle.value,
                labelText = "type your video title here"
            ) { videoTitle.value = it }
            Spacer(modifier = Modifier.height(30.dp))
            VideoDescriptionField(
                text = videoDescription.value,
                labelText = "Add your video description"
            ) { videoDescription.value = it }
            Spacer(modifier = Modifier.height(30.dp))
            VideosButton(text = "Add Video", onClick = {})
            Spacer(modifier = Modifier.height(120.dp))

        }
        BottomAppBar(
            modifier = Modifier.align(Alignment.BottomCenter)
                .background(color = Color.White)
        ) {
            BottomNavigationBar(navController, viewModel)
        }
    }
}

@Composable
fun VideoDescriptionField(
    text: String,
    labelText: String,
    onValueChange: (String) -> Unit
){
    Column(
        modifier = Modifier
            .padding(5.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ){
        var label by remember { mutableStateOf(false) }
        Text(
            text = "Video Description",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start
        )
        Box(
            modifier = Modifier
                .heightIn(min = 160.dp)
                .drawBehind {
                    val strokeWidth = 2.dp.toPx()
                    val gradient = Brush.linearGradient(
                        colors = listOf(Color(0xFF185573), Color(0xFF14868D))
                    )
                    drawRoundRect(
                        brush = gradient,
                        size = size,
                        style = Stroke(strokeWidth),
                        cornerRadius = CornerRadius(x = 6.dp.toPx(), y = 6.dp.toPx()),
                    )
                }
        ) {
            OutlinedTextField(
                value = text,
                textStyle = MaterialTheme.typography.bodySmall,
                onValueChange = onValueChange,
                label = {
                    if (!label && text.isEmpty()) {
                        Text(
                            text = labelText,
                            style = MaterialTheme.typography.labelMedium.copy(
                                fontSize = 16.sp,
                                lineHeight = 20.16.sp
                            ),
                            color = Color(0xFF9D9D9D),
                            modifier = Modifier
                                .offset(y = (-8).dp)
                        )
                    }
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent
                ),
                modifier = Modifier.fillMaxWidth()
                    .onFocusChanged { focusState ->
                        label = focusState.isFocused
                    },
                maxLines = Int.MAX_VALUE
            )
        }
    }
}


@Composable
fun VideoTitleField(
    text: String,
    labelText: String,
    onValueChange: (String) -> Unit
){
    Column(
        modifier = Modifier
            .padding(5.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = "Video Title",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start
        )
        TextFieldOne(text, onValueChange, labelText)
    }
}

@Composable
private fun TextFieldOne(
    text: String,
    onValueChange: (String) -> Unit,
    labelText: String
) {
    val label = remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .height(52.dp)
            .drawBehind {
                val strokeWidth = 2.dp.toPx()
                val gradient = Brush.linearGradient(
                    colors = listOf(Color(0xFF185573), Color(0xFF14868D))
                )
                drawRoundRect(
                    brush = gradient,
                    size = size,
                    style = Stroke(strokeWidth),
                    cornerRadius = CornerRadius(x = 6.dp.toPx(), y = 6.dp.toPx()),
                )
            },
        contentAlignment = Alignment.Center
    ) {
        TextField(
            value = text,
            textStyle = MaterialTheme.typography.bodySmall.copy(
                fontSize = 18.sp,
                lineHeight = 14.4.sp
            ),
            onValueChange = onValueChange,
            label = {
                if (!label.value && text.isEmpty()) {
                    Text(
                        text = labelText,
                        style = MaterialTheme.typography.labelMedium.copy(
                            fontSize = 16.sp,
                            lineHeight = 20.16.sp
                        ),
                        color = Color(0xFF9D9D9D),
                        modifier = Modifier
                    )
                }
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            ),
            modifier = Modifier
                .fillMaxSize()
                .onFocusChanged { focusState ->
                    label.value = focusState.isFocused
                }
                .offset(y = (-5).dp)
        )
    }
}


@Composable
fun DashedVideoBox(
    modifier: Modifier = Modifier,
    text: String
) {
    Box(
        modifier = modifier
            .height(208.dp)
            .width(382.dp)
            .background(
                color = Color(0xFFB6DFE6).copy(alpha = 0.15f),
                shape = RoundedCornerShape(20.dp)
            )
            .border(width = 1.dp, color = Color.Transparent, RoundedCornerShape(20.dp))
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
                    cornerRadius = CornerRadius(20.dp.toPx())
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
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = "Upload $text",
                    style = MaterialTheme.typography.labelLarge.copy(
                        brush = Brush.linearGradient(
                            colors = listOf(Color(0xFF185573), Color(0xFF14868D))
                        ),
                        fontSize = 18.sp,
                        lineHeight = 12.sp,
                        letterSpacing = 0.15.sp
                    )
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Click on the button or Drag and Drop files here",
                style = MaterialTheme.typography.labelSmall.copy(
                    fontSize = 12.sp,
                    lineHeight = 12.sp,
                    letterSpacing = 0.15.sp,
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
                    .width(296.dp)
                    .height(53.dp)
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(Color(0xFF185573), Color(0xFF14868D))
                        ),
                        shape = RoundedCornerShape(5.dp)
                    )
            ) {
                Text(
                    text = "Browse Files",
                    style = TextStyle(
                        fontFamily = openFont,
                        color = Color.White,
                        fontWeight = FontWeight(600),
                        fontSize = 16.sp,
                        lineHeight = 12.sp,
                        letterSpacing = 0.15.sp
                    )
                )
            }
        }
    }
}


@Composable
private fun DashedURLBox(
    modifier: Modifier = Modifier,
) {
    var urlField by remember { mutableStateOf("") }
    Box(
        modifier = modifier
            .height(208.dp)
            .width(382.dp)
            .background(
                color = Color(0xFFB6DFE6).copy(alpha = 0.15f),
                shape = RoundedCornerShape(20.dp)
            )
            .border(width = 1.dp, color = Color.Transparent, RoundedCornerShape(20.dp))
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
                    cornerRadius = CornerRadius(20.dp.toPx())
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
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = "Add URL",
                    style = MaterialTheme.typography.labelLarge.copy(
                        brush = Brush.linearGradient(
                            colors = listOf(Color(0xFF185573), Color(0xFF14868D))
                        ),
                        fontSize = 18.sp,
                        lineHeight = 12.sp,
                        letterSpacing = 0.15.sp
                    )
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Please Enter or Paste valid video source URL to import",
                style = MaterialTheme.typography.labelSmall.copy(
                    lineHeight = 15.12.sp,
                    letterSpacing = 0.15.sp,
                    color = Color.Black.copy(alpha = 0.4f)
                )
            )
            Spacer(modifier = Modifier.height(30.dp))
            TextFieldOne(
                text = urlField,
                onValueChange = { urlField = it},
                labelText = "https://www.youtube.com"
            )
        }
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

@Composable
fun UploadedFilesCard(
    title: String,
    text: String,
    subText: String,
    image: Int,
    progress: Float = 0.5f
){
    Column(
        modifier = Modifier.padding(start = 5.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ){
        Text(
            text = title,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start
        )
        Box(
            modifier = Modifier
                .height(80.dp)
                .fillMaxWidth()
                .border(
                    width = 0.61.dp,
                    brush = Brush.horizontalGradient(
                        colors = listOf(Color(0xFF185573), Color(0xFF14868D))
                    ),
                    shape = RoundedCornerShape(8.dp)
                )
                .background(
                    color = Color(0xFF75B6E4).copy(alpha = 0.1f),
                )
                .padding(5.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(end = 5.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Image(
                        painter = painterResource(image),
                        contentDescription = "video",
                        modifier = Modifier
                            .width(95.dp)
                            .height(70.dp)
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxHeight(),
                        verticalArrangement = Arrangement.SpaceAround
                    ) {
                        Text(
                            text = text,
                            style = MaterialTheme.typography.bodySmall.copy(
                                fontWeight = FontWeight(600),
                                lineHeight = 24.31.sp,
                                color = Color(0xFF1D1751)
                            ),
                            modifier = Modifier.wrapContentWidth()
                        )
                        LinearProgressIndicator(
                            progress = { progress },
                            modifier = Modifier
                                .clip(RoundedCornerShape(12.16.dp))
                                .width(193.dp)
                                .height(7.dp),
                            color = Color(0xFF2D9549)
                        )
                        Text(
                            text = subText,
                            style = MaterialTheme.typography.labelSmall,
                            color = Color(0xFFA3A3A3)
                        )
                    }
                }
                Image(
                    painter = painterResource(R.drawable.delete),
                    contentDescription = "delete",
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}

@Composable
private fun AddedFilesCard(
    title: String,
    text: String,
    subText: String,
    image: Int,
    progress: Float = 1f
){
    Column(
        modifier = Modifier.padding(start = 5.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.height(4.dp))
        Box(
            modifier = Modifier
                .height(80.dp)
                .fillMaxWidth()
                .border(
                    width = 0.61.dp,
                    brush = Brush.horizontalGradient(
                        colors = listOf(Color(0xFF185573), Color(0xFF14868D))
                    ),
                    shape = RoundedCornerShape(8.dp)
                )
                .background(
                    color = Color(0xFF75B6E4).copy(alpha = 0.1f),
                )
                .padding(5.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(end = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Image(
                        painter = painterResource(image),
                        contentDescription = "video",
                        modifier = Modifier
                            .width(95.dp)
                            .height(70.dp)
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(end = 20.dp),
                        verticalArrangement = Arrangement.SpaceAround
                    ) {
                        Text(
                            text = text,
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontSize = 16.sp,
                                lineHeight = 24.31.sp,
                            ),
                            modifier = Modifier.wrapContentWidth()
                        )
                        LinearProgressIndicator(
                            progress = { progress },
                            modifier = Modifier
                                .clip(RoundedCornerShape(12.16.dp))
                                .width(193.dp)
                                .height(7.dp),
                            color = Color(0xFF2D9549)
                        )
                        Text(
                            text = subText,
                            style = TextStyle(
                                fontFamily = italicSansFont,
                                fontSize = 12.sp,
                                lineHeight = 24.31.sp,
                                color = Color(0xFF1D1751)
                            )
                        )
                    }
                }
                Image(
                    painter = painterResource(R.drawable.delete),
                    contentDescription = "delete",
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}