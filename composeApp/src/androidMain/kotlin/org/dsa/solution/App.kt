package org.dsa.solution

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationDefaults
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.ProgressIndicatorDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import miniproject.composeapp.generated.resources.Res
import miniproject.composeapp.generated.resources.background
import miniproject.composeapp.generated.resources.headphones
import miniproject.composeapp.generated.resources.setting
import miniproject.composeapp.generated.resources.talyerSwift
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        var selectedItem by remember { mutableStateOf(0) }
        val items = listOf("Home", "Profile", "Favorite", "Settings")
        val icons = listOf(
            Icons.Default.Home,
            Icons.Default.Person,
            Icons.Default.FavoriteBorder,
            Icons.Default.Settings
        )

        Scaffold(bottomBar = {
            BottomNavigation(windowInsets = BottomNavigationDefaults.windowInsets) {
                items.forEachIndexed { index, item ->
                    BottomNavigationItem(icon = {
                        Icon(
                            imageVector = icons[index],
                            contentDescription = null,
                            tint = if (selectedItem == index) Color.Blue else Color.White
                        )
                    },
                        label = { Text(item) },
                        selected = selectedItem == index,
                        onClick = { selectedItem = index })
                }
            }
        }) { innerPadding ->
            Box(modifier = Modifier) {
                when (selectedItem) {
                    0 -> Home()
                    1 -> Profile()
                    2 -> Favorite()
                    3 -> Setting()
                }
            }
        }

    }
}


@Composable
fun Home() {
    Box(modifier = Modifier.fillMaxSize()) {

/*        Image(
            painter = painterResource(Res.drawable.uione),
            modifier = Modifier.fillMaxSize(),
            alpha = 0.2f,
            contentDescription = null,
            contentScale = ContentScale.Fit
        )*/

        LazyColumn(modifier = Modifier.fillMaxSize()) {

            item { Spacer(modifier = Modifier.height(60.dp)) }

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(Res.drawable.headphones),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp),
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            "Luister",
                            style = MaterialTheme.typography.h6,
                            fontWeight = FontWeight.W900
                        )
                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = null,
                            modifier = Modifier
                                .border(
                                    1.dp, color = Color.Gray, CircleShape
                                )
                                .padding(5.dp)
                                .size(25.dp),
                            tint = Color.Gray
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Image(
                            painter = painterResource(Res.drawable.background),
                            contentDescription = null,
                            modifier = Modifier
                                .border(1.dp, color = Color.Blue, CircleShape)
                                .clip(CircleShape)
                                .size(45.dp),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }

//                Spacer(modifier = Modifier.height(.dp))

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 10.dp)
                ) {
                    Text(
                        "Top Artist",
                        style = MaterialTheme.typography.h6,
                        fontWeight = FontWeight.W900
                    )
                }
            }

            item {
                LazyRow(
                    modifier = Modifier.padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(5) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Image(
                                painter = painterResource(Res.drawable.background),
                                contentDescription = null,
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .size(80.dp),
                                contentScale = ContentScale.Crop
                            )

                            Text(
                                "Justin",
                                style = MaterialTheme.typography.subtitle2,
                                modifier = Modifier.padding(top = 2.dp),
                                fontWeight = FontWeight.Bold,
                                letterSpacing = 2.sp
                            )
                        }
                    }
                }
            }

            item { Spacer(modifier = Modifier.height(8.dp)) }

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 10.dp)
                ) {
                    Text(
                        "New Album",
                        style = MaterialTheme.typography.h6,
                        fontWeight = FontWeight.W900
                    )
                }
            }


            item {
                Box(
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .fillMaxWidth()
                ) {

                    Image(
                        painter = painterResource(Res.drawable.background),
                        contentDescription = null,
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.dp))
                            .aspectRatio(16f / 7f),
                        contentScale = ContentScale.Crop
                    )

                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(horizontal = 20.dp, vertical = 10.dp)
                    ) {
                        Column {
                            Text(
                                "Today Justin Briber new Song",
                                style = MaterialTheme.typography.subtitle2,
                                color = Color.White
                            )
                            Text(
                                "New Album",
                                style = MaterialTheme.typography.subtitle2,
                                color = Color.White
                            )
                        }
                    }

                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(20.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.PlayArrow,
                            contentDescription = null,
                            modifier = Modifier
                                .clip(CircleShape)
                                .border(1.dp, Color.White, CircleShape)
                                .background(Color.White)
                                .padding(3.dp)
                        )
                    }

                }
            }

            item { Spacer(modifier = Modifier.height(12.dp)) }

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 10.dp)
                ) {
                    Text(
                        "Recently Played",
                        style = MaterialTheme.typography.h5,
                        fontWeight = FontWeight.W800
                    )
                }
            }

            item {
                LazyRow(
                    modifier = Modifier.padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(6) {
                        Column(modifier = Modifier.padding(top = 4.dp, end = 4.dp)) {
                            Box(modifier = Modifier) {
                                Image(
                                    painter = painterResource(Res.drawable.background),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(20.dp))
                                        .size(115.dp),
                                    contentScale = ContentScale.Crop,
                                )

                                Box(
                                    modifier = Modifier
                                        .align(Alignment.Center)
                                        .padding(20.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.PlayArrow,
                                        contentDescription = null,
                                        modifier = Modifier
                                            .clip(CircleShape)
                                            .border(1.dp, Color.White, CircleShape)
                                            .background(Color.White)
                                            .padding(3.dp)
                                    )
                                }

                            }

                            Text(
                                "style",
                                style = MaterialTheme.typography.subtitle2,
                                modifier = Modifier.padding(top = 5.dp),
                                fontWeight = FontWeight.Bold,
                                letterSpacing = 2.sp
                            )

                            Text(
                                "This is new Album",
                                style = MaterialTheme.typography.subtitle2,
                                modifier = Modifier.width(105.dp),
                                fontWeight = FontWeight.Bold,
                                letterSpacing = 2.sp,
                                overflow = TextOverflow.Ellipsis,
                                lineHeight = 15.sp
                            )
                        }
                    }
                }
            }

            item { Spacer(modifier = Modifier.height(60.dp)) }

        }

    }
}

