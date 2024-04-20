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
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun Stopper(modifier: Modifier = Modifier) {

    val isRunning = remember { mutableStateOf(false) }
    val elapsedTime = remember { mutableDoubleStateOf(0.0) }
    val scope = rememberCoroutineScope()

    // Function to stop the timer
    fun stopTimer() {
        isRunning.value = false
    }

    // Function to reset the timer
    fun resetTimer() {
        if (isRunning.value)
            return
        elapsedTime.doubleValue = 0.0
        scope.launch {
            delay(1000)
            elapsedTime.doubleValue = 0.0
        }
    }

    fun startTimer() {
        isRunning.value = true
        Log.d("Stopper", "startTimer: isRunning: ${isRunning.value}")
        scope.launch {
            while (isRunning.value) {
                delay(10)
                elapsedTime.doubleValue += 0.01
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
            text = "Elapsed Time: ${formatTime(elapsedTime.doubleValue)} seconds"
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

fun formatTime(time: Double): String {
    val minutes = (time / 60).toInt()
    val seconds = (time % 60).toInt()
    val hours = (time / 3600).toInt()
    return String.format("%02d:%02d:%02d", hours, minutes, seconds)
}

@Preview(showBackground = true)
@Composable
fun StopperPreview() {
    Stopper()
}