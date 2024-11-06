package com.teacherapplication.teacherapplication.ui.login.otp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.teacherapplication.teacherapplication.R
import com.teacherapplication.teacherapplication.ui.AppComponents.LoginScreenButton



//@Preview
@Composable
fun OTPScreen( modifier: Modifier = Modifier, navController: NavController)
{
    var otpValues = remember { List(4) { mutableStateOf("") } }
    var gradientBrush = if (otpValues[3].value.isNotEmpty())
        Brush.linearGradient(
            colors = listOf(Color(0xFF185573), Color(0xFF14868D)),
            start = Offset(0f, 0f),
            end = Offset(Float.POSITIVE_INFINITY, 0f)
        )
    else {
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
                .padding(start = 10.dp, top = 40.dp, end = 10.dp))
        {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "back",
                    )
                }
                Spacer(modifier = Modifier.width(60.dp))
                Text(
                    text = "OTP Verification",
                    style = MaterialTheme.typography.titleSmall.copy(
                        brush = Brush.linearGradient(
                            colors = listOf(Color(0xFF185573), Color(0xFF14868D)),
                            start = Offset(0f, 0f),
                            end = Offset(Float.POSITIVE_INFINITY, 0f)
                        ),
                    ),
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(top = 10.dp)
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                Text(text = "A 4 digit code has been sent to",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(0xFF333333)
                )
                Text(text = " + 9890000012",
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontWeight = FontWeight(700)
                    ),
                )

                Spacer(modifier = Modifier.height(30.dp))
                otpValues = OTPVerify(otpValues)

                Row(
                    modifier = Modifier.padding(20.dp)
                ){
                    Text(text = "Don’t receive the code ?",
                        color = Color(0xFF333333),
                        style = MaterialTheme.typography.bodySmall
                    )
                    Spacer(modifier = Modifier.width(2.dp))
                    Text(
                        text = "RESEND",
                        style = MaterialTheme.typography.bodySmall.copy(
                            fontWeight = FontWeight(600)
                        ),
                        textDecoration = TextDecoration.Underline,
                        color = Color(0xFF129193)
                    )
                }
                Spacer(modifier = Modifier.height(70.dp))
                LoginScreenButton(text = "Verify", gradientBrush = gradientBrush)
                {
                    navController.navigate(route = "password")
                }
            }

        }
        Image(
            painter = painterResource(id = R.drawable.elephant_color),
            contentDescription = "coloured elephant",
            modifier = Modifier
                .align(Alignment.BottomStart)

        )
    }
}

@Composable
fun OTPVerify(otpValues: List<MutableState<String>>): List<MutableState<String>> {
    var focusManager = LocalFocusManager.current
    var focusRequesters = List(4) { FocusRequester()}

    LaunchedEffect(Unit) {
        focusRequesters[0].requestFocus()
    }

    Row(
        horizontalArrangement = Arrangement.spacedBy(25.dp)
    ) {
        otpValues.forEachIndexed { index, otpDigit ->
            var isFocused by remember { mutableStateOf(false) }

            OutlinedTextField(
                value = otpDigit.value,
                onValueChange = { newValue ->
                    if (newValue.length <= 1 && newValue.all { it.isDigit() }) {
                        otpDigit.value = newValue
                        if (newValue.isNotEmpty()) {
                            // Move focus to next field or clear focus after the last field
                            if (index < 3) focusRequesters[index + 1].requestFocus()
                            else {
                                focusManager.clearFocus()
                            }
                        }
                    }
                },
                modifier = Modifier
                    .clip(CircleShape)
                    .size(60.dp)
                    .focusRequester(focusRequesters[index])
                    .onFocusChanged { focusState ->
                        isFocused = focusState.isFocused
                    }
                    .border(width = 1.dp, color = if (isFocused) Color(0xFF129193) else Color(0xFFE4E4E4))
                    .background( if (otpValues[index].value.isNotEmpty() || isFocused) Color(0xFF129193) else Color(0xFFE4E4E4)),
                textStyle = MaterialTheme.typography.titleSmall.copy(
                    fontWeight = FontWeight(800),
                    textAlign = TextAlign.Center,
                    color = Color(0xFFFFFFFF),
                ),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = OutlinedTextFieldDefaults.colors(
                    cursorColor = Color.White
                )
            )
        }
    }
    return otpValues
}