package com.teacherapplication.teacherapplication.ui.login.otp

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview(showBackground = true)
@Composable
fun OTPInputScreen() {
    val otpDigits = List(4) { remember { mutableStateOf("") } }
    val focusRequesters = List(4) { FocusRequester() }
    val focusManager = LocalFocusManager.current

    // Track the focus state for each field to apply color
    val focusStates = List(4) { remember { mutableStateOf(false) } }

    val isOtpComplete = otpDigits.all { it.value.isNotEmpty() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            otpDigits.forEachIndexed { index, otpDigit ->
                OutlinedTextField(
                    value = otpDigit.value,
                    onValueChange = { newValue ->
                        if (newValue.length <= 1 && newValue.all { it.isDigit() }) {
                            otpDigit.value = newValue
                            if (newValue.isNotEmpty()) {
                                if (index < otpDigits.size - 1) {
                                    focusRequesters[index + 1].requestFocus()
                                } else {
                                    focusManager.clearFocus()
                                }
                            }
                        }
                    },
                    enabled = true,
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .border(
                            width = 1.dp,
                            color = if (focusStates[index].value) Color.Blue else Color(0xFFE4E4E4),
                            shape = CircleShape
                        )
                        .background(Color(0xFFE4E4E4))
                        .focusRequester(focusRequesters[index])
                        .onFocusChanged { focusStates[index].value = it.isFocused },
                    textStyle = LocalTextStyle.current.copy(fontSize = 24.sp),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { /* Handle OTP submission */ },
            enabled = isOtpComplete,
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isOtpComplete) Color.Green else Color.Gray
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .padding(horizontal = 32.dp)
        ) {
            Text("Submit OTP")
        }
    }
}
