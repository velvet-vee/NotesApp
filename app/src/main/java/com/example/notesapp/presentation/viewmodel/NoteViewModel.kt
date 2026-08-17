package com.example.notesapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesapp.domain.model.Note
import com.example.notesapp.domain.usecases.note.CreateNote
import com.example.notesapp.domain.usecases.note.GetNote
import com.example.notesapp.domain.usecases.note.UpdateNote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val getNote: GetNote,
    private val updateNote: UpdateNote,
    private val createNote: CreateNote,
    ): ViewModel(){
    private val _note = MutableStateFlow<Note?>(null)
    val note = _note.asStateFlow()

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
    fun getNote(id: Int) {
        viewModelScope.launch {
            _note.value = getNote.execute(id)
        }
    }
}