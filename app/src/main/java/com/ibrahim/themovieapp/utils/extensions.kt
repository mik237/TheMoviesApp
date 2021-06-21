package com.ibrahim.themovieapp.utils

import androidx.navigation.NavController
import androidx.navigation.NavDirections

fun NavController.safNavigate(direction: NavDirections){
    currentDestination?.getAction(direction.actionId)?.run { navigate(direction) }
}