package com.example.stm.Screens

import Navigationbar
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.stm.Navigation.Apptopbar
import com.example.stm.Routes.Routes
import com.example.stm.Screens.components.Answer
import com.example.stm.Screens.components.Card
import com.example.stm.Screens.components.SingleChoiceQuestions
import com.example.stm.ViewModels.AuthState
import com.example.stm.ViewModels.AuthViewModel

@Composable
fun Home(modifier: Modifier, navController: NavController, authViewModel: AuthViewModel){
    val options = listOf(
        Answer(1, "Alice", "Description for Alice"),
        Answer(2, "Bob", "Description for Bob"),
        Answer(3, "Charlie", "Description for Charlie"),
        Answer(4, "Charlie", "Description for Charlie"),
        Answer(5, "Charlie", "Description for Charlie"),
        Answer(6, "Charlie", "Description for Charlie"),
        Answer(7, "Charlie", "Description for Charlie"),
        Answer(8, "Charlie", "Description for Charlie"),
        Answer(3, "Charlie", "Description for Charlie"),
        Answer(4, "Charlie", "Description for Charlie"),
        Answer(5, "Charlie", "Description for Charlie"),
        Answer(6, "Charlie", "Description for Charlie"),
        Answer(7, "Charlie", "Description for Charlie"),
        Answer(8, "Charlie", "Description for Charlie")
    )

    val authState by authViewModel.authState.observeAsState(AuthState.Loading)
    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {

            Apptopbar(authViewModel,navController = navController)

        },

        bottomBar = {
            Navigationbar(
                selectedIndex = selectedIndex,
                onItemSelected = { index ->
                    selectedIndex = index
                    // You can also trigger navigation here based on index
                    when (index) {
                        0 -> navController.navigate("home_route")
                        1 -> navController.navigate("search_route")
                        2 -> navController.navigate("profile_route")
                        3 -> navController.navigate("settings_route")
                    }
                }

            )
        }
    ){ innnerPadding->
        Column (
        Modifier.fillMaxSize().padding(innnerPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ){
    SingleChoiceQuestions(
                    options
                )
    }
    }
}
