package com.bokkoa.ecommerceappmvvm.presentation.screens.auth.login.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.bokkoa.ecommerceappmvvm.domain.util.Resource
import com.bokkoa.ecommerceappmvvm.presentation.components.ProgressBar
import com.bokkoa.ecommerceappmvvm.presentation.navigation.screen.AuthScreen
import com.bokkoa.ecommerceappmvvm.presentation.screens.auth.login.LoginViewModel

@Composable
fun Login(navController: NavHostController, vm: LoginViewModel = hiltViewModel()) {
    when (val response = vm.loginReponse) {
        Resource.Loading -> {
            ProgressBar()
        }

        is Resource.Success -> {
            LaunchedEffect(Unit) {
                vm.saveSession(response.data)
                if (response.data.user?.roles!!.size > 1) {
                    navController.navigate(route = AuthScreen.Roles.route) {
                        popUpTo(AuthScreen.Login.route) { inclusive = true }
                    }
                } else {
                    navController.navigate(route = AuthScreen.Home.route) {
                        popUpTo(AuthScreen.Login.route) { inclusive = true }
                    }
                }
            }
        }

        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_SHORT).show()
        }
        else -> {
            if (response != null) {
                Toast.makeText(LocalContext.current, "Unknown error", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
