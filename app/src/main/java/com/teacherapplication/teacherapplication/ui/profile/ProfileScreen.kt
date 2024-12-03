package com.teacherapplication.teacherapplication.ui.profile

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
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.teacherapplication.teacherapplication.R
import com.teacherapplication.teacherapplication.ui.AppComponents.BackArrow
import com.teacherapplication.teacherapplication.ui.AppComponents.brush
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
                BackArrow( onClick = { })
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
                    ),
                contentAlignment = Alignment.Center
            ){
                Icon(
                    painter = painterResource(R.drawable.editing),
                    contentDescription = "edit",
                    tint = Color.White,
                    modifier = Modifier
                        .size(20.dp)
                        .clickable {

                        }
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
private fun ProfileEditing(modifier: Modifier = Modifier) {
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
                .align(Alignment.BottomEnd),
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
}