package com.example.tvapp.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.tvapp.presentation.screen.list.ListScreen

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.List
    ) {
        composable<Screen.List> {
            ListScreen(
                onTVShowClick = {
                    navController.navigate(
                        Screen.Detail(it)
                    )
                }
            )
        }

        composable<Screen.Detail>{

        }
    }
}