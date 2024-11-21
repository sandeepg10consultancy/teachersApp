package com.teacherapplication.teacherapplication.ui.SubjectChapterList.ArtContent

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teacherapplication.teacherapplication.ui.AppComponents.SmallCircle

@Preview(showBackground = true)
@Composable
fun AssignmentDetails(modifier: Modifier = Modifier){
    Column(
        modifier = modifier.fillMaxSize()
            .padding(top = 40.dp)
    ){
        TopBox()
    }
}

@Composable
private fun TopBox() {
    Box(
        modifier = Modifier
            .height(74.dp)
            .fillMaxWidth()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFF185573), Color(0xFF14868D))
                )
            )
            .padding(20.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "back",
                modifier = Modifier.size(24.dp),
                tint = Color.White
            )
            Text(
                text = "Art",
                style = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight(600),
                    lineHeight = 12.8.sp,
                    color = Color.White
                ),
                modifier = Modifier.alignByBaseline()
            )
            SmallCircle(
                dim = 4.dp,
                containerColor = Color(0xFFF4F4F4),
                borderColor = Color.Transparent
            )
            Text(
                text = "Ch-4",
                style = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight(600),
                    lineHeight = 12.8.sp,
                    color = Color.White
                ),
                modifier = Modifier.alignByBaseline()
            )
            SmallCircle(
                dim = 4.dp,
                containerColor = Color(0xFFF4F4F4),
                borderColor = Color.Transparent
            )
            Text(
                text = "JuniorKG-A",
                style = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight(600),
                    lineHeight = 12.8.sp,
                    color = Color.White
                ),
                modifier = Modifier.alignByBaseline()
            )
        }
    }
}