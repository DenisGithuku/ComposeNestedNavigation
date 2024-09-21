package com.githukudenis.composenestedgraphs.graphs

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.settingsGraph(
    appState: AppState
) {
    navigation(
        route = MainDestination.Settings.route,
        startDestination = SettingsRoute.Settings.route
    ) {
        composable(route = SettingsRoute.Settings.route) {
            SettingsScreen(toAccount = {
                appState.navigate(
                    SettingsRoute.Account.route,
                    popUpTo = SettingsRoute.Account.route,
                    inclusive = true
                )
            }, logout = {
                appState.navigate(
                    MainDestination.Auth.route,
                    popUpTo = MainDestination.Home.route,
                    inclusive = true
                )
            })
        }
        composable(route = SettingsRoute.Account.route) {
            AccountScreen(back = {
                appState.navigateUp()
            })
        }
    }
}

enum class SettingsRoute(val route: String) {
    Settings("setting"), Account("account")
}

@Composable
fun SettingsScreen(modifier: Modifier = Modifier, toAccount: () -> Unit, logout: () -> Unit) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column {
            Text(text = "Settings")
            Button(onClick = toAccount) {
                Text(text = "Go to Account")
            }
            Button(onClick = logout) {
                Text(text = "Logout")
            }
        }
    }
}

@Composable
fun AccountScreen(modifier: Modifier = Modifier, back: () -> Unit) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column {
            Text(text = "Account")
            Button(onClick = back) {
                Text(text = "Back")
            }
        }

    }
}