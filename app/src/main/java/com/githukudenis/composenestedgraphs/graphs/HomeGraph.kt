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

fun NavGraphBuilder.homeNavGraph(
    appState: AppState
) {
    navigation(route = MainDestination.Home.route, startDestination = HomeRoute.Dashboard.route) {
        composable(route = HomeRoute.Dashboard.route) {
            DashboardScreen(toDetail = {
                appState.navigate(
                    HomeRoute.Detail.route, popUpTo = HomeRoute.Detail.route, inclusive = true
                )
            }, toSettings = {
                appState.navigate(
                    MainDestination.Settings.route,
                    popUpTo = MainDestination.Settings.route,
                    inclusive = true
                )
            })
        }
        composable(route = HomeRoute.Detail.route) {
            DetailScreen(back = {
                appState.navigateUp()
            })
        }
    }
}

enum class HomeRoute(val route: String) {
    Dashboard("dashboard"), Detail("detail")
}


@Composable
fun DashboardScreen(modifier: Modifier = Modifier, toDetail: () -> Unit, toSettings: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column {
            Text(text = "Dashboard")
            Button(onClick = toDetail) {
                Text(text = "Go to Detail")
            }
            Button(onClick = toSettings) {
                Text(text = "Go to Settings")
            }
        }
    }
}

@Composable
fun DetailScreen(modifier: Modifier = Modifier, back: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column {
            Text(text = "Detail")
            Button(onClick = back) {
                Text(text = "Back")
            }
        }
    }
}
