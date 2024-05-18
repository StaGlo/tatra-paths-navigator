package com.example.touristpath.ui.screen

import android.content.ContentValues
import android.content.Intent
import android.provider.MediaStore
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.touristpath.R
import com.example.touristpath.data.PathObject
import com.example.touristpath.data.pathList
import com.example.touristpath.tools.DataStoreManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Composable
fun PathDetail(
    path: PathObject,
    modifier: Modifier = Modifier,
    navController: NavHostController? = null,
    isLargeScreen: Boolean = false,
    dataStoreManager: DataStoreManager
) {
    val showStopper by dataStoreManager.getStopperVisibility(path.title)
        .collectAsState(initial = false)
    var toggleStopper by remember { mutableStateOf(false) }

    if (toggleStopper) {
        LaunchedEffect(true) {
            dataStoreManager.setStopperVisibility(path.title, !showStopper)
        }
        toggleStopper = false
    }

    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = path.imageResId),
            contentDescription = path.title,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
                .border(BorderStroke(3.dp, MaterialTheme.colorScheme.primary))
        )
        Text(
            style = MaterialTheme.typography.headlineMedium,
            text = path.title,
            modifier = Modifier.padding(bottom = 24.dp)
        )
        Text(
            style = MaterialTheme.typography.bodyMedium,
            text = path.description,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        )
        if (showStopper) {
            Stopper(dataStoreManager = dataStoreManager, path = path)
        }
        Spacer(modifier = Modifier.weight(1f))
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Button(onClick = { toggleStopper = true }) {
                Text(if (showStopper) "Stop trip!" else "Start trip!")
            }
            if (!isLargeScreen) {
                Button(onClick = { navController?.navigateUp() }) {
                    Text("Main Page")
                }
            }
        }
    }
}

@Composable
fun PathDetailFAB(
    path: PathObject,
    modifier: Modifier = Modifier,
    navController: NavHostController? = null,
    isLargeScreen: Boolean = false,
    dataStoreManager: DataStoreManager
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        modifier = modifier
            .background(MaterialTheme.colorScheme.background),
        floatingActionButton = {
            FloatingActionButton(onClick = {

                // Define image metadata
                val values = ContentValues()
                values.put(
                    MediaStore.Images.Media.DISPLAY_NAME,
                    "MyImage_" + path.title + "_" + System.currentTimeMillis()
                )
                values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg")
                values.put(MediaStore.Images.Media.RELATIVE_PATH, "Pictures/Paths' photos")

                // Insert the image into the MediaStore
                val resolver = context.contentResolver
                val uri = resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)

                // Start the camera
                val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, uri)

                coroutineScope.launch(Dispatchers.Main) {
                    context.startActivity(takePictureIntent)
                }

            }) {
                Icon(
                    painter = painterResource(id = R.drawable.camera),
                    contentDescription = "Take Photo",
                    modifier = Modifier.size(32.dp)
                )

            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) { paddingValues ->
        PathDetail(
            path = path,
            modifier = modifier.padding(paddingValues),
            navController = navController,
            isLargeScreen = isLargeScreen,
            dataStoreManager = dataStoreManager
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PathDetailPreview() {
    // Assuming there's a mock DataStoreManager instance and NavHostController
    val context = LocalContext.current
    PathDetailFAB(
        path = pathList.first(),
        isLargeScreen = false,
        dataStoreManager = DataStoreManager(context) // Correctly initialize
    )
}
