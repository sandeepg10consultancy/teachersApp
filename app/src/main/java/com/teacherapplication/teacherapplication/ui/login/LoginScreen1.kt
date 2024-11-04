package com.teacherapplication.teacherapplication.ui.login

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.teacherapplication.teacherapplication.R


@Preview(showBackground = true)
@Composable
fun LoginScreen(modifier: Modifier = Modifier) {

    var phoneNumber by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    val gradientBrush = if (phoneNumber.length >= 10){
        Brush.linearGradient(
            colors = listOf(Color(0xFF185573), Color(0xFF14868D)),
            start = Offset(0f, 0f),
            end = Offset(Float.POSITIVE_INFINITY, 0f)
        )
    }else{
        Brush.linearGradient(
            colors = listOf(
                Color(0x66129193).copy(alpha = 0.4f),
                Color(0x66185472).copy(alpha = 0.4f)
            ),
            start = Offset.Infinite.copy(x = 1f),
            end = Offset.Zero
        )
    }

    var showLabel by remember { mutableStateOf(true) }

    Box(modifier = Modifier
        .fillMaxSize()
        //.padding(top = 50.dp)
        .background(color = Color(0xFFFFFFFF))
    ){
        Spacer(modifier = Modifier.height(150.dp))

        Column(
            modifier = Modifier
                .padding(start = 10.dp, top = 30.dp, end = 10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "back",
                        modifier = Modifier.scale(1.2f)
                    )
                }
                Spacer(modifier = Modifier.width(100.dp))
                Text(
                    text = "Log In",
                    color = Color(0xFF14868D),
                    fontSize = 25.sp,
                    fontWeight = FontWeight(800),
                    modifier = Modifier.align(Alignment.Bottom)
                )
            }
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Row(
                    modifier = Modifier
                ) {
                    Text(
                        text = "Phone Number",
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
                OutlinedTextField(
                    value = phoneNumber,
                    onValueChange = {phoneNumber = it},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .padding(top = 2.dp)
                        .clickable { showLabel = false }
                        .border(
                            width = 2.dp,
                            color = Color(0xFF14868D),
                            shape = RoundedCornerShape(5.dp)
                        ),
                    label = {
                            Text(
                                text = if (phoneNumber.isEmpty())"Please enter your phone number" else "",
                                color = Color(0xFF9D9D9D),
                                modifier = Modifier.offset(x = 0.dp, y = (-4).dp)
                            )
                    },

                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color.Transparent,
                        focusedBorderColor = Color.Transparent
                    )
                )
                Spacer(modifier = Modifier.height(20.dp))
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
                        value = password,
                        onValueChange = { password = it},
                        label = {
                            Text(
                                text = if (password.isEmpty()) "Please enter your password" else "",
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
                Text(text = "Forgot Password?",
                    color = Color(0xFF14868D),
                    fontSize = 15.sp,
                    fontWeight = FontWeight(600),
                    modifier = Modifier
                        .padding(top = 10.dp, bottom = 15.dp)
                        .align(Alignment.End)
                        .clickable { }
                )
                Box(
                    modifier = Modifier
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
                            text = "Login",
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
                Row(
                    modifier = Modifier
                        .padding(20.dp)
                        .align(Alignment.CenterHorizontally)
                ) {
                    Text(text = "New to the app?")
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "Create account",
                        textDecoration = TextDecoration.Underline,
                        color = Color(0xFF129193)
                    )
                }
                LoginChecking(false)
            }
        }
        Image(
            painter = painterResource(id = R.drawable.elephant_color),
            contentDescription = "coloured elephant",
            modifier = Modifier
                .scale(1.2f)
                .offset(x = 20.dp, y = 573.dp)

        )

    }

}

@Composable
fun LoginChecking(check: Boolean) {
    if (check){
        Box(modifier = Modifier
            .padding(top = 10.dp)
            .fillMaxWidth()
            .background(
                color = Color(0xFF25A455),
                shape = RoundedCornerShape(10.dp)
            )){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center

            ){
                Image(painter = painterResource(id = R.drawable.successful),
                    contentDescription = "success",
                    modifier = Modifier.scale(1.2f)
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = "Login Successful",
                    color = Color(0xFFFFFFFF))
            }
        }
    }else{
        Box(modifier = Modifier
            .padding(top = 10.dp)
            .fillMaxWidth()
            .background(
                color = Color(0xFFEF6464),
                shape = RoundedCornerShape(10.dp)
            )){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center

            ){
                Image(painter = painterResource(id = R.drawable.login_failed),
                    contentDescription = "failed",
                    modifier = Modifier.scale(1.2f)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Login Failed",
                    color = Color(0xFFFFFFFF))
            }
        }
    }
}


