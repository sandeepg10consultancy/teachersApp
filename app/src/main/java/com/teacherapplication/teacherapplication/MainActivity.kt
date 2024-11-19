package com.teacherapplication.teacherapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.scale
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.teacherapplication.teacherapplication.ui.AppComponents.BackArrow
import com.teacherapplication.teacherapplication.ui.SubjectChapterList.ArtContent.ChapterList
import com.teacherapplication.teacherapplication.ui.SubjectChapterList.ArtContent.ChapterScreen
import com.teacherapplication.teacherapplication.ui.SubjectChapterList.ArtContent.ContentViewScreen
import com.teacherapplication.teacherapplication.ui.SubjectChapterList.ArtContent.TopicListingScreen
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
import com.teacherapplication.teacherapplication.ui.theme.jostFont
import com.teacherapplication.teacherapplication.ui.theme.openFont

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TeacherApplicationTheme {
                ContentViewScreen()
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
            ContentViewScreen()
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun BottomSheetExample(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        val sheetState = rememberModalBottomSheetState()
        var isSheetOpen by rememberSaveable {
            mutableStateOf(false)
        }
        var buttonSelection by rememberSaveable { mutableStateOf("Files") }
        var textFieldData by rememberSaveable { mutableStateOf("Shapes and colours") }
        Button(onClick = {isSheetOpen = !isSheetOpen}) {
            Text(text = "button")
        }
        if(isSheetOpen){
                        ModalBottomSheet(
                            sheetState = sheetState,
                            onDismissRequest = {
                                isSheetOpen = false
                            },
                            dragHandle = { BottomSheetDefaults.ExpandedShape}
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(30.dp)
                            ){
                                BackArrow(onClick = {})
                                Spacer(modifier = Modifier.height(20.dp))
                                Box(
                                    modifier = Modifier
                                        .height(50.dp)
                                        .fillMaxWidth()
                                        .background(
                                            color = Color(0xFFE2F2F5),
                                            shape = RoundedCornerShape(10.dp)
                                        )
                                ){
                                  Row(
                                      modifier = Modifier.fillMaxSize(),
                                  ){
                                      Button(
                                          onClick = {
                                              buttonSelection = "Text"
                                          },
                                          modifier = Modifier
                                              .padding(5.dp)
                                              .height(40.dp)
                                              .fillMaxWidth(0.5f),
                                          shape = RoundedCornerShape(10.dp),
                                          colors = ButtonDefaults.buttonColors(
                                              containerColor = if (buttonSelection == "Text") Color.White else Color(0xFFE2F2F5)
                                          )
                                      ) {
                                          Text(
                                              text = "Text",
                                              style = TextStyle(
                                                  fontFamily = jostFont,
                                                  fontWeight = FontWeight(400),
                                                  fontSize = 18.sp,
                                                  lineHeight = 12.sp
                                              ),
                                              color = Color(0xFF1D1751)
                                          )
                                      }
                                      Button(
                                          onClick = {
                                              buttonSelection = "Files"
                                          },
                                          modifier = Modifier
                                              .padding(5.dp)
                                              .height(40.dp)
                                              .fillMaxWidth(),
                                          shape = RoundedCornerShape(10.dp),
                                          colors = ButtonDefaults.buttonColors(
                                              containerColor = if (buttonSelection == "Files") Color.White else Color(0xFFE2F2F5)
                                          )
                                      ) {
                                          Text(
                                              text = "Files",
                                              style = TextStyle(
                                                  fontFamily = jostFont,
                                                  fontWeight = FontWeight(400),
                                                  fontSize = 18.sp,
                                                  lineHeight = 12.sp
                                              ),
                                              color = Color(0xFF1D1751)
                                          )
                                      }
                                  }
                                }
                                Spacer(modifier = Modifier.height(20.dp))
                                Text(
                                    text = buildAnnotatedString {
                                        append("File Title")
                                        withStyle(style = SpanStyle(
                                            color = Color.Red
                                        )){
                                            append("*")
                                        }
                                    },
                                    style = MaterialTheme.typography.bodySmall.copy(
                                        fontWeight = FontWeight(500)
                                    )
                                )
                                Spacer(modifier = Modifier.height(10.dp))
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .drawBehind {
                                            val strokeWidth = 2.dp.toPx()
                                            val gradient = Brush.linearGradient(
                                                colors = listOf(Color(0xFF185573), Color(0xFF14868D))
                                            )
                                            drawRoundRect(
                                                brush = gradient,
                                                size = size,
                                                style = Stroke(strokeWidth),
                                                cornerRadius = CornerRadius(x = 6.dp.toPx(), y = 6.dp.toPx()),                                            )
                                        },
                                ) {
                                    OutlinedTextField(
                                        value = textFieldData,
                                        textStyle = MaterialTheme.typography.bodySmall,
                                        onValueChange = { textFieldData = it },
                                        label = {  },
                                        maxLines = 1,
                                        colors = OutlinedTextFieldDefaults.colors(
                                            focusedBorderColor = Color.Transparent,
                                            unfocusedBorderColor = Color.Transparent
                                        ),
                                        modifier = Modifier
                                            .offset(y = (-8).dp)
                                    )
                                }
                                Spacer(modifier = Modifier.height(20.dp))
                                DashedBorderBox()
                                Spacer(modifier = Modifier.height(100.dp))
                                SaveButton()


                            }
                        }
                    }
    }
}

