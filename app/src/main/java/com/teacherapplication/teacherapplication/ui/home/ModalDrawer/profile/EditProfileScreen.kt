package com.teacherapplication.teacherapplication.ui.home.ModalDrawer.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.teacherapplication.teacherapplication.R
import com.teacherapplication.teacherapplication.ui.AppComponents.BackArrow
import com.teacherapplication.teacherapplication.ui.AppComponents.ProfileTextFieldBox
import com.teacherapplication.teacherapplication.ui.login.account.SectionCard
import com.teacherapplication.teacherapplication.ui.login.account.SubjectCard
import com.teacherapplication.teacherapplication.ui.login.account.sectionName
import com.teacherapplication.teacherapplication.ui.theme.jostFont
import com.teacherapplication.teacherapplication.ui.theme.openFont
import com.teacherapplication.teacherapplication.ui.utills.exelaGradient


@Composable
fun EditProfileScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
){
    val scrollState = rememberScrollState()
    val firstName = remember { mutableStateOf("Chandani") }
    val lastName = remember { mutableStateOf("Poosarla") }
    val phoneNumber = remember { mutableStateOf("9890000000") }
    val genderChecked = remember { mutableStateOf(true) }
    val genderValue = remember { mutableStateOf("Female") }
    val schoolCode = remember { mutableStateOf("1313") }
    val schoolName = remember { mutableStateOf("Exela pvt.school ") }
    val classesMap = mapOf("Nursery" to R.drawable.nursery_img,
        "Junior KG" to R.drawable.junior_kg_img,
        "Senior KG" to R.drawable.senior_kg_img
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 15.dp, top = 40.dp, end = 15.dp)
            .verticalScroll(scrollState)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                BackArrow(onClick = { navController.popBackStack() })
                Text(
                    text = "Back",
                    style = TextStyle(
                        fontFamily = openFont,
                        fontWeight = FontWeight(600),
                        fontSize = 12.sp,
                        lineHeight = 16.34.sp,
                        letterSpacing = 0.03.sp,
                        color = Color.Black
                    )
                )
            }
            Box(
                modifier = Modifier
                    .height(40.dp)
                    .width(120.dp)
                    .background(
                        brush = exelaGradient,
                        shape = RoundedCornerShape(4.dp)
                    )
                    .clickable {

                    },
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Image(
                        painter = painterResource(R.drawable.elephant_button),
                        contentDescription = "elephant",
                    )
                    Text(
                        text = "Save",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontSize = 16.sp,
                            lineHeight = 36.sp,
                            color = Color.White
                        )
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
        ProfileEditing(Modifier.align(Alignment.CenterHorizontally))

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Chandani Poosarla",
            style = MaterialTheme.typography.titleMedium.copy(
                brush = exelaGradient,
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
        ProfileTextFieldBox(
            subTitle = "First Name",
            fieldValue = firstName
        )
        Spacer(modifier = Modifier.height(10.dp))
        ProfileTextFieldBox(
            subTitle = "Last Name",
            fieldValue = lastName
        )
        Spacer(modifier = Modifier.height(10.dp))
        ProfileTextFieldBox(
            subTitle = "Phone Number",
            fieldValue = phoneNumber
        )
        Spacer(modifier = Modifier.height(10.dp))
        GenderField(genderChecked, genderValue)
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Teaching Details",
            style = MaterialTheme.typography.titleMedium,
            color = Color.Black,
        )
        Spacer(modifier = Modifier.height(10.dp))
        ProfileTextFieldBox(
            subTitle = "School Code",
            fieldValue = schoolCode
        )
        Spacer(modifier = Modifier.height(10.dp))
        SchoolNameField(schoolName)
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Classes & Subjects",
            style = TextStyle(
                fontFamily = jostFont,
                fontWeight = FontWeight(400),
                fontSize = 16.sp,
                lineHeight = 23.12.sp,
                color = Color.Black
            )
        )
        Spacer(modifier = Modifier.height(20.dp))
        classesMap.forEach{ (key, value) ->
            ClassSectionSelectionCard(name = key, image = value)
            Spacer(modifier = Modifier.height(20.dp))
        }
        Spacer(modifier = Modifier.height(100.dp))
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ClassSectionSelectionCard(name: String, image:Int){
    var sectionSwitch by remember { mutableStateOf(false) }
    val subjectsList = listOf("Mathematics", "Science","Reading", "Writing","Social Studies", "Drawing","Mathematics","Science","Reading","Writing")
    val isAllSubjectSelected = remember { mutableStateOf(false) }
    val sections = listOf("Section - A", "Section - B", "Section - C", "Section - D", "Section - E")

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF5F5F5)
        )
    ){
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 15.dp, end = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Row(
                horizontalArrangement = Arrangement.spacedBy(15.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = painterResource(image),
                    contentDescription = "nursery",
                    modifier = Modifier
                        .clip(RoundedCornerShape(5.dp))
                        .size(54.dp)
                )
                Column {
                    Text(text = name,
                        style = MaterialTheme.typography.titleMedium.copy(
                            lineHeight = 23.4.sp
                        )
                    )
                    Text(text = sectionName,
                        style = MaterialTheme.typography.labelMedium.copy(
                            lineHeight = 18.2.sp,
                            color = Color(0xFF5A5A5A)
                        )
                    )
                }
            }
            Switch(
                checked = sectionSwitch,
                onCheckedChange = { sectionSwitch = !sectionSwitch},
                modifier = Modifier
                    .height(26.dp)
                    .width(43.dp),
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.White,
                    uncheckedThumbColor = Color.White,
                    checkedTrackColor = Color(0xFF129193),
                    uncheckedTrackColor = Color(0xFFC4C4C4),
                    uncheckedBorderColor = Color.Transparent,
                )
            )
        }
    }
    if (sectionSwitch) {
        Spacer(modifier = Modifier.height(20.dp))
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ){
            sections.forEach { section ->
                SectionCard(sec = section)
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        SelectSubjectsSection(subjectsList, isAllSubjectSelected)
    }
}

