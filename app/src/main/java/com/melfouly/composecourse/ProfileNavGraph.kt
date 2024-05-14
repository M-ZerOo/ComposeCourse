package com.melfouly.composecourse

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun ProfileNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = AppDestinations.ProfileScreen.route
    ) {
        composable(AppDestinations.ProfileScreen.route) { ProfileScreen(navController) }
        saveInfoRoute(navController)
    }
}