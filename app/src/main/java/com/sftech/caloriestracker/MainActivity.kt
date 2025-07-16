package com.sftech.caloriestracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sftech.caloriestracker.ui.navigation.navigates
import com.sftech.caloriestracker.ui.theme.CaloriesTrackerTheme
import com.sftech.core.navigation.Route
import com.sftech.onboarding_presentation.age.AgeScreen
import com.sftech.onboarding_presentation.gender.GenderScreen
import com.sftech.onboarding_presentation.welcome.WelcomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CaloriesTrackerTheme {
                val navController = rememberNavController()
                val snackbarHostState = remember { SnackbarHostState() }
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    snackbarHost = { SnackbarHost(snackbarHostState) },
                ) { paddingValues ->
                    NavHost(
                        navController = navController,
                        startDestination = Route.WELCOME,
                        modifier = Modifier.padding(paddingValues)
                    ) {
                        composable(Route.WELCOME) {
                            WelcomeScreen(onNavigate = navController::navigates)
                        }
                        composable(Route.ACTIVITY) { }
                        composable(Route.AGE) {
                            AgeScreen (
                                onNavigate = navController::navigates,
                                snackbarHostState = snackbarHostState
                            )
                        }
                        composable(Route.GENDER) {
                            GenderScreen(onNavigate = navController::navigates)
                        }
                        composable(Route.HEIGHT) { }
                        composable(Route.WEIGHT) { }
                        composable(Route.TRACKER_OVERVIEW) { }
                        composable(Route.NUTRIENT_GOAL) { }
                        composable(Route.SEARCH) { }
                        composable(Route.GOAL) { }
                    }
                }

            }
        }
    }
}

