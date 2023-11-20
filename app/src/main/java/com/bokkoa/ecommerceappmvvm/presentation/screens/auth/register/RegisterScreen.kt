package com.bokkoa.ecommerceappmvvm.presentation.screens.auth.register

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.bokkoa.ecommerceappmvvm.presentation.components.DefaultTopBar
import com.bokkoa.ecommerceappmvvm.presentation.screens.auth.register.components.RegisterContent
import com.bokkoa.ecommerceappmvvm.presentation.ui.theme.EcommerceAppMVVMTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Sign Up",
                upAvailable = true,
                navController = navController,
            )
        },
    ) { paddingValues ->
        RegisterContent(paddingValues = paddingValues)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegisterScreenPreview() {
    EcommerceAppMVVMTheme {
        RegisterScreen(rememberNavController())
    }
}
