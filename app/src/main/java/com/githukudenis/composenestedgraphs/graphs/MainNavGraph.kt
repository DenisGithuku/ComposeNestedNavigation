package com.githukudenis.composenestedgraphs.graphs

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost

@Composable
fun MainNavGraph(
    appState: AppState,
) {
    NavHost(
        navController = appState.navHostController,
        startDestination = MainDestination.Auth.route,
    ) {
        authGraph(appState)
        homeNavGraph(appState)
        settingsGraph(appState)
    }
}

enum class MainDestination(val route: String) {
    Auth("auth"), Home("home"), Settings("settings")
}