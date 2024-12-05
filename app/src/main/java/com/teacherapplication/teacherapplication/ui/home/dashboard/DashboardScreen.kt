package com.teacherapplication.teacherapplication.ui.home.dashboard

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.teacherapplication.teacherapplication.R
import com.teacherapplication.teacherapplication.ui.AppComponents.brush
import com.teacherapplication.teacherapplication.ui.theme.jostFont
import com.teacherapplication.teacherapplication.ui.theme.openFont
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showBackground = true)
@Composable
fun DashBoardScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: DashboardViewModel
){
    val verticalScroll = rememberScrollState()
    val isFilterClicked = rememberSaveable{ mutableStateOf(false) }
    val classesList = listOf(
        "Nursery - A", "Nursery - B", "Nursery - C",
        "Junior KG - A", "Junior KG - B", "Junior KG - C",
        "Senior KG - A", "Senior KG - B", "Senior KG - C"
    )
    val selectedSection = remember { mutableStateOf(classesList[0]) }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ProfileDrawerContent( modifier = Modifier, navController = navController,drawerState = drawerState, scope)
        }
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.elephant_slide),
                contentDescription = "elephant",
                modifier = Modifier
                    .size(320.dp)
                    .align(Alignment.TopEnd)
            )
            Scaffold(
                modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                topBar = {
                    TopAppBar(
                        navigationIcon = {
                            ProfileWithMenuIcon(
                                onOpenDrawer = {
                                    scope.launch {
                                        drawerState.apply {
                                            if (isClosed) open() else close()
                                        }
                                    }
                                }
                            )
                        },
                        title = {
                            Column(
                                modifier = Modifier
                                    .padding(start = 8.dp, top = 2.dp)
                                //.align(Alignment.Center)
                            ) {
                                Text(
                                    text = "Good Morning,",
                                    style = MaterialTheme.typography.labelSmall.copy(
                                        color = Color(0xFF129193),
                                        lineHeight = 13.2.sp
                                    ),
                                )
                                Text(
                                    text = "Chandini",
                                    style = MaterialTheme.typography.titleMedium.copy(
                                        color = Color(0xFF1D1751),
                                        fontSize = 24.sp
                                    )
                                )
                            }
                        },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = Color.Transparent,
                            titleContentColor = Color.Gray
                        ),
                        actions = {
                            IconButton(onClick = { /*TODO*/ }) {
                                Image(
                                    painter = painterResource(id = R.drawable.notification),
                                    contentDescription = "notification",
                                    modifier = Modifier.size(33.dp)
                                )
                            }
                            DropdownFilter(isFilterClicked, viewModel)
                        }
                    )
                },
                containerColor = Color.Transparent,
                content = {
                    Column(
                        modifier = Modifier.padding(it)
                            .verticalScroll(verticalScroll)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            horizontalArrangement = Arrangement.spacedBy(20.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            EachSubjectCard(
                                text = viewModel.selectedSection.collectAsState().value,
                                subject = "Art",
                                brush = viewModel.subjectColors[0],
                                yOffset = (-10).dp,
                                image = R.drawable.art_img,
                                color = Color(0xFFFDC194),
                                onClick = {
                                    navController.navigate("artChapter/${R.drawable.art_img}/Art")
                                }
                            )
                            EachSubjectCard(
                                text = viewModel.selectedSection.collectAsState().value,
                                subject = "Numeracy",
                                brush = viewModel.subjectColors[1],
                                yOffset = (-2).dp,
                                image = R.drawable.numeracy_img,
                                color = Color(0xFF99D6FC),
                                onClick = {
                                    navController.navigate("artChapter/${R.drawable.numeracy_img}/Numeracy")
                                }
                            )

                        }
                        Row(
                            modifier = Modifier.fillMaxWidth()
                                .padding(8.dp),
                            horizontalArrangement = Arrangement.spacedBy(20.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            EachSubjectCard(
                                text = viewModel.selectedSection.collectAsState().value,
                                subject = "General Awareness",
                                brush = viewModel.subjectColors[2],
                                yOffset = (-4).dp,
                                image = R.drawable.general_img,
                                color = Color(0xFF93ECFF),
                                onClick = { navController.navigate("artChapter/${R.drawable.general_img}/General Awareness") }
                            )
                            EachSubjectCard(
                                text = viewModel.selectedSection.collectAsState().value,
                                subject = "Literacy",
                                brush = viewModel.subjectColors[3],
                                yOffset = (-8).dp,
                                image = R.drawable.literacy_img,
                                color = Color(0xFFFED276),
                                onClick = { navController.navigate("artChapter/${R.drawable.literacy_img}/Literacy") }
                            )

                        }
                        Row(
                            modifier = Modifier.fillMaxWidth()
                                .padding(8.dp),
                            horizontalArrangement = Arrangement.spacedBy(20.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            EachSubjectCard(
                                text = viewModel.selectedSection.collectAsState().value,
                                subject = "GK",
                                brush = viewModel.subjectColors[4],
                                yOffset = (-0).dp,
                                image = R.drawable.gk_img,
                                color = Color(0xFFF2C0C0),
                                onClick = { navController.navigate("artChapter/${R.drawable.gk_img}/GK") }
                            )
                            MoreCard()
                        }

                        StudentAssessment()

                        Spacer(modifier = Modifier.height(20.dp))
                        Column(
                            modifier = Modifier.padding(start = 10.dp)
                        ) {
                            Text(
                                text = "Recently Viewed",
                                style = MaterialTheme.typography.titleMedium.copy(
                                    fontSize = 16.sp,
                                    lineHeight = 23.12.sp,
                                    brush = Brush.linearGradient(
                                        colors = listOf(
                                            Color(0xFF185573),
                                            Color(0xFF14868D)
                                        )
                                    )
                                ),
                            )
                            Box(
                                modifier = modifier
                                    .width(27.dp)
                                    .height(1.5.dp)
                                    .clip(RoundedCornerShape(1.5.dp))
                                    .border(0.1.dp, Color(0xFF1D1751), RoundedCornerShape(1.5.dp))
                                    .background(
                                        brush = Brush.linearGradient(
                                            colors = listOf(
                                                Color(0xFF185573),
                                                Color(0xFF14868D)
                                            )
                                        ),
                                    )
                            )
                        }
                        if (isFilterClicked.value) {
                            SectionBottomSheet(isFilterClicked, classesList, viewModel)
                        }
                    }

                },
                bottomBar = {
                    BottomNavigationBar(navController, viewModel)
                }
            )
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun SectionBottomSheet(
    isFilterClicked: MutableState<Boolean>,
    classesList: List<String>,
    viewModel: DashboardViewModel
) {
    val sheetState = rememberModalBottomSheetState()
    ModalBottomSheet(
        sheetState = sheetState,
        onDismissRequest = { isFilterClicked.value = false },
        dragHandle = { BottomSheetDefaults.ExpandedShape },
        containerColor = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(30.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Select Class",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Black
                )
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "close",
                    modifier = Modifier
                        .size(32.dp)
                        .clickable { isFilterClicked.value = false }
                )
            }

            HorizontalDivider(
                thickness = 1.dp,
                color = Color(0xFFDEDEDE)
            )
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(30.dp),
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                items(classesList) { name ->
                    Box(
                        modifier = Modifier
                            .height(60.dp)
                            .width(366.dp)
                            .border(
                                width = 2.dp,
                                color = Color(0xFF1D1751),
                                shape = RoundedCornerShape(8.dp)
                            )
                            .clickable {
//                                selectedSection.value = name
                                viewModel.setSelectedSection(name)
                                isFilterClicked.value = false
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = name,
                            style = TextStyle(
                                fontFamily = jostFont,
                                fontWeight = FontWeight(500),
                                fontSize = 18.sp,
                                lineHeight = 23.4.sp,
                                color = Color(0xFF1D1751),
                            ),
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController, viewModel: DashboardViewModel) {

    val selectedItem = viewModel.selectedIcon.collectAsState().value


    // List of navigation items with their labels and icons
    val navItems = listOf(
        "Home" to if (selectedItem == "Home") R.drawable.home_icon else R.drawable.home_bw_icon,
        "Calender" to if (selectedItem == "Calender") R.drawable.calender_icon else R.drawable.calender_bw_icon,
        "Diary" to if (selectedItem == "Diary") R.drawable.diary_icon else R.drawable.diary_bw_icon
    )

    NavigationBar(
        containerColor = Color.White,
    ) {
        navItems.forEach { (label, iconRes) ->
            val isSelected = (selectedItem == label)
            NavigationBarItem(
                selected = isSelected,
                icon = {
                    Image(
                        painter = painterResource(iconRes),
                        contentDescription = label
                    )
                },
                label = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = label,
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontSize = if (isSelected) 14.sp else 12.sp,
                                fontWeight = FontWeight(if (selectedItem == label) 600 else 500),
                                lineHeight = if (selectedItem == label) 20.23.sp else 17.34.sp,
                                brush = Brush.linearGradient(
                                    colors = if (isSelected) listOf(
                                        Color(0xFF185573),
                                        Color(0xFF14868D)
                                    ) else listOf(
                                        Color(0xFF000000),
                                        Color(0xFF000000)
                                    )
                                )
                            )
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        if (isSelected) {
                            Box(
                                modifier = Modifier
                                    .width(89.dp)
                                    .height(6.dp)
                                    .clip(RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
                                    .background(
                                        brush = brush
                                    )
                            )
                        }
                    }
                },
                onClick = {
                        viewModel.setSelectedIcon(label)
                    val destination = when (label) {
                        "Home" -> "dashboard"
                        "Calender" -> "newGroupScreen"
                        "Diary" -> "dairyScreen"
                        else -> "dashboard"
                    }
                    navController.navigate(destination) {
                        // Avoid multiple copies of the same destination in the back stack
                        launchSingleTop = true
                        restoreState = true
                    }
                          },
                colors = NavigationBarItemColors(
                    selectedIconColor = Color.Transparent,
                    selectedTextColor = Color.Transparent,
                    selectedIndicatorColor = Color.Transparent,
                    unselectedIconColor = Color.Transparent,
                    unselectedTextColor = Color.Transparent,
                    disabledIconColor = Color.Transparent,
                    disabledTextColor = Color.Transparent
                )
            )
        }
//        if(selectedItem == "Home"){
//            navController.navigate(route = "dashboard")
//        }else if (selectedItem == "Calender"){
//            navController.navigate(route = "dashboard")
//        }else{
//            navController.navigate(route = "dairyScreen")
//        }
    }

}


@Composable
private fun StudentAssessment() {
    Box(
        modifier = Modifier
            .width(386.dp)
            .height(170.7.dp)
    ) {
        Box(
            modifier = Modifier
                .height(138.dp)
                .width(386.dp)
                .align(Alignment.BottomCenter)
                .padding(10.dp)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFF185573),
                            Color(0xFF14868D)
                        )
                    ),
                    shape = RoundedCornerShape(13.dp)
                )
        ) {
            Canvas(
                modifier = Modifier
                    .size(172.dp)
                    .offset(x = 140.dp, y = (-50).dp)

            ) {
                drawCircle(
                    color = Color.White.copy(alpha = 0.1f),
                    radius = size.width / 2.0f,
                    alpha = 0.4f
                )
            }
            Canvas(
                modifier = Modifier
                    .size(172.dp)
                    .offset(x = 225.dp, y = 40.dp)

            ) {
                drawCircle(
                    color = Color.White.copy(alpha = 0.2f),
                    radius = size.width / 2.0f,
                    alpha = 0.4f
                )
            }
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(13.dp)),
                color = Color.Transparent,
                shape = RoundedCornerShape(13.dp),
            ) {
                Column(
                    modifier = Modifier
                        .offset(x = 60.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = Color(0xFFFFFFFF),
                                    fontFamily = jostFont,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight(400)
                                )
                            ) {
                                append("It's time to ")
                            }
                            withStyle(
                                style = SpanStyle(
                                    color = Color(0xFFFFFFFF),
                                    fontFamily = jostFont,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight(500)
                                )
                            ) {
                                append("grade!")
                            }
                        }
                    )
                    Text(
                        text = "Student Assessments",
                        style = MaterialTheme.typography.titleSmall.copy(
                            color = Color(0xFFFFFFFF),
                            fontSize = 22.sp,
                            lineHeight = 17.6.sp
                        )
                    )
                    Box(
                        modifier = Modifier
                            .size(38.17.dp)
                            .clip(CircleShape)
                            .background(
                                brush = Brush.linearGradient(
                                    colors = listOf(
                                        Color(0xFF185573),
                                        Color(0xFF14868D)
                                    )
                                )
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                            contentDescription = "Arrow",
                            tint = Color.White,
                            modifier = Modifier
                                .size(25.dp)
                                .clickable {

                                }
                        )
                    }
                }
            }
        }
        Image(
            painter = painterResource(R.drawable.elephant_balloon),
            contentDescription = "elephant",
            modifier = Modifier
                .height(170.7.dp)
                .width(127.dp)
                .offset(x = 25.dp, y = 18.5.dp)

        )
    }
}

