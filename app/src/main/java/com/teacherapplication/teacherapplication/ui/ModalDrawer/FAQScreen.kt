package com.teacherapplication.teacherapplication.ui.ModalDrawer

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.teacherapplication.teacherapplication.R
import com.teacherapplication.teacherapplication.ui.AppComponents.BackArrow
import com.teacherapplication.teacherapplication.ui.AppComponents.brush

@Composable
fun FAQScreen(navController: NavHostController) {
    val searchValue = remember { mutableStateOf("") }
    val questionsList = listOf(
        "How do I create an account?",
        "How do I update my profile information?",
        "How can I track student performance?",
        "How do I create and assign homework?",
        "How is my data protected?",
        "Can I delete my account?",
        "What tools are available for class communication?",
        "How can I contact customer support?"
    )
    val answersList = listOf(
        "To create an account, download the app, open it, and follow the registration prompts. You'll need to provide your email, create a password, and verify your email address.",
        "","","","","","","",""
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 15.dp, top = 40.dp, end = 15.dp)
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            BackArrow(onClick = { navController.popBackStack() })
            Text(
                text = "FAQ",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontSize = 20.sp,
                    lineHeight = 28.9.sp,
                    color = Color.Black
                ),
                modifier = Modifier
                    .fillMaxWidth(0.95f),
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        SearchFieldFunction(searchValue)
        Spacer(modifier = Modifier.height(30.dp))
        questionsList.forEachIndexed { index,question ->
            QuestionsArrangement(question, answer = answersList[index])
            Spacer(modifier = Modifier.height(20.dp))
            if (index < questionsList.lastIndex){
                HorizontalDivider(
                    thickness = 0.5.dp,
                    color = Color.Black.copy(alpha = 0.3f)
                )
                Spacer(modifier = Modifier.height(15.dp))
            }
        }

    }
}

@Composable
private fun QuestionsArrangement(question: String, answer: String = "") {
    val isQuestionClicked = remember { mutableStateOf(false) }
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = question,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.fillMaxWidth(0.9f)
        )
        Box(
            modifier = Modifier
                .size(35.dp)
                .border(
                    width = 1.dp,
                    color = Color(0xFF129193),
                    shape = CircleShape
                )
                .clickable {
                    isQuestionClicked.value = !isQuestionClicked.value
                },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource( if (isQuestionClicked.value) R.drawable.up_faq else R.drawable.down_faq),
                contentDescription = "down",
                tint = Color(0xFF129193),
                modifier = Modifier.size(18.62.dp)
            )
        }
    }
    if (isQuestionClicked.value){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 4.dp, end = 50.dp)
        ){
            Text(
                text = answer,
                style = MaterialTheme.typography.labelMedium,
                color = Color.Black.copy(alpha = 0.8f)
            )
        }
    }
}

@Composable
private fun SearchFieldFunction(searchValue: MutableState<String>) {
    Box(
        modifier = Modifier
            .height(48.dp)
            .width(386.dp)
            .background(
                color = Color(0xFFF3F9FA),
                shape = RoundedCornerShape(8.dp)
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.search),
                contentDescription = "search",
                modifier = Modifier
                    .size(15.dp)
            )
            TextField(
                value = searchValue.value,
                onValueChange = { searchValue.value = it },
                modifier = Modifier.fillMaxSize(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                ),
                placeholder = {
                    Text(
                        text = "Search your FAQ",
                        style = MaterialTheme.typography.labelMedium.copy(
                            brush = brush,
                            lineHeight = 11.2.sp
                        )
                    )
                },
                textStyle = MaterialTheme.typography.labelMedium
            )
        }
    }
}