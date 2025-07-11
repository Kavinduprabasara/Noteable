package com.example.stm.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.stm.Routes.Routes
import com.example.stm.ViewModels.AuthViewModel

@Composable
fun SignUp(modifier: Modifier,navController:NavController,authViewModel: AuthViewModel){
    val email by authViewModel.email.observeAsState(initial ="")

    val password by authViewModel.password.observeAsState(initial ="")

    val authState = authViewModel.authState.observeAsState()
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Sign Up",
            style = TextStyle(fontSize = 30.sp)
        )
        TextField("name",email, onNameChange ={
            authViewModel.onNameUpdate(it)
        } )
        TextField("password",password, onNameChange ={
            authViewModel.onPasswordUpdate(it)
        })

        Button(onClick = {
            navController.navigate(Routes.SignUp)
            println("$email $password")
            authViewModel.signup(email,password)
        }) {
            Text(text = "Sign Up")
        }
        TextButton(onClick = {
            navController.navigate(Routes.Login)
            println("$email $password")
        }) {
            Text(text = "Already Signed up, Login")
        }

    }
}