@Composable
private fun MoreCard() {
    Card(
        modifier = Modifier
            .height(117.dp)
            .width(181.dp)
            .padding(top = 5.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF1F1F1)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "More",
                    style = MaterialTheme.typography.titleSmall.copy(
                        fontSize = 22.sp,
                        lineHeight = 24.2.sp,
                        color = Color(0xFF1D1751)
                    )
                )
                Icon(
                    painter = painterResource(R.drawable.more_icon),
                    contentDescription = "icon",
                    modifier = Modifier.clickable {

                    }
                )
            }
            Text(
                text = "View All Subjects",
                style = MaterialTheme.typography.labelSmall.copy(
                    lineHeight = 13.2.sp,
                    color = Color(0xFF1D1751)
                )
            )
        }
    }
}

@Composable
private fun EachSubjectCard(
    text: String,
    subject: String,
    brush: Brush,
    yOffset: Dp = 0.dp,
    image: Int,
    color: Color,
    onClick: () -> Unit = { }
) {
    Box(
        modifier = Modifier
            .height(125.dp)
            .width(181.dp)
    ) {
        Card(
            modifier = Modifier
                .height(117.dp)
                .width(181.dp)
                .align(Alignment.BottomCenter)
                .clip(RoundedCornerShape(13.dp))
                .background(
                    brush = brush,
                ),
            colors = CardDefaults.cardColors(
                containerColor = Color.Transparent
            ),
            onClick = onClick
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(19.dp),
                verticalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = text,
                    style = MaterialTheme.typography.labelSmall.copy(
                        fontSize = 10.sp,
                        fontWeight = FontWeight(600),
                        lineHeight = 11.sp,
                        color = Color(0xFFFFFFFF)
                    )
                )
                Column {
                    Text(
                        text = "20 Chapters",
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontSize = 10.sp,
                            fontWeight = FontWeight(600),
                            lineHeight = 11.sp,
                            color = Color(0xFFFFFFFF)
                        )
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    LinearProgressIndicator(
                        progress = { 0.5f },
                        color = Color(0xFFFFFFFF),
                        trackColor = color,
                        modifier = Modifier
                            .height(5.dp)
                            .width(135.dp)
                            .clip(RoundedCornerShape(40.dp))
                    )
                }
            }
        }
        Image(
            painter = painterResource(image),
            contentDescription = "art",
            modifier = Modifier
                .size(80.dp)
                .scale(1.2f)
                .align(Alignment.TopEnd)
                .offset(x = 0.dp, y = yOffset)
        )
        Text(
            text = subject,
            style = MaterialTheme.typography.titleSmall.copy(
                fontSize = 22.sp,
                lineHeight = 24.2.sp,
                color = Color(0xFFFFFFFF)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(19.dp)
                .offset(x = 0.dp, y = 20.dp),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

    }
}



