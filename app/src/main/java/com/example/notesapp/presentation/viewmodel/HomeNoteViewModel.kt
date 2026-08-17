// сосояние и логика ui
package com.example.notesapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesapp.domain.model.Note
import com.example.notesapp.domain.repository.NoteRepository
import com.example.notesapp.domain.usecases.note.CreateNote
import com.example.notesapp.domain.usecases.note.GetAllNotes
import com.example.notesapp.domain.usecases.note.UpdateNote
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.launch


@HiltViewModel
class HomeNoteViewModel @Inject constructor(
    private val createNote: CreateNote,
    private val updateNote: UpdateNote,
    private val getAllNotes: GetAllNotes
): ViewModel() {
    val notes = getAllNotes.execute()

    fun createNote(note: Note) {
        viewModelScope.launch {
            createNote.execute(note)
        }
    }
    fun updateNote(note: Note) {
        viewModelScope.launch {
            updateNote.execute(note)
        }
    }
}