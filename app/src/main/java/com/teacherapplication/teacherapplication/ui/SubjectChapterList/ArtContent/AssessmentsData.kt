package com.teacherapplication.teacherapplication.ui.SubjectChapterList.ArtContent

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.teacherapplication.teacherapplication.R
import com.teacherapplication.teacherapplication.ui.theme.jostFont

val assignmentTitle = listOf("Assignment Name 1","Assignment Name 2","Assignment Name 3","Assignment Name 4")

//@Preview(showBackground = true)
@Composable
fun AssessmentsCards(modifier: Modifier = Modifier, navController: NavHostController){
    Column(modifier = modifier.fillMaxSize()){
        assignmentTitle.forEach { title ->
            AssignmentCard(title, navController)
            Spacer(modifier = Modifier.height(25.dp))
        }
        CreateAssessmentButton(onClick = {})
        Spacer(modifier = Modifier.height(150.dp))
    }
}

@Composable
fun CreateAssessmentButton(onClick: () -> Unit = {},modifier: Modifier = Modifier){
    Box(
        modifier = modifier
            .height(54.dp)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFF185573), Color(0xFF14868D))
                ),
                shape = RoundedCornerShape(12.dp)
            )

    ) {
        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp)
        ) {
            Text(
                text = "Create New Assesstment",
                style = TextStyle(
                    fontFamily = jostFont,
                    fontWeight = FontWeight(500),
                    fontSize = 20.sp,
                    lineHeight = 28.9.sp
                )
            )
        }
        Image(
            painter = painterResource(id = R.drawable.elephant_button),
            contentDescription = "elephant background",
            modifier = Modifier
                .scale(1f)
                .offset(x = 30.dp, y = 2.dp)
        )
    }
}


@Composable
private fun AssignmentCard(title: String, navController: NavHostController) {
    Card(
        modifier = Modifier
            .height(128.dp)
            .fillMaxWidth(),
        onClick = { navController.navigate(route = "assignmentDetails") },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleMedium.copy(
                            lineHeight = 14.4.sp
                        )

                    )

                    Row(
                        modifier = Modifier.padding(top = 10.dp),
                        horizontalArrangement = Arrangement.spacedBy(15.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .width(53.dp)
                                .height(20.dp)
                                .clip(RoundedCornerShape(20.dp))
                                .background(
                                    color = Color(0xFFE5EFFF)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "CG-1.1",
                                style = MaterialTheme.typography.labelSmall.copy(
                                    lineHeight = 9.6.sp,
                                    color = Color(0xFF1D6BF3)
                                )
                            )
                        }
                        Box(
                            modifier = Modifier
                                .width(53.dp)
                                .height(20.dp)
                                .clip(RoundedCornerShape(20.dp))
                                .background(
                                    color = Color(0xFFE5EFFF)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "CG-1.2",
                                style = MaterialTheme.typography.labelSmall.copy(
                                    lineHeight = 9.6.sp,
                                    color = Color(0xFF1D6BF3)
                                )
                            )
                        }
                    }
                }
                Box(
                    modifier = Modifier
                        .height(25.dp)
                        .width(73.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .background(
                            brush = Brush.linearGradient(
                                colors = listOf(Color(0xFFE67E22), Color(0xFFFFC261))
                            )
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Pending",
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontWeight = FontWeight(500),
                            lineHeight = 9.6.sp,
                            color = Color.White
                        )
                    )
                }
            }
            Spacer(modifier = Modifier.height(7.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Created by",
                        style = MaterialTheme.typography.labelSmall.copy(
                            lineHeight = 9.6.sp,
                            color = Color.Black.copy(alpha = 0.5f)
                        )
                    )
                    Text(
                        text = "Exela Publication",
                        style = MaterialTheme.typography.labelSmall.copy(
                            lineHeight = 9.6.sp,
                            color = Color.Black
                        )
                    )
                }
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Created on",
                        style = MaterialTheme.typography.labelSmall.copy(
                            lineHeight = 9.6.sp,
                            color = Color.Black.copy(alpha = 0.5f)
                        )
                    )
                    Text(
                        text = "22Aug2024",
                        style = MaterialTheme.typography.labelSmall.copy(
                            lineHeight = 9.6.sp,
                            color = Color.Black
                        )
                    )
                }
            }

        }

    }
}