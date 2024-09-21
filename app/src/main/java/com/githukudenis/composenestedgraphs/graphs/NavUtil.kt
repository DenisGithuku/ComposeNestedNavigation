package com.githukudenis.composenestedgraphs.graphs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun rememberAppState(
    navHostController: NavHostController = rememberNavController(),
): AppState {
    return remember(navHostController) {
        AppState(navHostController)
    }
}


class AppState(
    val navHostController: NavHostController,
) {
    val currentDestination: NavDestination?
        @Composable get() {
            return navHostController.currentBackStackEntryAsState().value?.destination
        }

    fun navigate(
        route: String,
        popUpTo: String? = null,
        inclusive: Boolean = false,
    ) {
        navHostController.navigate(route) {
            if (popUpTo != null) {
                popUpTo(popUpTo) {
                    this.inclusive = inclusive
                }
            } else {
                popUpTo(navHostController.graph.startDestinationRoute ?: return@navigate)
            }
        }
    }

    fun navigateUp() = navHostController.navigateUp()
}