@Composable
private fun DropdownFilter(
    isFilterClicked: MutableState<Boolean>,
    viewModel: DashboardViewModel
) {
    Box(
        modifier = Modifier
            .height(35.dp)
            .width(112.dp)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFF185573), Color(0xFF14868D)),
                    start = Offset(0f, 0f),
                    end = Offset(Float.POSITIVE_INFINITY, 0f)
                ),
                shape = RoundedCornerShape(8.dp)
            )
            .clickable {
                isFilterClicked.value = true
            },
    ){
        Row(
            modifier = Modifier.fillMaxSize()
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = viewModel.selectedSection.collectAsState().value,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color(0xFFFFFFFF)
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.weight(1f)
            )
            Icon(painter = painterResource(R.drawable.expand) ,
                contentDescription = "filter",
                tint = Color(0xFFFFFFFF),
                modifier = Modifier
                    .size(24.dp)
            )
        }
    }

}


@Composable
fun ProfileWithMenuIcon(
    onOpenDrawer: () -> Unit
) {
    Box(
        modifier = Modifier
            .height(50.dp)
            .width(51.dp)
            .clickable {
                onOpenDrawer()
            },
        contentAlignment = Alignment.BottomEnd
    ) {
        // Profile Image
        Image(
            painter = painterResource(id = R.drawable.profile_img),
            contentDescription = "Profile Image",
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
        )
        // Menu Icon
        Surface(
            modifier = Modifier
                .size(20.dp)
                .offset(x = 5.dp, y = 7.dp),
            shape = CircleShape,
        ){
            Box(
                modifier = Modifier.background(brush = Brush.linearGradient(
                    colors = listOf(Color(0xFF129193), Color(0xFF062C2D)),
                ))
            ){
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Menu Icon",
                    tint = Color(0xFFFFFFFF),
                    modifier = Modifier
                        .padding(3.dp)
                        .size(15.dp)
                )

            }

        }
    }
}


