package com.example.stm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.stm.Navigation.Navigation
import com.example.stm.ViewModels.AuthViewModel
import com.example.stm.ViewModels.StateViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val viewModel = ViewModelProvider(this)[StateViewModel :: class.java]
        val authViewModel = ViewModelProvider(this)[AuthViewModel :: class.java]
        setContent {
            Scaffold(modifier = Modifier.fillMaxSize()) {innerPadding ->
                Navigation(modifier = Modifier.padding(innerPadding),authViewModel = authViewModel)
            }
        }
    }
}