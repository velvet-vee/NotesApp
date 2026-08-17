package com.example.notesapp.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.unit.sp
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
    var titleError by remember { mutableStateOf(false) }

    LaunchedEffect(note) { // положиь в поля экрана ui те данные, которые в бд
        note?.let {
            title = it.title
            content = it.content
        }
    }

    fun saveNote(): Boolean {
        if (title.isBlank()) {
            titleError = true
            return false
        }
        val currentNote = Note(
            id = noteId,
            title = title,
            content = content
        )
        if (noteId != null) {
            viewModel.updateNote(currentNote)
        }
        else{
            viewModel.createNote(currentNote)
        }
        onBack()
        return true
    }

    Column {
        IconButton(
            onClick = {
                    saveNote()
                }
        ) { Text(
            text = "<-",
            fontSize = 24.sp
        )}
        TextField(
            value = title,
            onValueChange = {
                title = it
                if(it.isNotBlank()){
                    titleError = false
                }
            },
            isError = titleError,
            label = {
                Text(
                    text = if (titleError) "Введите название" else "Введите название"
                )
            },
            modifier = Modifier.onFocusChanged {focusState ->
                if (!focusState.isFocused && title.isBlank()){
                    titleError = true
                }
            },
        )
        TextField(
            value = content?: "",
            onValueChange = {content = it}
        )
    }
}