@Composable
private fun SelectSubjectsSection(
    subjectsList: List<String>,
    isAllSubjectSelected: MutableState<Boolean>
) {
    val selectedSubject = remember { mutableStateOf("") }
    val selectedSubjectsList = remember { mutableStateListOf<String>() }

    Column {
        Text(
            text = "Select Subjects",
            style = TextStyle(
                fontFamily = jostFont,
                fontWeight = FontWeight(400),
                fontSize = 16.sp,
                lineHeight = 23.12.sp,
                color = Color.Black
            )
        )
        Spacer(modifier = Modifier.height(20.dp))
        subjectsList.chunked(2).forEach { rowItems ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ){
                rowItems.forEach { item ->
                    SubjectCard(
                        name = item,
                        allSubject = isAllSubjectSelected.value,
                        selectedSubject = selectedSubject,
                        selectedSubjectsList = selectedSubjectsList
                    )
                }
                if (rowItems.size < 2) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = isAllSubjectSelected.value,
                onCheckedChange = { isAllSubjectSelected.value = !isAllSubjectSelected.value },
                colors = CheckboxDefaults.colors(
                    uncheckedColor = Color(0xFF129193),
                    checkedColor = Color(0xFF129193)
                )
            )
            Text(
                text = "Select all Subjects",
                fontSize = 14.sp,
                fontWeight = FontWeight(500)
            )
        }
    }
}


@Composable
private fun SchoolNameField(schoolName: MutableState<String>) {
    Column(
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Text(
            text = "School Name",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Black,
        )
        OutlinedTextField(
            value = schoolName.value,
            onValueChange = { schoolName.value = it },
            textStyle = MaterialTheme.typography.bodySmall.copy(
                color = Color.Black,
            ),
            readOnly = true,
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
                .border(
                    width = 2.dp,
                    brush = exelaGradient,
                    shape = RoundedCornerShape(6.dp)
                ),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = Color.Transparent,
                focusedContainerColor = Color(0xFF129193).copy(alpha = 0.05f),
                unfocusedContainerColor = Color(0xFF129193).copy(alpha = 0.05f),
            )
        )
    }
}

@Composable
fun GenderField(
    genderChecked: MutableState<Boolean>,
    genderValue: MutableState<String>
) {

    Column(
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ){
        Text(
            text = "Gender",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Black,
        )
        Box(
            modifier = Modifier
                .height(52.dp)
                .fillMaxWidth()
                .border(
                    width = 2.dp,
                    brush = exelaGradient,
                    shape = RoundedCornerShape(6.dp)
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(end = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                OutlinedTextField(
                    value = if (genderChecked.value) genderValue.value else "Male",
                    onValueChange = { genderValue.value = it },
                    textStyle = MaterialTheme.typography.bodySmall.copy(
                        color = Color.Black,
                    ),
                    modifier = Modifier
                        .fillMaxWidth(0.65f)
                        .fillMaxHeight(),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color.Transparent,
                        focusedBorderColor = Color.Transparent,
                    ),
                    readOnly = true
                )
                Row(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Icon(
                        painter = painterResource(R.drawable.male_color_img),
                        contentDescription = "Male",
                        tint = if (genderChecked.value) Color.Black.copy(alpha = 0.3f) else Color(0xFF4DB4F8),
                        modifier = Modifier
                            .size(18.86.dp)
                    )
                    Switch(
                        checked = genderChecked.value,
                        onCheckedChange = { genderChecked.value = it },
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = Color.White,
                            uncheckedThumbColor = Color.White,
                            checkedTrackColor = Color(0xFFFF499C),
                            uncheckedTrackColor = Color(0xFF4DB4F8),
                            uncheckedBorderColor = Color(0xFF4DB4F8),
                        ),
                        modifier = Modifier
                            .height(18.86.dp)
                            .width(39.43.dp)
                            .border(
                                width = 1.71.dp,
                                color = Color.Transparent,
                                shape = RoundedCornerShape(85.71.dp)
                            )
                    )
                    Icon(
                        painter = painterResource(R.drawable.female_color_img),
                        contentDescription = "Female",
                        tint = if (genderChecked.value) Color(0xFFFF499C) else Color.Black.copy(alpha = 0.3f),
                        modifier = Modifier
                            .size(18.86.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EditProfileScreenPreview(){
    val navController = rememberNavController()
    EditProfileScreen(
        navController = navController,
    )
}