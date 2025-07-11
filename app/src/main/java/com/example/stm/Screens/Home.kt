package com.example.stm.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.stm.Routes.Routes
import com.example.stm.Screens.components.Answer
import com.example.stm.Screens.components.Card
import com.example.stm.Screens.components.SingleChoiceQuestions
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
    Column (
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround

    ){
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Home",
            style = TextStyle(fontSize = 30.sp)
        )
        SingleChoiceQuestions(
            options
        )

    }
}