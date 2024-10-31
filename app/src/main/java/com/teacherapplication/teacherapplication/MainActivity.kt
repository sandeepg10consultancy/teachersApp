package com.teacherapplication.teacherapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.teacherapplication.teacherapplication.ui.home.login.LoginAndRegister
import com.teacherapplication.teacherapplication.ui.home.login.LoginScreen
import com.teacherapplication.teacherapplication.ui.home.login.account.ClassSelection
import com.teacherapplication.teacherapplication.ui.home.login.account.PersonDetails
import com.teacherapplication.teacherapplication.ui.home.login.account.SubjectSelection
import com.teacherapplication.teacherapplication.ui.home.login.otp.OTPScreen
import com.teacherapplication.teacherapplication.ui.home.login.password.SetPassword
import com.teacherapplication.teacherapplication.ui.home.splash.SplashScreen
import com.teacherapplication.teacherapplication.ui.theme.TeacherApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TeacherApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginAndRegister(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

