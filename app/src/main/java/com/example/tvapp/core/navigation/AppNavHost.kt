package com.example.tvapp.core.navigation

import android.R.attr.data
import android.util.Log.d
import androidx.compose.runtime.Composable
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.tvapp.presentation.screen.detail.DetailScreen
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

        composable<Screen.Detail> {
            val data = it.toRoute<Screen.Detail>()
            DetailScreen(
                id = data.id
            )
        }
    }
}