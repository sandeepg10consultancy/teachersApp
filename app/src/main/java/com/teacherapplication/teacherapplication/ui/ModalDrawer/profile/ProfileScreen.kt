package com.teacherapplication.teacherapplication.ui.ModalDrawer.profile

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavHostController
import com.teacherapplication.teacherapplication.R
import com.teacherapplication.teacherapplication.ui.AppComponents.BackArrow
import com.teacherapplication.teacherapplication.ui.AppComponents.brush
import com.teacherapplication.teacherapplication.ui.SubjectChapterList.ArtContent.DashedVideoBox
import com.teacherapplication.teacherapplication.ui.home.dashboard.DashboardViewModel
import com.teacherapplication.teacherapplication.ui.theme.jostFont
import com.teacherapplication.teacherapplication.ui.theme.openFont

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: DashboardViewModel
){

    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 15.dp, top = 40.dp, end = 15.dp)
            .verticalScroll(scrollState)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ){
                BackArrow( onClick = { navController.popBackStack()})
                Text(
                    text = "Back",
                    style = TextStyle(
                        fontFamily = openFont,
                        fontWeight = FontWeight(600),
                        fontSize = 16.sp,
                        lineHeight = 21.79.sp,
                        letterSpacing = 0.03.sp,
                        color = Color.Black
                    )
                )
            }
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(
                        brush = brush,
                        shape = CircleShape
                    )
                    .clickable {
                        navController.navigate(route = "editProfileScreen")
                    },
                contentAlignment = Alignment.Center
            ){
                Icon(
                    painter = painterResource(R.drawable.editing),
                    contentDescription = "edit",
                    tint = Color.White,
                    modifier = Modifier
                        .size(20.dp)
                )
            }
        }

        ProfileEditing(Modifier.align(Alignment.CenterHorizontally))

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Chandani Poosarla",
            style = MaterialTheme.typography.titleMedium.copy(
                brush = brush,
                fontSize = 20.sp,
                lineHeight = 28.9.sp,
            ),
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Text(
            text = "98900000XXXX",
            style = TextStyle(
                fontFamily = jostFont,
                fontWeight = FontWeight(500),
                fontSize = 16.sp,
                color = Color.Black.copy(alpha = 0.8f),
                lineHeight = 23.12.sp,
            ),
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Personal Info",
            style = MaterialTheme.typography.titleMedium,
            color = Color.Black,
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "First Name",
            style = MaterialTheme.typography.labelMedium,
            color = Color.Black.copy(alpha = 0.4f)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Chandini",
            style = MaterialTheme.typography.bodyLarge,
            color = Color(0xFF1D1751)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Last Name",
            style = MaterialTheme.typography.labelMedium,
            color = Color.Black.copy(alpha = 0.4f)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Poosarla",
            style = MaterialTheme.typography.bodyLarge,
            color = Color(0xFF1D1751)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Phone Number",
            style = MaterialTheme.typography.labelMedium,
            color = Color.Black.copy(alpha = 0.4f)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "989000000",
            style = MaterialTheme.typography.bodyLarge,
            color = Color(0xFF1D1751)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Gender",
            style = MaterialTheme.typography.labelMedium,
            color = Color.Black.copy(alpha = 0.4f)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Female",
            style = MaterialTheme.typography.bodyLarge,
            color = Color(0xFF1D1751)
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Teaching Details",
            style = MaterialTheme.typography.titleMedium,
            color = Color.Black,
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "School Code",
            style = MaterialTheme.typography.labelMedium,
            color = Color.Black.copy(alpha = 0.4f)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "131",
            style = MaterialTheme.typography.bodyLarge,
            color = Color(0xFF1D1751)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "School Name",
            style = MaterialTheme.typography.labelMedium,
            color = Color.Black.copy(alpha = 0.4f)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Exela pvt.school",
            style = MaterialTheme.typography.bodyLarge,
            color = Color(0xFF1D1751)
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Classes",
            style = MaterialTheme.typography.titleMedium,
            color = Color.Black,
        )
        Spacer(modifier = Modifier.height(20.dp))
        Box(
            modifier = Modifier
                .height(50.dp)
                .width(130.dp)
                .background(
                    color = Color(0xFF1D1751),
                    shape = RoundedCornerShape(5.dp)
                ),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = "Nursery - A",
                style = MaterialTheme.typography.bodySmall,
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Subjects",
            style = MaterialTheme.typography.titleMedium,
            color = Color.Black,
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Class : Nursery - A",
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight(600),
            color = Color(0xFF1D1751)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Box(
                modifier = Modifier
                    .height(60.dp)
                    .width(180.dp)
                    .background(
                        color = Color(0xFFF18A90),
                        shape = RoundedCornerShape(8.dp)
                    ),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = "Mathematics",
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontWeight = FontWeight(500),
                        lineHeight = 20.8.sp,
                        color = Color.White
                    )
                )
            }
            Box(
                modifier = Modifier
                    .height(60.dp)
                    .width(180.dp)
                    .background(
                        color = Color(0xFFF18A90),
                        shape = RoundedCornerShape(8.dp)
                    ),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = "Science",
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontWeight = FontWeight(500),
                        lineHeight = 20.8.sp,
                        color = Color.White
                    )
                )
            }
        }
        Spacer(modifier = Modifier.height(50.dp))
    }
}

