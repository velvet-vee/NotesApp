package com.example.notesapp.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.notesapp.domain.model.Note
import com.example.notesapp.presentation.components.NoteList
import com.example.notesapp.presentation.viewmodel.HomeNoteViewModel


@Composable
fun NotesHomeScreen(
    viewModel: HomeNoteViewModel = hiltViewModel(),
    onCreateNote: () -> Unit,
    onOpenNote: (Int) -> Unit,

    ) {
    val notes by viewModel.notes.collectAsStateWithLifecycle(initialValue = emptyList())
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Мои заметки",
                modifier = Modifier.weight(1f),
                fontSize = 24.sp
            )
            IconButton(onClick = onCreateNote) {
                Text(
                    text = "+",
                    fontSize = 24.sp
                )
            }
        }
        Spacer(modifier = Modifier.height(5.dp))
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(notes) { note ->
                NoteList(
                    note = note,
                    onClick = {
                        note.id?.let { id ->
                            onOpenNote(id)
                        }
                    }
                )
            }
        }
    }
}