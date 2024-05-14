package com.melfouly.composecourse

sealed class AppDestinations(val route: String) {
    data object ProfileScreen : AppDestinations("firstScreen")
}
