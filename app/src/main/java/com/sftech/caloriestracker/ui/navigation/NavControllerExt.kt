package com.sftech.caloriestracker.ui.navigation

import androidx.navigation.NavController
import com.sftech.core.util.UiEvent

fun NavController.navigates(event: UiEvent.Navigate){
    this.navigate(event.route)
}