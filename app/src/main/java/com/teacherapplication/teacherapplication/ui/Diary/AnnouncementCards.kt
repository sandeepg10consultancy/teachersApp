package com.teacherapplication.teacherapplication.ui.Diary

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teacherapplication.teacherapplication.R
import com.teacherapplication.teacherapplication.ui.theme.fonts
import com.teacherapplication.teacherapplication.ui.theme.italicJost
import com.teacherapplication.teacherapplication.ui.theme.jostFont
import com.teacherapplication.teacherapplication.ui.utills.blueGradient
import com.teacherapplication.teacherapplication.ui.utills.exelaGradient
import com.teacherapplication.teacherapplication.ui.utills.greenGradient
import com.teacherapplication.teacherapplication.ui.utills.pinkGradient
import com.teacherapplication.teacherapplication.ui.utills.specialGradient
import com.teacherapplication.teacherapplication.ui.utills.violetGradient

//@Preview(showBackground = true)
@Composable
fun HomeworkCard(
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier
            .width(328.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        verticalAlignment = Alignment.Top
    ){
        Box(
            modifier = Modifier
                .width(280.dp)
                .clip(RoundedCornerShape(15.dp))
                .background(
                    color = Color(0xFFF0FDFF)
                )
        ) {
            Column(
                modifier = Modifier
                    .padding(10.dp)
            ) {
                TitleBox(title = "Homework", bgGradient = blueGradient)
                Spacer(modifier = Modifier.height(3.dp))
                DetailsBox(
                    icon = R.drawable.homework_icon,
                    iconColor = Color(0xFF1775F1),
                    priority = "High",
                    bgGradient = blueGradient,
                    iconBoxColor = Color(0xFFF8FBFF)
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "Hi Nursery A explorers! \n" +
                            "\nFor your science homework, please find a small leaf or flower and upload a photo of it to our class portal. \n" +
                            "Ask an adult to help you take a picture, and don’t forget to upload it by tomorrow. We’ll look at all the photos together in class and talk about the different plants we found! I’m excited to see your discoveries! ",
                    style = TextStyle(
                        fontFamily = jostFont,
                        fontWeight = FontWeight(400),
                        fontSize = 16.sp,
                        lineHeight = 23.12.sp,
                        color = Color.Black
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 5.dp)
                )
                Text(
                    text = "11:17 am",
                    style = TextStyle(
                        fontFamily = jostFont,
                        fontWeight = FontWeight(400),
                        fontSize = 12.sp,
                        lineHeight = 15.sp,
                        color = Color(0xFF1D1751)
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.End
                )
                Spacer(modifier = Modifier.height(5.dp))
                Box(
                    modifier = Modifier
                        .height(54.dp)
                        .width(269.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(
                            brush = exelaGradient
                        )
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.elephant_button),
                            contentDescription = "elephant",
                            modifier = Modifier
                                .height(52.dp)
                                .width(47.68.dp)
                                .offset(x = 3.dp, y = 2.dp)
                        )
                        Image(
                            painter = painterResource(R.drawable.assessment_upload),
                            contentDescription = "upload",
                            modifier = Modifier
                                .size(24.dp)
                        )
                        Text(
                            text = "View Assessment",
                            style = TextStyle(
                                fontFamily = jostFont,
                                fontWeight = FontWeight(400),
                                fontSize = 16.sp,
                                lineHeight = 12.8.sp,
                                color = Color.White
                            ),
                        )
                    }
                }
            }
        }
        Image(
            painter = painterResource(R.drawable.profile_img),
            contentDescription = "profile",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )
    }
}

