package com.teacherapplication.teacherapplication.ui.Diary

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ChatAppUI() {
    val messages = remember { mutableStateListOf("Hello!", "How are you?", "I'm good, thanks!") }
    var currentMessage by remember { mutableStateOf(TextFieldValue()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF2F2F2))
    ) {
        // Messages List
        MessagesList(
            messages = messages,
            modifier = Modifier
                .weight(1f)
                .padding(8.dp)
        )

        // Input Box
        MessageInputBox(
            currentMessage = currentMessage,
            onMessageChange = { currentMessage = it },
            onSendMessage = {
                if (currentMessage.text.isNotBlank()) {
                    messages.add(currentMessage.text)
                    currentMessage = TextFieldValue("")
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
    }
}

@Composable
fun MessagesList(messages: List<String>, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        messages.forEach { message ->
            MessageBubble(message = message)
        }
    }
}

@Composable
fun MessageBubble(message: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
    ) {
        Text(
            text = message,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .background(
                    color = Color(0xFFCCE4FF),
                    shape = MaterialTheme.shapes.medium
                )
                .padding(12.dp),
            fontSize = 16.sp,
            textAlign = TextAlign.Start
        )
    }
}

@Composable
fun MessageInputBox(
    currentMessage: TextFieldValue,
    onMessageChange: (TextFieldValue) -> Unit,
    onSendMessage: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        BasicTextField(
            value = currentMessage,
            onValueChange = onMessageChange,
            modifier = Modifier
                .weight(1f)
                .background(Color.White, CircleShape)
                .padding(12.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Button(
            onClick = onSendMessage,
            modifier = Modifier
                .size(48.dp)
                .background(Color(0xFF007AFF), CircleShape)
        ) {
            Text(text = "Send", color = Color.White, fontSize = 14.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChatAppUIPreview() {
    ChatAppUI()
}
