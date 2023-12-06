package com.bokkoa.ecommerceappmvvm.presentation.screens.roles

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.bokkoa.ecommerceappmvvm.presentation.components.DefaultTopBar
import com.bokkoa.ecommerceappmvvm.presentation.screens.roles.components.RolesContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RolesScreen(navController: NavHostController) {
    Scaffold(
        topBar = { DefaultTopBar(title = "Select a role") },
    ) { paddingValues ->
        RolesContent(paddingValues, navController = navController)
    }
}
