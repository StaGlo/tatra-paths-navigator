package com.example.touristpath.ui.screen

import WelcomePage
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.touristpath.data.PathObject
import com.example.touristpath.data.pathList
import com.example.touristpath.tools.DataStoreManager
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationDrawer(dataStoreManager: DataStoreManager) {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val (selectedPath, setSelectedPath) = remember { mutableStateOf<PathObject?>(null) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier
                    .width(240.dp)
                    .background(color = MaterialTheme.colorScheme.surface),
            ) {
                DrawerItem(text = "Home") {
                    scope.launch {
                        navController.navigate("welcomePage")
                        drawerState.close()
                    }
                }
                DrawerItem(text = "All Paths") {
                    scope.launch {
                        navController.navigate("allPaths")
                        drawerState.close()
                    }
                }
                DrawerItem(text = "Easy Paths") {
                    scope.launch {
                        navController.navigate("easyPaths")
                        drawerState.close()
                    }
                }
                DrawerItem(text = "Hard Paths") {
                    scope.launch {
                        navController.navigate("hardPats")
                        drawerState.close()
                    }
                }
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Szlaki w Tatrach") },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch { drawerState.open() }
                        }) {
                            Icon(Icons.Filled.Menu, contentDescription = "Menu")
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
                )
            }
        ) { paddingValues ->
            Box(modifier = Modifier.padding(paddingValues)) {
                NavHost(navController = navController, startDestination = "welcomePage") {
                    composable("welcomePage") { WelcomePage() }
                    composable("allPaths") {
                        ResponsiveLayout(
                            paths = pathList,
                            navController = navController,
                            selectedPathObject = null,
                            dataStoreManager = dataStoreManager
                        )
                    }
                    composable("easyPaths") {
                        ResponsiveLayout(
                            paths = pathList.filter { it.easy },
                            navController = navController,
                            selectedPathObject = null,
                            dataStoreManager = dataStoreManager
                        )
                    }
                    composable("hardPats") {
                        ResponsiveLayout(
                            paths = pathList.filter { !it.easy },
                            navController = navController,
                            selectedPathObject = null,
                            dataStoreManager = dataStoreManager
                        )
                    }

                    composable("detail/{pathIndex}") { backStackEntry ->
                        val pathIndex =
                            backStackEntry.arguments?.getString("pathIndex")?.toIntOrNull() ?: 0
                        val path =
                            pathList.getOrNull(pathIndex) ?: PathObject(
                                "Not Found",
                                "Path does not exist.",
                                0
                            )
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
    }
}

@Composable
fun DrawerItem(text: String, onClick: () -> Unit) {
    TextButton(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(text)
    }
}
