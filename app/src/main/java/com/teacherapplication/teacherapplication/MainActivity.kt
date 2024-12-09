package com.teacherapplication.teacherapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.teacherapplication.teacherapplication.ui.Calendar.CalendarScreen
import com.teacherapplication.teacherapplication.ui.Diary.DailyDiaryScreen
import com.teacherapplication.teacherapplication.ui.Diary.GroupDiscussionScreen
import com.teacherapplication.teacherapplication.ui.Diary.NewGroupScreen
import com.teacherapplication.teacherapplication.ui.home.ModalDrawer.BookmarksScreen
import com.teacherapplication.teacherapplication.ui.home.ModalDrawer.FAQScreen
import com.teacherapplication.teacherapplication.ui.SubjectChapterList.ArtContent.AssignmentDetails
import com.teacherapplication.teacherapplication.ui.SubjectChapterList.ArtContent.ChapterList
import com.teacherapplication.teacherapplication.ui.SubjectChapterList.ArtContent.ChapterScreen
import com.teacherapplication.teacherapplication.ui.SubjectChapterList.ArtContent.ContentViewScreen
import com.teacherapplication.teacherapplication.ui.SubjectChapterList.ArtContent.StudentMarking
import com.teacherapplication.teacherapplication.ui.SubjectChapterList.ArtContent.StudentSubmissions
import com.teacherapplication.teacherapplication.ui.SubjectChapterList.ArtContent.TopicListingScreen
import com.teacherapplication.teacherapplication.ui.SubjectChapterList.ArtContent.UploadEbookScreen
import com.teacherapplication.teacherapplication.ui.SubjectChapterList.ArtContent.UploadVideoScreen
import com.teacherapplication.teacherapplication.ui.home.ModalDrawer.StudentPerformance.StudentFilterScreen
import com.teacherapplication.teacherapplication.ui.home.ModalDrawer.StudentPerformance.StudentListScreen
import com.teacherapplication.teacherapplication.ui.home.ModalDrawer.StudentPerformance.StudentOverallPerformance
import com.teacherapplication.teacherapplication.ui.home.ModalDrawer.StudentPerformance.StudentSubmittedScreen
import com.teacherapplication.teacherapplication.ui.home.ModalDrawer.StudentPerformance.StudentWiseAssessmentView
import com.teacherapplication.teacherapplication.ui.home.RegisterScreen
import com.teacherapplication.teacherapplication.ui.home.dashboard.DashBoardScreen
import com.teacherapplication.teacherapplication.ui.home.dashboard.DashboardViewModel
import com.teacherapplication.teacherapplication.ui.login.LoginAndRegister
import com.teacherapplication.teacherapplication.ui.login.LoginScreen
import com.teacherapplication.teacherapplication.ui.login.account.ClassSelection
import com.teacherapplication.teacherapplication.ui.login.account.PersonDetails
import com.teacherapplication.teacherapplication.ui.login.account.SubjectSelection
import com.teacherapplication.teacherapplication.ui.login.otp.OTPScreen
import com.teacherapplication.teacherapplication.ui.login.password.SetPassword
import com.teacherapplication.teacherapplication.ui.home.ModalDrawer.profile.EditProfileScreen
import com.teacherapplication.teacherapplication.ui.home.ModalDrawer.profile.ProfileScreen
import com.teacherapplication.teacherapplication.ui.home.notifications.NotificationDetailsScreen
import com.teacherapplication.teacherapplication.ui.home.notifications.NotificationsScreen
import com.teacherapplication.teacherapplication.ui.theme.TeacherApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val viewModel: DashboardViewModel = viewModel()
            TeacherApplicationTheme {

                //StudentWiseAssessmentView()
                //StudentSubmittedScreen(navController)
                //StudentOverallPerformance(navController)
                //StudentListScreen(navController)
                MyApp()
                //CalendarScreen(navController, viewModel)

            }
        }
    }
}


@Composable
fun MyApp(){
    val navController = rememberNavController()
    val viewModel: DashboardViewModel = viewModel()
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
            DashBoardScreen(navController = navController, viewModel = viewModel)
        }
        composable(route = "notificationsScreen"){
            NotificationsScreen(navController = navController)
        }
        composable(route = "notificationDetails"){
            NotificationDetailsScreen(navController = navController)
        }
        composable(route = "profileScreen"){
            ProfileScreen(navController = navController, viewModel = viewModel)
        }
        composable(route = "editProfileScreen"){
            EditProfileScreen(navController = navController)
        }
        composable(route = "faqScreen"){
            FAQScreen(navController = navController)
        }
        composable(route = "bookmarksScreen"){
            BookmarksScreen(navController = navController)
        }
        composable(route = "studentFilterScreen"){
            StudentFilterScreen(navController = navController)
        }
        composable(route = "studentListScreen"){
            StudentListScreen(navController = navController)
        }
        composable(route = "studentOverall"){
            StudentOverallPerformance(navController = navController)
        }
        composable(route = "studentWiseAssessment"){
            StudentWiseAssessmentView(navController = navController)
        }
        composable(route = "studentSubmittedScreen"){
            StudentSubmittedScreen(navController = navController)
        }
        composable(route = "calendarScreen"){
            CalendarScreen(navController = navController, viewModel = viewModel)
        }
        composable(route = "dairyScreen"){
            DailyDiaryScreen(navController = navController, viewModel = viewModel)
        }
        composable(route = "groupDiscussion"){
            GroupDiscussionScreen(navController = navController)
        }
        composable(route = "newGroupScreen"){
            NewGroupScreen(navController = navController, viewModel = viewModel)
        }
        composable(
            route = "artChapter/{image}/{title}",
            arguments = listOf(
                navArgument("image") { type = NavType.IntType },
                navArgument("title") { type = NavType.StringType },
            )
        ){ backStackEntry ->
            val image = backStackEntry.arguments?.getInt("image") ?: R.drawable.art_img
            val title = backStackEntry.arguments?.getString("title") ?: ""
            ChapterList(navController = navController, viewModel = viewModel, image = image, title = title)
        }
        composable( route = "chapterOne"){
            ChapterScreen(navController = navController, viewModel = viewModel)
        }
        composable(route = "chapterOneTopics"){
            TopicListingScreen(navController = navController, viewModel = viewModel)
        }
        composable(route = "chapterOneContent") {
            ContentViewScreen(navController = navController, viewModel = viewModel)
        }
        composable(route = "videoUpload"){
            UploadVideoScreen(navController = navController,viewModel = viewModel)
        }
        composable(route = "ebookUpload"){
            UploadEbookScreen(navController = navController,viewModel = viewModel)
        }
        composable(route = "assignmentDetails"){
            AssignmentDetails(navController = navController, viewModel = viewModel)
        }
        composable( route = "studentSubmissions/{isDone}"){ backStackEntry ->
            val isDone = backStackEntry.arguments?.getString("isDone")?.toBoolean() ?: false
            StudentSubmissions(navController = navController, viewModel = viewModel, isDone = isDone)
        }
        composable( route = "studentMarking"){
            StudentMarking(navController = navController, viewModel = viewModel)
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