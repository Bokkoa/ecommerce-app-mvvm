package com.bokkoa.ecommerceappmvvm.presentation.navigation.screen

sealed class AuthScreen(val route: String) {
    object Login : AuthScreen(route = "login")
    object Register : AuthScreen(route = "register")
    object Home : AuthScreen(route = "home")
    object Roles : AuthScreen("roles")
    object ClientHome : AuthScreen("client/home")
    object AdminHome : AuthScreen("admin/home")
}
