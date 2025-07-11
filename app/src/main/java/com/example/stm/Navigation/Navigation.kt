package com.example.stm.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.stm.Routes.Routes
import com.example.stm.Screens.Home
import com.example.stm.Screens.Login
import com.example.stm.Screens.SignUp
import com.example.stm.ViewModels.AuthViewModel

@Composable
fun Navigation(modifier: Modifier = Modifier,authViewModel: AuthViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.Login , builder ={
        composable(Routes.Home) {
            Home(modifier,navController,authViewModel)
        }
        composable(Routes.Login) {
            Login(modifier,navController,authViewModel)
        }

        composable(Routes.SignUp){
            SignUp(modifier,navController,authViewModel)
        }
    } )
}