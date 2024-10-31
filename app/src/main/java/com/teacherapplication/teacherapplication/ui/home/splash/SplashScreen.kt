
package com.teacherapplication.teacherapplication.ui.home.splash

import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teacherapplication.teacherapplication.R

@Preview(showBackground = true)
@Composable
fun SplashScreen(modifier: Modifier = Modifier){

        Box(modifier = Modifier.fillMaxSize()
            .background(color = Color.Gray)){
//            Image(painter = painterResource(id = R.drawable.img),
//                modifier = Modifier.fillMaxSize(),
//                contentDescription = "image"
//            )
            Column(
                modifier = Modifier
                    .fillMaxWidth().padding(start = 24.dp, top = 633.dp, end = 24.dp)
            ){
                Text(text = "Hii Welcome!",
                    color = Color.White,
                    style = MaterialTheme.typography.titleMedium,
                    fontFamily = FontFamily.Serif,
                    fontSize = 35.sp,
                    fontWeight = FontWeight(700),
                    modifier = Modifier.fillMaxWidth().padding(bottom = 2.dp))
                Text(text = "Unlock the joy of learning with",
                    color = Color.White,
                    fontSize = 20.sp,
                    modifier = Modifier.fillMaxWidth().padding(bottom = 2.dp))
                Text(text = "Kindergarten app",
                    color = Color.White,
                    style = MaterialTheme.typography.titleMedium,
                    fontFamily = FontFamily.Serif,
                    fontSize = 35.sp,
                    fontWeight = FontWeight(600),
                    modifier = Modifier.fillMaxWidth().padding(bottom = 2.dp))
                Text(text = "where curiosity meets creativity!",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight(400),
                    modifier = Modifier.fillMaxWidth().padding(bottom = 2.dp))
                Button(onClick = { /*TODO*/ },
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Cyan),
                    modifier = Modifier.fillMaxWidth()

                        .padding(top = 30.dp)) {
                    Text(text = "Continue")
                }
            }
        }

}