package com.example.stm.Screens

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.navigation.NavController
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.example.stm.Routes.Routes
import com.example.stm.ViewModels.AuthViewModel
import com.example.stm.ViewModels.StateViewModel

//remember  -> persist state on recomposition
//rememberSaveable ->persists even on configuration changes
//ViewModel and LiveData -> Hoist the state for re-usability

@Composable
fun Login(modifier: Modifier,navController:NavController,authViewModel: AuthViewModel){
    val email by authViewModel.email.observeAsState(initial ="")

    val password by authViewModel.password.observeAsState(initial ="")
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Login",
            style = TextStyle(fontSize = 30.sp)
        )
        TextField("Email",email, onNameChange ={
            authViewModel.onNameUpdate(it)
        } )
        TextField("password",password, onNameChange ={
            authViewModel.onPasswordUpdate(it)
        })

        Button(onClick = {
            navController.navigate(Routes.Home)
            println("$email $password")
            authViewModel.login(email,password)
        }) {
            Text(text = "Login")
        }
        TextButton(onClick = {
            navController.navigate(Routes.SignUp)
            println("$email $password")

        }) {
            Text(text = "Don't have an account, Sign Up")
        }

    }
}

@Composable
fun TextField(field:String,name:String,onNameChange :(String)->Unit){
    OutlinedTextField(
        value = name,
        onValueChange = {
            onNameChange(it)
        },
        label ={
            Text(
                text = "Enter $field"
            )
        }
    )
}