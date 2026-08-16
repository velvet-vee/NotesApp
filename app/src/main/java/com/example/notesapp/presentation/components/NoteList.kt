package com.example.notesapp.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NoteList() {
    Card(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text("Test 1")
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = {}){
                Text(
                    text = "-",
                    fontSize = 24.sp
                )
            }
        }
    }
}