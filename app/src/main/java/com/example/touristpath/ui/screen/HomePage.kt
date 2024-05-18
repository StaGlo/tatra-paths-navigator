package com.example.touristpath.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.touristpath.data.PathObject
import com.example.touristpath.data.pathList
import com.example.touristpath.ui.theme.TouristPathTheme


@Composable
fun HomePage(
    listItems: List<PathObject>,
    modifier: Modifier = Modifier, isLargeScreen: Boolean = false, navController: NavHostController?
) {
    Column(modifier = modifier.padding(16.dp)) {
        Text(
            text = "Tourist Paths",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            textAlign = TextAlign.Center
        )

        LazyColumn {
            itemsIndexed(listItems) { index, listItem ->
                ListItemView(listItem) {
                    if (!isLargeScreen) navController?.navigate("detail/$index")
                }
            }
        }

        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()) {
            //TODO add path button action
            Button(onClick = { /* Handle the click event */ }) {
                Text("Add Path")
            }
        }
    }
}


@Composable
fun ListItemView(listItem: PathObject, onClick: () -> Unit) {
    Box(contentAlignment = Alignment.CenterStart,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }) {
        Text(
            text = listItem.title, modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun HomePageGrid(
    listItems: List<PathObject>,
    modifier: Modifier = Modifier,
    isLargeScreen: Boolean = false,
    navController: NavHostController?
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 180.dp),
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        itemsIndexed(listItems) { index, listItem ->
            GridItem(listItem) {
                if (!isLargeScreen)
                    navController?.navigate("detail/${listItem.title}")
            }
        }
    }
}

@Composable
fun GridItem(path: PathObject, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable { onClick() },
//       /**/ backgroundColor = MaterialTheme.colorScheme.primary
    ) {
        Column(modifier = Modifier.padding(8.dp)) {


            Image(
                painter = painterResource(id = path.imageResId),
                contentDescription = path.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(4.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .align(Alignment.CenterHorizontally)
                    .fillMaxSize()
                    .size(128.dp),

                )
            Text(
                text = if (path.title.length > 30) "${path.title.take(30)}..." else path.title,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    TouristPathTheme {
        HomePage(
            pathList,
            navController = null
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomePageGridPreview() {
    TouristPathTheme {
        HomePageGrid(
            pathList,
            navController = null
        )
    }
}

