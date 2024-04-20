package com.example.touristpath.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.touristpath.data.PathObject
import com.example.touristpath.data.pathList
import com.example.touristpath.ui.theme.TouristPathTheme

@Composable
fun PathDetail(
    path: PathObject,
    modifier: Modifier = Modifier,
    navController: NavHostController? = null,
    isLargeScreen: Boolean = false
) {

    val (showStopper, setShowStopper) = remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            style = MaterialTheme.typography.headlineMedium,
            text = path.title,
            modifier = Modifier
                .padding(bottom = 24.dp)
        )

        Text(
            style = MaterialTheme.typography.bodyMedium,
            text = path.description,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        )

        if (showStopper) {
            Stopper()
        }

        Spacer(modifier = Modifier.weight(1f))

        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Button(onClick = {
                Log.d("PathDetail", "ShowStopper: $showStopper")
                if (showStopper) {
                    setShowStopper(false)
                } else {
                    setShowStopper(true)
                }
            }) {
                if (showStopper) {
                    Text("Stop trip!")
                } else {
                    Text("Start trip!")
                }
            }

            if (!isLargeScreen) {

                Button(
                    onClick = { navController?.navigate("home") },
                ) {
                    Text("Return to Main Page")
                }
            }
        }
    }

    Spacer(modifier = Modifier.padding(16.dp))

}

@Preview(showBackground = true)
@Composable
fun PathDetailPreview() {
    TouristPathTheme {
        PathDetail(
            pathList.first(),
            isLargeScreen = false,
        )  // Pass first item as a mock detail view
    }
}