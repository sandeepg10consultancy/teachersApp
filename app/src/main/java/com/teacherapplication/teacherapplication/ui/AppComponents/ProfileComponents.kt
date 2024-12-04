package com.teacherapplication.teacherapplication.ui.AppComponents

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ProfileTextFieldBox(
    subTitle: String,
    fieldValue: MutableState<String>,
){
    Column(
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ){
        Text(
            text = subTitle,
            style = MaterialTheme.typography.bodySmall,
            color = Color.Black,
        )
        OutlinedTextField(
            value = fieldValue.value,
            onValueChange = { fieldValue.value = it },
            textStyle = MaterialTheme.typography.bodySmall.copy(
                color = Color.Black,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
                .border(
                    width = 2.dp,
                    brush = brush,
                    shape = RoundedCornerShape(6.dp)
                ),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = Color.Transparent
            )
        )
    }
}