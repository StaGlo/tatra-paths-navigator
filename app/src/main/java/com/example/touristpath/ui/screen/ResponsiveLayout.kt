package com.example.touristpath.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.touristpath.data.PathObject

@Composable
fun ResponsiveLayout(
    paths: List<PathObject>, navController: NavHostController?, selectedPathObject: PathObject?
) {

    BoxWithConstraints {

        // Define large screen condition
        val isLargeScreen = maxWidth > 600.dp

        if (isLargeScreen) {
            Log.d("ResponsiveLayout", "Large screen detected")

            Row(modifier = Modifier.fillMaxSize()) {
                HomePage(
                    listItems = paths, modifier = Modifier.weight(1f), navController = navController
                )

                // For large screens, show the detail view side by side
                Log.d("ResponsiveLayout!!", "Selected path: ${selectedPathObject?.title}")

                PathDetail(
                    path = selectedPathObject
                        ?: paths.first(),  // Show first or selected path's details
                    modifier = Modifier.weight(1f), isLargeScreen = true
                )
            }
        } else {
            Log.d("ResponsiveLayout", "Small screen detected")

            if (selectedPathObject != null) {

                Log.d("ResponsiveLayout", "Selected path: ${selectedPathObject.title}")
                PathDetail(
                    path = selectedPathObject,
                    modifier = Modifier.fillMaxSize(),
                    navController = navController,
                )
            } else {
                HomePage(
                    listItems = paths, navController = navController
                )
            }
        }
    }
}

