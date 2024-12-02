package org.dsa.solution

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import miniproject.composeapp.generated.resources.Res
import miniproject.composeapp.generated.resources.background
import miniproject.composeapp.generated.resources.comment
import miniproject.composeapp.generated.resources.save
import miniproject.composeapp.generated.resources.share
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        FrontPage()
    }
}


@Composable
fun FrontPage() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        item {
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Row(
                    modifier = Modifier.weight(1f),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Instragram",
                        style = MaterialTheme.typography.h5,
                        fontFamily = FontFamily.Cursive,
                        fontWeight = FontWeight.W900
                    )
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowDown, contentDescription = null
                        )
                    }
                }

                Row(
                    modifier = Modifier.weight(1f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.FavoriteBorder, contentDescription = null
                        )
                    }
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.MailOutline, contentDescription = null
                        )
                    }
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.AddCircle, contentDescription = null
                        )
                    }
                }
            }
        }

        item {
            LazyRow(
                modifier = Modifier.padding(5.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                item {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(
                            modifier = Modifier.align(alignment = Alignment.End),
                            contentAlignment = Alignment.BottomEnd
                        ) {
                            Icon(
                                imageVector = Icons.Default.AccountCircle,
                                contentDescription = null,
                                modifier = Modifier.size(60.dp)
                            )

                            Icon(
                                imageVector = Icons.Default.AddCircle,
                                contentDescription = null,
                                tint = Color.Blue,
                                modifier = Modifier
                                    .size(20.dp)
                                    .background(Color.White)
                            )
                        }

                        Text(
                            "Ruffles",
                            modifier = Modifier.padding(vertical = 5.dp),
                            style = MaterialTheme.typography.subtitle2
                        )
                    }
                }

                items(30) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(
                            modifier = Modifier.border(
                                    2.dp, brush = Brush.linearGradient(
                                        colors = listOf(Color.Red, Color.Blue)
                                    ), shape = RoundedCornerShape(50.dp)
                                )
                        ) {
                            Icon(
                                imageVector = Icons.Default.AccountCircle,
                                contentDescription = null,
                                modifier = Modifier.size(60.dp)
                            )
                        }

                        Text(
                            "Ruffles",
                            modifier = Modifier.padding(vertical = 5.dp),
                            style = MaterialTheme.typography.subtitle2
                        )
                    }
                }
            }
        }

        item {
            Row(
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    Text(
                        "Ruffles",
                        modifier = Modifier.padding(vertical = 5.dp),
                        style = MaterialTheme.typography.subtitle2,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.W900
                    )
                }

                Icon(
                    imageVector = Icons.Default.MoreVert, contentDescription = null
                )
            }
        }

        item {
            Box(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(Res.drawable.background),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(ratio = 16f / 16f),
                    contentScale = ContentScale.Crop
                )

                Box(
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxSize()
                        .clip(RoundedCornerShape(30.dp))
                        .align(Alignment.TopEnd), contentAlignment = Alignment.TopEnd
                ) {
                    Text(
                        " 3/5 ", modifier = Modifier.background(Color.DarkGray), color = Color.White
                    )
                }

                Box(modifier = Modifier.align(Alignment.BottomCenter)
                    ){
                    Column {
                        Box(
                            modifier = Modifier
                                .padding(10.dp)
                                .fillMaxSize()
                                .clip(RoundedCornerShape(10.dp))
                                .padding(horizontal = 10.dp),
                            contentAlignment = Alignment.BottomStart
                        ) {
                            Icon(
                                imageVector = Icons.Default.AccountCircle,
                                contentDescription = null,
                                tint = Color.White
                            )
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .alpha(0.3f)
                                .background(Color.Blue),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                "CTA copy here", color = Color.White,
                                modifier = Modifier.padding(10.dp)
                            )

                            Icon(
                                imageVector = Icons.Default.KeyboardArrowRight,
                                contentDescription = null,
                                tint = Color.White, modifier = Modifier.size(35.dp)
                            )
                        }
                    }
                }

            }

        }
/*
        item {

        }*/

        item{
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Row(verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    Icon(imageVector = Icons.Default.Favorite,
                        contentDescription = null,
                        tint = Color.Red)

                    Icon(painter = painterResource(Res.drawable.comment),
                        contentDescription = null, modifier = Modifier.size(20.dp))

                    Icon(painter = painterResource(Res.drawable.share),
                        contentDescription = null,modifier = Modifier.size(20.dp))
                }

                Row(verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                    Row(modifier = Modifier.clip(RoundedCornerShape(50.dp)).size(8.dp)
                        .background(Color.Blue)) {  }

                    Row(modifier = Modifier.clip(RoundedCornerShape(50.dp)).size(8.dp)
                        .background(Color.Gray)) {  }

                    Row(modifier = Modifier.clip(RoundedCornerShape(50.dp)).size(5.dp)
                        .background(Color.Gray)) {  }

                    Row(modifier = Modifier.clip(RoundedCornerShape(50.dp)).size(5.dp)
                        .background(Color.Gray)) {  }                }

                Icon(painter = painterResource(Res.drawable.save),
                    contentDescription = null,modifier = Modifier.size(20.dp))

            }
        }

        item {
            Text(modifier = Modifier.padding(start = 10.dp),
                text = "100 Likes", fontWeight = FontWeight.W900,
                fontSize = 14.sp)

            Row {
                Text(
                    modifier = Modifier.padding(start = 10.dp),
                    text = "Username ", fontWeight = FontWeight.W900,
                    fontSize = 14.sp
                )
                Text(text = "this post is Created on the date",
                    fontSize = 14.sp
                )
            }
        }

    }
}