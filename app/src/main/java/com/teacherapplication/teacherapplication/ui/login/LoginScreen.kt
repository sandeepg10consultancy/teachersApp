package com.teacherapplication.teacherapplication.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.teacherapplication.teacherapplication.R
import com.teacherapplication.teacherapplication.ui.AppComponents.BackArrow
import com.teacherapplication.teacherapplication.ui.AppComponents.LoginScreenButton
import com.teacherapplication.teacherapplication.ui.AppComponents.LoginScreenTextField
import com.teacherapplication.teacherapplication.ui.AppComponents.PasswordField
import com.teacherapplication.teacherapplication.ui.AppComponents.brush


//@Preview(showBackground = true)
@Composable
fun LoginScreen(modifier: Modifier = Modifier, navController: NavHostController
) {
    val phoneNumbersList = listOf("")
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

    Box(modifier = Modifier
        .fillMaxSize()
    ){
        Column(
            modifier = Modifier
                .padding(start = 15.dp, top = 40.dp, end = 15.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                BackArrow(onClick = {navController.popBackStack()})
                Text(
                    text = "Log In",
                    style = MaterialTheme.typography.titleSmall.copy(
                        brush = brush,
                    ),
                    modifier = Modifier
                        .fillMaxWidth(0.95f),
                    textAlign = TextAlign.Center
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                modifier = Modifier
            ) {
                Text(
                    text = "Phone Number",
                    style = MaterialTheme.typography.bodySmall,
                    //color = if (phoneNumber !in phoneNumbersList) Color(0xFFEF6464) else Color.Black
                )
                Spacer(modifier = Modifier.width(2.dp))
                Text(
                    text = "*",
                    color = Color(0xFFEF6464),
                )
            }
            LoginScreenTextField(text = phoneNumber, labelText = "Please enter your phone Number") { phoneNumber = it}
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier
            ) {
                Text(
                    text = "Password",
                    style = MaterialTheme.typography.bodySmall,
                )
                Spacer(modifier = Modifier.width(2.dp))
                Text(
                    text = "*",
                    color = Color(0xFFEF6464),
                )
            }

            PasswordField(password = password, labelText = "Please enter your password"){password = it}

            Text(text = "Forgot Password?",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 14.sp,
                    lineHeight = 36.sp
                ),
                color = Color(0xFF129193),
                modifier = Modifier
                    .padding(top = 10.dp, bottom = 15.dp)
                    .align(Alignment.End)
                    .clickable { }
            )
            LoginScreenButton(text = "Login", enabled = phoneNumber.length >= 10) {
                navController.navigate(route = "dashboard")
            }
            Row(
                modifier = Modifier
                    .padding(20.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(text = "New to the app?",
                    style = MaterialTheme.typography.bodySmall)
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = "Create account",
                    textDecoration = TextDecoration.Underline,
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontWeight = FontWeight(600)
                    ),
                    color = Color(0xFF129193),
                    modifier = Modifier.clickable {
                        navController.navigate(route = "register")
                    }
                )
            }
            LoginChecking(true)
        }
        Image(
            painter = painterResource(id = R.drawable.elephant_color),
            contentDescription = "coloured elephant",
            modifier = Modifier
                .height(276.95.dp)
                .width(296.41.dp)
                .align(Alignment.BottomStart)

        )

    }

}

@Composable
fun LoginChecking(check: Boolean) {
    if (!check){
        Box(modifier = Modifier
            .height(70.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(
                color = Color(0xFF25A455),
                shape = RoundedCornerShape(10.dp)
            )){
            Row(
                modifier = Modifier
                    .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center

            ){
                Image(painter = painterResource(id = R.drawable.successful),
                    contentDescription = "success",
                    modifier = Modifier
                        .size(24.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "Login Successful",
                    color = Color.White,
                    style = MaterialTheme.typography.labelSmall
                    )
            }
        }
    }else{
        Box(modifier = Modifier
            .height(60.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(
                color = Color(0xFFEF6464),
                shape = RoundedCornerShape(10.dp)
            )){
            Row(
                modifier = Modifier
                    .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center

            ){
                Image(painter = painterResource(id = R.drawable.login_failed),
                    contentDescription = "failed",
                    modifier = Modifier
                        .height(21.33.dp)
                        .width(24.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "Login Failed",
                    color = Color.White,
                    style = MaterialTheme.typography.labelSmall
                )
            }
        }
    }
}


