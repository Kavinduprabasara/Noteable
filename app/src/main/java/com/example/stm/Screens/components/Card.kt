package com.example.stm.Screens.components

import android.media.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SingleChoiceQuestions(answers: List<Answer>) {
    var selectedAnswer by remember { mutableStateOf<Answer?>(null) }

    Column(
        modifier = Modifier
            .background(Color.LightGray).fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        answers.forEach { answer ->
            Card(
                answer = answer.title,
                isSelected = (selectedAnswer == answer),
            )
        }
    }
}

@Composable
fun Card(
    answer: String,
    isSelected :Boolean,
    modifier: Modifier = Modifier
) {
    var isActive by remember { mutableStateOf(false) }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clickable { isActive = !isActive }
                .padding(16.dp)
        ) {

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = answer,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.weight(1f)
            )

            RadioButton(
                selected = isActive,
                onClick = { isActive = !isActive }
            )
        }
    }
}
