package com.bokkoa.ecommerceappmvvm.presentation.screens.auth.login.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.bokkoa.ecommerceappmvvm.domain.util.ResourceResponse
import com.bokkoa.ecommerceappmvvm.presentation.components.ProgressBar
import com.bokkoa.ecommerceappmvvm.presentation.navigation.screen.AuthScreen
import com.bokkoa.ecommerceappmvvm.presentation.screens.auth.login.LoginViewModel

@Composable
fun Login(navController: NavHostController, vm: LoginViewModel = hiltViewModel()) {
    when (val response = vm.loginReponse) {
        ResourceResponse.Loading -> {
            ProgressBar()
        }

        is ResourceResponse.Success -> {
            LaunchedEffect(Unit) {
                navController.navigate(route = AuthScreen.Home.route)
            }
        }

        is ResourceResponse.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_SHORT).show()
        }
        else -> {
            if (response != null) {
                Toast.makeText(LocalContext.current, "Unknown error", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
