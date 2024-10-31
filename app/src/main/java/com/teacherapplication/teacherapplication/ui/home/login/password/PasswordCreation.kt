package com.teacherapplication.teacherapplication.ui.home.login.password

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teacherapplication.teacherapplication.R
import com.teacherapplication.teacherapplication.ui.home.login.otp.OTPVerify

@Preview
@Composable
fun SetPassword(modifier: Modifier = Modifier){

    val password = remember {
        mutableStateOf("")
    }
    val rePassword = remember {
        mutableStateOf("")
    }
    val gradientBrush = if ((password.value == rePassword.value) && (password.value.length >=6))
        Brush.linearGradient(
        colors = listOf(
            Color(0xFF129193),
            Color(0xFF185472)
        ),
            start = Offset(Float.POSITIVE_INFINITY, 0f),
            end = Offset.Zero

    ) else {
        Brush.linearGradient(
            colors = listOf(
                Color(0x66129193).copy(alpha = 0.4f),
                Color(0x66185472).copy(alpha = 0.4f)
            ),
            start = Offset.Infinite.copy(x = 1f),
            end = Offset.Zero
        )
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xFFFFFFFF)))
    {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 10.dp, top = 30.dp, end = 10.dp))
        {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(40.dp)
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "back",
                        modifier = Modifier.scale(1.2f)
                    )
                }
                Text(
                    text = "Set Your Password",
                    color = Color(0xFF14868D),
                    fontSize = 23.sp,
                    fontWeight = FontWeight(800),
                    modifier = Modifier.align(Alignment.Bottom)
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                Text(text = "Your password needs to be at least 6",
                    fontWeight = FontWeight(400),
                    textAlign = TextAlign.Center,
                    color = Color(0xFF333333)
                )
                Text(text = "characters.",
                    fontWeight = FontWeight(400),
                    textAlign = TextAlign.Center,
                    color = Color(0xFF333333)
                )

                Column(
                    modifier = Modifier.padding(10.dp)
                ) {
                    Row(
                        modifier = Modifier
                    ) {
                        Text(
                            text = "Password",
                            fontSize = 15.sp,
                        )
                        Spacer(modifier = Modifier.width(2.dp))
                        Text(
                            text = "*",
                            color = Color(0xFFEF6464),
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .scale(1.2f)
                        )
                    }
                    Box {
                        OutlinedTextField(
                            value = password.value,
                            onValueChange = { password.value = it },
                            label = {
                                Text(
                                    text = if (password.value.isEmpty()) "Enter your password" else "",
                                    color = Color(0xFF9D9D9D),
                                    modifier = Modifier.offset(x = 0.dp, y = (-4).dp)
                                )
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp)
                                .padding(top = 2.dp)
                                .border(
                                    width = 2.dp,
                                    color = Color(0xFF14868D),
                                    shape = RoundedCornerShape(5.dp)
                                ),
                            colors = OutlinedTextFieldDefaults.colors(
                                unfocusedBorderColor = Color.Transparent,
                                focusedBorderColor = Color.Transparent
                            )
                        )
                        Image(painter = painterResource(id = R.drawable.eye),
                            contentDescription = "eye",
                            modifier = Modifier
                                .align(Alignment.CenterEnd)
                                .padding(end = 20.dp)
                                .scale(1.3f)
                                .clickable {
                                    //TODO
                                })

                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        modifier = Modifier
                    ) {
                        Text(
                            text = "Re-Enter Password",
                            fontSize = 15.sp,
                        )
                        Spacer(modifier = Modifier.width(2.dp))
                        Text(
                            text = "*",
                            color = Color(0xFFEF6464),
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .scale(1.2f)
                        )
                    }
                    Box {
                        OutlinedTextField(
                            value = rePassword.value,
                            onValueChange = { rePassword.value = it },
                            label = {
                                Text(
                                    text = if (rePassword.value.isEmpty()) "Re-Enter your password" else "",
                                    color = Color(0xFF9D9D9D),
                                    modifier = Modifier.offset(x = 0.dp, y = (-4).dp)
                                )
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp)
                                .padding(top = 2.dp)
                                .border(
                                    width = 2.dp,
                                    color = Color(0xFF14868D),
                                    shape = RoundedCornerShape(5.dp)
                                ),
                            colors = OutlinedTextFieldDefaults.colors(
                                unfocusedBorderColor = Color.Transparent,
                                focusedBorderColor = Color.Transparent
                            )
                        )
                        Image(painter = painterResource(id = R.drawable.eye),
                            contentDescription = "eye",
                            modifier = Modifier
                                .align(Alignment.CenterEnd)
                                .padding(end = 20.dp)
                                .scale(1.3f)
                                .clickable {
                                    //TODO
                                })

                    }
                    Box(
                        modifier = Modifier
                            .padding(top = 60.dp)
                            .height(70.dp)
                            .background(
                                brush = gradientBrush,
                                shape = RoundedCornerShape(10.dp)
                            )
                    ) {
                        Button(
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent
                            ),
                            enabled = true,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(70.dp)
                        ) {
                            Text(
                                text = "Save & Next",
                                fontSize = 18.sp,
                                fontWeight = FontWeight(700)
                            )
                        }
                        Image(
                            painter = painterResource(id = R.drawable.elephant_button),
                            contentDescription = "elephant background",
                            modifier = Modifier
                                .scale(1.3f)
                                .offset(x = 25.dp, y = 7.dp)
                        )
                    }
                }

            }


            Image(
                painter = painterResource(id = R.drawable.elephant_color),
                contentDescription = "coloured elephant",
                modifier = Modifier
                    .scale(1.2f)
                    .offset(x = 0.dp, y = 180.dp)

            )


        }
    }
}