@Composable
fun BringToSchool(
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier
            .width(328.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        verticalAlignment = Alignment.Top
    ){
        Box(
            modifier = Modifier
                .width(280.dp)
                .clip(RoundedCornerShape(15.dp))
                .background(
                    color = Color(0xFFF0FDFF)
                )
        ) {
            Column(
                modifier = Modifier
                    .padding(10.dp)
            ) {
                TitleBox(
                    title = "Bring to School",
                    bgGradient = violetGradient
                )
                Spacer(modifier = Modifier.height(3.dp))
                DetailsBox(
                    icon = R.drawable.bring_to_school,
                    iconColor = Color(0xFF27325A),
                    iconBoxColor = Color(0xFFF1F4FF),
                    priority = "High",
                    bgGradient = violetGradient
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "                                                                   \n" +
                            "Hi Nursery A friends! \n" +
                            "\nTomorrow, we’re going to have a special show-and-tell day! Please bring your favourite stuffed animal to school. We’ll be sharing why it’s special to us and introducing our cuddly friends to the class! \n" +
                            "\n" +
                            "Don’t forget to pack it in your bag tonight so it’s ready to go in the morning. I can’t wait to meet all your furry friends! See you tomorrow!  colors.",
                    style = TextStyle(
                        fontFamily = jostFont,
                        fontWeight = FontWeight(400),
                        fontSize = 16.sp,
                        lineHeight = 23.12.sp,
                        color = Color.Black
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 5.dp)
                )
                Text(
                    text = "11:17 am",
                    style = TextStyle(
                        fontFamily = jostFont,
                        fontWeight = FontWeight(400),
                        fontSize = 12.sp,
                        lineHeight = 15.sp,
                        color = Color(0xFF1D1751)
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.End
                )
            }
        }
        Image(
            painter = painterResource(R.drawable.profile_img),
            contentDescription = "profile",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )
    }
}

@Composable
fun SpecialRequest(
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier
            .width(328.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        verticalAlignment = Alignment.Top
    ){
        Box(
            modifier = Modifier
                .width(280.dp)
                .clip(RoundedCornerShape(15.dp))
                .background(
                    color = Color(0xFFF0FDFF)
                )
        ) {
            Column(
                modifier = Modifier
                    .padding(10.dp)
            ) {
                TitleBox(
                    title = "Special Request",
                    bgGradient = specialGradient
                )
                Spacer(modifier = Modifier.height(3.dp))
                DetailsBox(
                    icon = R.drawable.special_request,
                    iconColor = Color(0xFF52A6A9),
                    iconBoxColor = Color(0xFFEAFEFF),
                    priority = "High",
                    bgGradient = specialGradient
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "Hello Nursery A families! \n" +
                            "\nWe have an important update for you. This Friday, we’ll be having a Special Activity Day in our class!  We’ll be doing some fun arts and crafts, playing games, and having a little party to celebrate all the great work we’ve been doing.\n" +
                            "Please make sure your child wears comfortable clothes that they can get a little messy in, and don’t forget to send a small snack for them to enjoy during the party. \n" +
                            "If you have any questions or need more information, feel free to reach out. We’re looking forward to a fun and exciting day with all our Nursery A stars! ",
                    style = TextStyle(
                        fontFamily = jostFont,
                        fontWeight = FontWeight(400),
                        fontSize = 16.sp,
                        lineHeight = 23.12.sp,
                        color = Color.Black
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 5.dp)
                )
                Text(
                    text = "11:17 am",
                    style = TextStyle(
                        fontFamily = jostFont,
                        fontWeight = FontWeight(400),
                        fontSize = 12.sp,
                        lineHeight = 15.sp,
                        color = Color(0xFF1D1751)
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.End
                )
            }
        }
        Image(
            painter = painterResource(R.drawable.profile_img),
            contentDescription = "profile",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )
    }
}

@Composable
fun NoticeCard(
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier
            .width(328.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        verticalAlignment = Alignment.Top
    ){
        Box(
            modifier = Modifier
                .width(280.dp)
                .clip(RoundedCornerShape(15.dp))
                .background(
                    color = Color(0xFFF0FDFF)
                )
        ) {
            Column(
                modifier = Modifier
                    .padding(10.dp)
            ) {
                TitleBox(
                    title = "Notice",
                    bgGradient = pinkGradient
                )
                Spacer(modifier = Modifier.height(3.dp))
                DetailsBox(
                    icon = R.drawable.notice,
                    iconColor = Color(0xFFFB4B8B),
                    iconBoxColor = Color(0xFFFFE0EC),
                    priority = "High",
                    bgGradient = pinkGradient
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "                                                                   \n" +
                            "Hi Nursery A friends! \n" +
                            "\nTomorrow, we’re going to have a special show-and-tell day! Please bring your favourite stuffed animal to school. We’ll be sharing why it’s special to us and introducing our cuddly friends to the class! \n" +
                            "\n" +
                            "Don’t forget to pack it in your bag tonight so it’s ready to go in the morning. I can’t wait to meet all your furry friends! See you tomorrow!  colors.",
                    style = TextStyle(
                        fontFamily = jostFont,
                        fontWeight = FontWeight(400),
                        fontSize = 16.sp,
                        lineHeight = 23.12.sp,
                        color = Color.Black
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 5.dp)
                )
                Text(
                    text = "11:17 am",
                    style = TextStyle(
                        fontFamily = jostFont,
                        fontWeight = FontWeight(400),
                        fontSize = 12.sp,
                        lineHeight = 15.sp,
                        color = Color(0xFF1D1751)
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.End
                )
            }
        }
        Image(
            painter = painterResource(R.drawable.profile_img),
            contentDescription = "profile",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )
    }
}


@Composable
private fun DetailsBox(
    icon: Int,
    iconColor: Color,
    priority: String,
    bgGradient: Brush,
    iconBoxColor: Color
) {
    Box(
        modifier = Modifier
            .height(54.dp)
            .width(269.dp)
            .clip(RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp))
            .background(
                brush = bgGradient
            ),
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp, vertical = 5.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .background(color = iconBoxColor),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(icon),
                        contentDescription = "edit",
                        tint = iconColor,
                        modifier = Modifier.size(30.dp)
                    )
                }
                Column(
                    verticalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Text(
                        text = "Science",
                        style = TextStyle(
                            fontFamily = italicJost,
                            fontWeight = FontWeight(400),
                            fontSize = 12.sp,
                            lineHeight = 17.34.sp,
                            color = Color.White
                        )
                    )
                    Text(
                        text = "1 Day left",
                        style = TextStyle(
                            fontFamily = jostFont,
                            fontWeight = FontWeight(500),
                            fontSize = 12.sp,
                            lineHeight = 9.6.sp,
                            color = Color.White
                        )
                    )
                }
            }
            Box(
                modifier = Modifier
                    .height(23.dp)
                    .width(92.dp)
                    .clip(RoundedCornerShape(18.dp))
                    .background(
                        color = Color(0xFFEF6464)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "$priority Priority",
                    style = MaterialTheme.typography.labelSmall.copy(
                        lineHeight = 15.12.sp,
                        color = Color.White
                    )
                )
            }
        }
    }
}

