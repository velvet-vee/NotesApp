package com.example.notesapp.presentation.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.notesapp.domain.model.Note
import com.example.notesapp.presentation.viewmodel.NoteViewModel

@Composable
fun NoteScreen(
    viewModel: NoteViewModel = hiltViewModel(),
    onBack: () -> Unit,
    noteId: Int? = null
){
    val note by viewModel.note.collectAsStateWithLifecycle()
    LaunchedEffect(noteId) { // запрос на заметку из бд через getNote
        noteId?.let { id ->
            viewModel.getNote(id)
        }
    }

    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf<String?>(null) }
    LaunchedEffect(note) { // тположиь в поля экрана ui те данные, которые в бд
        note?.let {
            title = it.title
            content = it.content
        }
    }

    val updateNote = Note(
        id = noteId,
        title = title,
        content = content
    )
    viewModel.updateNote(updateNote)
}