package com.bokkoa.ecommerceappmvvm.presentation.screens.auth.login.components

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.bokkoa.ecommerceappmvvm.domain.util.ResourceResponse
import com.bokkoa.ecommerceappmvvm.presentation.navigation.screen.AuthScreen
import com.bokkoa.ecommerceappmvvm.presentation.screens.auth.login.LoginViewModel

@Composable
fun Login(navController: NavHostController, vm: LoginViewModel = hiltViewModel()) {
    when (val response = vm.loginReponse) {
        ResourceResponse.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                CircularProgressIndicator()
            }
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
