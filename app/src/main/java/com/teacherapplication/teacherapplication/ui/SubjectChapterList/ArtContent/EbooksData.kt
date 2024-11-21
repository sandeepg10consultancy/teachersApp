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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.teacherapplication.teacherapplication.ui.theme.fonts
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
fun EbooksCards(navController: NavHostController) {
    if (ebooksList.isNotEmpty()) {
        Column(modifier = Modifier.fillMaxSize()) {
            ebooksList.forEach { item ->
                EbookCard(title = item.first, image = item.second)
            }
            Spacer(modifier = Modifier.height(10.dp))
            VideosButton(onClick = { navController.navigate(route = "ebookUpload")}, text = "Add Ebook")
            Spacer(modifier = Modifier.height(100.dp))
        }
    }else{
        EmptyEbooksScreen()
    }
}

@Composable
fun EmptyEbooksScreen(){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Image(
            painter = painterResource(R.drawable.empty_ebook),
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
            fontSize = 20.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "No E-books have been added for this \n" +
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

@Composable
fun UploadEbookScreen(){
    var buttonSelection by rememberSaveable { mutableStateOf(false) }
    val ebookTitle = rememberSaveable { mutableStateOf("") }
    val ebookDescription = rememberSaveable { mutableStateOf("") }
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
                    text = "Upload Ebook",
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
            DashedVideoBox(text = "Ebook")
            Spacer(modifier = Modifier.height(20.dp))
            UploadedFilesCard(
                title = "Uploaded Files",
                text = "Sample.pdf",
                subText = "2 Pages",
                image = R.drawable.eb_sample
            )
            Spacer(modifier = Modifier.height(20.dp))
            VideoTitleField(
                text = ebookTitle.value,
                labelText = "type your ebook title here"
            ) { ebookTitle.value = it }
            Spacer(modifier = Modifier.height(30.dp))
            VideoDescriptionField(
                text = ebookDescription.value,
                labelText = "Add your ebook description"
            ) { ebookDescription.value = it }
            Spacer(modifier = Modifier.height(30.dp))
            VideosButton(text = "Add Ebook", onClick = {})
            Spacer(modifier = Modifier.height(120.dp))
        }
        BottomAppBar(
            modifier = Modifier.align(Alignment.BottomCenter)
                .background(color = Color.White)
        ) {
            BottomNavigationBar()
        }
    }
}