@Composable
private fun DashedBorderBox(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .height(179.dp)
            .fillMaxWidth()
            .background(
                color = Color(0xFFB6DFE6).copy(alpha = 0.15f),
                shape = RoundedCornerShape(18.9.dp) // Adjust shape as needed
            )
            .border(width = 4.dp, color = Color.Transparent, RoundedCornerShape(8.dp))
            .drawBehind {
                val borderWidth = 1.dp.toPx()
                val dashWidth = 5.dp.toPx()
                val dashGap = 5.dp.toPx()
                val paint = Paint().apply {
                    //color = Color.Black // Adjust the border color as needed
                    //style = PaintingStyle.Stroke
                    strokeWidth = borderWidth
                    pathEffect = PathEffect.dashPathEffect(floatArrayOf(dashWidth, dashGap), 0f)
                }
                drawRoundRect(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFF185573), Color(0xFF14868D))
                    ),
                    size = size,
                    style = Stroke(width = borderWidth, pathEffect = paint.pathEffect),
                    cornerRadius = CornerRadius(18.9.dp.toPx())
                )
            }
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ){
                Image(
                    painter = painterResource(R.drawable.upload_icon),
                    contentDescription = "upload",
                    modifier = Modifier.size(22.68.dp)
                )
                Text(
                    text = "Upload media",
                    color = Color.Black,
                    style = MaterialTheme.typography.labelLarge.copy(
                        brush = Brush.linearGradient(
                            colors = listOf(Color(0xFF185573), Color(0xFF14868D))
                        ),
                        fontSize = 17.01.sp,
                        lineHeight = 11.34.sp,
                        letterSpacing = 0.14.sp
                    )
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Click on the button or Drag and Drop files here",
                style = MaterialTheme.typography.labelSmall.copy(
                    fontSize = 11.34.sp,
                    lineHeight = 11.34.sp,
                    letterSpacing = 0.14.sp,
                    color = Color(0xFF5A5A5A)
                )
            )
            Spacer(modifier = Modifier.height(30.dp))
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ),
                enabled = true,
                modifier = Modifier
                    .width(247.37.dp)
                    .height(44.29.dp)
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(Color(0xFF185573), Color(0xFF14868D))
                        ),
                        shape = RoundedCornerShape(4.18.dp)
                    )
            ) {
                Text(
                    text = "Browse Files",
                    style = TextStyle(
                        fontFamily = openFont,
                        color = Color.White,
                        fontWeight = FontWeight(600),
                        fontSize = 13.37.sp,
                        lineHeight = 10.03.sp,
                        letterSpacing = 0.13.sp
                    )
                )
            }
        }
    }
}



@Composable
fun DashedBorderBoxAlternative(
    modifier: Modifier = Modifier,
    gradientColors: List<Color> = listOf(Color(0xFF185573), Color(0xFF14868D))
) {
    Box(
        modifier = modifier
            .background(
                brush = Brush.linearGradient(gradientColors),
                shape = RoundedCornerShape(8.dp) // Adjust shape as needed
            )
            .drawBehind {
                // Variables for the dashed border
                val borderWidth = 4.dp.toPx()
                val dashWidth = 10.dp.toPx()
                val dashGap = 5.dp.toPx()

                // Draw the dashed border using the canvas
                val path = Path().apply {
                    addRoundRect(
                        RoundRect(
                            left = borderWidth / 2,
                            top = borderWidth / 2,
                            right = size.width - borderWidth / 2,
                            bottom = size.height - borderWidth / 2,
                            cornerRadius = CornerRadius(8.dp.toPx())
                        )
                    )
                }

                drawPath(
                    path = path,
                    color = Color.Black, // Border color
                    style = Stroke(
                        width = borderWidth,
                        pathEffect = PathEffect.dashPathEffect(floatArrayOf(dashWidth, dashGap), 0f)
                    )
                )
            }
            .padding(16.dp) // Adjust padding as needed
    ) {
        // Content inside the Box
        Text(
            text = "Dashed Border Box",
            color = Color.White,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}





@Composable
private fun SaveButton(onClick:() -> Unit = { }){
    Box(
        modifier = Modifier
            .height(54.dp)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFF185573), Color(0xFF14868D))
                ),
                shape = RoundedCornerShape(8.dp)
            )

    ) {
        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            ),
            enabled = true,
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
        ) {
            Text(
                text = "Save",
                style = MaterialTheme.typography.titleMedium.copy(
                    color = Color.White,
                    fontWeight = FontWeight(500)
                )
            )
        }
        Image(
            painter = painterResource(id = R.drawable.elephant_button),
            contentDescription = "elephant background",
            modifier = Modifier
                .scale(1f)
                .offset(x = 50.dp, y = 2.dp)
        )
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