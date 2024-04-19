package com.example.touristpath.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun Stopper(modifier: Modifier = Modifier) {

    // State to track whether the timer is running
    val isRunning = remember { mutableStateOf(false) }

    // State to track the elapsed time

    val elapsedTime = remember { mutableLongStateOf(0L) }

    // Coroutine scope for timer
    val scope = rememberCoroutineScope()


    // Function to stop the timer
    fun stopTimer() {
        isRunning.value = false
    }

    // Function to reset the timer
    fun resetTimer() {
        stopTimer()
        elapsedTime.longValue = 0
        scope.launch {
            delay(1000)
            elapsedTime.longValue = 0
        }
    }

    fun startTimer() {
        isRunning.value = true
        Log.d("Stopper", "startTimer: isRunning: ${isRunning.value}")
        scope.launch {
            while (isRunning.value) {
                delay(1000)
                elapsedTime.longValue += 1
            }
        }
    }

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
            text = "Elapsed Time: ${elapsedTime.longValue} seconds"
        )

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Button(onClick = { if (!isRunning.value) startTimer() }) {
                Text("Start")
            }
            Button(onClick = { stopTimer() }) {
                Text("Stop")
            }
            Button(onClick = { resetTimer() }) {
                Text("Reset")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun StopperPreview() {
    Stopper()
}