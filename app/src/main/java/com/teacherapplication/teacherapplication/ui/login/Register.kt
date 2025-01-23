package com.teacherapplication.teacherapplication.ui.login


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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.teacherapplication.teacherapplication.R
import com.teacherapplication.teacherapplication.ui.AppComponents.BackArrow
import com.teacherapplication.teacherapplication.ui.AppComponents.LoginScreenButton
import com.teacherapplication.teacherapplication.ui.AppComponents.LoginScreenTextField
import com.teacherapplication.teacherapplication.ui.utills.exelaGradient


@Composable
fun RegisterScreen(modifier: Modifier = Modifier, navController: NavHostController){

    var schoolCode by remember {
        mutableStateOf("")
    }
    var phoneNumber by remember {
        mutableStateOf("")
    }
    val scrollState = rememberScrollState()

    Box(modifier = Modifier
        .fillMaxSize()
    ){
        Column(
            modifier = Modifier
                .padding(start = 15.dp, top = 40.dp, end = 15.dp)
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    BackArrow(onClick = { navController.popBackStack() })
                    Text(
                        text = "Create Account",
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
                            .fillMaxWidth(0.95f)
                            .padding(top = 1.dp),
                        textAlign = TextAlign.Center
                    )
                }
                Text(
                    text = "Create a account by filling in info below.",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier
                        .fillMaxWidth(),
                    color = Color(0xFF333333),
                    textAlign = TextAlign.Center
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Column {
                Row(
                    modifier = Modifier
                ) {
                    Text(
                        text = "School Code",
                        style = MaterialTheme.typography.bodySmall,
                    )
                    Spacer(modifier = Modifier.width(2.dp))
                    Text(
                        text = "*",
                        color = Color(0xFFEF6464),
                        modifier = Modifier
                    )
                }
                LoginScreenTextField(
                    text = schoolCode,
                    labelText = "Enter School Code"
                ) { schoolCode = it }
            }
//            if (schoolCode.isNotEmpty()){
//                SchoolName()
//            }
            SchoolName()
            Column {
                Row(
                    modifier = Modifier
                ) {
                    Text(
                        text = "Phone Number",
                        style = MaterialTheme.typography.bodySmall,
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

                LoginScreenTextField(
                    text = phoneNumber,
                    labelText = "Enter your phone number"
                ) { phoneNumber = it }
            }
            Spacer(modifier = Modifier.height(10.dp))
            LoginScreenButton( text = "Get OTP", enabled = phoneNumber.length >= 10)
            {
                navController.navigate(route = "otpVerify")
            }
            Row(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(text = "Already have an account?",
                    style = MaterialTheme.typography.bodySmall)
                Spacer(modifier = Modifier.width(3.dp))
                Text(
                    text = "Log in",
                    textDecoration = TextDecoration.Underline,
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontWeight = FontWeight(600)
                    ),
                    color = Color(0xFF129193),
                    modifier = Modifier.clickable {

                    }
                )
            }
        }
        Image(
            painter = painterResource(id = R.drawable.elephant_color),
            contentDescription = "coloured elephant",
            modifier = Modifier
                .height(276.95.dp)
                .width(296.41.dp)
                .align(Alignment.BottomStart)

        )
    }

}

@Composable
fun SchoolName(name: String = "1313 - Exela pvt.school"){
    Column {
        Text(
            text = "School Name",
            style = MaterialTheme.typography.bodySmall,
        )
        Spacer(modifier = Modifier.height(3.dp))
        OutlinedTextField(
            value = name,
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
                .clip(RoundedCornerShape(6.dp))
                .border(
                    width = 2.dp,
                    brush = exelaGradient,
                    shape = RoundedCornerShape(6.dp)
                )
                .background(
                    color = Color(0xFFF4FFFF)
                ),
            readOnly = true,
            textStyle = MaterialTheme.typography.bodySmall.copy(
                fontWeight = FontWeight(600),
                color = Color(0xFF1D1751)
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview(){
    val navController = rememberNavController()
    RegisterScreen(navController = navController)
}
