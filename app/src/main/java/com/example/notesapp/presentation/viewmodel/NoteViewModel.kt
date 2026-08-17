package com.example.notesapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.notesapp.domain.usecases.note.GetNote
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val getNote: GetNote,
    ): ViewModel(){
}