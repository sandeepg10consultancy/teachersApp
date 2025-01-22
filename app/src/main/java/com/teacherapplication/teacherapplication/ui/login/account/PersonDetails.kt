package com.teacherapplication.teacherapplication.ui.login.account

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.teacherapplication.teacherapplication.R
import com.teacherapplication.teacherapplication.ui.AppComponents.BackArrow
import com.teacherapplication.teacherapplication.ui.AppComponents.LoginScreenButton
import com.teacherapplication.teacherapplication.ui.AppComponents.LoginScreenTextField
import com.teacherapplication.teacherapplication.ui.AppComponents.brush


//@Preview(showBackground = true)
@Composable
fun PersonDetails(modifier: Modifier = Modifier, navController: NavHostController){

    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var genderChecked by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()

    val genderValue = if (genderChecked) "Female" else "Male"

    var showLabel by remember { mutableStateOf(true) }

    Box(modifier = Modifier
        .fillMaxSize()
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 15.dp, top = 40.dp, end = 15.dp)
                .verticalScroll(scrollState)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                BackArrow(onClick = { navController.popBackStack() })
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
                    modifier = Modifier
                        .fillMaxWidth(0.95f)
                        .padding(top = 1.dp),
                    textAlign = TextAlign.Center
                )
            }
            Text(text = "Create a account by filling in info below.",
                style = MaterialTheme.typography.bodySmall,
                color = Color(0xFF333333),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.height(30.dp))
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
            OutlinedTextField(
                value = genderValue,
                onValueChange = { },
                textStyle = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight(600),
                    color = Color.Black,
                ),
                modifier = Modifier
                    .height(52.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(6.dp))
                    .border(
                        width = 2.dp,
                        brush = brush,
                        shape = RoundedCornerShape(6.dp)
                    ),
                readOnly = true,
                trailingIcon = {
                    Row(
                        modifier = Modifier.padding(end = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(20.dp)
                    ){
                        Icon(
                            painter = painterResource(R.drawable.male_color_img),
                            contentDescription = "Male",
                            tint = if (genderChecked) Color.Black.copy(alpha = 0.3f) else Color(0xFF4DB4F8),
                            modifier = Modifier
                                .size(18.86.dp)
                        )
                        Switch(
                            checked = genderChecked,
                            onCheckedChange = {
                                genderChecked = !genderChecked
                            },
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = Color.White,
                                uncheckedThumbColor = Color.White,
                                checkedTrackColor = Color(0xFFFF499C),
                                uncheckedTrackColor = Color(0xFF4DB4F8),
                                uncheckedBorderColor = Color(0xFF4DB4F8),
                            ),
                            modifier = Modifier
                                .height(18.86.dp)
                                .width(39.43.dp)
                                .border(
                                    width = 1.71.dp,
                                    color = Color.Transparent,
                                    shape = RoundedCornerShape(85.71.dp)
                                )
                        )
                        Icon(
                            painter = painterResource(R.drawable.female_color_img),
                            contentDescription = "Female",
                            tint = if (genderChecked) Color(0xFFFF499C) else Color.Black.copy(alpha = 0.3f),
                            modifier = Modifier
                                .size(18.86.dp)
                        )
                    }
                }
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "School Name",
                style = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight(600)
                ),
            )
            Spacer(modifier = Modifier.height(2.dp))
            OutlinedTextField(
                value = "1313-Exela pvt.school",
                onValueChange = {  },
                modifier = Modifier
                    .height(52.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(6.dp))
                    .background(
                        color = Color(0xFF129193).copy(alpha = 0.05f)
                    )
                    .border(
                        width = 2.dp,
                        brush = brush,
                        shape = RoundedCornerShape(5.dp)
                    ),
                readOnly = true,
                textStyle = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight(700),
                    color = Color(0xFF1D1751)
                ),
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 15.dp, vertical = 50.dp),
            contentAlignment = Alignment.BottomCenter
        ){
            LoginScreenButton(text = "Save & Select Classes", enabled = firstName.isNotEmpty() && lastName.isNotEmpty()) {
                navController.navigate(route = "class")
            }
        }

        Image(
            painter = painterResource(id = R.drawable.elephant_light),
            contentDescription = "coloured elephant",
            modifier = Modifier
                .height(276.95.dp)
                .width(296.41.dp)
                .align(Alignment.BottomStart)

        )


    }

}