@Composable
private fun TitleBox(title: String, bgGradient: Brush) {
    Box(
        modifier = Modifier
            .height(32.dp)
            .width(269.dp)
            .clip(RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp))
            .background(
                brush = bgGradient
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = title,
            style = TextStyle(
                fontFamily = jostFont,
                fontWeight = FontWeight(400),
                fontSize = 14.sp,
                lineHeight = 11.2.sp,
                color = Color.White
            )
        )
    }
}


@Composable
fun HolidayAlert(
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier
            .width(328.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        verticalAlignment = Alignment.Top
    ){
        Box(
            modifier = Modifier
                .width(280.dp)
                .clip(RoundedCornerShape(15.dp))
                .background(
                    color = Color(0xFFF0FDFF)
                )
        ) {
            Column(
                modifier = Modifier
                    .padding(10.dp)
            ) {
                TitleBox(
                    title = "Holiday Alert",
                    bgGradient = greenGradient
                )
                Spacer(modifier = Modifier.height(3.dp))
                HolidayDetailsBox()
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = buildAnnotatedString {
                        append("Hi Nursery A friends!\n\nI have some exciting news! We’re going to have a holiday break next week. There will be no school from ")
                        withStyle(SpanStyle(
                            fontWeight = FontWeight(500)
                        )){
                            append("1")
                        }
                        withStyle(
                            SpanStyle(
                                baselineShift = BaselineShift.Superscript,
                            )
                        ){
                            append("st")
                        }
                        withStyle(
                            SpanStyle(
                                fontWeight = FontWeight(500)
                            )
                        ){
                            append(" Sep 2024")
                        }
                        append(" to ")
                        withStyle(SpanStyle(
                            fontWeight = FontWeight(500)
                        )){
                        append("12")
                        }
                        withStyle(
                            SpanStyle(
                                baselineShift = BaselineShift.Superscript,
                            )
                        ){
                            append("th")
                        }
                        withStyle(
                            SpanStyle(
                                fontWeight = FontWeight(500)
                            )
                        ){
                            append(" Sep 2024")
                        }
                        append("\nDuring the break, make sure to spend lots of time playing, resting, and having fun with your family! Don’t forget to read your favorite books and maybe even draw some pictures to share with the class when we return. \nWe’ll be back in school on ")
                        withStyle(SpanStyle(
                            fontWeight = FontWeight(500)
                        )){
                            append("13")
                        }
                        withStyle(
                            SpanStyle(
                                baselineShift = BaselineShift.Superscript,
                            )
                        ){
                            append("th")
                        }
                        withStyle(
                            SpanStyle(
                                fontWeight = FontWeight(500)
                            )
                        ){
                            append(" Sep 2024")
                        }
                        append("ready for more learning and adventures together! Have a wonderful holiday!")
                    },
                    style = TextStyle(
                        fontFamily = jostFont,
                        fontWeight = FontWeight(400),
                        fontSize = 16.sp,
                        lineHeight = 23.12.sp,
                        color = Color.Black
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 5.dp)
                )
                Text(
                    text = "11:17 am",
                    style = TextStyle(
                        fontFamily = jostFont,
                        fontWeight = FontWeight(400),
                        fontSize = 12.sp,
                        lineHeight = 15.sp,
                        color = Color(0xFF1D1751)
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.End
                )
            }
        }
        Image(
            painter = painterResource(R.drawable.profile_img),
            contentDescription = "profile",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )
    }
}