@Composable
fun ProfileDrawerContent(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    drawerState: DrawerState,
    scope: CoroutineScope
){
    val iconsList = listOf(
        "Profile" to R.drawable.profile_icon,
        "Student Performance" to R.drawable.performance_graph,
        "Bookmarks" to R.drawable.bookmarks,
        "FAQ'S" to R.drawable.faqs,
        "Privacy Policy" to R.drawable.policy,
        "Logout" to R.drawable.log_out
    )
    var showLogoutDialog by remember { mutableStateOf(false) }
    Box(
        modifier = modifier
            .fillMaxHeight()
            .width(301.dp)
            .background(
                brush = brush
            ),
        contentAlignment = Alignment.Center
    ){
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(start = 20.dp, top = 20.dp)
        ){
            Icon(
                painter = painterResource(R.drawable.close),
                contentDescription = "close",
                tint = Color.White,
                modifier = Modifier
                    .size(20.dp)
                    .clickable {
                        scope.launch {
                            drawerState.close()
                        }
                    }
            )
            Spacer(modifier = Modifier.height(20.dp))
            ProfileCard()
            Spacer(modifier = Modifier.height(10.dp))
            iconsList.forEach { item ->
                NavigationDrawerItem(
                    icon = {
                        Icon(
                            painter = painterResource(item.second),
                            contentDescription = item.first,
                            tint = Color.White,
                            modifier = Modifier
                                .size(24.dp)
                        )
                    },
                    label = {
                        Text(
                            text = item.first,
                            style = TextStyle(
                                fontFamily = openFont,
                                fontWeight = FontWeight(600),
                                fontSize = 18.sp,
                                lineHeight = 18.sp,
                                color = Color.White
                            )
                        )
                    },
                    selected = false,
                    onClick = {
                        when(item.first){
                            "Profile" -> { navController.navigate(route = "profileScreen")}
                            "Student Performance" -> { }
                            "Bookmarks" -> { navController.navigate(route = "bookmarksScreen")}
                            "FAQ'S" -> { navController.navigate(route = "faqScreen")}
                            "Privacy Policy" -> { }
                            "Logout" -> { showLogoutDialog = true }

                        }
                    },
                    colors = NavigationDrawerItemDefaults.colors(
                        selectedContainerColor = Color.Transparent,
                        unselectedContainerColor = Color.Transparent,
                    )
                )
            }
            Spacer(modifier = Modifier.height(310.dp))
            Button(
                onClick = { },
                modifier = Modifier
                    .height(47.dp)
                    .width(258.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ){
                    Icon(
                        painter = painterResource(R.drawable.help_icon),
                        contentDescription = "help",
                        tint = Color.Black,
                        modifier = Modifier
                            .width(23.91.dp)
                            .height(28.dp)
                    )
                    Text(
                        text = "Help",
                        style = TextStyle(
                            fontFamily = openFont,
                            fontWeight = FontWeight(600),
                            fontSize = 16.sp,
                            lineHeight = 16.sp,
                            letterSpacing = (-0.02).sp,
                            color = Color.Black
                        )
                    )
                }
            }
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "V 0.1.0",
                style = TextStyle(
                    fontFamily = openFont,
                    fontWeight = FontWeight(600),
                    fontSize = 16.sp,
                    lineHeight = 16.sp,
                    letterSpacing = (-0.02).sp,
                    color = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, top = 5.dp)
            )
            if (showLogoutDialog){
                LogoutDialogBox(onDismiss = { showLogoutDialog = false })
            }
        }
        Image(
            painter = painterResource(R.drawable.elephant_color),
            contentDescription = "elephant",
            modifier = Modifier
                .offset(x = (-25).dp,y = 150.dp)
                .height(327.02.dp)
                .width(350.dp)
                .scale(1.1f)
                .alpha(0.6f)
        )
    }
}

