package com.teacherapplication.teacherapplication.ui.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.teacherapplication.teacherapplication.R
import com.teacherapplication.teacherapplication.ui.utills.exelaGradient


@Composable
fun LoginAndRegister(
    modifier: Modifier = Modifier,
    navController: NavController
){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = exelaGradient
        )
    ){
        Image(painter = painterResource(id = R.drawable.elephant_bg),
            contentDescription = "elephant bg",
            modifier = Modifier
                .height(511.dp)
                .width(618.08.dp)
                .padding(start = 30.dp, bottom = 40.dp)
                .align(Alignment.BottomEnd)
        )
        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .size(350.dp)
                .offset(y = (-3).dp)
        ){
            Image(
                painter = painterResource(id = R.drawable.exela_img),
                contentDescription = "Exela logo",
                modifier = Modifier
                    .height(330.dp)
                    .width(345.dp)
            )
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.exela_txt),
                    contentDescription = "text",
                    modifier = Modifier
                        .height(109.21.dp)
                        .width(351.5.dp)
                )
            }
        }
        Column(
            modifier = Modifier
                .padding(15.dp)
                .padding(bottom = 40.dp)
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Box(
                modifier = Modifier
                    .height(81.08.dp)
                    .width(382.dp)
            ) {
                Button(
                    onClick = {
                        navController.navigate(route = "login")
                    },
                    shape = RoundedCornerShape(4.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .align(Alignment.BottomCenter)
                ) {
                    Text(
                        text = "Log In",
                        style = MaterialTheme.typography.bodySmall.copy(
                            brush = exelaGradient,
                            lineHeight = 36.sp,
                            fontWeight = FontWeight(600)
                        )

                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.elephant_lr),
                    contentDescription = "elephant image",
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .height(81.08.dp)
                        .width(79.dp)
                )
            }
            OutlinedButton(
                onClick = {
                    navController.navigate(route = "register")
                },
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .border(
                        width = 2.dp,
                        color = Color.White,
                        shape = RoundedCornerShape(4.dp)
                    )
            ) {
                Text(
                    text = "New User? Let's Register",
                    color = Color.White,
                    style = MaterialTheme.typography.bodySmall.copy(
                        lineHeight = 36.sp,
                        fontWeight = FontWeight(600)
                    )

                )
            }
        }
    }
}

@Preview
@Composable
fun LoginAndRegisterPreview(){
    val navController = rememberNavController()
    LoginAndRegister(navController = navController)
}