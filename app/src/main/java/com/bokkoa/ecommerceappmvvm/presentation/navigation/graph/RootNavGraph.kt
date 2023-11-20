package com.bokkoa.ecommerceappmvvm.presentation.navigation.graph
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import com.bokkoa.ecommerceappmvvm.presentation.navigation.Graph

@Composable
fun RootNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.AUTH,
    ) {
        AuthNavGraph(navController = navController)
    }
}