@Composable
private fun ProfileCard() {
    Card(
        modifier = Modifier
            .height(81.dp)
            .width(259.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(10.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Canvas(
                modifier = Modifier
                    .size(243.dp)
                    .offset(250.dp, 0.dp)
            ) {
                drawCircle(
                    color = Color(0xFFD9F9FF),
                    radius = size.width / 2f,
                    center = Offset(0f, 0f)
                )
            }
            Canvas(
                modifier = Modifier
                    .size(186.dp)
                    .offset(165.dp, 0.dp)
            ) {
                drawCircle(
                    color = Color(0xFFD9F9FF).copy(alpha = 0.6f),
                    radius = size.width / 2f,
                    center = Offset(0f, 0f)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 22.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.profile_img),
                    contentDescription = "image",
                    modifier = Modifier
                        .size(45.dp)
                        .clip(CircleShape)
                )
                Column {
                    Text(
                        text = "Chandani Poosarla",
                        style = TextStyle(
                            fontFamily = openFont,
                            fontWeight = FontWeight(600),
                            fontSize = 16.sp,
                            lineHeight = 21.78.sp,
                            letterSpacing = (-0.02).sp,
                            color = Color(0xFF1D1751)
                        )
                    )
                    Text(
                        text = "abc@gmail.com",
                        style = TextStyle(
                            fontFamily = openFont,
                            fontWeight = FontWeight(400),
                            fontSize = 14.sp,
                            lineHeight = 19.07.sp,
                            letterSpacing = (-0.02).sp,
                            color = Color(0xFF5A5A5A)
                        )
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LogoutDialogBox(onDismiss: () -> Unit) {
    BasicAlertDialog(
        onDismissRequest = onDismiss,
        modifier = Modifier
            .height(279.dp)
            .fillMaxWidth()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(15.dp)
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ){
            Image(
                painter = painterResource(R.drawable.logout_alert),
                contentDescription = "logout",
                modifier = Modifier
                    .size(80.dp)
            )
            Text(
                text = "Are you sure you want to log out?",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight(500),
                    color = Color.Black.copy(alpha = 0.8f)
                )
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ){
                Button(
                    onClick = onDismiss,
                    modifier = Modifier
                        .height(54.dp)
                        .fillMaxWidth(0.5f)
                        .border(
                            width = 1.dp,
                            brush = brush,
                            shape = RoundedCornerShape(4.dp)
                        ),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    )
                ) {
                    Text(
                        text = "Cancel",
                        style = TextStyle(
                            fontFamily = openFont,
                            fontWeight = FontWeight(600),
                            fontSize = 16.sp,
                            lineHeight = 36.sp,
                            brush = brush
                        )
                    )
                }
                Box(
                    modifier = Modifier
                        .width(160.dp)
                        .height(54.dp)
                        .background(
                            brush = brush,
                            shape = RoundedCornerShape(4.dp)
                        )
                ){
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Image(
                            painter = painterResource(R.drawable.elephant_button),
                            contentDescription = "elephant"
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "Yes",
                            style = TextStyle(
                                fontFamily = openFont,
                                fontWeight = FontWeight(600),
                                fontSize = 16.sp,
                                lineHeight = 36.sp,
                                color = Color.White
                            ),
                        )
                    }
                }
            }
        }
    }
}


