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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teacherapplication.teacherapplication.R
import com.teacherapplication.teacherapplication.ui.AppComponents.LoginScreenButton
import com.teacherapplication.teacherapplication.ui.AppComponents.LoginScreenTextField


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
        .background(color = Color(0xFFFFFFFF))
    ){
        Column(
            modifier = Modifier
                .padding(start = 10.dp, top = 40.dp, end = 10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "back",
                    )
                }
                Spacer(modifier = Modifier.width(80.dp))
                Text(
                    text = "Enter Details",
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
            Text(text = "Create a account by filling in info below.",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .padding(start = 67.dp),
                color = Color(0xFF333333)
            )
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Row(
                    modifier = Modifier
                ) {
                    Text(
                        text = "First Name",
                        style = MaterialTheme.typography.bodySmall.copy(
                            fontWeight = FontWeight(600)
                        ),
                    )
                    Spacer(modifier = Modifier.width(2.dp))
                    Text(
                        text = "*",
                        color = Color(0xFFEF6464),
                    )
                }
                LoginScreenTextField(text = firstName, labelText = "Enter your first name") {
                    firstName = it
                }
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier
                ) {
                    Text(
                        text = "Last Name",
                        style = MaterialTheme.typography.bodySmall.copy(
                            fontWeight = FontWeight(600)
                        ),
                    )
                    Spacer(modifier = Modifier.width(2.dp))
                    Text(
                        text = "*",
                        color = Color(0xFFEF6464),
                    )
                }
                LoginScreenTextField(text = lastName, labelText = "Enter your last name") {
                    lastName = it
                }
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier
                ) {
                    Text(
                        text = "Gender",
                        style = MaterialTheme.typography.bodySmall.copy(
                            fontWeight = FontWeight(600)
                        ),
                    )
                    Spacer(modifier = Modifier.width(2.dp))
                    Text(
                        text = "*",
                        color = Color(0xFFEF6464),
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
                        Image(painter = painterResource(
                            id = if (gender) R.drawable.male_bw_img else R.drawable.male_color_img
                        ),
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
                        Image(painter = painterResource(
                            id = if (gender) R.drawable.female_color_img else R.drawable.female_bw_img
                        ),
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
                Text(
                    text = "School Name",
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontWeight = FontWeight(600)
                    ),
                )
                OutlinedTextField(
                    value = "1313-Exela pvt.school",
                    onValueChange = {  },
                    readOnly = true,
                    textStyle = MaterialTheme.typography.bodySmall.copy(
                        fontWeight = FontWeight(700),
                        color = Color(0xFF1D1751)
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
                )
            }

        }
        Box(
            modifier = Modifier.fillMaxSize()
                .padding(20.dp),
            contentAlignment = Alignment.BottomCenter
        ){
            LoginScreenButton(text = "Save & Select Classes", gradientBrush = gradientBrush) {

            }
        }

        Image(
            painter = painterResource(id = R.drawable.elephant_light),
            contentDescription = "coloured elephant",
            modifier = Modifier
                .align(Alignment.BottomStart)

        )


    }

}



