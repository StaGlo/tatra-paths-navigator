package com.example.touristpath.ui.screen

import TimerViewModelManager
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.touristpath.data.PathObject
import com.example.touristpath.tools.DataStoreManager

@Composable
fun Stopper(modifier: Modifier = Modifier, dataStoreManager: DataStoreManager, path: PathObject) {
    val timerViewModel = remember {
        TimerViewModelManager.getOrCreate(dataStoreManager, path.title)
    }

    val time by timerViewModel.elapsedTime.collectAsState()

    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            style = MaterialTheme.typography.headlineMedium,
            text = "Stopper",
            modifier = Modifier.padding(bottom = 24.dp)
        )
        Text(
            style = MaterialTheme.typography.bodyMedium,
            text = "Elapsed Time: ${formatTime(time)} seconds"
        )

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Button(onClick = { timerViewModel.startTimer() }) {
                Text("Start")
            }
            Button(onClick = { timerViewModel.stopTimer() }) {
                Text("Stop & Save")
            }
            Button(onClick = { timerViewModel.setElapsedTime(0.0) }) {
                Text("Reset")
            }
        }
    }
}

fun formatTime(time: Double): String {
    val minutes = (time / 60).toInt()
    val seconds = (time % 60).toInt()
    val hours = (time / 3600).toInt()
    return String.format("%02d:%02d:%02d", hours, minutes, seconds)
}

@Preview(showBackground = true)
@Composable
fun StopperPreview() {
    val context = androidx.compose.ui.platform.LocalContext.current
    Stopper(path = PathObject("title", "description"), dataStoreManager = DataStoreManager(context))
}