package com.example.notesapp.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.notesapp.domain.model.Note
import com.example.notesapp.presentation.components.NoteList
import com.example.notesapp.presentation.viewmodel.HomeNoteViewModel
import kotlinx.coroutines.flow.Flow


@Composable
fun NotesHomeScreen(
    viewModel: HomeNoteViewModel = hiltViewModel(),
    onCreateNote: () -> Unit,
    onOpenNote: (Int) -> Unit,
    ) {
    val notes by viewModel.notes.collectAsStateWithLifecycle(initialValue = emptyList())

    NotesHomeContent(
        notes = notes,
        onCreateNote = onCreateNote,
        onOpenNote = onOpenNote
    )
}

@Composable
fun NotesHomeContent(
    notes: List<Note>,
    onCreateNote: () -> Unit,
    onOpenNote: (Int) -> Unit
) {
    Scaffold(
        // 1. Настраиваем плавающую кнопку
        floatingActionButton = {
            FloatingActionButton(
                onClick = onCreateNote,
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Добавить заметку"
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Мои заметки",
                    modifier = Modifier
                        .weight(1f),
                    fontSize = 24.sp
                )
            }
            Spacer(modifier = Modifier.height(5.dp))
            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(notes) { note ->
                    NoteList(
                        note = note,
                        tag = note.tag,
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
}
@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL_4)
@Composable
fun NotesHomePreview(){
    val testNotes = listOf(
        Note(id = 1, title = "Купить продукты", content = "Молоко, хлеб, сыр", tag = null),
        Note(id = 2, title = "Идеи для Compose", content = "Разобраться с превью и лямбдами", tag = null),
        Note(id = 3, title = "Важное напоминание", content = "Полить цветы вечером", tag = null)
    )
    NotesHomeContent(
        notes = testNotes,
        onCreateNote = { },
        onOpenNote = { }
    )
}
