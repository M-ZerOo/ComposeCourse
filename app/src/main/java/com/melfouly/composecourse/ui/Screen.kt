package com.melfouly.composecourse.ui

sealed class Screen(val route: String) {
    object Home: Screen("home_screen")
    object Notification: Screen("notification_screen")
    object Settings: Screen("settings_screen")
}
