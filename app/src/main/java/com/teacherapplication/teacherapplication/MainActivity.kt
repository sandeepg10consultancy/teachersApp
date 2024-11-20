package com.teacherapplication.teacherapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.teacherapplication.teacherapplication.ui.SubjectChapterList.ArtContent.ChapterList
import com.teacherapplication.teacherapplication.ui.SubjectChapterList.ArtContent.ChapterScreen
import com.teacherapplication.teacherapplication.ui.SubjectChapterList.ArtContent.ContentViewScreen
import com.teacherapplication.teacherapplication.ui.SubjectChapterList.ArtContent.TopicListingScreen
import com.teacherapplication.teacherapplication.ui.SubjectChapterList.ArtContent.UploadVideoScreen
import com.teacherapplication.teacherapplication.ui.home.RegisterScreen
import com.teacherapplication.teacherapplication.ui.home.dashboard.DashBoardScreen
import com.teacherapplication.teacherapplication.ui.login.LoginAndRegister
import com.teacherapplication.teacherapplication.ui.login.LoginScreen
import com.teacherapplication.teacherapplication.ui.login.account.ClassSelection
import com.teacherapplication.teacherapplication.ui.login.account.PersonDetails
import com.teacherapplication.teacherapplication.ui.login.account.SubjectSelection
import com.teacherapplication.teacherapplication.ui.login.otp.OTPScreen
import com.teacherapplication.teacherapplication.ui.login.password.SetPassword
import com.teacherapplication.teacherapplication.ui.theme.TeacherApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TeacherApplicationTheme {
                UploadVideoScreen()
                //ContentViewScreen()
                //TopicListingScreen()
                //DashBoardScreen(navController = navController)
                //MyApp()
                //SubjectSelection()
                //BottomSheetExample()
            }
        }
    }
}


@Composable
fun MyApp(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable(route = "home"){
            LoginAndRegister(navController = navController)
        }
        composable(route = "login"){
            LoginScreen(navController = navController)
        }
        composable(route = "register"){
            RegisterScreen(navController = navController)
        }
        composable(route = "otpVerify"){
            OTPScreen(navController = navController)
        }
        composable(route = "password"){
            SetPassword(navController = navController)
        }
        composable(route = "personDetails"){
            PersonDetails(navController = navController)
        }
        composable(route = "class"){
            ClassSelection(navController = navController)
        }
        composable(route = "subject"){
            SubjectSelection(navController = navController)
        }
        composable(route = "dashboard"){
            DashBoardScreen(navController = navController)
        }
        composable( route = "artChapter"){
            ChapterList(navController = navController)
        }
        composable( route = "chapterOne"){
            ChapterScreen(navController = navController)
        }
        composable(route = "chapterOneTopics"){
            TopicListingScreen(navController = navController)
        }
        composable(route = "chapterOneContent") {
            ContentViewScreen(navController = navController)
        }
        composable(route = "videoUpload"){
            UploadVideoScreen()
        }
    }
}



/*
        BottomSheetScaffold(
            scaffoldState = scaffoldState,
            sheetContent = {
                Text(
                    text = "Bottom Bar"
                )
                Spacer(modifier = Modifier.height(500.dp))
            },
            sheetPeekHeight = 0.dp,
            sheetDragHandle = { BottomSheetDefaults.DragHandle() }
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Button(onClick = {
                    scope.launch {
                        scaffoldState.bottomSheetState.expand()
                    }
                }) {
                    Text(text = "Open sheet")
                }
            }
        }

 */