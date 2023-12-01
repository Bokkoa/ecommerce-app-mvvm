package com.bokkoa.ecommerceappmvvm.presentation.screens.auth.register.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.bokkoa.ecommerceappmvvm.domain.util.ResourceResponse
import com.bokkoa.ecommerceappmvvm.presentation.components.ProgressBar
import com.bokkoa.ecommerceappmvvm.presentation.navigation.screen.AuthScreen
import com.bokkoa.ecommerceappmvvm.presentation.screens.auth.register.RegisterViewModel

@Composable
fun Register(navController: NavHostController, vm: RegisterViewModel = hiltViewModel()) {
    when (val response = vm.registerResponse) {
        ResourceResponse.Loading -> {
            ProgressBar()
        }

        is ResourceResponse.Success -> {
            navController.navigate(route = AuthScreen.Home.route)
        }

        is ResourceResponse.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_LONG).show()
        }

        else -> {
            if (response != null) {
                Toast.makeText(LocalContext.current, "Unknown error", Toast.LENGTH_LONG).show()
            }
        }
    }
}
