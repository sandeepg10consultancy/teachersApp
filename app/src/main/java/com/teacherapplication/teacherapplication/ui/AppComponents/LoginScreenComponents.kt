package com.teacherapplication.teacherapplication.ui.AppComponents

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.teacherapplication.teacherapplication.R
import com.teacherapplication.teacherapplication.ui.utills.exelaGradient

/*
class StarVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        // Transform each character of the password into a star '*'
        val transformedText = AnnotatedString("*".repeat(text.text.length))
        return TransformedText(transformedText, OffsetMapping.Identity)
    }
}
*/

@Composable
fun BackArrow(onClick: () -> Unit = {}){
    IconButton(
        onClick = onClick,
        modifier = Modifier.size(24.dp))
    {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "back"
        )
    }
}




@Composable
fun LoginScreenTextField(
    text: String,
    labelText: String,
    onValueChange: (String) -> Unit
){
    OutlinedTextField(
        value = text,
        onValueChange = onValueChange,
        modifier = Modifier
            .height(52.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(6.dp))
            .border(
                width = 2.dp,
                brush = exelaGradient,
                shape = RoundedCornerShape(6.dp)
            ),
        placeholder = {
                Text(
                    text = labelText,
                    style = MaterialTheme.typography.labelMedium,
                    color = Color(0xFF9D9D9D),
                )
        },
        textStyle = MaterialTheme.typography.bodySmall.copy(
            fontWeight = FontWeight(600),
        ),
    )
}

@Composable
fun LoginScreenButton(
    text: String,
    enabled: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
){
    val gradientBrush = if (enabled){
        exelaGradient
    }else{
        Brush.horizontalGradient(
            colors = listOf(
                Color(0x66185472).copy(alpha = 0.4f),
                Color(0x66129193).copy(alpha = 0.4f),
            ),
        )
    }

    Box(
        modifier = Modifier
            .height(72.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(
                brush = gradientBrush,
                shape = RoundedCornerShape(10.dp)
            )
            .clickable {
                if (enabled) onClick()
            },
    ) {
        Image(
            painter = painterResource(id = R.drawable.elephant_button),
            contentDescription = "elephant background",
            modifier = Modifier
                .height(68.dp)
                .width(62.35.dp)
                .offset(x = 25.dp, y = 2.dp)
        )
        Text(
            text = text,
            style = MaterialTheme.typography.labelLarge,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 25.dp),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun PasswordField(
    password: String,
    labelText: String,
    onValueChange: (String) -> Unit = {}
){
    var isPasswordVisible by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = password,
        onValueChange = onValueChange,
        modifier = Modifier
            .height(52.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(6.dp))
            .border(
                width = 2.dp,
                brush = exelaGradient,
                shape = RoundedCornerShape(6.dp)
            ),
        placeholder = {
            Text(
                text = labelText,
                style = MaterialTheme.typography.labelMedium,
                color = Color(0xFF9D9D9D),
            )
        },
        textStyle = MaterialTheme.typography.bodySmall.copy(
            fontWeight = FontWeight(600)
        ),
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            Image(painter = painterResource(id = if (isPasswordVisible) R.drawable.eye_close else R.drawable.eye),
                contentDescription = "eye",
                modifier = Modifier
                    .height(15.dp)
                    .width(19.dp)
                    .clickable {
                        isPasswordVisible = !isPasswordVisible
                    }
            )
        }

    )
}


@Composable
fun TopProgressBar(progress: Float = 0.4f) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 40.dp)
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
        ) {
            // background track
            drawRect(
                color = Color( 0xFFD9D9D9),
                size = Size(size.width, size.height),
            )

            // progress track with gradient and rounded corners
            if (progress > 0) {
                drawRoundRect(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFF185573), Color(0xFF14868D))
                    ),
                    size = Size(size.width * progress, size.height),
                    cornerRadius = CornerRadius(10f, 10f)
                )
            }
        }
    }
}



