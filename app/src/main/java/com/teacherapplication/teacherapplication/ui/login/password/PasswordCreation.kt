package com.teacherapplication.teacherapplication.ui.login.password

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.teacherapplication.teacherapplication.R
import com.teacherapplication.teacherapplication.ui.AppComponents.BackArrow
import com.teacherapplication.teacherapplication.ui.AppComponents.LoginScreenButton
import com.teacherapplication.teacherapplication.ui.AppComponents.PasswordField

//@Preview
@Composable
fun SetPassword(modifier: Modifier = Modifier, navController: NavHostController){

    var password by remember {
        mutableStateOf("")
    }
    var rePassword by remember {
        mutableStateOf("")
    }
    val gradientBrush = if ((password == rePassword) && (password.length >=6))
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
        .fillMaxSize())
    {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 15.dp, top = 40.dp, end = 15.dp))
        {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                BackArrow(onClick = { navController.popBackStack() })
                Text(
                    text = "Set Your Password",
                    style = MaterialTheme.typography.titleSmall.copy(
                        brush = Brush.linearGradient(
                            colors = listOf(Color(0xFF185573), Color(0xFF14868D)),
                            start = Offset(0f, 0f),
                            end = Offset(Float.POSITIVE_INFINITY, 0f)
                        ),
                    ),
                    fontSize = 25.sp,
                    modifier = Modifier
                        .fillMaxWidth(0.95f)
                        .padding(top = 1.dp),
                    textAlign = TextAlign.Center
                )
            }
            Text(text = "Your password needs to be at least 6\n characters.",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = Color(0xFF333333)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier
            ) {
                Text(
                    text = "Enter Password",
                    style = MaterialTheme.typography.bodySmall,
                )
                Spacer(modifier = Modifier.width(2.dp))
                Text(
                    text = "*",
                    color = Color(0xFFEF6464),
                )
            }
            PasswordField(password = password, labelText = "Enter your password"){
                password = it
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier
            ) {
                Text(
                    text = "Re-Enter Password",
                    style = MaterialTheme.typography.bodySmall,
                )
                Spacer(modifier = Modifier.width(2.dp))
                Text(
                    text = "*",
                    color = Color(0xFFEF6464),
                )
            }
            PasswordField(password = rePassword, labelText = "Re-Enter your password"){
                rePassword = it
            }
            Spacer(modifier = Modifier.height(50.dp))

            LoginScreenButton(text = "Save & Next", gradientBrush = gradientBrush){
                navController.navigate(route = "personDetails")
            }
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