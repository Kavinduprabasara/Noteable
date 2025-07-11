package com.example.stm.Navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import com.example.stm.Routes.Routes
import com.example.stm.ViewModels.AuthViewModel

@Composable
fun Apptopbar(authViewModel:AuthViewModel,modifier: Modifier = Modifier,navController: NavController) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxWidth().padding(32.dp)
    ) {
        Button(onClick = {
            authViewModel.signout()
            navController.navigate(Routes.Login)
        }) {
            Text(text = "Sign out")
        }
    }
}