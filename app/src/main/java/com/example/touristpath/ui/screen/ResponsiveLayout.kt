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
import com.example.touristpath.tools.DataStoreManager

@Composable
fun ResponsiveLayout(
    paths: List<PathObject>,
    navController: NavHostController?,
    selectedPathObject: PathObject?,
    dataStoreManager: DataStoreManager
) {

    BoxWithConstraints {

        // Define large screen condition
        val isLargeScreen = maxWidth > 600.dp

        if (isLargeScreen) {
            Log.d("ResponsiveLayout", "Large screen detected")

            Row(modifier = Modifier.fillMaxSize()) {
                HomePageGrid(
                    listItems = paths, modifier = Modifier.weight(1f), navController = navController
                )

                // For large screens, show the detail view side by side
                Log.d("ResponsiveLayout!!", "Selected path: ${selectedPathObject?.title}")

                PathDetailFAB(
                    path = selectedPathObject
                        ?: paths.first(),  // Show first or selected path's details
                    modifier = Modifier.weight(1f),
                    isLargeScreen = true,
                    dataStoreManager = dataStoreManager
                )
            }
        } else {
            Log.d("ResponsiveLayout", "Small screen detected")

            if (selectedPathObject != null) {

                Log.d("ResponsiveLayout", "Selected path: ${selectedPathObject.title}")
                PathDetailFAB(
                    path = selectedPathObject,
                    modifier = Modifier.fillMaxSize(),
                    navController = navController,
                    dataStoreManager = dataStoreManager
                )
            } else {
                HomePageGrid(
                    listItems = paths, navController = navController
                )
            }
        }
    }
}

