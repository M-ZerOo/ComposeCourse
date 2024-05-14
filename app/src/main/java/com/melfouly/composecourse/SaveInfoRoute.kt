package com.melfouly.composecourse

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

private const val ROUTE = "saveInfoScreen"

fun NavController.navigateToSaveInfoScreen(firstName: String) {
    navigate("$ROUTE/$firstName")
}


fun NavGraphBuilder.saveInfoRoute(navController: NavController) {

    composable(
        "$ROUTE/{${SaveInfoArgs.FIRST_NAME_ARGS}}",
        arguments = listOf(
            navArgument(SaveInfoArgs.FIRST_NAME_ARGS) { NavType.StringType }
        )
    ) { SaveInfoScreen(navController) }
}

class SaveInfoArgs(savedStateHandle: SavedStateHandle) {

    val firstName = checkNotNull(savedStateHandle[FIRST_NAME_ARGS])

    companion object {
        const val FIRST_NAME_ARGS = "firstName"
    }
}