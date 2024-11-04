package com.teacherapplication.teacherapplication.ui.login.account

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
import androidx.compose.foundation.layout.size
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
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.LinearGradient
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teacherapplication.teacherapplication.R


@Preview(showBackground = true)
@Composable
fun PersonDetails(modifier: Modifier = Modifier){

    var firstName by remember {
        mutableStateOf("")
    }
    var lastName by remember {
        mutableStateOf("")
    }

    val gradientBrush = if (firstName.isNotEmpty() && lastName.isNotEmpty()){
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
    var gender by remember {
        mutableStateOf(false)
    }

    var showLabel by remember { mutableStateOf(true) }

    Box(modifier = Modifier
        .fillMaxSize()
        //.padding(top = 50.dp)
        .background(color = Color(0xFFFFFFFF))
    ){
        Column(
            modifier = Modifier
                .padding(start = 10.dp, top = 30.dp, end = 10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(80.dp)
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "back",
                        modifier = Modifier.scale(1.2f)
                    )
                }

                Text(
                    text = "Enter Details",
                    color = Color(0xFF14868D),
                    fontSize = 22.sp,
                    fontWeight = FontWeight(800),
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
            Text(text = "Create a account by filling in info below.",
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center)
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Row(
                    modifier = Modifier
                ) {
                    Text(
                        text = "First Name",
                        fontWeight = FontWeight.Medium,
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
                    value = firstName,
                    onValueChange = { firstName = it },
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
                            text = if (firstName.isEmpty()) "Enter your first name" else "",
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
                        text = "Last Name",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium
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
                    value = lastName,
                    onValueChange = { lastName = it },
                    label = {
                        Text(
                            text = if (lastName.isEmpty()) "Enter your last name" else "",
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
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier
                ) {
                    Text(
                        text = "Gender",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium
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
                Box(
                    modifier = Modifier.fillMaxWidth()
                ){
                    OutlinedTextField(
                        value = if (gender) "Female" else "Male",
                        onValueChange = {  },
                        readOnly = true,
                        textStyle = TextStyle(
                            fontWeight = FontWeight.Medium,
                            fontSize = 15.sp
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(58.dp)
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
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.CenterEnd)
                            .offset(x = 125.dp)

                    ){
                        Image(painter = painterResource(id = R.drawable.male_img),
                            contentDescription = "male",
                            modifier = Modifier
                                .padding(end = 0.dp)
                                .scale(1.2f)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Switch(
                            checked = gender,
                            onCheckedChange = { gender = it },
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = Color.White,
                                uncheckedThumbColor = Color.White,
                                checkedTrackColor = Color(0xFFFF499C),
                                uncheckedTrackColor = Color(0xFF4DB4F8)
                            ),
                            modifier = Modifier
                                .scale(0.8f)
                        )
                        Spacer(modifier = Modifier.width(7.dp))
                        Image(painter = painterResource(id = R.drawable.female_img),
                            contentDescription = "female",
                            modifier = Modifier
                                .padding(end = 35.dp)
                                .scale(1.2f)
                                .clickable {
                                    gender = !gender
                                }
                        )
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "School Name",
                    fontWeight = FontWeight.Medium)
                OutlinedTextField(
                    value = "Name of the School",
                    onValueChange = {  },
                    readOnly = true,
                    textStyle = TextStyle(
                        fontWeight = FontWeight.Medium
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .padding(top = 2.dp)
                        .background(
                            brush = Brush.linearGradient(
                                colors = listOf(
                                    Color(0xFF185573).copy(alpha = 0.1f),
                                    Color(0xFF14868D).copy(alpha = 0.1f)
                                ),
                                start = Offset(0f, 0f),
                                end = Offset(Float.POSITIVE_INFINITY, 0f)
                            )
                        )
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
                Spacer(modifier = Modifier.height(270.dp))
                BottomButton(gradientBrush = gradientBrush)

            }

        }
        Image(
            painter = painterResource(id = R.drawable.elephant_light),
            contentDescription = "coloured elephant",
            modifier = Modifier
                .scale(1.2f)
                .offset(x = 0.dp, y = 570.dp)

        )


    }

}

@Composable
fun BottomButton(gradientBrush: Brush){
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
                text = "Save & Select Classes",
                fontSize = 18.sp,
                fontWeight = FontWeight(700)
            )
        }
        Image(
            painter = painterResource(id = R.drawable.elephant_button),
            contentDescription = "elephant background",
            modifier = Modifier
                .scale(1.3f)
                .offset(x = 20.dp, y = 7.dp)
        )
    }
}




