package com.sftech.caloriestracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sftech.caloriestracker.ui.navigation.navigates

import com.sftech.caloriestracker.ui.theme.CaloriesTrackerTheme
import com.sftech.core.navigation.Route
import com.sftech.onboarding_presentation.welcome.WelcomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CaloriesTrackerTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Route.WELCOME
                ) {
                    composable(Route.WELCOME) {
                        WelcomeScreen(onNavigate = navController::navigates)
                    }
                    composable(Route.ACTIVITY) { }
                    composable(Route.AGE) { }
                    composable(Route.GENDER) { }
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

