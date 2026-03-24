package com.example.feedexplorer.presentation.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.feedexplorer.presentation.view.detail.ProfessionalDetailScreen
import com.example.feedexplorer.presentation.view.list.ProfessionalListScreen

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.List
    ) {
        // --- 1. List Screen ---
        composable<Screen.List> {
            ProfessionalListScreen(
                onItemClick = { professional ->
                    // Navigate using the Type-Safe route object
                    navController.navigate(Screen.Detail(id = professional.id))
                }
            )
        }

        // --- 2. Detail Screen ---
        composable<Screen.Detail> { backStackEntry ->
            // Automatically extracts the 'id' from the route
            val args: Screen.Detail = backStackEntry.toRoute()

            ProfessionalDetailScreen(
                professionalId = args.id,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}