package com.githukudenis.composenestedgraphs.graphs

import android.util.Log
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

fun NavGraphBuilder.authGraph(
    appState: AppState
) {
    navigation(route = MainDestination.Auth.route, startDestination = AuthRoute.Login.route) {
        composable(route = AuthRoute.Login.route) {
            LoginScreen(toHome = {
                appState.navigate(
                    MainDestination.Home.route,
                    popUpTo = MainDestination.Auth.route,
                    inclusive = true
                )
            }, toRegister = {
                Log.d(
                    "route",
                    appState.navHostController.visibleEntries.value.map { it.destination.route }
                        .toString()
                )

                appState.navigate(
                    AuthRoute.Register.route,
                    popUpTo = AuthRoute.Register.route,
                    inclusive = true
                )
                Log.d(
                    "route",
                    appState.navHostController.visibleEntries.value.map { it.destination.route }
                        .toString()
                )

            })
        }
        composable(route = AuthRoute.Register.route) {
            RegisterScreen(toDashboard = {
                Log.d(
                    "route",
                    appState.navHostController.visibleEntries.value.map { it.destination.route }
                        .toString()
                )

                appState.navigate(
                    MainDestination.Home.route,
                    popUpTo = MainDestination.Auth.route,
                    inclusive = true
                )
                Log.d(
                    "route",
                    appState.navHostController.visibleEntries.value.map { it.destination.route }
                        .toString()
                )
            }, back = {
                appState.navigateUp()
            })
        }
    }
}

enum class AuthRoute(val route: String) {
    Login("login"), Register("register")
}

@Composable
fun LoginScreen(modifier: Modifier = Modifier, toHome: () -> Unit, toRegister: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column {
            Text(text = "Login")
            Button(onClick = toHome) {
                Text(text = "Go to Home")
            }
            Button(onClick = toRegister) {
                Text(text = "Go to Register")
            }
        }
    }
}

@Composable
fun RegisterScreen(modifier: Modifier = Modifier, toDashboard: () -> Unit, back: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column {
            Text(text = "Register")
            Button(onClick = toDashboard) {
                Text(text = "Dashboard")
            }

            Button(onClick = back) {
                Text(text = "Back")
            }
        }
    }
}