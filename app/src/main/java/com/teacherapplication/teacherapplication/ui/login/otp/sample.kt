package com.teacherapplication.teacherapplication.ui.login.otp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.tooling.preview.Preview


@Preview(showBackground = true)
@Composable
fun OtpScreen() {
    var otpValues = remember { List(6) { mutableStateOf("") } }
    val focusManager = LocalFocusManager.current
    val focusRequesters = List(6) { FocusRequester() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Enter OTP", fontSize = 20.sp, color = Color.Black)

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            otpValues.forEachIndexed { index, otpDigit ->
                OutlinedTextField(
                    value = otpDigit.value,
                    onValueChange = { newValue ->
                        if (newValue.length <= 1 && newValue.all { it.isDigit() }) {
                            otpDigit.value = newValue
                            if (newValue.isNotEmpty()) {
                                // Move focus to next field or clear focus after the last field
                                if (index < 5) focusRequesters[index + 1].requestFocus()
                                else focusManager.clearFocus()
                            }
                        }
                    },
                    modifier = Modifier
                        .width(50.dp)
                        .clip(CircleShape)
                        .background(Color.LightGray)
                        .focusRequester(focusRequesters[index]),
                    textStyle = LocalTextStyle.current.copy(fontSize = 24.sp),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    visualTransformation = VisualTransformation.None
                )
            }
        }
    }
}

