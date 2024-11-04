package com.teacherapplication.teacherapplication.ui.home.dashboard

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teacherapplication.teacherapplication.R

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun DashBoardScreen(modifier: Modifier = Modifier){
    Box(modifier = Modifier.fillMaxSize()){
        Image(painter = painterResource(id = R.drawable.elephant_slide),
            contentDescription = "elephant",
            modifier = Modifier
                .size(320.dp)
                .align(Alignment.TopEnd))
        Scaffold(
            modifier = Modifier.padding(top = 30.dp, start = 10.dp, end = 10.dp),
            topBar = {
                TopAppBar(
                    navigationIcon = {
                        ProfileWithMenuIcon()
                    },
                    title = {
                    Column(
                        modifier = Modifier
                            .padding(start = 8.dp, top = 5.dp)
                            //.align(Alignment.Center)
                    ){
                        Text(text = "Good Morning,",
                            color = Color(0xFF129193),
                            fontWeight = FontWeight(400),
                            fontSize = 12.sp,
                            lineHeight = 12.sp
                        )
                        Text(text = "Chandini",
                            color = Color(0xFF1D1751),
                            fontWeight = FontWeight(600),
                            fontSize = 24.sp,
                            lineHeight = 24.sp)
                    }
                },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Transparent,
                        titleContentColor = Color.Gray
                    ),
                    actions = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Image(painter = painterResource(id = R.drawable.notification),
                                contentDescription = "notification",
                                modifier = Modifier.size(35.dp))
                        }
                        DropdownMenu()
                    }
                )
            },
            containerColor = Color.Transparent,
            content = {
                Column(modifier = Modifier.padding(it)){

                }
            }
        )
    }
}

@Composable
fun DropdownMenu(
){
    Surface(
        modifier = Modifier
            .height(35.dp)
    ){

    }

}


@Composable
fun ProfileWithMenuIcon() {
    Box(
        modifier = Modifier
            .height(50.dp)
            .width(51.dp),
        contentAlignment = Alignment.BottomEnd
    ) {
        // Profile Image
        Image(
            painter = painterResource(id = R.drawable.profile_img), // Replace with your drawable resource
            contentDescription = "Profile Image",
            modifier = Modifier
                .size(45.dp)
                .scale(1f)
        )
        // Menu Icon
        Surface(
            modifier = Modifier
                .size(20.dp)
                .offset(x = 5.dp, y = 7.dp),
            shape = CircleShape,
        ){
            Box(
                modifier = Modifier.background(brush = Brush.linearGradient(
                    colors = listOf(Color(0xFF129193), Color(0xFF062C2D)),
                ))
            ){
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Menu Icon",
                    tint = Color(0xFFFFFFFF),
                    modifier = Modifier
                        .padding(3.dp)
                        .size(15.dp)
                )

            }

        }
    }
}

