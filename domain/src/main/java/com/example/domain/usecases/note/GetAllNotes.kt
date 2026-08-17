package com.example.notesapp.domain.usecases.note

import com.example.notesapp.domain.model.Note
import com.example.notesapp.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllNotes @Inject constructor(
    private val noteRepository: NoteRepository
    ){
        fun execute(): Flow<List<Note>> {
            return noteRepository.getAllNotes()
        }
    }