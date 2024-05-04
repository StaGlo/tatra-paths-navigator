package com.example.touristpath

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.touristpath.data.PathObject
import com.example.touristpath.data.pathList
import com.example.touristpath.tools.DataStoreManager
import com.example.touristpath.ui.screen.ResponsiveLayout
import com.example.touristpath.ui.theme.TouristPathTheme


class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TouristPathTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // val navController = rememberNavController()

                    val dataStoreManager = DataStoreManager(this)
                    AppNavigation(dataStoreManager)
                }
            }
        }

    }


    @Composable
    fun AppNavigation(dataStoreManager: DataStoreManager) {
        val navController = rememberNavController()
        // State for managing selected path in split view
        val (selectedPath, setSelectedPath) = remember { mutableStateOf<PathObject?>(null) }

        NavHost(navController = navController, startDestination = "home") {
            composable("home") {
                // Pass setSelectedPath to HomePage if you want to update the detail view from the list
                Log.d("MainActivity", "AppNavigation: home")
                ResponsiveLayout(
                    paths = pathList,
                    //selectedPath = selectedPath,
                    //onPathSelected = setSelectedPath, // Update selectedPath based on user interaction
                    navController = navController,
//                    selectedPathObject = selectedPath
                    selectedPathObject = null,
                    dataStoreManager = dataStoreManager
                )
            }

            composable("detail/{pathIndex}") { backStackEntry ->

                Log.d("MainActivity", "AppNavigation: detail")

                val pathIndex = backStackEntry.arguments?.getString("pathIndex")?.toIntOrNull() ?: 0
                val path =
                    pathList.getOrNull(pathIndex) ?: PathObject(
                        "Not Found",
                        "Path does not exist.",
                        0
                    )
                // Update the selected path for the split view
                setSelectedPath(path)

                Log.d("MainActivity", "AppNavigation: pathIndex: $pathIndex")

                ResponsiveLayout(
                    paths = pathList,
                    navController = navController,
                    selectedPathObject = path,
                    dataStoreManager = dataStoreManager
                )

            }
        }
    }

}
