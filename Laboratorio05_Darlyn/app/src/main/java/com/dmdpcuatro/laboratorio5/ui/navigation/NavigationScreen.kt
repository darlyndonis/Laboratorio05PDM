package com.dmdpcuatro.laboratorio5.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dmdpcuatro.laboratorio5.ui.home.HomeScreen
import com.dmdpcuatro.laboratorio5.ui.ToDo.ToDoScreen
import com.dmdpcuatro.laboratorio5.ui.sensors.SensorLuzScreen

@Composable
fun NavigationScreen() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController)
        }
        composable("todo") {
            ToDoScreen()
        }
        composable("sensor") {
            SensorLuzScreen()
        }
    }
}