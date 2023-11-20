package com.bokkoa.ecommerceappmvvm.presentation.screens.auth.login

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.bokkoa.ecommerceappmvvm.presentation.screens.auth.login.components.LoginContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavHostController) {
    Scaffold(
//        content = { paddingValues ->
//            LoginContent(paddingValues)
//        },
    ) { paddingValues ->
        LoginContent(navController = navController, paddingValues)
// LoginContent(it) // it === this in JS
    }
}
