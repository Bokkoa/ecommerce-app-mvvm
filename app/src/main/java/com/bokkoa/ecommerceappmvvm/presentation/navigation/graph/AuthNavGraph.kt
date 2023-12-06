package com.bokkoa.ecommerceappmvvm.presentation.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.bokkoa.ecommerceappmvvm.presentation.navigation.Graph
import com.bokkoa.ecommerceappmvvm.presentation.navigation.screen.AuthScreen
import com.bokkoa.ecommerceappmvvm.presentation.screens.admin.home.AdminHomeScreen
import com.bokkoa.ecommerceappmvvm.presentation.screens.auth.login.LoginScreen
import com.bokkoa.ecommerceappmvvm.presentation.screens.auth.register.RegisterScreen
import com.bokkoa.ecommerceappmvvm.presentation.screens.client.home.ClientHomeScreen

fun NavGraphBuilder.AuthNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.AUTH,
        startDestination = AuthScreen.Login.route,
    ) {
        composable(route = AuthScreen.Login.route) {
            LoginScreen(navController = navController)
        }

        composable(route = AuthScreen.Register.route) {
            RegisterScreen(navController = navController)
        }

        composable(route = AuthScreen.AdminHome.route) {
            AdminHomeScreen(navController = navController)
        }

        composable(route = AuthScreen.ClientHome.route) {
            ClientHomeScreen(navController = navController)
        }
    }
}