@Composable
private fun HolidayDetailsBox(
    icon: Int = R.drawable.holiday_alert,
    iconColor: Color = Color(0xFF438508),
    priority: String = "High",
    bgGradient: Brush = greenGradient,
    iconBoxColor: Color = Color.White,
    fromDate: String = "1st Sep 2024",
    endDate: String = "12st Sep 2024"
) {
    Box(
        modifier = Modifier
            .height(75.dp)
            .width(269.dp)
            .clip(RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp))
            .background(
                brush = bgGradient
            ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(RoundedCornerShape(6.dp))
                            .background(color = iconBoxColor),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(icon),
                            contentDescription = "edit",
                            tint = iconColor,
                            modifier = Modifier.size(30.dp)
                        )
                    }
                    Column(
                        verticalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        Text(
                            text = "Science",
                            style = TextStyle(
                                fontFamily = italicJost,
                                fontWeight = FontWeight(400),
                                fontSize = 12.sp,
                                lineHeight = 17.34.sp,
                                color = Color.White
                            )
                        )
                        Text(
                            text = "Ganesh Festival",
                            style = TextStyle(
                                fontFamily = jostFont,
                                fontWeight = FontWeight(500),
                                fontSize = 14.sp,
                                lineHeight = 11.2.sp,
                                color = Color.White
                            )
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .height(23.dp)
                        .width(92.dp)
                        .clip(RoundedCornerShape(18.dp))
                        .background(
                            color = Color(0xFFEF6464)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "$priority Priority",
                        style = MaterialTheme.typography.labelSmall.copy(
                            lineHeight = 15.12.sp,
                            color = Color.White
                        )
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text = buildAnnotatedString {
                        append("From:")
                        withStyle(style = SpanStyle(
                            fontSize = 10.sp,
                        )){
                            append(fromDate)
                        }
                    },
                    style = MaterialTheme.typography.labelSmall.copy(
                        lineHeight = 12.6.sp,
                        color = Color.White
                    )

                )
                Text(
                    text = buildAnnotatedString {
                        append("To:")
                        withStyle(style = SpanStyle(
                            fontSize = 10.sp,
                        )){
                            append(endDate)
                        }
                    },
                    style = MaterialTheme.typography.labelSmall.copy(
                        lineHeight = 12.6.sp,
                        color = Color.White
                    )

                )
            }
        }
    }
}

@Composable
fun AllCards(modifier: Modifier = Modifier){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ){
        HomeworkCard(modifier = Modifier)

        BringToSchool()

        SpecialRequest()

        NoticeCard()

        HolidayAlert()
    }
}