@Composable
fun Profile() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {

/*        Image(
            painter = painterResource(Res.drawable.profile),
            modifier = Modifier.fillMaxSize(),
            alpha = 0.2f,
            contentDescription = null,
            contentScale = ContentScale.Fit
        )*/

        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            item {
                Spacer(modifier = Modifier.height(60.dp))
            }

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = null,
                        modifier = Modifier.size(25.dp),
                        tint = Color.White
                    )


                    Text(
                        "Recently played",
                        style = MaterialTheme.typography.h6,
                        color = Color.White,
                        fontWeight = FontWeight.W900
                    )


                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = null,
                        modifier = Modifier
                            .size(25.dp)
                            .rotate(90f),
                        tint = Color.White
                    )
                }
            }

            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                ) {
                    Image(
                        painter = painterResource(Res.drawable.background),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .aspectRatio(16f / 17f)
                            .clip(
                                RoundedCornerShape(20.dp)
                            )
                    )

                    Box(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(bottom = 120.dp)
                    ) {
                        Text(
                            "Recently played",
                            style = MaterialTheme.typography.subtitle2,
                            color = Color.White,
                            fontWeight = FontWeight.W900
                        )
                    }
                }
            }

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(horizontalAlignment = Alignment.Start) {
                        Text(
                            "Style",
                            style = MaterialTheme.typography.h6,
                            color = Color.White,
                            fontWeight = FontWeight.W900,
                            modifier = Modifier.padding(vertical = 10.dp),
                            letterSpacing = 1.sp
                        )

                        Text(
                            "About Album",
                            color = Color.White,
                            style = MaterialTheme.typography.subtitle1
                        )
                    }


                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        tint = Color.White,
                        contentDescription = null
                    )
                }
            }

            item {
                var progress by remember { mutableStateOf(0.6f) }
                val animatedProgress by animateFloatAsState(
                    targetValue = progress,
                    animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 10.dp)
                ) {
                    LinearProgressIndicator(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.LightGray),
                        progress = animatedProgress,
                        strokeCap = StrokeCap.Butt
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Text("0.0", style = MaterialTheme.typography.subtitle2, color = Color.White)
                    Text("-5.45", style = MaterialTheme.typography.subtitle2, color = Color.White)
                }
            }

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = null,
                        tint = Color.White
                    )

                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth(0.6f),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                            contentDescription = null,
                            tint = Color.White
                        )

                        Icon(
                            imageVector = Icons.Default.PlayArrow,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier
                                .clip(CircleShape)
                                .background(Color.Blue)
                                .padding(20.dp)
                        )

                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                            contentDescription = null,
                            tint = Color.White
                        )

                    }


                    Icon(
                        imageVector = Icons.Default.Refresh,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }

            item {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 20.dp, vertical = 20.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color.Blue)
                ) {

                    Row(
                        modifier = Modifier
                            .padding(20.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            "Lyrics",
                            style = MaterialTheme.typography.subtitle2,
                            fontWeight = FontWeight.W900,
                            color = Color.White,
                            fontSize = 18.sp
                        )

                        Row {
                            Icon(
                                imageVector = Icons.Default.Share,
                                contentDescription = null,
                                tint = Color.White
                            )
                            Icon(
                                imageVector = Icons.Default.Home,
                                contentDescription = null,
                                tint = Color.White
                            )
                        }
                    }

                    Text(
                        "The following snippet provides a relatively detailed example. When the user presses the button, the app both displays the progress indicator, and launches a coroutine that gradually increases the value of progress. This causes the progress indicator to iterate up in turn.",
                        modifier = Modifier
                            .padding(horizontal = 20.dp)
                            .fillMaxWidth(0.5f),
                        maxLines = 10,
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Composable
fun Favorite() {
    Box(modifier = Modifier.fillMaxSize()) {

/*        Image(
            painter = painterResource(Res.drawable.Favorite),
            modifier = Modifier.fillMaxSize(),
            alpha = 0.2f,
            contentDescription = null,
            contentScale = ContentScale.Fit
        )*/

        LazyColumn(modifier = Modifier.fillMaxSize()) {

            item { Spacer(modifier = Modifier.height(60.dp)) }

            item {
                Row(
                    modifier = Modifier
                        .padding(15.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null
                    )

                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = null,
                        modifier = Modifier.rotate(90f)
                    )
                }
            }

            item {
                Box(modifier = Modifier.fillMaxWidth()) {
                    Image(
                        painter = painterResource(Res.drawable.talyerSwift),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(16f / 12f),
                        contentScale = ContentScale.Crop,
                        alpha = 0.2f
                    )

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(16f / 12f)
                            .align(Alignment.BottomCenter)
                            .background(
                                Brush.verticalGradient(
                                    colors = listOf(
                                        Color.Transparent, Color.White.copy(alpha = 0.8f)
                                    ), startY = 0f, endY = Float.POSITIVE_INFINITY
                                )
                            )
                    )

                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .fillMaxWidth(0.65f)
                            .padding(20.dp)
                    ) {
                        Column {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    "Taylor Swift",
                                    style = MaterialTheme.typography.h5,
                                    fontWeight = FontWeight.W900
                                )
                                Spacer(modifier = Modifier.width(20.dp))
                                Icon(
                                    imageVector = Icons.Default.CheckCircle,
                                    contentDescription = null,
                                    modifier = Modifier.size(25.dp),
                                    tint = Color.Blue
                                )
                            }

                            Spacer(modifier = Modifier.height(15.dp))

                            Text(
                                "The music player itself has an immersive feel, with a dark background and intuitive controls, so listeners can dive right into their favorite tracks.",
                                maxLines = 2
                            )
                        }
                    }

                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(horizontal = 20.dp, vertical = 30.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .clip(RoundedCornerShape(20.dp))
                                .background(Color.Blue)
                                .padding(20.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                "#10",
                                color = Color.White,
                                style = MaterialTheme.typography.h5,
                                fontWeight = FontWeight.W900
                            )
                            Spacer(modifier = Modifier.height(5.dp))
                            Text(
                                "Top 10 List",
                                color = Color.White,
                                style = MaterialTheme.typography.subtitle2,
                                fontWeight = FontWeight.W900
                            )
                        }
                    }

                }


            }

            item {
                Text(
                    "New Release",
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(horizontal = 15.dp),
                    fontWeight = FontWeight.W900
                )
            }

            items(26) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp, end = 25.dp)
                        .padding(top = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(Res.drawable.background),
                            contentDescription = null,
                            modifier = Modifier
                                .clip(RoundedCornerShape(20.dp))
                                .size(80.dp)
                                .aspectRatio(16f / 16f),
                            contentScale = ContentScale.Crop
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Column {
                            Text(
                                "Song Name With Title",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.W900
                            )
                            Text(
                                "Album 2023  18 Album",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.W400
                            )
                        }

                    }

                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = null,
                        modifier = Modifier.rotate(90f)
                    )
                }
            }
        }
    }
}

