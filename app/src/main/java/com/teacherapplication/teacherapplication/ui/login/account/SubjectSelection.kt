package com.teacherapplication.teacherapplication.ui.login.account

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.teacherapplication.teacherapplication.R
import com.teacherapplication.teacherapplication.ui.AppComponents.BackArrow
import com.teacherapplication.teacherapplication.ui.AppComponents.LoginScreenButton
import com.teacherapplication.teacherapplication.ui.AppComponents.brush
import kotlinx.coroutines.delay


//@Preview
@Composable
fun SubjectSelection(modifier: Modifier = Modifier,navController: NavHostController
){

    val subjectsList = listOf("Mathematics", "Science", "Reading", "Writing", "Social Studies", "Drawing", "Physics", "Chemistry", "English", "Sports")
    val selectedSubject = remember { mutableStateOf("") }
    val selectedSubjectsList = remember { mutableStateListOf<String>() }
    var allSubject by remember {
        mutableStateOf(false)
    }

    var showDialog by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 15.dp, top = 40.dp, end = 15.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                BackArrow( onClick = {navController.popBackStack()} )
                Text(
                    text = "Subjects I Teach",
                    style = MaterialTheme.typography.titleSmall.copy(
                        brush = brush,
                        fontWeight = FontWeight(600),
                        fontSize = 20.sp,
                        lineHeight = 28.9.sp
                    ),
                )
            }
            Text(text = "Please select the subjects that you teach",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 40.dp),
                style = MaterialTheme.typography.bodySmall,
                color = Color(0xFF333333)
            )
            Spacer(modifier = Modifier.height(40.dp))
            SchoolCard()
            Spacer(modifier = Modifier.height(40.dp))
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp),
            ) {
                items(subjectsList){ item ->
                    SubjectCard(item,allSubject, selectedSubject, selectedSubjectsList)

                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                Checkbox(checked = allSubject,
                    onCheckedChange = { allSubject = !allSubject},
                    colors = CheckboxDefaults.colors(
                        uncheckedColor = Color(0xFF129193),
                        checkedColor = Color(0xFF129193))
                )
                Text(text = "Select all Subjects",
                    fontSize = 14.sp,
                    fontWeight = FontWeight(500))
            }

        }
        Box(
            modifier = Modifier.fillMaxSize()
                .padding(horizontal = 15.dp, vertical = 50.dp),
            contentAlignment = Alignment.BottomCenter
        ){
            LoginScreenButton(
                text = "Save & Proceed",
                enabled = allSubject || selectedSubject.value.isNotEmpty()
            ) {
                showDialog = true
            }
        }
        if (showDialog){
            DialogBox{showDialog = false}
            LaunchedEffect(Unit) {
                delay(2000)
                navController.navigate(route = "dashboard")
            }
        }


        Image(
            painter = painterResource(id = R.drawable.elephant_color),
            contentDescription = "coloured elephant",
            modifier = Modifier
                .height(276.95.dp)
                .width(296.41.dp)
                .align(Alignment.BottomStart),
            alpha = 0.3f

        )
    }
}

@Composable
private fun DialogBox(onClick:() -> Unit = {}) {
    Dialog(onDismissRequest = onClick) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .height(300.dp)
                .width(382.dp)
        ) {
            Surface(
                modifier = Modifier
                    .height(230.dp)
                    .width(382.dp)
                    .align(Alignment.BottomCenter),
                shape = RoundedCornerShape(20.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "All Done!",
                        style = MaterialTheme.typography.titleSmall.copy(
                            color = Color(0xFF47CB72)
                        )
                    )
                    Text(
                        text = "You’re all set and ready to start",
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontSize = 18.sp,
                            fontWeight = FontWeight(300)
                        )
                    )
                }
            }
            Image(
                painter = painterResource(R.drawable.dialog_cnf_img),
                contentDescription = "",
                modifier = Modifier.offset(y = (-85).dp)
            )
        }
    }
}

@Composable
fun SubjectCard(
    name: String,
    allSubject: Boolean,
    selectedSubject: MutableState<String>,
    selectedSubjectsList: SnapshotStateList<String>
) {
    val isSelected = allSubject || name in selectedSubjectsList
    Card(
        modifier = Modifier
            .height(60.dp)
            .width(180.dp),
        border = BorderStroke(width = 2.dp, color = Color(0xFFF18A90)),
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) Color(0xFFF18A90) else Color(0xFFFFFFFF)
        ),
        shape = RoundedCornerShape(8.dp),
        onClick = {
            selectedSubject.value = name
            if (name in selectedSubjectsList) {
                selectedSubjectsList.remove(name)
            }
            else {
                selectedSubjectsList.add(name)
            }
        }
    ) {
        Text(
            text = name,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp),
            style = MaterialTheme.typography.bodySmall.copy(
                fontWeight = FontWeight(500),
                lineHeight = 20.8.sp
            ),
            textAlign = TextAlign.Center,
            color = if (isSelected) Color(0xFFFFFFFF) else Color(0xFFF18A90),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SubjectSelectionScreenPreview(){
    val navController = rememberNavController()
    SubjectSelection(navController = navController)
}
