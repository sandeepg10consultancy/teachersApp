package com.teacherapplication.teacherapplication.ui.home


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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teacherapplication.teacherapplication.R


@Preview(showBackground = true)
@Composable
fun RegisterScreen(modifier: Modifier = Modifier){

    var schoolCode by remember {
        mutableStateOf("")
    }
    var phoneNumber by remember {
        mutableStateOf("")
    }
    val gradientBrush = if (phoneNumber.length >= 10){
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

    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xFFFFFFFF))
    ){
        Column(
            modifier = Modifier
                .padding(start = 10.dp, top = 30.dp, end = 10.dp)
        ) {
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
                    text = "Create Account",
                    color = Color(0xFF14868D),
                    fontSize = 25.sp,
                    fontWeight = FontWeight(800),
                    modifier = Modifier
                        .align(Alignment.Bottom)
                        .padding(end = 10.dp)
                )
            }
            Text(text = "Create a account by filling in info below.",
                modifier = Modifier
                    .height(20.dp)
                    .padding(start = 60.dp, end = 60.dp, top = 5.dp),
                color = Color(0xFF333333)
            )
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Row(
                    modifier = Modifier
                ) {
                    Text(
                        text = "School Code",
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
                    value = schoolCode,
                    onValueChange = {schoolCode = it},
                    label = {
                        Text(
                            text = if (schoolCode.isEmpty())"Enter School Code" else "",
                            color = Color(0xFF9D9D9D),
                            modifier = Modifier.offset(x = 0.dp, y = (-4).dp)
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
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
                if (schoolCode.isEmpty()){
                    SchoolName()
                }
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier
                ) {
                    Text(
                        text = "Phone Number",
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
                    value = phoneNumber,
                    onValueChange = { phoneNumber = it},
                    label = {
                        Text(
                            text = if (phoneNumber.isEmpty()) "Enter your phone number" else "",
                            color = Color(0xFF9D9D9D),
                            modifier = Modifier.offset(x = 0.dp, y = (-4).dp)
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
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
                Spacer(modifier = Modifier.height(70.dp))
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
                            text = "Get OTP",
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
                Row(
                    modifier = Modifier
                        .padding(20.dp)
                        .align(Alignment.CenterHorizontally)
                ) {
                    Text(text = "Already have an account?")
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "Log in",
                        textDecoration = TextDecoration.Underline,
                        color = Color(0xFF129193)
                    )
                }
            }
        }
        Image(
            painter = painterResource(id = R.drawable.elephant_color),
            contentDescription = "coloured elephant",
            modifier = Modifier
                .scale(1.2f)
//                .align(Alignment.BottomStart)
                .offset(x = 20.dp, y = 573.dp)

        )

    }

}

@Composable
fun SchoolName(name: String = ""){
    Spacer(modifier = Modifier.height(20.dp))
    Text(
        text = "School Name",
        fontSize = 15.sp,
    )
    OutlinedTextField(
        value = name,
        onValueChange = {},
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
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
}