@Composable
fun Setting() {
    Box(modifier = Modifier.fillMaxSize()) {
/*        Image(
            painter = painterResource(Res.drawable.setting),
            modifier = Modifier.fillMaxSize(),
            alpha = 0.2f,
            contentDescription = null,
            contentScale = ContentScale.Fit
        )*/

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item { Spacer(modifier = Modifier.height(60.dp)) }

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp, vertical = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        "Profile", style = MaterialTheme.typography.h6, fontWeight = FontWeight.W900
                    )

                    Row(
                        modifier = Modifier.padding(end = 15.dp),
                        horizontalArrangement = Arrangement.spacedBy(25.dp)
                    ) {
                        Icon(imageVector = Icons.Default.CheckCircle, contentDescription = null)

                        Icon(imageVector = Icons.Default.Settings, contentDescription = null)
                    }
                }
            }

            item {
                Box(modifier = Modifier.fillMaxWidth()) {

                    var progress by remember { mutableStateOf(0.4f) }
                    val animatedProgress by animateFloatAsState(
                        progress, animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
                    )

                    Box(modifier = Modifier.align(Alignment.Center)) {


                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            CircularProgressIndicator(
                                progress,
                                modifier = Modifier
                                    .padding(bottom = 20.dp)
                                    .size(180.dp)
                                    .rotate(180f),
//                                color = Color.DarkGray,
                                strokeWidth = 8.dp,
                                backgroundColor = Color.Yellow,
                                strokeCap = StrokeCap.Round
                            )
                        }
                    }

                    Box(modifier = Modifier.align(Alignment.Center)) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Image(
                                painter = painterResource(Res.drawable.background),
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(top = 30.dp)
                                    .clip(CircleShape)
                                    .size(140.dp)
                                    .aspectRatio(1f),
                                contentScale = ContentScale.Crop
                            )

                            OutlinedButton(onClick = {
                                if (progress < 1f) progress += 0.1f else progress = 0.1f
                            },
                                modifier = Modifier.clip(RoundedCornerShape(20.dp)),
                                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue)
                            ) { Text("20% Increase", color = Color.White) }
                        }
                    }

                }
            }

            item { 
                LazyRow(modifier = Modifier.padding(horizontal = 20.dp, vertical = 15.dp),
                    horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                    item {
                        Button(onClick = {}, shape = RoundedCornerShape(20.dp),
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)) {
                            Text("My Plan", color = Color.White, fontWeight = FontWeight.W900)
                        }
                    }

                    item {
                        Button(onClick = {}, shape = RoundedCornerShape(20.dp),
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)) {
                            Text("Profile", color = Color.Black, fontWeight = FontWeight.W900)
                        }
                    }

                    item {
                        Button(onClick = {}, shape = RoundedCornerShape(20.dp),
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)) {
                            Text("safety and wellAwareNess", color = Color.Black, fontWeight = FontWeight.W900)
                        }
                    }

                    items(10) {
                        Button(onClick = {}, shape = RoundedCornerShape(20.dp),
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)) {
                            Text("My Plan", color = Color.Black, fontWeight = FontWeight.W900)
                        }
                    }
                }
            }

            item {
                Column (modifier = Modifier.padding(horizontal = 10.dp).clip(RoundedCornerShape(15.dp)).fillMaxWidth()
                    .background(Color(0xFFfe3d13)),
                    horizontalAlignment = Alignment.CenterHorizontally){

                    Row {
                        Text(
                            "Enjoy a ", style = MaterialTheme.typography.h5,
                            fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 10.dp),
                            color = Color.White
                        )
                        Text(
                            "70% Superior", style = MaterialTheme.typography.h5,
                            fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 10.dp),
                            color = Color.Yellow
                        )
                    }

                    Text(
                        "Advantage Over Other Users in " +
                                "Finding Your Ideal Match", style = MaterialTheme.typography.h5,
                        fontWeight = FontWeight.Bold,
                        color = Color.White, textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(0.8f)
                    )

                    Column(modifier = Modifier.padding(10.dp).fillMaxWidth().clip(RoundedCornerShape(15.dp))
                        .background(Color(0xFFF7F5E8)).padding(horizontal = 10.dp, vertical = 20.dp)) {

                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                            Row(modifier = Modifier.weight(0.9f).clip(RoundedCornerShape(20.dp)).background(Color.White).padding(10.dp),
                                verticalAlignment = Alignment.CenterVertically) {
                                Icon(imageVector = Icons.Default.FavoriteBorder,contentDescription = null,
                                    modifier = Modifier.border(1.dp,Color.Gray, CircleShape).padding(10.dp))
                                Spacer(modifier = Modifier.width(5.dp))

                                Text("Easier Discovery in Searches", style = MaterialTheme.typography.h5,
                                    fontWeight = FontWeight.Bold,maxLines = 2, fontSize = 18.sp)
                            }

                            Spacer(modifier = Modifier.width(5.dp))

                            Row(modifier = Modifier.weight(0.9f).clip(RoundedCornerShape(20.dp)).background(Color.White).padding(10.dp),
                                verticalAlignment = Alignment.CenterVertically) {
                                Icon(imageVector = Icons.Default.FavoriteBorder,contentDescription = null,
                                    modifier = Modifier.border(1.dp,Color.Gray, CircleShape).padding(10.dp))
                                Spacer(modifier = Modifier.width(5.dp))

                                Text("Easier Discovery in Searches", style = MaterialTheme.typography.h5,
                                    fontWeight = FontWeight.Bold,maxLines = 2, fontSize = 18.sp)
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                            Row(modifier = Modifier.weight(0.9f).clip(RoundedCornerShape(20.dp)).background(Color.White).padding(10.dp),
                                verticalAlignment = Alignment.CenterVertically) {
                                Icon(imageVector = Icons.Default.FavoriteBorder,contentDescription = null,
                                    modifier = Modifier.border(1.dp,Color.Gray, CircleShape).padding(10.dp))
                                Spacer(modifier = Modifier.width(5.dp))

                                Text("Easier Discovery in Searches", style = MaterialTheme.typography.h5,
                                    fontWeight = FontWeight.Bold, maxLines = 2, fontSize = 18.sp)
                            }

                            Spacer(modifier = Modifier.width(5.dp))

                            Row(modifier = Modifier.weight(0.9f).clip(RoundedCornerShape(20.dp)).background(Color.White).padding(10.dp),
                                verticalAlignment = Alignment.CenterVertically) {
                                Icon(imageVector = Icons.Default.FavoriteBorder,contentDescription = null,
                                    modifier = Modifier.border(1.dp,Color.Gray, CircleShape).padding(10.dp))
                                Spacer(modifier = Modifier.width(5.dp))

                                Text("Easier Discovery in Searches", style = MaterialTheme.typography.h5,
                                    fontWeight = FontWeight.Bold,maxLines = 2, fontSize = 18.sp)
                            }
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Button(onClick = {},
                            modifier = Modifier.clip(RoundedCornerShape(20.dp))
                                .fillMaxWidth(), colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)) {
                            Text("Subscribe now", color = Color.White, style = MaterialTheme.typography.h6,
                                fontWeight = FontWeight.Bold)
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Button(onClick = {},
                            modifier = Modifier.clip(RoundedCornerShape(20.dp))
                                .fillMaxWidth(), colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)) {
                            Text("See more for detail", color = Color.Black, style = MaterialTheme.typography.h6,
                                fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(20.dp))
            }
        }

    }
}