@Composable
fun ProfileEditing(modifier: Modifier = Modifier) {
    val isDialogOpen = remember { mutableStateOf(false) }
    Box(
        modifier = modifier
            .size(132.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.profile_img),
            contentDescription = "image",
            modifier = Modifier
                .size(131.dp)
                .clip(CircleShape)
        )
        Box(
            modifier = Modifier
                .size(34.dp)
                .clip(CircleShape)
                .background(
                    brush = brush,
                )
                .border(
                    width = 3.dp,
                    color = Color.White,
                    shape = CircleShape
                )
                .align(Alignment.BottomEnd)
                .clickable {
                    isDialogOpen.value = true
                },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.editing),
                contentDescription = "edit",
                tint = Color.White,
                modifier = Modifier
                    .size(16.dp)
            )
        }
    }
    if (isDialogOpen.value){
        Dialog(
            onDismissRequest = { isDialogOpen.value = false},
        ) {
            Box(
                modifier = Modifier
                    .height(704.dp)
                    .fillMaxSize()
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .padding(start = 10.dp, top = 15.dp, end = 10.dp)
            ){
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ){
                    PhotoDashedBox()
                    Text(
                        text = "Uploaded Photo",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            lineHeight = 14.59.sp,
                            letterSpacing = 0.18.sp,
                            color = Color.Black.copy(alpha = 0.6f)
                        )
                    )
                    Image(
                        painter = painterResource(R.drawable.profile_img),
                        contentDescription = "image",
                        modifier = Modifier
                            .size(250.dp)
                            .clip(CircleShape)
                            .align(Alignment.CenterHorizontally)
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ){
                        Button(
                            onClick = { isDialogOpen.value = false },
                            modifier = Modifier
                                .height(54.dp)
                                .width(165.dp)
                                .border(
                                    width = 1.dp,
                                    brush = brush,
                                    shape = RoundedCornerShape(5.dp)
                                ),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.White
                            )
                        ) {
                            Text(
                                text = "Cancel",
                                style = TextStyle(
                                    fontFamily = jostFont,
                                    fontWeight = FontWeight(400),
                                    fontSize = 18.sp,
                                    lineHeight = 12.sp,
                                    letterSpacing = 0.15.sp,
                                    brush = brush
                                )
                            )
                        }
                        Box(
                            modifier = Modifier
                                .height(54.dp)
                                .width(165.dp)
                                .border(
                                    width = 1.dp,
                                    brush = brush,
                                    shape = RoundedCornerShape(5.dp)
                                )
                                .background(
                                    brush = brush,
                                    shape = RoundedCornerShape(5.dp)
                                )
                                .clickable {

                                },
                            ) {
                            Image(
                                painter = painterResource(R.drawable.elephant_button),
                                contentDescription = "elephant"
                            )
                            Text(
                                text = "Save Changes",
                                style = TextStyle(
                                    fontFamily = jostFont,
                                    fontWeight = FontWeight(400),
                                    fontSize = 18.sp,
                                    lineHeight = 12.sp,
                                    letterSpacing = 0.15.sp,
                                    color = Color.White
                                ),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 5.dp, top = 15.dp),
                                textAlign = TextAlign.Center
                            )

                        }
                    }
                }
            }

        }
    }
}

@Composable
private fun PhotoDashedBox(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .height(208.dp)
            .width(382.dp)
            .border(width = 1.dp, color = Color.Transparent, RoundedCornerShape(20.dp))
            .drawBehind {
                val borderWidth = 1.dp.toPx()
                val dashWidth = 5.dp.toPx()
                val dashGap = 5.dp.toPx()
                val paint = Paint().apply {
                    strokeWidth = borderWidth
                    pathEffect = PathEffect.dashPathEffect(floatArrayOf(dashWidth, dashGap), 0f)
                }
                drawRoundRect(
                    color = Color(0xFFD9D9D9),
                    size = size,
                    style = Stroke(width = borderWidth, pathEffect = paint.pathEffect),
                    cornerRadius = CornerRadius(20.dp.toPx())
                )
            }
            .padding(14.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.upload_icon),
                    contentDescription = "upload",
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = "Upload Photo",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 18.sp,
                        lineHeight = 12.sp,
                        letterSpacing = 0.15.sp
                    )
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Supports: JPEG , PNG. Keep the files under 5MB.",
                style = MaterialTheme.typography.labelSmall.copy(
                    lineHeight = 12.sp,
                    letterSpacing = 0.15.sp,
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
                    .width(296.dp)
                    .height(53.dp)
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(Color(0xFF185573), Color(0xFF14868D))
                        ),
                        shape = RoundedCornerShape(5.dp)
                    )
            ) {
                Text(
                    text = "Browse Files",
                    style = TextStyle(
                        fontFamily = openFont,
                        color = Color.White,
                        fontWeight = FontWeight(600),
                        fontSize = 16.sp,
                        lineHeight = 12.sp,
                        letterSpacing = 0.15.sp
                    )
                )
            }
        }
    }
}