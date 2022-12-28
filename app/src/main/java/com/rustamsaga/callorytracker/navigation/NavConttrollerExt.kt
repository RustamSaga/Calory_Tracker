package com.rustamsaga.callorytracker.navigation

import androidx.navigation.NavController
import com.rustamsaga.core.util.UiEvent

fun NavController.navigate(event: UiEvent.Navigate){
    this.navigate(event.route)

}