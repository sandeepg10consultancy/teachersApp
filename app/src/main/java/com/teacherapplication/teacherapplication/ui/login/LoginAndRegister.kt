package com.teacherapplication.teacherapplication.ui.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teacherapplication.teacherapplication.R


@Preview
@Composable
fun LoginAndRegister(modifier: Modifier = Modifier){

    Box(modifier = Modifier.fillMaxSize()
        .background(
            brush = Brush.linearGradient(
                colors = listOf(Color(0xFF185573), Color(0xFF14868D)),
                start = Offset(0f, 0f),
                end = Offset(Float.POSITIVE_INFINITY, 0f)
            )
        )){
        Image(painter = painterResource(id = R.drawable.elephant_bg),
            contentDescription = "elephant bg",
            modifier = Modifier
                .scale(1.27f)
                .offset(x = (-33).dp, y = (-80).dp)
                .align(Alignment.BottomEnd)
        )
        Image(painter = painterResource(id = R.drawable.exela_img),
            contentDescription = "Exela logo",
            modifier = Modifier
                .scale(1.3f)
                .align(Alignment.TopCenter)
        )
        Image(painter = painterResource(id = R.drawable.exela_txt),
            contentDescription = "text",
            modifier = Modifier
                .scale(1.3f)
                .padding(top = 170.dp)
                .align(Alignment.TopCenter)
        )
        Column(
            modifier = Modifier
                .padding(15.dp)
                .padding(bottom = 40.dp)
                .align(Alignment.BottomCenter)
        ){

            Box {
                Button(onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(5.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)) {
                    Text(text = "Log In",
                        fontSize = 18.sp,
                        color = Color(0xFF14868D)
                    )
                }
                Image(painter = painterResource(id = R.drawable.elephant_lr),
                    contentDescription = "elephant image",
                        modifier = Modifier
                            .padding(start = 20.dp)
                            .scale(1.3f)
                            .offset(x = 0.dp, y = (-15).dp))
                }
                OutlinedButton(onClick = {},
                    shape = RoundedCornerShape(5.dp),
                    border = BorderStroke(width = 2.dp, color = Color.White),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)) {
                    Text(text = "New User? Let's Register",
                        color = Color.White,
                        style = MaterialTheme.typography.labelLarge,
                        //fontSize = 18.sp
                    )
                }
            }
        }


}