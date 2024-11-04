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
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
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
import com.teacherapplication.teacherapplication.R


var gradientBrush =
    Brush.linearGradient(
        colors = listOf(
            Color(0x66129193).copy(alpha = 0.4f),
            Color(0x66185472).copy(alpha = 0.4f)
        ),
        start = Offset.Infinite.copy(x = 1f),
        end = Offset.Zero
    )

@Preview
@Composable
fun OTPScreen( modifier: Modifier = Modifier)
{

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
                horizontalArrangement = Arrangement.spacedBy(50.dp)
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "back",
                        modifier = Modifier.scale(1.2f)
                    )
                }
                Text(
                    text = "OTP Verification",
                    color = Color(0xFF14868D),
                    fontSize = 25.sp,
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
                Text(text = "A 4 digit code has been sent to",
                    fontWeight = FontWeight(400),
                    textAlign = TextAlign.Center,
                    color = Color(0xFF333333)
                )
                Text(text = " + 9890000012",
                    fontWeight = FontWeight(700)
                )

                Spacer(modifier = Modifier.height(30.dp))
                OTPVerify()

                Row(
                    modifier = Modifier.padding(20.dp)
                ){
                    Text(text = "Don’t receive the code ?",
                        fontWeight = FontWeight(400),
                        color = Color(0xFF333333)
                    )
                    Spacer(modifier = Modifier.width(2.dp))
                    Text(
                        text = "RESEND",
                        fontWeight = FontWeight(600),
                        textDecoration = TextDecoration.Underline,
                        color = Color(0xFF129193)
                    )
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
                            text = "Verify",
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


            Image(
                painter = painterResource(id = R.drawable.elephant_color),
                contentDescription = "coloured elephant",
                modifier = Modifier
                    .scale(1.2f)
                    .offset(x = 0.dp, y = 220.dp)

            )


        }
    }
}

@Composable
fun OTPVerify(){
    var otpValues = remember { List(4) { mutableStateOf("") } }
    var focusManager = LocalFocusManager.current
    var focusRequesters = List(4) { FocusRequester()}

    val isOtpComplete = otpValues.all { it.value.isNotEmpty() }

    Row(
        horizontalArrangement = Arrangement.spacedBy(25.dp)
    ) {
        otpValues.forEachIndexed { index, otpDigit ->
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
                    .size(60.dp)
                    .clip(CircleShape)
                    .border(width = 1.dp, color = Color(0xFFE4E4E4))
                    .background( if (otpValues[index].value.isNotEmpty()) Color(0xFF129193) else Color(0xFFE4E4E4))
                    .focusRequester(focusRequesters[index]),
                textStyle = LocalTextStyle.current.copy(fontSize = 24.sp, color = Color(0xFFFFFFFF)),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                visualTransformation = VisualTransformation.None
            )
            if (isOtpComplete) {
                gradientBrush =
                    Brush.linearGradient(
                        colors = listOf(
                            Color(0x66129193),
                            Color(0x66185472),
                        )
                    )
            }
        }
    }
}